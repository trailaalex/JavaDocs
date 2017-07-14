package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static ro.teamnet.zth.appl.LocationDaoTest.location;

/**
 * Created by Alexandra.Traila on 7/14/2017.
 */
public class DepartmentDaoTest {
    static Department department = new Department();
    DepartmentDaoTest departmentdaoTest= new DepartmentDaoTest();
    DepartmentDao departmentdao= new DepartmentDao();
    @Test
    public void TestInsert(){

        department.setDepartmentName("Administration");
        department= departmentdao.DeptInsert(department);
        assertEquals(department , departmentdao.findDeptById(department.getId()));

    }

    @Test
    public void DeleteDepartmentTest() {

        departmentdao.DeptDelete(department);
        Department deptId = departmentdao.findDeptById(department.getId());
        assertNull(deptId);
    }

    @Test
    public void UpdateLocationTest() {
        department.setDepartmentName("Administration");
        department = departmentdao.DeptUpdate(department);

        assertEquals(departmentdao.findDeptById(department.getId()), department);
    }

}
