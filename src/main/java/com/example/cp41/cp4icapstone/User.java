package com.example.cp41.cp4icapstone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USER")
@Accessors(fluent = true)
public class User implements Serializable {

    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    //private final @Id @Setter(AccessLevel.PRIVATE)long id;
    private @Id
    long id;

    private @NonNull String firstName;

    private @NonNull String lastName;

    private @NonNull String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}