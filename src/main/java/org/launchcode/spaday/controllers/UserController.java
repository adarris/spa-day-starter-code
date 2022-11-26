package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

   @GetMapping("/add")
    public String displayAddUserForm(Model model){
       model.addAttribute(new User());
       return "user/add";
    }
    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        // add form submission handling code here
//        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());


        if (errors.hasErrors()){
            model.addAttribute("error", "WHAT THE F***?");
            return "user/add";
        } else {
            if (user.getPassword().equals(verify)){
                return "user/index";
            } else {
                model.addAttribute("error", "Passwords do not match");
                return "user/add";
            }

        }

    }
}
