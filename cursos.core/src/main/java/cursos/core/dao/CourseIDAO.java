package cursos.core.dao;

import java.util.List;

import cursos.core.exception.AppException;
import cursos.core.model.Course;

public interface CourseIDAO {
	
	/**
	 * Inserts new course in the database.
	 * @param c Course to be inserted.
	 * @return Identifier for the course in database.
	 */
	void insertCourse(Course c) throws AppException;
	
	/**
	 * Gets the course from database if exists.
	 * @param id Identifier of the course to get.
	 * @return Information of the recovered course.
	 */
	Course getCourseById(int id) throws AppException;
	
	/**
	 * Delete a course of database by id.
	 * @param id Identifier of the course which wants to be deleted.
	 * @return Number of affected  rows.
	 */
	int deleteCourse(int id) throws AppException;
	
	/**
	 * Get the active courses in the database.
	 * @return Active courses.
	 */
	List<Course> getActiveCourses() throws AppException;

}
