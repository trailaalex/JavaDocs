package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class Point3D extends Point {

    private int zPos;

    Point3D(int x,int y,int z)
    {
        super(x,y);
        this.zPos=z;
    }

    /*22.	In inheritance the subclass can call the super classes constructor by using the super keyword.
     Create a new class, in ro.teamnet.zerotohero.oop.graphicshape, named Point3D,
     that extends Point class, with a private int zPos and a constructor with three parameters.
     The first two parameters will be used in the call of the super classes constructor like
      so super(x, y) and the third will be used to set the zPos;*/
}
