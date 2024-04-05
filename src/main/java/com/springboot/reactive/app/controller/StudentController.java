package com.springboot.reactive.app.controller;

import com.springboot.reactive.app.model.Student;
import com.springboot.reactive.app.service.IStudentService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create-student")
    @ResponseStatus(HttpStatus.CREATED)
    public Single<ResponseEntity<Student>> createStudent(@RequestBody Student student) {
        logger.info("Controller create student -->name: {} ...", student.getName());
        return studentService.createStudent(student).subscribeOn(Schedulers.io())
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/all")
    public Flowable<ResponseEntity<Student>> getStudentAll() {
        logger.info("Controller get student all");
        return studentService.getAllStudents().subscribeOn(Schedulers.io())
                .map(response -> ResponseEntity.ok(response));
    }
}
