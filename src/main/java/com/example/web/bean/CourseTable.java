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
@Table(name = "courses")
@ToString(exclude = {"userSet", "groupSet"})
public class CourseTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "courseUser")
    private Set<TgUserTable> userSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "groupCourse")
    private Set<GroupTable> groupSet;

}
