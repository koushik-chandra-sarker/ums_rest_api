package com.seu.ums.Repository;

import com.seu.ums.Entity.Course_Student;
import com.seu.ums.Entity.Lecturer_Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseStudentRepository extends CrudRepository<Course_Student, String> {

    @Query(value = "SELECT * from course_student  where student_id=?1",nativeQuery = true)
    public List<Course_Student> findAllByStudentId(int id);

}
