package com.example.DogPound;

import com.example.DogPound.Classes.Booking;
import com.example.DogPound.Classes.User;
import com.example.DogPound.Classes.Week;
import com.example.DogPound.Services.BookingService;
import com.example.DogPound.Services.UserService;
import com.example.DogPound.Services.WeekService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DogController {
    @Autowired
    UserService userService;
    @Autowired
    WeekService weekService;
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
        session.setAttribute("userId", createdUser.getId());

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
            List<String> bookingString = userService.convertBookingsToStringList(user);
            session.setAttribute("ownerName", user.getOwnerName());
            session.setAttribute("email", email);
            session.setAttribute("bookingString", bookingString);
            session.setAttribute("userId", user.getId());
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

        return "selectWeek";
    }
    @PostMapping("/booking")
    String bookingConfirmed(@RequestParam String selectedWeek, @RequestParam String selectedDay, Model model, HttpSession session) {
        Week week = weekService.createNewWeekOrReturnIfAlreadyExists(selectedWeek);
        User user = userService.getUser((Long)(session.getAttribute("userId")));
        Booking booking = bookingService.createNewBooking(selectedDay, week, user);
        List<String> bookingString = userService.convertBookingsToStringList(user);
        session.setAttribute("bookingString", bookingString);


//        Week week = weekService.returnSpecificWeek(selectedWeek);
//        List<Day> days = week.getWeekDays();
//        model.addAttribute("selectedWeek", selectedWeek); //string
//        model.addAttribute("days", days);
//        model.addAttribute("week",week);
//        session.setAttribute("week", week);
        return "myProfile";
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
