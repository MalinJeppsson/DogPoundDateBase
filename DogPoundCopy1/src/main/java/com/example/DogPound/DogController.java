package com.example.DogPound;

import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import javax.xml.validation.Validator;
import java.util.*;

@Controller
public class DogController {
    @Autowired
    UserService userService;
    @Autowired
    BookingService bookingService;
    @GetMapping("/")
    String mainPage(Model model, HttpSession session) {
        if (session.getAttribute("ownerName") == null) {
            session.setAttribute("ownerName", "Ej inloggad");
        }
        model.addAttribute(model);
        return "mainPage";
    }

    @GetMapping("/createUser")
    String login(Model model) {

        model.addAttribute("user", new User());
        return "createUser2";
    }

    @PostMapping("/createUser")
    public String login(@Valid User user, BindingResult bindingResult, HttpSession session, @RequestParam String ownerName) {
        if (bindingResult.hasErrors()) {
            return "createUser2";
        }
        User createdUser = userService.createUser(user);
        session.setAttribute("ownerName", createdUser.getOwnerName());
        session.setAttribute("email", createdUser.getEmail());
        session.setAttribute("bookingString", createdUser.getBookings());

        return "myProfile";

    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/login")
    String login(HttpSession session, @RequestParam String email, @RequestParam String password) {
        User user = userService.findUserByEmailAndByPassword(email, password);
        if(user != null){
            session.setAttribute("ownerName", user.getOwnerName());
            session.setAttribute("email", email);
            session.setAttribute("bookingString", user.getBookings());
            return "myProfile";
        }

        return "login";
    }

    @GetMapping("/editMyProfile")
    String user (HttpSession session, Model model) {
        String email = (String)session.getAttribute("email");
        User user = userService.getUser(email);
        model.addAttribute("user", user);
        return "editProfile";
    }

    @PostMapping ("/editMyProfile")
    String editUser (@ModelAttribute User user, Model model, BindingResult bindingResult, HttpSession session){
    validate(user, bindingResult);
    if (bindingResult.hasErrors()) {
        return "editProfile";
        }
        userService.editUser(user);
        session.setAttribute("ownerName", user.getOwnerName());
        return "myProfile";

    }


    @GetMapping("/myProfile")
    String myProfile (HttpSession session) {
        String email = (String)session.getAttribute("email");
        if (email != null){
            return "myProfile";
        } else
            return "mainPage";

    }
    @GetMapping("/logout")
    String logout(HttpSession session) {
        session.removeAttribute("ownerName");
        session.removeAttribute("bookingString");
        session.removeAttribute("email");
        return "redirect:/";
    }

    @GetMapping("/booking")
    String booking () {

        return "timeSlots";
    }

    private void validate(User user, BindingResult bindingResult){
        if (user.getOwnerName() == null || user.getOwnerName().equals("")) {
            bindingResult.rejectValue("ownerName", "wrong input");
        }
        if (user.getOwnerLastName() == null || user.getOwnerLastName().equals("")) {
            bindingResult.rejectValue("ownerLastName", "wrong input");
        }
        if (user.getDogName() == null || user.getDogName().equals("")
                || user.getDogName().length() < 2 || user.getDogName().length() > 30){
            bindingResult.rejectValue("dogName", "wrong input");
        }
        if (user.getPassword() == null || user.getPassword().equals("")
                || user.getPassword().length() < 5 || user.getPassword().length() > 25){
            bindingResult.rejectValue("password", "wrong input");
        }
        if (user.getPhoneNumber() == null || user.getPhoneNumber().matches("^[0-9]{3}[0-9- .]{4,10}+$") != true){
            bindingResult.rejectValue("phoneNumber", "wrong input");

        }

    }


}
