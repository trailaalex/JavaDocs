package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class Point {

    int xPos;
    int yPos;

    public Point(int x, int y)
    {
        this.xPos=x;
        this.yPos=y;

    }

    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        // check if the dynamic type of 'other' is Point
        // if 'other' is of any other type than 'Point', the two objects cannot be
        // equal if 'other' is of type Point (or one of its derived classes), then
        // downcast the object to Point type and then compare members for equality
        if(other instanceof Point) {
            Point anotherPoint = (Point) other;
            // two points are equal only if their x and y positions are equal
            if( (xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos) )
                return true;
        }
        return false;
    }



    /*21.	Let’s dive deeper into overwriting. Create a new Point class in
ro.teamnet.zerotohero.oop.graphicshape package. This method should have two primitives int
 variables xPos and yPos. Create a constructor, for the Point class, with two parameters, that initializes
  the  two data variables. Another method inherited from the Object class is equals().
  Let’s overwrite it by creating a new method equals like so :
// override the equals method to perform "deep" comparison of two Point objects
*/
}
