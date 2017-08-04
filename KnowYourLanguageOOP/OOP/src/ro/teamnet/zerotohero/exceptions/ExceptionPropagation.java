package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class ExceptionPropagation {

    void method3(){
        int result=100/0;

    }
    void method2()
    {
        method3();
    }

    void method1()
    {
        try
        {
            method2();
        } catch(Exception e)
        {
            System.out.println("Exception is handled here");
        }
    }
}
