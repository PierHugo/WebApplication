package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
@DiscriminatorValue(value = "GenericUser")
public class Admin extends User
{
    public Admin(String firstName, String lastName, String username, String password, String age, String city) {
        super(firstName, lastName, username, password, age, city);
    }
}
