package cursos.core.mappers;

import java.util.List;

import cursos.core.model.Teacher;

public interface TeacherMapper {
	
	/**
	 * Gets the teachers existing in the system.
	 * @return List of teachers.
	 */
	List<Teacher> getTeachers();

}
