public class Arithmetic extends AbstractSeries {

    // instance variables

    private int a; 
    private double b; 

    public Arithmetic() { 
        this.a = 0; 
        this.b = 0; 
    }

    public double next() {
        this.a++; 
        this.b += this.a;

        return this.b; 

        // implement the method
        
    }
}