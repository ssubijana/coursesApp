package cursos.core.service;

import java.util.List;

import cursos.core.dao.CourseIDAO;
import cursos.core.exception.AppException;
import cursos.core.model.Course;

public class CourseService {
	
	private CourseIDAO courseDAO;	
	
	/**
	 * @param courseDAO the courseDAO to set
	 */
	public void setCourseDAO(CourseIDAO courseDAO) {
		this.courseDAO = courseDAO;
	}


	/**
	 * Inserts new course in the system.
	 * @param c Course to be inserted.
	 *  @throws AppException Describes the error.
	 */
	public void insertCourse(Course c) throws AppException {
		if (isValidCourse(c)) {
			courseDAO.insertCourse(c);
		}
		else {
			throw new AppException(1, "The course is not valid. Please, check all the fields");
		}
	}
	
	/**
	 * Delete course form database.
	 * @param c Course to be deleted.
	 * @return Number of registers affected by delete.
	 * @throws AppException Describes the error.
	 */
	public int deleteCourse(Course c) throws AppException {
		return courseDAO.deleteCourse(c.getId());
	}
	
	/**
	 * Get Active courses in the system.
	 * @return Active courses.
	 * @throws AppException Describes the error.
	 */
	public List<Course> getActiveCourses() throws AppException {
		return courseDAO.getActiveCourses();
	}
	
	/**
	 * Gets a course by id.
	 * @param id Identifier of the course.
	 * @return Course recovered.
	 * @throws AppException Describes the error.
	 */
	public Course getCourse(int id) throws AppException {
		return courseDAO.getCourseById(id);
	}
	
	/**
	 * Checks if a course has valid fields. 
	 * @param c The course to be validated.
	 * @return True if course is valid.
	 */
	public boolean isValidCourse(Course c) {
		return (
				c!= null &&
				c.getTitle() != null && c.getTitle().length() >0 &&
				c.getLevel() != null && c.getLevel() > 0 &&
				c.getHours() != null && c.getHours() > 0 &&
				c.getId_teacher() != null && c.getId_teacher() > 0 &&
				c.isActive() != null);
	}

}
