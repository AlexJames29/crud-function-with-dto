package crudFunctionality.crudWithDto.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Integer password;
    @Column
    private String gender;
    @Column
    private String nationality;
    @Column
    private Integer age;






}
