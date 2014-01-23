package cursos.core.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import cursos.core.exception.AppException;
import cursos.core.model.Teacher;
import cursos.core.service.MyBatisUtil;
import cursos.core.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testApplicationContext.xml"})
public class GetTeachersTest {
	
	@Autowired
	private TeacherService teacherService;	

	/**
	 * @param teacherService the teacherService to set
	 */
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}



	@Test
	public void is_teacher_service_initialized() {
		Assert.notNull(teacherService);
	}
	
	@Test
	public void is_database_connection_created() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Assert.notNull(sqlSession);	
		sqlSession.close();
	}
	
	@Test
	public void is_teacher_initialized() {
		Teacher t = new Teacher(1,"Sara Subijana Gracia");
		Assert.notNull(t);		
	}
	
	@Test
	public void get_available_teachers() throws AppException{
		List<Teacher> teachers = teacherService.getTeachers();
		Assert.notNull(teachers);
		Assert.notEmpty(teachers);
	}

}
