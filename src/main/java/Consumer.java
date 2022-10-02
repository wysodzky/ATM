public class Consumer extends Thread {
    private Account account;

    public Consumer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(10);
        }
    }
}
