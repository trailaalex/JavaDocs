package ro.teamnet.zerotohero.Proiect.ExceptionZoo;

import java.util.zip.DataFormatException;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class AnimalPeCaleDeDisparitieException extends Exception {

    public AnimalPeCaleDeDisparitieException(String message)
    {
        System.out.println("Animal pe cale de disparitie"+message);
    }

}
