public class Arithmetic extends AbstractSeries {
    private double n = 1;
	private double sum = 0;
    public double next() {
        sum += n++;
		return sum;
    }
}