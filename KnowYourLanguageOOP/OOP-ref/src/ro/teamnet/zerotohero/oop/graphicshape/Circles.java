package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class Circles {

    public double getAreaPub()
    {
        Circle circle= new Circle();
        return circle.area();
    }

    public void getAreaDef()
    {
        Circle circle=new Circle();
        circle.fillColour();
        circle.fillColour(2);
        circle.fillColour(3.6f);
    }
/*
* 17.	In class Circles create a method named getAreaDef() with void return type.
* In this method create a new Circle object and call the three fillColour methods.*/


    /*12.	Create a new class named Circles with a method getAreaPub() with double return type.
     In this method create a new Circle object and  return its area (call to public method area(), within package).*/
}
