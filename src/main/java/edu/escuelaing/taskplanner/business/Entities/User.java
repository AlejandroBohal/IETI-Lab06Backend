package edu.escuelaing.taskplanner.business.Entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name="users")

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter @Setter
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "userid")
    private String userId;
    @Getter @Setter
    private String userName;
    @Column(name="email",unique = true)
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;

}
