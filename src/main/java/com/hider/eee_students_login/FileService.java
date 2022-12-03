package com.hider.eee_students_login;

import java.util.List;


public interface FileService {

	public void saveFile(Filemodel filemodel) ;
	public List <Filemodel >getAllFile();
	public Filemodel getFile(int id);
		
	
}
