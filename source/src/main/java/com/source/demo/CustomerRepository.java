package com.source.demo;

import com.demo.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findAllByStateOrderById(String state);
}
