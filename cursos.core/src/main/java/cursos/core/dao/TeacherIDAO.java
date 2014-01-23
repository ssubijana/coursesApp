package cursos.core.dao;

import java.util.List;

import cursos.core.exception.AppException;
import cursos.core.model.Teacher;

public interface TeacherIDAO {
	
	List<Teacher> getTeachers() throws AppException;

}
