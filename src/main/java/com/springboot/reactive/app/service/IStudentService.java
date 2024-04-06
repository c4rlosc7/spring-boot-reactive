package com.springboot.reactive.app.service;

import com.springboot.reactive.app.model.Student;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface IStudentService {
    Single<Student> createStudent(Student requestStudent);
    Flowable<Student> getAllStudents();
    Maybe<Student> getStudentById(long id);
    Single<Student> updateStudent(Student requestStudent);
    Completable deleteStudent(long id);
}
