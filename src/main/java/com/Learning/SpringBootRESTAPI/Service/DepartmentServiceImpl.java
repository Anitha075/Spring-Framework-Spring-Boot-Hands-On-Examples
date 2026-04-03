package com.Learning.SpringBootRESTAPI.Service;

import com.Learning.SpringBootRESTAPI.Error.DepartmentNotFoundException;
import com.Learning.SpringBootRESTAPI.Model.Department;
import com.Learning.SpringBootRESTAPI.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
  private DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepo.findAll();
    }

    @Override
    public Department fetchdepartmentbyid(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepo.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("department not foundddddd");
        }

            return department.get();

    }
    @Override
    public void deletedepartmentbyid(Long departmentId) {
         departmentRepo.deleteById(departmentId);
    }

    @Override
    public Department updatDepartment(Long departmentId, Department department) {
       Department dp=departmentRepo.findById(departmentId).orElseThrow(()->new RuntimeException("Department not found"));
       if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())
       )
       {
           dp.setDepartmentName(department.getDepartmentName());
       }
 if(department.getDepartmentCode()!=null && !department.getDepartmentCode().isBlank())
 {
     dp.setDepartmentCode(department.getDepartmentCode());
 }
 if(department.getDepartmentAddress()!=null && !department.getDepartmentAddress().isBlank())
 {
     dp.setDepartmentAddress(department.getDepartmentAddress());
 }
  return departmentRepo.save(dp);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepo.findByDepartmentNameIgnoreCase(departmentName);
    }
}
