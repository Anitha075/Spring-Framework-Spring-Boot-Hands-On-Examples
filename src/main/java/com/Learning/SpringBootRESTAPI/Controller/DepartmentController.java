package com.Learning.SpringBootRESTAPI.Controller;

import com.Learning.SpringBootRESTAPI.Error.DepartmentNotFoundException;
import com.Learning.SpringBootRESTAPI.Model.Department;
import com.Learning.SpringBootRESTAPI.Service.DepartmentService;
import com.Learning.SpringBootRESTAPI.Service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger logger= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
       logger.info("saved successfully");
       return departmentService.saveDepartment(department);
    }
    @GetMapping("/department")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/department/{id}")
    public Department fetchdepartmentbyid(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        logger.info("fetched from the department on ID successfully");
        return departmentService.fetchdepartmentbyid(departmentId);
    }
    @DeleteMapping("/department/{id}")
    public String deletedepartmentbyid(@PathVariable("id") Long departmentId){
        departmentService.deletedepartmentbyid(departmentId);
        return "deleted";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department)
    {
        return departmentService.updatDepartment(departmentId,department);
    }
    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
