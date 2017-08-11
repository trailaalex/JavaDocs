package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alexandra.Traila on 8/7/2017.
 */
public class MainClass {

    public static void main(String[] args)
    {
        Map<A,BigDecimal> mapA= new HashMap<A,BigDecimal>();
        Map<B,BigDecimal> mapB= new HashMap<B,BigDecimal>();
        Map<C,BigDecimal> mapC= new HashMap<C,BigDecimal>();
        Map<D,BigDecimal> mapD= new HashMap<D,BigDecimal>();

        A a1= new A("Ionescu","Ion");
        A a2 = new A("Popescu","Vlad");
        mapA.put(a1,new BigDecimal(12));
        mapA.put(a2, new BigDecimal(18));
      //  System.out.println(mapA.toString());
        Set keys = mapA.keySet();
        Iterator it =keys.iterator();
        while(it.hasNext())
        {
            A i= (A)it.next();
            System.out.println(i + " " + mapA.get(i));

        }
        System.out.println("\n");

        B b1= new B("Radulescu","Ion");
        B b2 = new B("Florescu","Vlad");
        mapB.put(b1,new BigDecimal(12));
        mapB.put(b2, new BigDecimal(18));
        System.out.println(mapB.toString());

        System.out.println("\n");

        C c1= new C("Laurian","Ion");
        C c2 = new C("Cezarescu","Vlad");
        mapC.put(c1,new BigDecimal(12));
        mapC.put(c2, new BigDecimal(18));
       System.out.println(mapC.toString());

        System.out.println("\n");

        D d1= new D("Andelescu","Ion");
        D d2 = new D("Dezarescu","Vlad");
        mapD.put(d1,new BigDecimal(12));
        mapD.put(d2, new BigDecimal(18));
        System.out.println(mapD.toString());

        System.out.println("\n");

    }

    /*

Now create another class that suits the main() method where we create 4 MAPS where the KEY will be of type STUDENT and the VALUE
will be a BigDecimal
representing the age (or whatever).
In the first Map, the key will be an object from point (a), in the second map it will be an object from point (b),
in the third map it will be an object from point (c) and in the last map it be an object from point (d).
Think and set the proper properties for the objects in order to observe what can go wrong with our dictionaries.

Give suggestive names for the classes and print the content of the dictionaries using Iterator!
     */
}
