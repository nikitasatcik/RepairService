package kolchiba.springservice.controllers;

import kolchiba.springservice.domain.User;
import kolchiba.springservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }

    @RequestMapping("user/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userform";
    }

    @RequestMapping("user/new")
    public String newProduct(Model model) {
        User u = new User();
        model.addAttribute("user", userService.saveUser(u));
        return "userform";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveProduct(User user) {

        userService.saveUser(user);
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, User user, Model model) {
        model.addAttribute("user", userService.deleteUserById(id, user));
        return "redirect:/users/";
    }
}
