package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public Application(LocalDate date, User user) {
        this.date = date;
        this.user = user;
    }

    @OneToMany (mappedBy = "application",cascade=CascadeType.ALL)
    private List<ListEdition> listEditionAp;

    @OneToOne(mappedBy = "applicationBl")
    private BlackList blackList;

 //   public void addEdition (Edition edition) {
 //       if (listEditionAp==null || listEditionAp.isEmpty()) {
 //           listEditionAp = new ArrayList<>();
 //           }
 //       listEditionAp.add(edition);
 //   }

    @Override
    public String toString() {
        return "Application{" +
                "date=" + date +
                ", user=" + user +
                '}';
    }

}