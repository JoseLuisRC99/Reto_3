package com.example.reto_c3.Model;

import javax.persistence.*;

@Entity
@Table(name = "score")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAdmin;
    private String email;
    private String name;
    private String password;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
