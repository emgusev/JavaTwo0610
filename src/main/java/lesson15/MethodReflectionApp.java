package lesson15;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodReflectionApp {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Class bikeClass = Bike.class;

        Method[] declaredMethods = bikeClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {

            if (declaredMethod.getAnnotation(SimpleAnnotation.class) != null) {
                System.out.println("method with annotation");
            }

            declaredMethod.getDeclaredAnnotations();

            System.out.println("name = " + declaredMethod.getName() + " returnType = " + declaredMethod.getReturnType().getName() +
                    " parameters " + Arrays.toString(declaredMethod.getParameterTypes()));
        }

        Method method = bikeClass.getDeclaredMethod("setYearAndModel", String.class, int.class);


        NotSimpleAnnotation annotation = method.getDeclaredAnnotation(NotSimpleAnnotation.class);
        System.out.println(annotation.name() + " " + annotation.value());


        Bike bike = new Bike();
        System.out.println(bike);
        method.setAccessible(true);
        method.invoke(bike, "Pinarello", 2021);
        System.out.println(bike);

    }
}
