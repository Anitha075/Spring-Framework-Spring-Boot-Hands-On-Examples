package com.Learning.SpringBootRESTAPI.Service;

import com.Learning.SpringBootRESTAPI.Model.Department;
import com.Learning.SpringBootRESTAPI.Repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
     @MockBean
    private DepartmentRepo departmentRepo;
    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentName("IT")
                .departmentCode("066")
                .departmentAddress("vskp")
                .build();
        Mockito.when(departmentRepo.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }
    @Test
    @DisplayName("get data based pm valid dp name")
    @Disabled
    public void WhenValidDepartmentName_thenDepartmentShouildFound()
    {
         String  departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}