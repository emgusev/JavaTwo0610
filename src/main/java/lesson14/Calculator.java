package lesson14;

public class Calculator {

    private Battery battery;

    public Calculator() {
        battery = new Battery(100);
    }

    public Calculator(Battery battery) {
        this.battery = battery;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a * b;
    }

    public int division(int a, int b) {
        return a / b;
    }

    //4xx
}
