package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class TryCatchResources {

   void mettry() {
       try (FileInputStream input = new FileInputStream("file.txt")) {

           int data = input.read();
           while (data != -1) {
               System.out.print((char) data);
               data = input.read();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
