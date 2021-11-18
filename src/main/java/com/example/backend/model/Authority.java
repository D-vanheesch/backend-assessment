package com.example.backend.model;

import javax.persistence.*;
import java.io.Serializable;

//Authority is voor PostgresQL voor DataSQL.

@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String authority;

    /**
     * Get username based on getUsername
     *
     * @return username, username attached to getUsername
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username based on setUsername
     *
     * @return username, username attached to setUsername
     */
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
