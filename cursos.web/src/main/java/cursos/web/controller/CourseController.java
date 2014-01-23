package cursos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cursos.core.exception.AppException;
import cursos.core.model.Course;
import cursos.core.model.Teacher;
import cursos.core.service.CourseService;
import cursos.core.service.TeacherService;
import cursos.web.model.ResponseJSON;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;	
	
	/**
	 * @param courseService the courseService to set
	 */
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}	

	/**
	 * @param teacherService the teacherService to set
	 */
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getPages() {
	      return "index"; 
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Course> getCoursesList() { 
		List<Course> activeCourses = null;
		try {
			activeCourses = courseService.getActiveCourses();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activeCourses; 
	}
	
	@RequestMapping(value = "/get-teachers", method = RequestMethod.GET)
	public @ResponseBody List<Teacher> getTeachersList() { 
		List<Teacher> teachers = null;
		try {
			teachers = teacherService.getTeachers();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachers; 
	}
	
	@RequestMapping(value="/add-course", method = RequestMethod.POST)
	public @ResponseBody ResponseJSON addCourse(@RequestBody final Course course) {
		ResponseJSON response = new ResponseJSON();
		try {
			courseService.insertCourse(course);
			response.setData(course);
			response.setSuccess(true);
		} catch(AppException appEx) {
			response.setSuccess(false);
			response.setMessageError("The course couldn't be inserted");
		}
		return response;	
		
	}
	

}
