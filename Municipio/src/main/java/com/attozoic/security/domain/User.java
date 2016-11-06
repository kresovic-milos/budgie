package com.attozoic.security.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String username;

    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(){}

    public User(String username, String passwordHash, Role role){
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }


}