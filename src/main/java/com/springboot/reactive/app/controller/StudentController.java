package com.springboot.reactive.app.controller;

import com.springboot.reactive.app.model.Student;
import com.springboot.reactive.app.service.IStudentService;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
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
    public Single<ResponseEntity<Student>> createStudent(@RequestBody Student requestStudent) {
        logger.info("Controller create student -->name: {} ...", requestStudent.getName());
        return studentService.createStudent(requestStudent).subscribeOn(Schedulers.io())
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/all")
    public Flowable<ResponseEntity<Student>> getStudentAll() {
        logger.info("Controller get student all");
        return studentService.getAllStudents().subscribeOn(Schedulers.io())
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/get-student-by-id/{id}")
    public Maybe<ResponseEntity<Student>> getStudentById(@PathVariable("id") long id) {
        logger.info("Controller get student by ID: {}", id);
        return studentService.getStudentById(id).subscribeOn(Schedulers.io())
                .map(response -> ResponseEntity.ok(response));
    }

    @PutMapping("/update-student/{id}")
    public Single<ResponseEntity<Student>> updateStudent(@RequestBody Student requestStudent) {
        logger.info("Controller update student by id: {}, name: {}", requestStudent.getId(), requestStudent.getName());
        return studentService.updateStudent(requestStudent).subscribeOn(Schedulers.io())
                .map(response -> ResponseEntity.ok(response));
    }

    @DeleteMapping("/delete-student/{id}")
    public Completable deleteStudent(@PathVariable("id") long id) {
        logger.info("Controller delete student by id: {}", id);
        return studentService.deleteStudent(id);
    }
}
