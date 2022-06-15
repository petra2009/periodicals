package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "list_editions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListEdition extends BaseEntity {
    @Column(name = "number_of_months")
    private Integer numberOfMonths;

    @ManyToOne()
    @JoinColumn(name = "applications_id")
    private Application application;

    @ManyToOne()
    @JoinColumn(name ="edition_id")
    private Edition edition;

    @Override
    public String toString() {
        return "ListEdition{" +
                "numberOfMonths=" + numberOfMonths +
                ", application=" + application +
                ", edition=" + edition +
                '}';
    }
}