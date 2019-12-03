package cindy.sirihpinang.repository;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import cindy.sirihpinang.model.Employee;

@Singleton
public class EmployeeRepository implements EmployeeRepositoryInterface {

    @PersistenceContext
    private EntityManager manager;

    public EmployeeRepository(@CurrentSession EntityManager manager){
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly = true)
    public Long size() {
        Long count = manager.createQuery("select count(*) from Employee where deleted_at IS NULL", Long.class).getSingleResult();
        return count;
    }

    @Override
    @Transactional
    public List<Employee> findAll(int page, int limit) {
        TypedQuery<Employee> query = manager
                .createQuery("from Employee where deleted_at IS NULL", Employee.class)
                .setFirstResult(page > 1 ? page * limit - limit : 0)
                .setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(@NotNull Long id) {
        Employee query = manager.find(Employee.class, id);
        return query;
    }

    @Override
    @Transactional
    public boolean save(@NotNull Employee employee) {
        try {
            manager.persist(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(@NotNull Long id, String name,String email, String password, String employeeid, String employeecomname) {
        try {

            Employee c = manager.find(Employee.class, id);
            if (name.equals("-")==false) c.setName(name);
            if (email.equals("-")==false) c.setEmail(email);
            if (password.equals("-")==false) c.setPassword(password);
            if (employeeid.equals("-")==false) c.setEmployeeId(employeeid);
            if (employeecomname.equals("-")==false) c.setEmployeeComName(employeecomname);

          //  if (grade != 0) c.setGrade(grade);
            c.setUpdated_At(new Date());
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean destroy(@NotNull Long id) {
        try {
            Employee c = manager.find(Employee.class, id);
            c.setDeleted_At(new Date());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}