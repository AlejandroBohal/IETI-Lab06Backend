package edu.escuelaing.taskplanner.business.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Getter @Setter
    private String userName;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;

}
