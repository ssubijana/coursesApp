package cursos.core.dao.imp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import cursos.core.dao.CourseIDAO;
import cursos.core.exception.AppException;
import cursos.core.mappers.CourseMapper;
import cursos.core.model.Course;
import cursos.core.service.MyBatisUtil;

public class CourseDAO implements CourseIDAO {

	/**
	 * {@Inherited}
	 */
	@Override
	public void insertCourse(Course c) throws AppException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			courseMapper.insertCourse(c);
			sqlSession.commit();
		}catch(PersistenceException pex) {
			throw new AppException(1, "There was an error and the course couldn't be inserted");
		}finally{
			sqlSession.close();
		}
	}

	/**
	 * {@Inherited}
	 */
	@Override
	public Course getCourseById(int id) throws AppException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			Course c = courseMapper.getCourse(id);
			return c;
		}catch(PersistenceException pex) {
			throw new AppException(1, "There was an error and the course couldn't be recovered");
		}finally{
			sqlSession.close();
		}
	}

	/**
	 * {@Inherited}
	 */
	@Override
	public int deleteCourse(int id) throws AppException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			int rowsAffected = courseMapper.deleteCourse(id);
			sqlSession.commit();
			return rowsAffected;
		}catch(PersistenceException pex) {
			throw new AppException(1, "There was an error and the course couldn't be deleted");
		}finally{
			sqlSession.close();
		}
	}

	/**
	 * {@Inherited}
	 */
	@Override
	public List<Course> getActiveCourses() throws AppException {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			List<Course> activeCourses = courseMapper.getActiveCourses();
			return activeCourses;
		}catch(PersistenceException pex) {
			throw new AppException(1, "There was an error and the courses couldn't be recovered");
		}finally{
			sqlSession.close();
		}
	}
	
	
	
	
	

}
