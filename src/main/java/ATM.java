public class ATM {
    public static void main(String[] args) {
        Account account = new Account(0);

        Thread producerOne = new Producer(account);
//        Thread producerTwo = new Producer(account);
        Thread consumerOne = new Consumer(account);
        Thread consumerTwo = new Consumer(account);
        Thread consumerThree = new Consumer(account);

        producerOne.start();
        consumerOne.start();
//        producerTwo.start();
        consumerTwo.start();
        consumerThree.start();

        try {
            producerOne.join();
            consumerOne.join();
//            producerTwo.join();
            consumerTwo.join();
            consumerThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Closing balance should be 0
        System.out.println("MAIN::: Closing balance " + account.getBalance());


    }
}
