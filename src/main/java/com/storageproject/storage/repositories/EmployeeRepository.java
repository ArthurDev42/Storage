package com.storageproject.storage.repositories;

import com.storageproject.storage.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
