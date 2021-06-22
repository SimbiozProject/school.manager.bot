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
@Table(name = "groups")
public class GroupTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_number")
    private Long groupNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="course_name")   // insertable=false, updatable=false)
    private CourseTable course;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private Set<TgUserTable> users;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private Set<HwForStudentTable> forStudent;
}
