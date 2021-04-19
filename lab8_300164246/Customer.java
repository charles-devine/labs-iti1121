import java.util.Random;

public class Customer { 

    private int arrivalTime; 
    private int initialNumberOfItems;
    private int numberOfItems; 
    private static int MAX_NUM_ITEMS = 25; 

    public Customer(int arrivalTime) { 
        this.arrivalTime = arrivalTime; 

        this.numberOfItems = 0; 

        Random generator; 
        generator = new Random(); 

        int numItems; 
        numItems = generator.nextInt(MAX_NUM_ITEMS - 1) + 1; 

        this.initialNumberOfItems = numItems; 
    }

    public int getArrivalTime() { 
        return arrivalTime; 
    }

    public int getNumberOfItems() { 
        return initialNumberOfItems - numberOfItems; 
    }

    public int getNumberOfServedItems() { 
        return numberOfItems; 
    }

    public void serve() { 
        numberOfItems++; 
    }
}