package com.springproject.webapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authorities
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "authority")
    private String authority;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username")
    private User user;

    public Authorities(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }
}
