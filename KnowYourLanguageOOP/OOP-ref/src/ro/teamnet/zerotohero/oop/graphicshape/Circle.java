package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class Circle extends Shape  {

    int xPos;
    int yPos;
    int radius;

    Circle()
    {
        this.xPos=0;
        this.yPos=2;
        this.radius=3;
    }

    public double area()
    {
        return PI*radius*radius;
    }

    public Circle(int x)
    {
      this.xPos=x;
    }

    Circle(int x,int y)
    {
       this.xPos=x;
       this.yPos=y;
    }

    Circle(int x, int y, int rad)
    {
       this.xPos=x;
       this.yPos=y;
       this.radius=rad;

    }

    public String toString()
    {
        String str="center=("+this.xPos+","+this.yPos+")and radius ="+this.radius;
        return str;
    }

    public void fillColour()
    {
        System.out.println(super.color);
    }

    public void fillColour(int col)
    {
        super.color=col;
        System.out.println("The circle color is now"+super.color);
    }

    public void fillColour(float sat)
    {
      super.saturation=sat;

    }

    /*16.	In the Circle class create an overloaded method named fillColour().
    One method should have no parameters, one with an int parameter and one with a float parameter.
     The fillColour method with no parameters should print the super class color primitive variable.
      The fillColour method with an int parameter should set the super class color primitive variable
      and print a message after. The message should be like "The circle color is now 2".
       The fillColour method with a float parameter should set the super class saturation parameter. */





    /*15.	Every class extends the Object class which has a default toString() method.
     Overwrite the toString() method in the Cirlce class in order to return the xPos, yPos
      and radius in
      the following format:
      “center = (x,y) and radius = z”. The toString() method prototype is: public String toString(); */

    /*14.	Overload the Circle class constructor by creating three more constructors with one,
     two, and three parameters.*/
/*
* 10.	Inheritance can be used by extending a concrete class as well.
 * Make Circle class extend Shape class and override the area() method so that it calculates the circle area.
 * Import java.lang.Math.PI with static import for that calculation. */

    /*5.	Create a new class Circle, in ro.teamnet.zerotohero.oop.graphicshape package.
    In this class create three private data fields of type int: xPos, yPos and radius,
    and a constructor with no parameters in which the three primitives
     are initializes with values (of you choice). */
}
