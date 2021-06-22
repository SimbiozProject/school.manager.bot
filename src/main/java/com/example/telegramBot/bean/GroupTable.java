package com.example.telegramBot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "student_group")
public class GroupTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long idGroup;

    @Column(name = "group_number")
    private Long groupNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="course_name")   // insertable=false, updatable=false)
    private CourseTable groupCourse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "groupUser")
    private Set<TgUserTable> tgUserSet;

    @OneToMany(mappedBy = "groupHwForStudents", fetch = FetchType.EAGER)
    private Set<HwForStudentTable> studentHw;
}
