package com.example.web.controller;

import com.example.web.bean.GroupTable;
import com.example.web.bean.HwForStudentTable;
import com.example.web.dto.StudentDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/myteach")
public class MyTeacherControl {

    @PostMapping("/addStudent")
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        studentDto.setName("max");
        return studentDto;
    }

    @GetMapping("/viewhomework")
    public HwForStudentTable getHomework() {
        return new HwForStudentTable(1, new GroupTable(), 2, "ok");
    }
}
