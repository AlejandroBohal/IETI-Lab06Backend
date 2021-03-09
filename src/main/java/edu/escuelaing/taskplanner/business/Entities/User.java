package edu.escuelaing.taskplanner.business.Entities;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private String userId;
    @Getter @Setter
    private String userName;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
}
