package lesson8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApp {


    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i=0; i < 100; i++) {
            list.add(random.nextInt(100)); // 0-99
        }
        System.out.println(list);




         String s = list.stream()
                .limit(50)
               // .peek(i -> System.out.println(i))
                .filter(integer -> integer % 2 == 1)
                 .sorted()
                 .distinct()
                .map(integer -> integer * 1000)
                .map(integer -> String.valueOf(integer))
         .collect(Collectors.joining("<->"));

        System.out.println(s);

        Stream<String> stringStream = Stream.of("aaaa", "bbbbb", "cccc", "aaa", "aaaa", "bbb");

        Map<String, Integer> map = stringStream
                .collect(Collectors.toMap(str -> str, str -> 1, (v1, v2) -> v1 + 1));

        System.out.println(map);
    }
}
