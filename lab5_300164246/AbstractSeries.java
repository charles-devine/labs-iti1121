public abstract class AbstractSeries implements Series {

    public double[] take(int k) {
        
        double[] tmp = new double[k]; 
        for (int i = 0; i < k; i++) { 
            tmp[i] = next(); 
        }
        return tmp; 
    }

    public double next() { 
        return 0; 
    }

}
