package com.example.web.bean;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student_group")
@ToString(exclude = {"tgUserSet", "studentHw"})
public class GroupTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long idGroup;

    @Column(name = "group_number")
    private Long groupNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_name")   // insertable=false, updatable=false)
    private CourseTable groupCourse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "groupUser")
    private Set<TgUserTable> tgUserSet;

    @OneToMany(mappedBy = "groupHwForStudents", fetch = FetchType.EAGER)
    private Set<HwForStudentTable> studentHw;

}
