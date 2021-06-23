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
@Table(name = "courses")
public class CourseTable {

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
