package cindy.sirihpinang.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employee")
public class Employee{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    

    @NotNull (message = "name empty.")
    @Column(name = "name")
    private String name;

    @NotNull (message = "email empty.")
    @Column(name = "email")
    private String email;


    @NotNull (message = "password empty.")
    @Column(name = "password")
    private String password;

    @NotNull (message = "Employee Id Empty.")
    @Column(name = "employeeid")
    private String employeeid;

    @NotNull (message = " Employee Company Name Empty.")
    @Column(name = "employeecompname")
    private String employeecompname;


    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    @Column(name = "deleted_at")
    private Date deleted_at;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeid;
    }

    public void setEmployeeId(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeeComName() {
        return employeecompname;
    }

    public void setEmployeeComName(String employeecompname) {
        this.employeecompname = employeecompname;
    }

   
    public Date getCreated_At() {
        return created_at;
    }

    public void setCreated_At(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_At() {
        return updated_at;
    }

    public void setUpdated_At(Date updated_at) {

        this.updated_at = updated_at;
    }

    public Date getDeleted_At() {
        return deleted_at;
    }
    
    public void setDeleted_At(Date deleted_at) {

        this.deleted_at = deleted_at;
    }

}