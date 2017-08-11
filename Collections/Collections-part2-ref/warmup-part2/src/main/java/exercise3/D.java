package exercise3;

/**
 * Created by Alexandra.Traila on 8/7/2017.
 */
public class D extends Student{
    public D(String last, String first)
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
        int result = getFirstName().hashCode();
        result = result * 31 + getLastName().hashCode();
        return result;
    }
    /*
    (d) Now create another class that extends the student class and override the equals and hash code methods like this:
    hash code: must be correctly implemented for all the properties.
    equals: must be correctly implemented for all the properties.
     */
}
