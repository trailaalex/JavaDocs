package ro.teamnet.zerotohero.Proiect.ExceptionZoo;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class AnimalManancaOmException extends RuntimeException {
    public AnimalManancaOmException(String e) {
        System.out.println("Animal mananca om"+e);
    }
}
