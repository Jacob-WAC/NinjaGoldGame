package jj.game;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	Random rand = new Random();
	ArrayList<String> messages = new ArrayList<String>();
	
	
	
	@RequestMapping("/")
    public String index(HttpSession session, Model model) {
		
		if (session.getAttribute("messages") == null) {
			session.setAttribute("messages", messages);}
		
		model.addAttribute("messages",session.getAttribute("messages"));
		
		
		if (session.getAttribute("gold") == null) {
		session.setAttribute("gold", 0);}
		model.addAttribute("gold",session.getAttribute("gold"));
	
        return "index.jsp";
    }
	 @RequestMapping(value="/send", method=RequestMethod.POST)
     public String play(@RequestParam(value="whichButton") String whichButton,HttpSession session) {
		 System.out.println(whichButton);
		 int randomNum;
		 if(whichButton.contains("farm")) {
			 session.setAttribute("gold", (Integer) session.getAttribute("gold") + (randomNum = rand.nextInt((20 - 10) + 1) + 10));
			 messages.add(String.format("you entered a farm and earned %s gold", randomNum));
			 session.setAttribute("messages", messages);
		 } else if (whichButton.contains("cave")) {
			 session.setAttribute("gold",(Integer) session.getAttribute("gold") + (randomNum = rand.nextInt((10 - 5) + 1) + 5));
			 messages.add(String.format("you entered a cave and earned %s gold", randomNum));
			 session.setAttribute("messages", messages);
		 } else if (whichButton.contains("house")) {
			 session.setAttribute("gold",(Integer) session.getAttribute("gold") + (randomNum = rand.nextInt((5 - 2) + 1) + 2));
			 messages.add(String.format("you entered a house and earned %s gold", randomNum));
			 session.setAttribute("messages", messages);
		 } else if (whichButton.contains("casino")) {
			 randomNum = rand.nextInt(2);
			
			 if (randomNum == 0) {
			 session.setAttribute("gold",(int) session.getAttribute("gold") + (randomNum = rand.nextInt(51)));
			 messages.add(String.format("you entered a casino and earned %s gold", randomNum));
			 session.setAttribute("messages", messages);
			
			 }
			 else if (randomNum  == 1) {
			 session.setAttribute("gold",(int) session.getAttribute("gold") - (randomNum = rand.nextInt(51))); 
			 messages.add(String.format("you entered a casino and lost %s gold", randomNum));
			 session.setAttribute("messages", messages);
				 }
		 }
		 return "redirect:/";
		 }
	
	 	
	 @RequestMapping("/delete")
	    public String clear(HttpSession session) {
		 session.invalidate();
		 messages.clear();
		 return "redirect:/";
	 }
	
	
	
}
