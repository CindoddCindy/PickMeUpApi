package cindy.sirihpinang.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cindy.sirihpinang.model.Employee;

public interface EmployeeRepositoryInterface {

    Long size();
    List<Employee> findAll (int page, int limit);
    Employee findById (@NotNull Long id);
    boolean save(@NotNull Employee employee);
    boolean update(@NotNull Long id, @NotBlank String name,@NotBlank String email, @NotBlank String password, @NotBlank String employeeid, @NotBlank String employeecomname); // @NotNull int grade);
    boolean destroy(@NotNull Long id);
}