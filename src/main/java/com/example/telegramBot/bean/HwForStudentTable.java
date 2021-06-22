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
@Table(name = "hw_for_students")
public class HwForStudentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hw_id")
    private int hwForStudentsId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_number")
    private GroupTable groupHwForStudents;

    @Column(name = "lesson_number")
    private int lessonNumber;

    @Column(name = "hw_doc")
    private String hwDoc;
}
