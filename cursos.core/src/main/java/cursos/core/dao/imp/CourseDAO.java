package cursos.core.dao.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cursos.core.dao.CourseIDAO;
import cursos.core.mappers.CourseMapper;
import cursos.core.model.Course;
import cursos.core.service.MyBatisUtil;

public class CourseDAO implements CourseIDAO {

	/**
	 * {@Inherited}
	 */
	@Override
	public void insertCourse(Course c) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			courseMapper.insertCourse(c);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}

	/**
	 * {@Inherited}
	 */
	@Override
	public Course getCourseById(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			Course c = courseMapper.getCourse(id);
			return c;
		}finally{
			sqlSession.close();
		}
	}

	/**
	 * {@Inherited}
	 */
	@Override
	public int deleteCourse(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			int rowsAffected = courseMapper.deleteCourse(id);
			sqlSession.commit();
			return rowsAffected;
		}finally{
			sqlSession.close();
		}
	}

	/**
	 * {@Inherited}
	 */
	@Override
	public List<Course> getActiveCourses() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			List<Course> activeCourses = courseMapper.getActiveCourses();
			return activeCourses;
		}finally{
			sqlSession.close();
		}
	}
	
	
	
	
	

}
