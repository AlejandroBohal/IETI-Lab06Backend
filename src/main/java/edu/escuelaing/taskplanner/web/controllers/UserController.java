package edu.escuelaing.taskplanner.web.controllers;

import edu.escuelaing.taskplanner.business.Entities.User;
import edu.escuelaing.taskplanner.business.Services.IUserService;
import edu.escuelaing.taskplanner.exceptions.UserServiceException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<User> users = userService.getAll();
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable String userId){
        try{
            User user = userService.getById(userId);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch(UserServiceException e){
            Map<String,String> result = new HashMap<>();
            result.put("error",e.getMessage());
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteById(@PathVariable String userId){
        try{
            userService.remove(userId);
            return new ResponseEntity<>(String.format("Deleted %s",userId),HttpStatus.OK);
        }catch (UserServiceException e){
            Map<String,String> result = new HashMap<>();
            result.put("error",e.getMessage());
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            userService.create(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch (Exception e){
            Map<String,String> result = new HashMap<>();
            result.put("error","Email already in use");
            return new ResponseEntity<>(result,HttpStatus.CONFLICT);
        }

    }
    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserServiceException {
        try{
            userService.update(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (UserServiceException e){
            Map<String,String> result = new HashMap<>();
            result.put("error",e.getMessage());
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }
    }
}
