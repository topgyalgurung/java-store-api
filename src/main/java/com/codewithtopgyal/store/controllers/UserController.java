package com.codewithtopgyal.store.controllers;

import com.codewithtopgyal.store.dtos.RegisterUserRequest;
import com.codewithtopgyal.store.dtos.UpdateUserRequest;
import com.codewithtopgyal.store.dtos.UserDto;
import com.codewithtopgyal.store.entities.User;
import com.codewithtopgyal.store.mappers.UserMapper;
import com.codewithtopgyal.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

//    @RequestMapping("/users")
    @GetMapping  // alias for @RequestMapping
    public Iterable<UserDto> getAllUsers(
            @RequestParam(required=false, defaultValue = "", name="sort") String sort
    ){
        if(!Set.of("name", "email").contains(sort))
            sort = "name";
        return userRepository.findAll(Sort.by(sort))
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
            return ResponseEntity.notFound().build(); // cleaner way
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // one way
        }
        return ResponseEntity.ok(userMapper.toDto(user)); // cleaner
//       return new  ResponseEntity<>(user, HttpStatus.OK);
//        var userDto = new UserDto(user.getId(), user.getName(), user.getEmail())
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder
            ){
        var user = userMapper.toEntity(request);
        userRepository.save(user);

        var userDto = userMapper.toDto(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateUserRequest request) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        // if user exists, update with data in our request
        userMapper.update(request, user);
        userRepository.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        var user = userRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
}
