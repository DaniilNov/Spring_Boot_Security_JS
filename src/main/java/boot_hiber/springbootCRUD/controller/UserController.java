package boot_hiber.springbootCRUD.controller;



import boot_hiber.springbootCRUD.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {


    @GetMapping("/hello")
    public ModelAndView printWelcome() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("user", user);
        return modelAndView;
    }


}
