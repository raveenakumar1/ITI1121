/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class Simulator {

    /**
     * Length of car plate numbers
     */
    public static final int PLATE_NUM_LENGTH = 3;

    /**
     * Number of seconds in one hour
     */
    public static final int NUM_SECONDS_IN_1H = 3600;

    /**
     * Maximum duration a car can be parked in the lot
     */
    public static final int MAX_PARKING_DURATION = 8 * NUM_SECONDS_IN_1H;

    /**
     * Total duration of the simulation in (simulated) seconds
     */
    public static final int SIMULATION_DURATION = 24 * NUM_SECONDS_IN_1H;

    /**
     * The probability distribution for a car leaving the lot based on the duration
     * that the car has been parked in the lot
     */
    public static final TriangularDistribution departurePDF = new TriangularDistribution(0, MAX_PARKING_DURATION / 2,
            MAX_PARKING_DURATION);

    /**
     * The probability that a car would arrive at any given (simulated) second
     */
    private Rational probabilityOfArrivalPerSec;

    /**
     * The simulation clock. Initially the clock should be set to zero; the clock
     * should then be incremented by one unit after each (simulated) second
     */
    private int clock;

    /**
     * Total number of steps (simulated seconds) that the simulation should run for.
     * This value is fixed at the start of the simulation. The simulation loop
     * should be executed for as long as clock < steps. When clock == steps, the
     * simulation is finished.
     */
    private int steps;

    /**
     * Instance of the parking lot being simulated.
     */
    private ParkingLot lot;

    /**
     * Queue for the cars wanting to enter the parking lot
     */
    private Queue<Spot> incomingQueue;

    /**
     * Queue for the cars wanting to leave the parking lot
     */
    private Queue<Spot> outgoingQueue;

    /**
     * @param lot   is the parking lot to be simulated
     * @param steps is the total number of steps for simulation
     */
    public Simulator(ParkingLot lot, int perHourArrivalRate, int steps) {
        if(lot == null || steps < 0 || perHourArrivalRate < 0){
            throw new IllegalStateException("Parking lot can't be null or Step can't be smaller than 0 or perHourArrivalRate can't be smaller than zero");
        }
        this.lot = lot;
        this.steps = steps;
        this.probabilityOfArrivalPerSec = new Rational(perHourArrivalRate, 3600);
        this.clock = 0;

        incomingQueue = new LinkedQueue<Spot>();
        outgoingQueue = new LinkedQueue<Spot>();
    }

    private void processArrival() {
        boolean shouldAddNewCar = RandomGenerator.eventOccurred(probabilityOfArrivalPerSec);

        if (shouldAddNewCar) {
            String plateNum = RandomGenerator.generateRandomString(PLATE_NUM_LENGTH);
            incomingQueue.enqueue(new Spot(new Car(plateNum), clock));
        }
    }

    private void processDeparture() {
        for (int i = 0; i < lot.getOccupancy(); i++){
            Spot spot = lot.getSpotAt(i);

            if (spot != null) {
                int duration = clock - spot.getTimestamp();

                boolean willLeave = false;

                if (duration > 8 * 3600) {
                    willLeave = true;

                } else {
                    willLeave = RandomGenerator.eventOccurred(departurePDF.pdf(duration));
                }

                if (willLeave) {
                    // System.out.println("DEPARTURE AFTER " + duration/3600f + " hours.");
                    Spot toExit = lot.remove(i);

                    toExit.setTimestamp(clock);

                    outgoingQueue.enqueue(spot);
                }
            }
        }
    }


    /**
     * Simulate the parking lot for the number of steps specified by the steps
     * instance variable
     * NOTE: Make sure your implementation of simulate() uses peek() from the Queue interface.
     */
    public void simulate() {
        Spot incomingToProcess = null;

        while (clock < steps) {
            processArrival();

            processDeparture();

            if (incomingToProcess != null) {
                boolean isProcessed = lot.attemptParking(incomingToProcess.getCar(), clock);

                if (isProcessed) {
                    incomingToProcess = null;
                }

            } else if (!incomingQueue.isEmpty()) {
                if(lot.attemptParking(incomingQueue.peek().getCar(), clock)){
                    lot.attemptParking(incomingQueue.dequeue().getCar(), clock);
                }else{
                    incomingToProcess = incomingQueue.dequeue();
                }
            }

            if (!outgoingQueue.isEmpty()) {
                outgoingQueue.dequeue();
            }

            clock++;
        }
    
    }

    public int getIncomingQueueSize() {
        return incomingQueue.size();
    }
}