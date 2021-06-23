package com.example.web.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "tg_user")
public class TgUserTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "user_name", unique=true)
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="course_name")     // insertable=false, updatable=false)
    private CourseTable courseUser;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="group_number") // insertable=false, updatable=false)
    private GroupTable groupUser;

    @Column(name = "block_user")
    private boolean blockUser;

    @Column(name = "payment")
    private boolean payment;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "studentName")
    private HwFromStudentTable fromStudent;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userName")
    private UserAnswerTable usersAnswers;

}
