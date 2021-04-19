
public class Account {

    private double balance; 

    public Account() { 
        this.balance = 0; 
    }

    public double getBalance() { 
        return balance; 
    }

    public void deposit(double value) { 
        balance += value; 
        System.out.println("new balance=" + getBalance() + "$");

    }

    public void withdraw(double value) throws NotEnoughMoneyException {

        if (value > balance) { 
            throw new NotEnoughMoneyException(value, getBalance());
        }

        this.balance = balance - value; 
        System.out.println("new balance=" + balance);

    }

}


