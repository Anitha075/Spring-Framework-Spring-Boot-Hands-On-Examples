package com.Learning.SpringBootRESTAPI.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
     @NotBlank(message = "not blank")
//     @Length(max=5,min=1)
//     @Size(max=5,min=1)
//
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;






}
