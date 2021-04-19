public class Geometric extends AbstractSeries {

    // instance variables

    private int a; 
    private double b; 

    public Geometric() { 
        this.a = -1; 
        this.b = 0.0; 
    }
    
    public double next() {

        this.a++; 
        this.b += (1/Math.pow(2, (double) this.a)); 
        return b; 

        // implement the method

    }
}