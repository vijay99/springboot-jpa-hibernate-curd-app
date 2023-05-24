package com.abc.springbootjpahibernatecurdapp.repo;

import com.abc.springbootjpahibernatecurdapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByFirstName(String firstName);

    @Query(value = "SELECT * FROM employee WHERE last_name =:value", nativeQuery = true)
    List<Employee> findByLastNameUsingNativeSQL(@Param("value") String lastName);
}
