package io.duqow.app.restAPI.Controller;

import io.duqow.app.restAPI.Models.User;
import io.duqow.app.restAPI.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String SaveUser(@RequestBody User user){
        userRepo.save(user);
        return "saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String UpdateUser(@PathVariable long id, @RequestBody User user){
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        return "updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String DeleteUser(@PathVariable long id, @RequestBody User user){
        User user1 = userRepo.findById(id).get();

        userRepo.delete(user1);
        return "deleted...";
    }

}
