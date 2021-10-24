package hw.hw3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private Map<String, Set<String>> map = new HashMap<>();


    public void add(String name, String phoneNumber) {
        if (map.containsKey(name)) {
            map.get(name).add(phoneNumber);
        } else {
            Set<String> set = new HashSet<>();
            set.add(phoneNumber);
            map.put(name, set);
        }
        //// 2 вариант (упрощенный)

        Set<String> set = map.getOrDefault(name, new HashSet<>());
        set.add(phoneNumber);
        map.put(name, set);
    }



    public Set<String> getPhones(String name) {
        return map.getOrDefault(name, Collections.emptySet());
    }


}
