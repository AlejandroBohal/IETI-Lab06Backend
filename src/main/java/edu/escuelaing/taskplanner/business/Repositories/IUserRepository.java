package edu.escuelaing.taskplanner.business.Repositories;

import edu.escuelaing.taskplanner.business.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends CrudRepository<User,String> {

    @Query(value = "DELETE FROM users u WHERE u.id = :userId", nativeQuery = true)
    void delete(@Param("userId") String userId);

}
