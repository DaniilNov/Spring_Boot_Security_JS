package boot_hiber.springbootCRUD.controller;

import boot_hiber.springbootCRUD.dto.UserDto;
import boot_hiber.springbootCRUD.model.Role;
import boot_hiber.springbootCRUD.model.User;
import boot_hiber.springbootCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class RestClientController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/clients")

    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    public ResponseEntity<?> create(@RequestBody User user, @RequestParam String idRole) {
//        userService.addUser(user, idRole);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//}

    @GetMapping(value = "/clients")
    public ResponseEntity<List<User>> readAll() {
        List<User> users = userService.listUsers();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
//    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody User user, @RequestParam String idRole) {
//        user.setId(id);
//        userService.updateUser(user, idRole);
//        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
