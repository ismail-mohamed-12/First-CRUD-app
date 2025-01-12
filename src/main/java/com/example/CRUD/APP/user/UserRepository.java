package com.example.CRUD.APP.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository <Users,Long>{

    Optional<Users> findUsersById(long id);
    Optional<Users> findUsersByName (String name);
    Optional<Users> deleteById(long id);



}
