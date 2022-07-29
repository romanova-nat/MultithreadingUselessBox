import java.util.Random;

public class UserToy {

    final int TIMEFORTURNON = 500;
    final int TIMEFORTURNOFF = 1000;
    int numberOfStart;

    private volatile static boolean switchOn = false;  // коробка закрыта
    Random random = new Random();

    public void turnOn() throws InterruptedException {
        while (numberOfStart < (random.nextInt(10)+1)) {  // выбираем рандомно количество итераций
            if (switchOn == false) { // если коробка закрыта
                System.out.println("Пользователь включил тумблер " + (numberOfStart + 1) + " раз");
                this.switchOn = true; // коробка открыта
                System.out.println("Коробка открылась...");
                numberOfStart++;
                Thread.sleep(TIMEFORTURNON);
            }
        }
    }

    public void turnOff() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            if (switchOn == true) {
                System.out.println("Игрушка выключила тумблер");
                this.switchOn = false; // коробка закрыта
                System.out.println("Коробка закрылась...");
                Thread.sleep(TIMEFORTURNOFF);
            }
        }
    }
}


