package Controllers;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.util.List;

/**
 * Created by akshay.Gupta on 1/12/2015.
 */
@Entity
@Table(name = "employee", schema = "", catalog = "my_db")
public class EmployeeEntity {
    private String name;
    private String username;
    private String password;
    private String confirmPassword;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Confirm_Password")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (confirmPassword != null ? !confirmPassword.equals(that.confirmPassword) : that.confirmPassword != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (confirmPassword != null ? confirmPassword.hashCode() : 0);
        return result;
    }

    public boolean authenticate_login(){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Criteria cr = session.createCriteria(EmployeeEntity.class);

        Criterion username = Restrictions.eq("username",this.getUsername());
        Criterion password = Restrictions.eq("password",this.getPassword());

        cr.add(Restrictions.and(username,password));
        List ans = cr.list();

        if(ans.isEmpty()){
            return false;
        } else {
            return true;
        }

    }

    public String Authenticate_and_register(){

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Criteria cr = session.createCriteria(EmployeeEntity.class);

        Criterion username = Restrictions.eq("username",this.getUsername());
        cr.add(username);
        List ans = cr.list();
        if(!ans.isEmpty()) return "User_already_exists";

        Transaction t = session.beginTransaction();
        session.persist(this);
        t.commit();
        session.close();
        return "success";
    }

}
