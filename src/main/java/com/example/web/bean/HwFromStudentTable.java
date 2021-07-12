package com.example.web.bean;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "hw_from_students")
public class HwFromStudentTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_name")
    private TgUserTable studentName;

    @Column(name = "lesson_number")
    private int lessonNumber;

    @Column(name = "students_hw")
    private String hwFromStudent;
}
