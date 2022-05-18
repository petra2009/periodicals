package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "black_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BlackList extends BaseEntity {

    @Column(name = "user_id")
    private Integer userId;

//    @Column(name = "applications_id")
//    private Integer applicationsId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applications_id")
    private Application applicationBl;
}