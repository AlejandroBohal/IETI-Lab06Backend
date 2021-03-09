package edu.escuelaing.taskplanner.business.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter @Setter
    @Id
    private String userId;
    @Getter @Setter
    private String userName;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
}
