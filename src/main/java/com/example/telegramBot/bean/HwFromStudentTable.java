package com.example.telegramBot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "hwFrom_students")
public class HwFromStudentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int studentId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_name")
    private TgUserTable studentName;

    @Column(name = "lesson_number")
    private int lessonNumber;

    @Column(name = "students_hw")
    private String hwFromStudent;
}
