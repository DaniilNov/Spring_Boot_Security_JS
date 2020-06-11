package boot_hiber.springbootCRUD.controller;



import boot_hiber.springbootCRUD.model.User;
import boot_hiber.springbootCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ModelAndView ListUsers() {
//        List<User> users = userService.listUsers();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users");
//        modelAndView.addObject("listUsers", users);
        List<User> users = userService.listUsers();
        ModelAndView modelAndView = new ModelAndView();
        User authuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User();
        modelAndView.setViewName("users");
        modelAndView.addObject("listUsers", users);
        modelAndView.addObject("user", user);
        modelAndView.addObject("authuser",authuser);

        return modelAndView;
    }


//    @GetMapping("/users/remove/{id}")
//    public String removeUser(@PathVariable("id") Long id) {
//        userService.removeUser(id);
//        return "redirect:/users";
//    }


//    @GetMapping("/users/edit/{id}")
//    public ModelAndView editPage(@PathVariable("id") Long id) {
//        User user = userService.getUserById(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editUser");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }

    @GetMapping("/users/remove/{id}")
    public String removeUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {

        userService.removeUser(id);
        return "redirect:/users";
    }

    @PostMapping("/users/edit/{id}")
    public ModelAndView editUser(@ModelAttribute("user") User user ,@PathVariable("id") Long id, @RequestParam String[] checkboxRoles) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.updateUser(user,checkboxRoles);
        return modelAndView;
    }


    @GetMapping("/users/add")

    public String addPage(User user){
        return "addUser";
//    public ModelAndView addPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("addUser");
//        return modelAndView;
    }


    @PostMapping("/users/add")
    public ModelAndView addUser(@ModelAttribute("user") User user, BindingResult result, @RequestParam String[] checkboxRoles) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.addUser(user, checkboxRoles);
        return modelAndView;
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


}
