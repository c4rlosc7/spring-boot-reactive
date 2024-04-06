package com.springboot.reactive.app;

import com.springboot.reactive.app.model.Student;
import com.springboot.reactive.app.repository.IStudentRepository;
import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootReactiveApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringBootReactiveApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveApplication.class, args);
		logger.info("Initializing application...");
	}

	@Bean
	ApplicationRunner init(IStudentRepository repository, DatabaseClient client) {
		return args -> {
			client.execute("create table IF NOT EXISTS STUDENTS" +
					"(ID SERIAL PRIMARY KEY, " +
					"NAME VARCHAR (255) not null, " +
					"LAST_NAME VARCHAR (255) not null, " +
					"ENROLL_ID int not null, " +
					"STATE VARCHAR (255) not null);").fetch().first().subscribe();
			client.execute("DELETE FROM STUDENTS;").fetch().first().subscribe();

			Stream<Student> stream = Stream.of(new Student(null, "Carlos1", "Martinez"),
					new Student(null, "Carlos2", "Martinez"),
					new Student(null, "Carlos3", "Martinez"));

			Flowable<Student> flowable = Flowable.just(
					new Student(null, "Carlos", "Martinez"),
					new Student(null, "Leonel", "Messi"),
					new Student(null, "Cristiano", "Ronaldo")
			);
			repository.saveAll(flowable).subscribe();

		};
	}
}
