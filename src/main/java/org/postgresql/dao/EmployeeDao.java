package org.postgresql.dao;

import org.postgresql.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

}
