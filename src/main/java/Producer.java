public class Producer extends Thread {
    private Account account;

    public Producer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            account.deposit(10);
        }
    }
}
