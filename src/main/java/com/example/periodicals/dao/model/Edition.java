package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "editions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Edition extends BaseEntity {

    @Column (name="title")
    private String title;

    @Column (name="description")
    private String description;

    @Column(name = "price_per_month", precision = 5, scale = 2)
    private BigDecimal pricePerMonth;

    @OneToMany (mappedBy = "edition",cascade=CascadeType.ALL)
    private List<ListEdition> listEditionEd;




}