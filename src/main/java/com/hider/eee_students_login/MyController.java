package com.hider.eee_students_login;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;





//import com.hider.Modeleee;


@Controller
public class MyController {


    @Autowired
    private  Serviceee obj;

  
    @GetMapping("/register")
	public String register_page(Model model) {	
		model.addAttribute("registerRequest", new Modeleee());
		return "register_page";
	}

    @GetMapping("/login")
	public String login_page(Model model) {
		model.addAttribute("loginRequest", new Modeleee());
		return "login";
	}
	
    @PostMapping("/register")
	public String register(@ModelAttribute Modeleee usermodel) {
		System.out.println("register request :"+ usermodel);
		Modeleee registered=obj.registerUser(usermodel.getLogin(),usermodel.getPassword(),usermodel.getName(),usermodel.getPhone_no());
	    return registered == null ?"error":"redirect:/login";
	}
    
    @PostMapping("/login")
	public String login(@ModelAttribute Modeleee usermodel ,Model model) {
		System.out.println("login request :"+usermodel);
		Modeleee auth=obj.authenticate(usermodel.getLogin(),usermodel.getPassword());
	   if(auth !=null) {
		   model.addAttribute("RegisterNumber", auth.getLogin());
		   model.addAttribute("Name", auth.getName());
		   model.addAttribute("PhoneNumber", auth.getPhone_no());
		   return "personal";
	   }else
		   return "error";
	}
    
    
    @PostMapping("/upload")
	@ResponseBody
	public String method(@RequestParam("file")MultipartFile file,Model model) throws IOException {
		byte[] content=file.getBytes();
		String name = file.getOriginalFilename();
		String filetype= file.getContentType();
		
		Filemodel filemodel = new Filemodel(name,filetype,content);
		obj.saveFile(filemodel);
//		System.out.println(filemodel.getFiletype());
//		model.addAttribute("allFile", obj.getAllFile());
		return "DisplayFile";
	}
    
}
