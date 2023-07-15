package sbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "stu_Name")
    private String name;
    @Column(name ="stu_course")
    private String course;
    @Column(name = "stu_mobile")
    private long mobile;
    @Column(name="stu_fee")
    private double fee;
}
