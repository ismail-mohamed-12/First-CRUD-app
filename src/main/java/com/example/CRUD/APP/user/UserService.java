package com.example.CRUD.APP.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserService( UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //creating a new user if the id didn't already exist
    public void createUser(Users user){
        Optional<Users> userById = userRepository.findUsersById(user.getId());
        if (userById.isPresent()){
            throw new IllegalStateException("the user already existed");
        }
        userRepository.save(user);


    }


    // to get the email based on the users id
    public String getUserEmailById(Long id) {
            Optional<Users> user= userRepository.findUsersById(id);
            //to check if the user is in the database or not
            if (user.isPresent()){
                return user.get().getEmail();
            }
            // if the id of the user wasn't in the database
            throw new NoSuchElementException("user couldn't be found with "+ id);

        }

    public String ChangeEmail(long id , String newEmail){
        Optional<Users> user= userRepository.findUsersById(id);
        if (user.isPresent()){
            user.get().setEmail(newEmail);
            userRepository.save(user.get());
            return newEmail;
        }
        throw new NoSuchElementException("the user couldn't be found so we couldn't update");
    }

    public String deleteUser ( long id){
        Optional<Users> user = userRepository.findUsersById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return "user was successful deleted";
        }
        throw new NoSuchElementException("the user's id doesn't exist");

    }



















}









