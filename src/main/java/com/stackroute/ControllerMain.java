package com.stackroute;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControllerMain {

    @PostMapping({"/home","/"})
    public String index(HttpServletRequest req, Model m) {
        String clrt=req.getParameter("clrr");
          m.addAttribute("clr", clrt);

        return ("index");
    }

//    @GetMapping
//    public String indexx() {
//
//
//        return ("index");
//    }

//    @PostMapping("/hola")
//    public String index(HttpServletRequest req, Model m) {
//        String clrt=req.getParameter("clrr");
//        m.addAttribute("clr", clrt);
//
//        return ("index");
//    }



    @PostMapping("/display")
    public String indexOne(HttpServletRequest req, Model m) {



        String name=req.getParameter("name");


        String msg="Hello "+ name;
        m.addAttribute("message", msg);
        return ("display");
    }

    @PostMapping("/displayUser")
    public String indexTwo(HttpServletRequest req, Model m) {


        final String password="123abc";
        String UserName=req.getParameter("name");
        String passwordEntered=req.getParameter("pass");
        User user=new User(UserName,passwordEntered);
String msg="";
        if(password.equals(passwordEntered))
        {
            msg="hello"+user.getName()+"your password is correct ,welcome";
        }
        else
        {
            msg="Wrong password ACCESS DENIED!!";
        }


        m.addAttribute("ola", msg);
        return ("displayUser");
    }


}
