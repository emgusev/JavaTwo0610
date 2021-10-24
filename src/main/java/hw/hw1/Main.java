package hw.hw1;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Human human = new Human(100, 2);
        Threadmill threadmill = new Threadmill(10);

        System.out.println(human.run(threadmill.getLength()));



        List<Obstacle> obstacles = List.of(new Threadmill(10), new Wall(), new Wall(), new Threadmill(5));
        List<Competable> competitors = List.of(new Human(100, 2), new Cat(), new Cat());


        for (Competable competitor : competitors) {
            boolean finished = true;

            for (Obstacle obstacle : obstacles) {

               if (obstacle instanceof Threadmill) {
                   Threadmill threadmill1 = (Threadmill) obstacle;
                    finished = competitor.run(threadmill1.getLength());
               } else if(obstacle instanceof Wall) {
                   finished = competitor.jump(1);
               }

               if(!finished) {
                   break;
               }

            }


            //Вот тут я знаю участника и смог ли он
        }

        //Obstacle[] obstacles1 = new Obstacle[]{new Threadmill(10), new Wall(), new Wall(), new Threadmill(5)};
    }


}
