package com.example.CRUD.APP.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController( UserService userService){
        this.userService= userService;
    }

    //create a user
    @PostMapping()
    public void CreateUser (@RequestBody Users user){


        userService.createUser(user);

    }

//getting the email of the user by id
    @GetMapping("/{id}")
    public ResponseEntity<String> getUserEmail(@PathVariable("id") Long id) {
        try {
            String email = userService.getUserEmailById(id);  // Get the email (not the whole user)
            return ResponseEntity.ok(email);
        } catch (Exception e) {
            // Handle any unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }
    //changing the email values of an old user and gives the new user email back
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserEmail(@PathVariable("id") long id, @RequestBody Users user){
        try{

            String newEmail = userService.ChangeEmail(id,user.getEmail());
            return ResponseEntity.ok(newEmail);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){

        try{
            return ResponseEntity.ok(userService.deleteUser(id));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an error occurred"+e.getMessage());
        }

    }








}






