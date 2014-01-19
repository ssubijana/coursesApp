package cursos.core.service.test;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import cursos.core.model.Course;
import cursos.core.service.CourseService;
import cursos.core.service.MyBatisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testApplicationContext.xml"})
public class InsertCourseTest {

	@Autowired
	private CourseService courseService;
	
	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@Test
	public void is_course_initialized() {
		String courseTitle = "Test title";
		Course c = new Course(1, courseTitle, 1, 12,true);
		Assert.notNull(c);
		Assert.isTrue(c.getTitle().equals(courseTitle));
	}
	
	@Test
	public void is_database_connection_created() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		Assert.notNull(sqlSession);	
		sqlSession.close();
	}
	
	@Test
	public void is_course_inserted() {
		fail("Not yet implemented");
	}
	
	@Test
	public void exists_course() {
		fail("Not yet implemented");
	}

}
