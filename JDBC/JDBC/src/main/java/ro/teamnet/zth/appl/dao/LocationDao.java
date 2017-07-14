package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;

/**
 * Created by Alexandra.Traila on 7/14/2017.
 */
public class LocationDao {

    EntityManager entityManager= new EntityManagerImpl();

    public Location findLocById(Long id)
    {
        return (Location)entityManager.findById(Location.class,id);
    }

    public Location insertLoc(Location loc)
    {
        return (Location)entityManager.insert(loc);
    }

    public Location updateLoc(Location loc)
    {
        return entityManager.update(loc);
    }

    public void deleteLoc(Location loc)
    {
        entityManager.delete(loc);
    }

    public List<Location> findToate(){

        EntityManager entityManager= new EntityManagerImpl();
        return entityManager.findAll(Location.class);}


    public Location findLocByString(String id){
        return (Location)entityManager.findByStringId(Location.class, id);
    }

    /*b)	LocationDao.java
-	create an EntityManager object;
-	create 5 methods which will call EntityManagerImpl.java  methods;
*/
}
