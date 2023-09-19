package com.example.microservicesproject.microservices;

import com.example.microservicesproject.SQL.customerSQL;
import com.example.microservicesproject.generalFunctions;
import com.example.microservicesproject.objects.Customer;
import com.example.microservicesproject.services.customerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class userManager {
    @Autowired
    private customerService customerService;
    @Autowired
    private generalFunctions generalFunctions;
    @RequestMapping("/registration")
    public String register(Model model, @RequestParam("name") String username,
                           @RequestParam("pass") String password,
                           @RequestParam("pass2") String password2,
                           @RequestParam("avatar") MultipartFile img,
                           RedirectAttributes redirectAttributes){
        List<Customer> users = customerService.findAll();
        for(int i = 0;i<users.size();i++){
            if(Objects.equals(users.get(i).getName(), username)){
                String err = "e1";
                redirectAttributes.addAttribute("error", err);
                return "redirect:register";
            }
        }
        if(username==null){String err = "e5";redirectAttributes.addAttribute("error", err);return "redirect:register";}
        if(img==null){String err = "e7";redirectAttributes.addAttribute("error", err);return "redirect:register";}
        if(password==null){String err = "e8";redirectAttributes.addAttribute("error", err);return "redirect:register";}
        if(username.length()<2){String err = "e5";redirectAttributes.addAttribute("error", err);return "redirect:register";}
        if(password.length()<5){String err = "e6";redirectAttributes.addAttribute("error", err);return "redirect:register";}
        if(!password.equals(password2)){String err = "e2";redirectAttributes.addAttribute("error", err);return "redirect:register";}
        switch (generalFunctions.checkFile(img)) {
            case 1 -> {
                redirectAttributes.addAttribute("error", "fileE1");
                return "redirect:register";
            }
            case 2 -> {
                redirectAttributes.addAttribute("error", "fileE2");
                return "redirect:register";
            }
            case 3 -> {
                redirectAttributes.addAttribute("error", "fileE3");
                return "redirect:register";
            }
            case 4 -> {
                redirectAttributes.addAttribute("error", "fileE4");
                return "redirect:register";
            }
        }
        if(generalFunctions.checkFile(img)==0){

        }

        return "index";
    }
    @RequestMapping("/")
    public String login(Model model, @RequestParam("name") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes, HttpSession session){
        List<Customer> users = customerService.findAll();
        Optional<Customer> matchingUser = users.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst();
        if(matchingUser.isPresent()){
            if(passwordEncoder.matches(password, matchingUser.get().getPassword())){
                Customer user = matchingUser.get();
                session.setAttribute("user", user);                                 //cele zleeeeee
                String imagePath = "/resources/images/"+matchingUser.get().getImg();
                model.addAttribute("user", user);
                model.addAttribute("img", imagePath);
                return "contents";
            }else{
                String err = "e3";
                redirectAttributes.addAttribute("error", err);
                return "redirect:index";
            }
        }else{
            String err = "e4";
            redirectAttributes.addAttribute("error", err);
            return "redirect:index";
        }
    }
}
