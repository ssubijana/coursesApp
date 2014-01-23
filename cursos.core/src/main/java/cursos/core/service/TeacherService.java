package cursos.core.service;

import java.util.List;

import cursos.core.dao.TeacherIDAO;
import cursos.core.exception.AppException;
import cursos.core.model.Teacher;

public class TeacherService {
	
	private TeacherIDAO teacherDAO;

	/**
	 * @param teacherDAO the teacherDAO to set
	 */
	public void setTeacherDAO(TeacherIDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	
	public List<Teacher> getTeachers() throws AppException {
		return teacherDAO.getTeachers();
	}

}
