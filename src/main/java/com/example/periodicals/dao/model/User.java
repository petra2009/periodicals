package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(name = "username", nullable = false, length = 16)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "errors.user.password")
    private String pass;

    @Enumerated(EnumType.STRING)
    private Role role;

    //@Column(name = "admin", nullable = false)
    //private Integer admin;




    @OneToMany(mappedBy = "user")
    private List<Application> applicationsUser;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}