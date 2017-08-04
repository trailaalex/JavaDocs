package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public final class ImmutableClass {
    private final String name;
    private final String firstname;
    ImmutableClass(String name, String firstname)
    {
        this.name=name;
        this.firstname=firstname;
    }

    public String getName()
    {
        return name;
    }
}
