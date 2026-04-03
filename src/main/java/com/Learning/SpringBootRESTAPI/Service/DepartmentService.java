package com.Learning.SpringBootRESTAPI.Service;

import com.Learning.SpringBootRESTAPI.Error.DepartmentNotFoundException;
import com.Learning.SpringBootRESTAPI.Model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchdepartmentbyid(Long departmentId) throws DepartmentNotFoundException;

    void deletedepartmentbyid(Long departmentId);

    Department updatDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
