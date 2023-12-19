package com.championship.championshipservices.model;
import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String email;
    public String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
