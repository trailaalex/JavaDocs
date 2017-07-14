package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;

/**
 * Created by Alexandra.Traila on 7/14/2017.
 */
public class DepartmentDao {

    EntityManager entitymanager = new EntityManagerImpl();

    public Department findDeptById(Long id){
        return (Department)entitymanager.findById(Department.class, id);
    }

    public Department findDeptByString(String id){
        return (Department)entitymanager.findByStringId(Department.class, id);
    }

    public List<Department> findToate()
    {
        return entitymanager.findAll(Department.class);
    }

    public Department DeptInsert(Department dept)
    {
        return (Department)entitymanager.insert(dept);
    }

    public Department DeptUpdate(Department dept)
    {
        return entitymanager.update(dept);
    }

    public void DeptDelete(Department dept)
    {
        entitymanager.delete(dept);
    }

    /*a)	DepartmentDao.java
-	create an EntityManager object;
-	create 5 methods which will call EntityManagerImpl.java  methods;
*/
}
