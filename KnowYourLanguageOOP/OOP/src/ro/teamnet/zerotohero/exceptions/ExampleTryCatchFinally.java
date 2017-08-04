package ro.teamnet.zerotohero.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class ExampleTryCatchFinally {
    private static void printFile() throws IOException {
        InputStream input = null;

        try {
            input = new FileInputStream("file.txt");

            int data = input.read();
            while(data != -1){
                System.out.print((char) data);
                data = input.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(input != null){
                input.close();
            }
        }
    }
}
