package cursos.core.mappers;

import java.util.List;

import cursos.core.model.Course;

public interface CourseMapper {
	
	/**
	 * Inserts new course in the database.
	 * @param c Course to be inserted.
	 */
	void insertCourse(Course course);
	
	/**
	 * Delete a course from database.
	 * @param id Id of the course to be deleted.
	 * @return rows affected.
	 */
	int deleteCourse(int id);
	
	/**
	 * Get active courses from database.
	 * @return Active courses in the system.
	 */
	List<Course> getActiveCourses();
	
	Course getCourse(int id);

}
