package com.codewithtopgyal.store.controllers;

import com.codewithtopgyal.store.dtos.UserDto;
import com.codewithtopgyal.store.entities.User;
import com.codewithtopgyal.store.mappers.UserMapper;
import com.codewithtopgyal.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
        // we will use lombok @AllArgsConstructor
        //    public UserController(UserRepository userRepository) {
        //        this.userRepository = userRepository;
        //    }

    // change return type method from list to Iterable
//    @RequestMapping("/users")
    @GetMapping  // alias for @RequestMapping
    public Iterable<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
//                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
                // now instead of manually mapping user to userdto we can call userMapper
//                .map(user -> userMapper.toDto(user)) // convert to lambda

    }
    @GetMapping("/{id}")  // alias for @RequestMapping
    public ResponseEntity<UserDto> getUser(@PathVariable Long id ){
        var user =  userRepository.findById(id).orElse(null);
        if(user == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // one way
            return ResponseEntity.notFound().build(); // cleaner way
        }
//        return new  ResponseEntity<>(user, HttpStatus.OK);
//        var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(userMapper.toDto(user)); // cleaner
    }

}
