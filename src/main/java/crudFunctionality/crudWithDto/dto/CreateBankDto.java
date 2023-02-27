package crudFunctionality.crudWithDto.dto;

import lombok.Data;

@Data
public class CreateBankDto {
    private String name;
    private String gender;
    private String nationality;
    private Integer age;
    private Integer password;
    private String address;

}
