package com.practice.project02.demo.project;

import com.practice.project02.demo.project.entity.Employee;
import java.util.List;

public interface EmployeeService {

    public String saveEmp(Employee emp);
    public Employee getById( Long id);
    public List<Employee> getAllEmp ();
    public String deleteById(Long id);
}
