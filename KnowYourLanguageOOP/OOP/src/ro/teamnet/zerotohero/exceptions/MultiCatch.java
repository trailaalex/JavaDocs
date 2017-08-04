package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class MultiCatch {

    void multicatch()
    {
        try {
            int arr[] = new int[5];
            arr[10] = 20;
            int r = arr[10]/10;
        }
        catch(ArrayIndexOutOfBoundsException|ArithmeticException ex) {
            ex.printStackTrace();
        }
    }
}
