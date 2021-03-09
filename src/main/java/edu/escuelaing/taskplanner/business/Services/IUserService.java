package edu.escuelaing.taskplanner.business.Services;

import edu.escuelaing.taskplanner.business.Entities.User;
import edu.escuelaing.taskplanner.exceptions.UserServiceException;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();

    User getById(String userId) throws UserServiceException;

    User create(User user);

    User update(User user);

    void remove(String userId) throws UserServiceException;
}
