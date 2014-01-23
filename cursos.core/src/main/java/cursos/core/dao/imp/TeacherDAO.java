package cursos.core.dao.imp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import cursos.core.dao.TeacherIDAO;
import cursos.core.exception.AppException;
import cursos.core.mappers.TeacherMapper;
import cursos.core.model.Teacher;
import cursos.core.service.MyBatisUtil;

public class TeacherDAO implements TeacherIDAO {

	@Override
	public List<Teacher> getTeachers() throws AppException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
			List<Teacher> activeTeachers = teacherMapper.getTeachers();
			return activeTeachers;
		}catch(PersistenceException pex) {
			throw new AppException(1, "There was an error and the teachers couldn't be recovered");
		}finally{
			sqlSession.close();
		}
	}

}
