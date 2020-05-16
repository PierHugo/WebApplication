package model;

import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;

@Entity
@Table(name = "User")
@DiscriminatorValue(value = "GenericUser")
public class User extends Person
{
    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String age, String city) {
        super(firstName, lastName, username, password, age, city);
    }
}
