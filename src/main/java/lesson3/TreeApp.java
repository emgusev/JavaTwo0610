package lesson3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeApp {

    // Comparable - interface
    //Comparator - abstract


    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<>();

        TreeSet<User> set = new TreeSet<>();
        set.add(new User(10));
        set.add(new User(6));
        set.add(new User(19));

        System.out.println(set);


        TreeSet<String> strings = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

               int res = o1.length() - o2.length();
               if(res != 0) {
                   return res;

               }
               return o1.compareTo(o2);
            }
        });
        strings.add("b");
        strings.add("bb");
        strings.add("bbb");
        strings.add("a");
        strings.add("aa");
        strings.add("aaa");


        System.out.println(strings);




    }
}
