package ro.teamnet.zerotohero.reflection.demoobjects;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //TODO get the class for a String object, and print it
         System.out.println("reflection".getClass());

        //TODO get the class of an Enum, and print it
        System.out.println(new int[]{1, 2}.getClass());

        //TODO get the class of a collection, and print it
        ArrayList a= new ArrayList();
        System.out.println(a.getClass());

        //TODO get the class of a primitive type, and print it
        System.out.println(float.class);

        //TODO get and print the class for a field of primitive type
           int b=1;
           Class c=int.class;
           System.out.println(c);



        //TODO get and print the class for a primitive type, using the wrapper class
        Field d=WrapperClass.class.getField("sea");
        System.out.println(d.getType());
        //TODO get the class for a specified class name

        final String className = Clasa.class.getCanonicalName();
        System.out.println(className);

        //TODO get the superclass of a class, and print it
        final Class<? super Clasa> classNameSuper = Clasa.class.getSuperclass();
        System.out.println(classNameSuper);
        //TODO get the superclass of the superclass above, and print it
        final Class<? super Clasa> classNameSuper1 = Clasa.class.getSuperclass().getSuperclass();
        System.out.println(classNameSuper1);
       // final Class<? super Clasa> classNameSuper2 = classNameSuper1.class.getSuperclass();
        //TODO get and print the declared classes within some other class
          System.out.println(Clasa.class.getDeclaredClasses());

        //TODO print the number of constructors of a class
           //while(Clasa.class.getDeclaredConstructor())
          System.out.println(Clasa.class.getDeclaredConstructors());

        //TODO get and invoke a public constructor of a class
          /*Method testMethod = Clasa.class.getMethod("Clasa");
          Object result = testMethod.invoke(new Clasa());
         System.out.println(result);*/
        //TODO get and print the class of one private field 
        
		
		//TODO set and print the value of one private field for an object
        

        //TODO get and print only the public fields class
        

        //TODO get and invoke one public method of a class
        

        //TODO get and invoke one inherited method of a class
       
		
		//TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
		//TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
		//what do you observe?
		
    }
}
