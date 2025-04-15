public class Geometric extends AbstractSeries {

    private double n = 0;
  private double product = 0;
    public double next() {
        product += 1/Math.pow(2, n++);
    return product;
    }
}