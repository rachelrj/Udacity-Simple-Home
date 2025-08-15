package org.example.simplehome;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model, HttpSession session) {
        Boolean seen = (Boolean) session.getAttribute("SEEN_HOME");
        boolean firstVisit = (seen == null);
        session.setAttribute("SEEN_HOME", true);

        model.addAttribute("firstVisit", firstVisit);
        return "home";
    }

}
