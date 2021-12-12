package lesson15;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorReflectionApp {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class bikeClass = Bike.class;

        Constructor[] declaredConstructors = bikeClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(Arrays.toString(declaredConstructor.getParameterTypes()));
        }

        Constructor constructor = bikeClass.getDeclaredConstructor(String.class, String.class, int.class);
        Bike bike = (Bike) constructor.newInstance("Canyon", "12345", 2018);

        System.out.println(bike);


    }
}
