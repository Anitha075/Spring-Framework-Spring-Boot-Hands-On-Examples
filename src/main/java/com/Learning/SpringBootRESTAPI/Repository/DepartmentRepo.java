package com.Learning.SpringBootRESTAPI.Repository;

import com.Learning.SpringBootRESTAPI.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
  public Department findByDepartmentName(String departmentName);
  public Department findByDepartmentNameIgnoreCase(String departmentName);
}
