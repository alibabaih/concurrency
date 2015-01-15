package bank;

import javax.naming.InsufficientResourcesException;

public class Operations {

    public static void main(String[] args) throws InsufficientResourcesException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a, b, 500);
                } catch (InsufficientResourcesException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        transfer(b, a, 300);

        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
    }

    static void transfer(Account acc1, Account acc2, int amount) throws InsufficientResourcesException {
        if (acc1.getBalance() < amount) throw  new InsufficientResourcesException();
        /*
        acc1.withdraw(amount);
        acc2.deposit(amount);
        */
        //пытаемся засинхронизировать доступ к русурсам,
        // но притакой реализации остаётся возможен deadlock (один ждёт другого)
        synchronized (acc1) {
            /* имитируем работу deadlock'а
            Thread dump
            in bin directory java jdk execute cmd input jps
                                                        jstack #thread
            or use JConsole
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Catch interrupted exception: " + e);
            }
            */
            synchronized (acc2) {
                acc1.withdraw(amount);
                acc2.deposit(amount);
            }
        }
    }
}
