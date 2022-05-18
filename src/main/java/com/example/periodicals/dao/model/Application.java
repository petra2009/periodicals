package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (mappedBy = "application")
    private List<ListEdition> listEditionAp;

    @OneToOne(mappedBy = "applicationBl")
    private BlackList blackList;

    @Override
    public String toString() {
        return "Application{" +
                "date=" + date +
                ", user=" + user +
                '}';
    }
}