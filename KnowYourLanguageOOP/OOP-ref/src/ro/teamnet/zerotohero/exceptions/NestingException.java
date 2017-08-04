package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class NestingException {
    public static void main(String[] args) throws Exception {
        Object[] localArgs = (Object[]) args;
           try {
                Integer[] numbers = (Integer[]) localArgs;
                } catch (ClassCastException originalException) {
            Exception generalException = new Exception(
                    "Horrible exception!",
                    originalException);
            throw generalException;
        }
          }
}
