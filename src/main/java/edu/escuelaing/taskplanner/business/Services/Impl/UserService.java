package edu.escuelaing.taskplanner.business.Services.Impl;

import edu.escuelaing.taskplanner.business.Entities.User;
import edu.escuelaing.taskplanner.business.Repositories.IUserRepository;
import edu.escuelaing.taskplanner.business.Services.IUserService;
import edu.escuelaing.taskplanner.exceptions.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(String userId) throws UserServiceException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserServiceException(UserServiceException.USER_NOT_FOUND_EXCEPTION));

        return user;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws UserServiceException {
        userRepository.findById(user.getUserId())
                .orElseThrow(() -> new UserServiceException(UserServiceException.USER_NOT_FOUND_EXCEPTION));
        userRepository.update(user);
        return user;
    }

    @Override
    public void remove(String userId) throws UserServiceException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserServiceException(UserServiceException.USER_NOT_FOUND_EXCEPTION));
        userRepository.delete(user.getUserId());
    }
}
