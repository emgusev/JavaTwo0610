public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1");
        Thread t1 = new Thread(() -> System.out.println());
        Thread t2 = new Thread(() -> System.out.println());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
