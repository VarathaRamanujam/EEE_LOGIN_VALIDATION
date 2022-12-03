package com.hider.eee_students_login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.hider.Modeleee;


@Repository
public interface Repo extends JpaRepository<Modeleee,Integer>{
    
    Optional<Modeleee> findByLoginAndPassword(String login,String password); 
	
	Optional<Modeleee> findBylogin(String login);

	void save(Filemodel filemodel);
}
