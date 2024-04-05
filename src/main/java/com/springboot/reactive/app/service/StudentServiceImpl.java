package com.springboot.reactive.app.service;

import com.springboot.reactive.app.model.Student;
import com.springboot.reactive.app.repository.IStudentRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final IStudentRepository repository;

    public StudentServiceImpl(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Student> createStudent(Student student) {
        logger.info("Create student -->name: {} service ...", student.getName());
        Single<Student> studentObservable = null;
        try {
            studentObservable = repository.save(new Student(null, student.getName(), student.getLastName()));
        } catch (Exception exception) {
            logger.error("Error creating new student --> message: {}", exception.getMessage());
        }
        return studentObservable;
    }

    @Override
    public Flowable<Student> getAllStudents() {
        logger.info("Get all students service ...");
        Flowable<Student> studentObservable = null;
        try {
            studentObservable = repository.findAll();
        } catch (Exception exception) {
            logger.error("Error get all students ");
        }
        return studentObservable;
    }

    @Override
    public Maybe<Student> getStudentById(long id) {
        return null;
    }

    @Override
    public Maybe<Student> updateStudent(long id, Student updateStudent) {
        return null;
    }

    @Override
    public Completable deleteStudent(long id) {
        return null;
    }
}
