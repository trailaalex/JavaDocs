package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class Shape extends AbstractShape implements ShapeBehaviour {

   protected int color;
   protected  float saturation;
    public double area()
    {
        return 0;
    }

    public void setColor(int col)
    {
        this.color=col;
    }

    public void setSaturation(float sat)
    {
        this.saturation=sat;

    }

    /*2.	Create a new class named Shape with a public area() method,  that returns a double value.
    As fields you should have one  primitive data field of type int, named color, and one primitive of type float,
     named saturation.
    Give the area() method a default implementation. For color and saturation create setter methods.*/
}
