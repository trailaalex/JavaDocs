package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Location;
import ro.teamnet.zth.appl.dao.LocationDao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Alexandra.Traila on 7/14/2017.
 */
 class LocationDaoTest {

    static Location location = new Location();
    LocationDaoTest locationdaoTest= new LocationDaoTest();
    LocationDao locationdao= new LocationDao();
    @Test
    public void TestInsert(){
        location.setCity("Bucuresti");
        location.setStreetAddress("Str Ana");
        location.setPostalCode("12345");
        location.setStateProvince("Bucuresti");
        location= locationdao.insertLoc(location);
        assertEquals(location , locationdao.findLocById(location.getId()));

    }

    @Test
    public void DeleteLocationTest() {

        locationdao.deleteLoc(location);
        Location locId = locationdao.findLocById(location.getId());
        assertNull(locId);
    }

    @Test
    public void UpdateLocationTest() {
        location.setStreetAddress("Bucuresti");
        location = locationdao.updateLoc(location);

        assertEquals(locationdao.findLocById(location.getId()), location);
    }

}

