package telran.java30.student.dao;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import telran.java30.student.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	Stream<Student> findByName(String name); //таким образом мы можем задавать запросы непосредсвенно в БД 
	//что бы не вытягивать из нее всех студентов и не сортировать их потом в сервисе
	//начинается запрос со слов findBy после By пишем имя поля по которму будем искатью после этого идем в сервис и пишем там имплементацию
	Stream<Student> findByNameRegex(String regex);
	
//	long countByName(String name);
//	@Query("{'scores.Math':{'$gte':90}}")
//	Stream<Student> findByExamScore(String exam, int score);
	long countByName(String name);
	@Query("{'?0':{'$gte':?1}}")
	Stream<Student> findByExamScore(String exam, int score);
}
