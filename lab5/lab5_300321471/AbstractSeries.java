public abstract class AbstractSeries implements Series {
  
    public double[] take(int k) {
    double arr[] = new double[k];
    for (int x = 0; x < k; x++) 
      arr[x] = next(); 
    return arr;
    }

}