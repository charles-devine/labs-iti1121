public class Cashier { 

    private ArrayQueue<Customer> queue; 
    private Customer currentCustomer; 

    private int totalCustomerWaitTime; 
    private int customersServed; 
    private int totalItemsServed; 

    public Cashier() { 
        queue = new ArrayQueue<Customer>(); 
        totalCustomerWaitTime = 0; 
        customersServed = 0; 
        totalItemsServed = 0; 
    }

    public void addCustomer(Customer c) { 
        queue.enqueue(c); 
    }

    public int getQueueSize() { 
        return queue.size();
    }

    public void serveCustomers( int currentTime) { 
        if (currentCustomer == null && queue.size() > 0) { 
            currentCustomer = queue.dequeue(); 
            totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime(); 
            customersServed++; 
        }

        if (currentCustomer != null) { 
            if (currentCustomer.getNumberOfItems() > 0) { 
                currentCustomer.serve(); 
            }

            if (currentCustomer.getNumberOfItems() == 0) { 
                totalItemsServed += currentCustomer.getNumberOfServedItems(); 
                currentCustomer = null; 
            }
        }
    }

    public int getTotalCustomerWaitTime() { 
        return totalCustomerWaitTime; 
    }
    
    public int getTotalItemsServed() { 
        return totalItemsServed; 
    }

    public int getTotalCustomersServed() { 
        return customersServed; 
    }
    
}
