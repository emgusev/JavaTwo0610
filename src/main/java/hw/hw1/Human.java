package hw.hw1;

public class Human implements Runnable, Jumpable, Competable{

    private int maxDistance;
    private int maxJumpHeight;
    private double stamina = 1;

    public Human(int maxDistance, int maxJumpHeight) {
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean jump(int height) {
        return height < maxJumpHeight * stamina;
    }

    @Override
    public boolean run(int distance) {
        return distance < maxDistance* stamina;
    }
}
