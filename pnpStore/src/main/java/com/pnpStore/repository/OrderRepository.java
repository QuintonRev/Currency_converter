package com.pnpStore.repository;

//import OrderRepository used files
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.Order;

//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository
//CrudRepository - uses CRUD(Create,Read,Update and Delete) functionalities
//Interfaces - collection of abstract classes
public interface OrderRepository extends CrudRepository <Order, Integer> {



}
