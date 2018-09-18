package com.pnpStore.repository;

//import UsersRepository used files
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.User;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository
//CrudRepository - uses CRUD(Create,Read,Update and Delete) functionalities
//Interfaces - collection of abstract classes
public interface UsersRepository extends CrudRepository <User, Integer> {

		

}
