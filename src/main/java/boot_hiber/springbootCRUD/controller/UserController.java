package boot_hiber.springbootCRUD.controller;

import boot_hiber.springbootCRUD.model.User;
import boot_hiber.springbootCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    final private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("user-add")
    public String addUserForm(User user) {
        return "user-add";
    }

    @PostMapping("user-add")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping("user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}
