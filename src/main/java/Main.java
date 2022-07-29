public class Main {

    public static void main(String[] args) throws InterruptedException {

        UserToy userToy = new UserToy();

        Thread threadUser = new Thread(() -> {
            try {
                userToy.turnOn();
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
            }
        });

        Thread threadToy = new Thread(() -> {
            try {
                userToy.turnOff();
            } catch (InterruptedException e) {
                Thread.currentThread().isInterrupted();
            }
        });

        threadUser.start();
        threadToy.start();

        threadUser.join();
        threadToy.interrupt();
    }
}