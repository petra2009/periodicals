package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    @Column(name = "password", nullable = false, length = 32)
    private String pass;

    @Column(name = "admin", nullable = false)
    private Integer admin;


}