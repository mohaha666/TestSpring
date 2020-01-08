package com.my.repo;

import com.my.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Transient;
import java.util.List;
@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {
    @Transient
    @Query("select distinct s from User s where s.userName = :userName and s.password = :password ")
    List<User> hasMatchUser(@Param("userName") String userName, @Param("password") String password);


    @Transient
    @Query("select distinct s from User s where s.userName = :userName ")
    User findUserByUserName(@Param("userName") String userName);
}
