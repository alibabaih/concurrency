package vasiliy.schitov;

//расширяться от класса Thread
public class MyThread_3 extends Thread {
    @Override
    public void run() {
        System.out.println("Another thread.");
    }
}

class Program {

    static MyThread_3 mySecondThread;

    public static void main(String[] args) {
        mySecondThread = new MyThread_3();
        mySecondThread.start();

        System.out.println("Main thread.");
    }

}
