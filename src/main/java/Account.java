public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public synchronized int  getBalance() {
        return balance;
    }

    public synchronized void deposit(int value) {
        int temp = balance;
        temp = temp + value;

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        balance = temp;
        System.out.println("Deposit balance: " + balance);
        notify();
    }

    public synchronized void withdraw(int value) {
        while (value > balance) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int temp = balance;
        temp  = temp - value;

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        balance = temp;
        System.out.println("Withdraw balance: " + balance);
    }

}
