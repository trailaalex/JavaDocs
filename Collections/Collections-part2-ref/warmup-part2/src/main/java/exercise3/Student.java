package exercise3;

/**
 * Created by Alexandra.Traila on 8/7/2017.
 */
public class Student {
     private String lastName;
     private  String firstName;

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;

    }

    public Student() {
        this.lastName = "Ionescu";
        this.firstName = "Vasile";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "LastName:ppp " + lastName + "FirstName: " + firstName;
    }
}
