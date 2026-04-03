package com.Learning.SpringBootRESTAPI.Controller;

import com.Learning.SpringBootRESTAPI.Error.DepartmentNotFoundException;
import com.Learning.SpringBootRESTAPI.Model.Department;
import com.Learning.SpringBootRESTAPI.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // ✅ fixed import
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp()
    {
        department = Department.builder()
                .departmentName("IT")
                .departmentCode("IT06")
                .departmentAddress("AVANTI")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {

        Department inputdepartment = Department.builder()
                .departmentName("IT")
                .departmentCode("IT06")
                .departmentAddress("AVANTI")
                .build();


        Mockito.when(departmentService.saveDepartment(Mockito.any(Department.class)))
                .thenReturn(department);


        mockMvc.perform(post("/department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"departmentCode\":\"mechhh\"," +
                                "\"departmentAddress\":\"delhi\"," +
                                "\"departmentName\":\"mech 077\"}"
                        ))
                .andExpect(status().isOk());
    }

    @Test
    void fetchdepartmentbyid() throws Exception {
        Mockito.when(departmentService.fetchdepartmentbyid(1l))
        .thenReturn(department);
        mockMvc.perform(get("/department/1")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.departmentName")
                .value(department.getDepartmentName()));
    }
//
//    @Test
//    void testSaveDepartment() {
//
//    }
//
//    @Test
//    void testFetchdepartmentbyid() {
//    }
}