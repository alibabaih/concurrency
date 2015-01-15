package vasiliy.schitov;

public class MyThread_1 implements Runnable { //Запуск с помощь имплементации Runnable

    public void run() {		//Этот метод будет выполняться в побочном потоке
        System.out.println("Привет из побочного потока!");
    }

    public static class Program { //Класс с методом main()

        static MyThread_1 thread_1; //thread_1 - объект класса, реализующего интерфейс Runnable
        static MyThread_1 thread_2;
        static MyThread_1 thread_3;
        static MyThread_1 thread_4;

        public static void main(String[] args) {
            thread_1 = new MyThread_1();
            thread_2 = new MyThread_1();
            thread_3 = new MyThread_1();
            thread_4 = new MyThread_1();

            Thread myThread_1 = new Thread(thread_1);	//Создание потока "myThready"
            myThread_1.start();				//Запуск потока

            Thread myThread_2 = new Thread(thread_1);	//Создание потока "myThready"
            myThread_2.start();				//Запуск потока

            Thread myThread_3 = new Thread(thread_1);	//Создание потока "myThready"
            myThread_3.start();				//Запуск потока

            Thread myThread_4 = new Thread(thread_1);	//Создание потока "myThready"
            myThread_4.start();				//Запуск потока

            System.out.println("Главный поток завершён...");
        }

    }
}
