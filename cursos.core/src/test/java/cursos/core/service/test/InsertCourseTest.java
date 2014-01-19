package cursos.core.service.test;

import java.util.List;

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
		Course c = new Course(1, courseTitle, 1, 12,true, 0);
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
		String courseTitle = "Test title";
		Course c = new Course(1, courseTitle, 1, 12,true, 1);
		courseService.insertCourse(c);
		Assert.isTrue(c.getId() > 0);
		int deletedCourses = courseService.deleteCourse(c);
		Assert.isTrue(deletedCourses > 0);
	}
	
	@Test
	public void get_active_courses() {
		String courseTitle1 = "Test title 1";
		Course courseActive = new Course(1, courseTitle1, 1, 12,true, 1);		
		courseService.insertCourse(courseActive);
		Assert.isTrue(courseActive.getId() > 0);		
		List<Course> activeCourses = courseService.getActiveCourses();
		Assert.isTrue(activeCourses.size() > 0);		
		int deletedCourses = courseService.deleteCourse(courseActive);
		Assert.isTrue(deletedCourses > 0);
	}

}
