package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class ThrowException {
    void throwexeption() throws MyException{
        if(1>0)
            throw new MyException("Testing the exception");
        else
            System.out.println("Comparatie incorecta");
    }
}
