package com.hider.eee_students_login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



//import com.hider.Modeleee;


@Service
public class Serviceee implements FileService {

    @Autowired
    private  Repo obj;


    public Modeleee  registerUser(String login,String password,String name,String phone_no) {
		if(login==null || password==null) {
			return null;
		}else {
			if(obj.findBylogin(login).isPresent()) {
				System.out.println("Duplicate Login");
				return null;
			}
			Modeleee usermodel = new Modeleee();
			usermodel.setLogin(login);
			usermodel.setName(name);
            usermodel.setPhone_no(phone_no);
			usermodel.setPassword(password);
		   return	obj.save(usermodel);		
		}	
	}
	
	
	public Modeleee authenticate(String login,String password) {
		return 	obj.findByLoginAndPassword(login, password).orElse(null);
	}
	
	
	public void saveFile(Filemodel filemodel) {
		obj.save(filemodel);
	}


	@Override
	public List<Filemodel> getAllFile() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Filemodel getFile(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public List<Filemodel> getAllFile() {
//		//List <Filemodel> ls=(List<Filemodel>)
//		return	(List<Filemodel>) obj.findAll();
//		 
//	}
//
//	
//	public Modeleee getFile(int id) {
//		Modeleee refer = obj.findById(id).get();
//		return refer;
//	}
    
    
}
