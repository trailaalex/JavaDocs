package exercise3;

/**
 * Created by Alexandra.Traila on 8/7/2017.
 */
public class C extends Student {
    public C(String last, String first)
    {
        super(last,first);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        C student = (C) o;
        if(student.getFirstName().equals(this.getFirstName()))
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
    (c) Now create another class that extends the student class and override the equals and hash code methods like this:
    hash code: must be correctly implemented for all the properties.
    equals: checks if two objects are equal taking into account ONLY the first name property.
     */
}
