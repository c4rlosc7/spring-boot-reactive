package com.springboot.reactive.app.service;

import com.springboot.reactive.app.model.Student;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface IStudentService {
    Single<Student> createStudent(Student student);
    Flowable<Student> getAllStudents();
    Maybe<Student> getStudentById(long id);
    Maybe<Student> updateStudent(long id, Student updateStudent);
    Completable deleteStudent(long id);
}
