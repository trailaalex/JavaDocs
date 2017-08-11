package exercise3;

/**
 * Created by Alexandra.Traila on 8/7/2017.
 */
public class B extends Student {

    public B(String last, String first)
    {
        super(last,first);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o==null || o.getClass() != this.getClass())
            return false;
        B student= (B) o;

        if(student.getFirstName().equals(this.getFirstName()) && student.getLastName().equals(this.getLastName()))
            return true;
        return false;

    }
    @Override
    public int hashCode() {
        return this.getFirstName().hashCode();
    }
    /*
    (b) Now create another class that extends the Student class and override the equals and hash code methods like this:
    hash code: returns the hashcode ONLY for the first name property.
    equals: must be correctly implemented for all the properties.
     */
}
