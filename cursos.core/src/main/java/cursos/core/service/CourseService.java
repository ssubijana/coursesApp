package cursos.core.service;

import java.util.List;

import cursos.core.dao.CourseIDAO;
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
	 * Inserts new course in the system
	 * @param c
	 * @return
	 */
	public void insertCourse(Course c) {
		courseDAO.insertCourse(c);
	}
	
	/**
	 * Delete course form database.
	 * @param c Course to be deleted.
	 * @return Number of registers affected by delete.
	 */
	public int deleteCourse(Course c) {
		return courseDAO.deleteCourse(c.getId());
	}
	
	public List<Course> getActiveCourses() {
		return courseDAO.getActiveCourses();
	}
	
	public Course getCourse(int id) {
		return courseDAO.getCourseById(id);
	}

}
