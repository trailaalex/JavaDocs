package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class RunApp {

   public static void main(String[] args)
   {
       Circles circles= new Circles();
       System.out.println("The default area is"+circles.getAreaPub());
       circles.getAreaDef();
       Canvas canvas =new Canvas();
       canvas.paint();
       Shape shape =new Circle(10);
       System.out.println(shape.area());
       ShapeBehaviour shapebeh=new Square(10);
       System.out.println(shapebeh.area());
       Object p1 = new Point(10, 20);
       Object p2 = new Point(50, 100);
       Object p3 = new Point(10, 20);
       System.out.println("p1 equals p2 is " + p1.equals(p2));
       System.out.println("p1 equals p3 is " + p1.equals(p3));

   }



   /*20.	Now lets test the runtime polymorphism.
   In the main method of the RunApp class create a new Shape object
   and initialize it with a new Circle(10) object. Print the new Shape object area.
   Create a ShapeBehaviour object by instantiating it with a new Square(10) object.
   Print the new Square object area.*/

/*18.	To use the getAreaDef() call it in  the main method of the RunApp class.*/

    /*13.	Create a runapp package in  ro.teamnet.zerotohero.oop. In this package create a new class
    named RunApp with a main(String[] args) method. In this method create a new Circles object and print
     the default circle area by caling getAreaPub() of the Circles object
     (The message printed should be something like ‘The default circle area is 2827.4333882308138’).*/
}
