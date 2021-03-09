package edu.escuelaing.taskplanner.exceptions;

public class UserServiceException extends Exception {
    public static final String USER_NOT_FOUND_EXCEPTION = "User not found";
    public UserServiceException(String message){
        super(message);
    }
}
