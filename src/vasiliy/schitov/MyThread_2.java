package vasiliy.schitov;

public class MyThread_2 {

    public static void main(String[] args) {
        //Создание потока (безымянный внутренний класс)
        Thread myThread_2 = new Thread(new Runnable() {
            public void run() { //Этот метод будет выполняться в побочном потоке
                System.out.println("Привет из побочного потока!");
            }
        });
        myThread_2.start();	//Запуск потока
        System.out.println("Главный поток завершён...");
    }

}
