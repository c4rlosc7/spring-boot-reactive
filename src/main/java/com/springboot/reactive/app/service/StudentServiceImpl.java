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
    public Single<Student> createStudent(Student requestStudent) {
        return Single.create(singleEmitter -> {
            Student newStudent = new Student(null, requestStudent.getName(), requestStudent.getLastName());
            singleEmitter.onSuccess(repository.save(newStudent).blockingGet());
        });
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
        logger.info("Get student by ID: {} service ...", id);
        return Maybe.create(maybeEmitter -> {
            maybeEmitter.onSuccess(repository.findById(id).blockingGet());
        });
    }

    @Override
    public Single<Student> updateStudent(Student requestStudent) {
        logger.info("Updated student: {}", requestStudent.toString());
        return Single.create(singleEmitter -> {
            singleEmitter.onSuccess(repository.save(requestStudent).blockingGet());
        });
    }

    @Override
    public Completable deleteStudent(long id) {
        logger.info("Delete student by ID: {}", id);
        return repository.deleteById(id);
    }
}

