package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class ExampleTryCatch {

    void methodtry() {
        int num1, num2;
        try {
            num1 = 0;
            num2 = 62 / num1;
        } catch (ArithmeticException e) {
            System.out.println("Error:Don't divide a number by zero");
        }
    }
}
