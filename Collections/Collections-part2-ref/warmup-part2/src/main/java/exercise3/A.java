package exercise3;

/**
 * Created by Alexandra.Traila on 8/7/2017.
 */
public class A extends Student {

   public A(String last, String first)
   {
       super(last, first);
   }
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;

        if(o == null || o.getClass() != this.getClass())
            return false;

        A student = (A) o;

        if(student.getFirstName().equals(this.getFirstName()))
            return true;

        return false;
    }

    @Override
    public int hashCode() {
       return this.getFirstName().hashCode();
    }
    /*
    (a) Now create another class that extends the Student class and override the equals and hash code methods like this:
    hash code: returns the hashcode ONLY for the first name property.
    equals: checks if two objects are equal taking into account ONLY the first name property.
     */
}
