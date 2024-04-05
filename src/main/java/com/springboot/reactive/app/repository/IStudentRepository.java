package com.springboot.reactive.app.repository;

import com.springboot.reactive.app.model.Student;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;

public interface IStudentRepository extends RxJava2CrudRepository<Student, Long> {
}
