package edu.escuelaing.taskplanner.business.Repositories;

import edu.escuelaing.taskplanner.business.Entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserRepository extends CrudRepository<User,String> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM users WHERE userid = :userId", nativeQuery = true)
    void delete(@Param("userId") String userId);

    @Transactional
    @Modifying
    @Query(value ="UPDATE users set user_name= :#{#user.userName}," +
            " email = :#{#user.email}," +
            " password= :#{#user.password} WHERE userid = :#{#user.userId}",nativeQuery = true)
    void update(@Param("user") User user);
}
