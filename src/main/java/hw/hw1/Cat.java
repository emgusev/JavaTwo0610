package hw.hw1;

public class Cat implements Runnable, Jumpable, Competable {
    @Override
    public boolean jump(int height) {
        return false;
    }

    @Override
    public boolean run(int distance) {
        return false;
    }
}
