package com.Learning.SpringBootRESTAPI.Repository;

import com.Learning.SpringBootRESTAPI.Model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private TestEntityManager testEntityManager;
    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentName("IT")
                .departmentAddress("MUMBAI")
                .departmentCode("IT-06")
                .build();
        testEntityManager.persist(department);
    }
    @Test
    public void whenfindById_themreturnDepartment()
    {
        Department department=departmentRepo.findById(1L).get();
        assertEquals(department.getDepartmentName(),"IT");
    }
}