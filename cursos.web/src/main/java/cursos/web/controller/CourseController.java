package cursos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * Redirects to show index page. 
	 * @return Name of the index page.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getPages() {
	      return "index"; 
	}
	
	/**
	 * Gets active courses from the system and returns in JSON format.
	 * @return Active courses in JSON format.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ResponseJSON getCoursesList() { 
		ResponseJSON response = new ResponseJSON();
		List<Course> activeCourses = null;
		try {
			activeCourses = courseService.getActiveCourses();
			response.setData(activeCourses);
			response.setSuccess(true);
		} catch (AppException e) {
			response.setSuccess(false);
			response.setMessageError("Courses could not be recovered by the system");
		}
		return response; 
	}
	
	/**
	 * Get teachers of the system and returns in JSON format.
	 * @return Teachers in the system.
	 */
	@RequestMapping(value = "/get-teachers", method = RequestMethod.GET)
	public @ResponseBody ResponseJSON getTeachersList() { 
		ResponseJSON response = new ResponseJSON();
		List<Teacher> teachers = null;
		try {
			teachers = teacherService.getTeachers();
			response.setData(teachers);
			response.setSuccess(true);
		} catch (AppException e) {
			response.setSuccess(false);
			response.setMessageError("Teachers could not be recovered by the system");
		}
		return response; 
	}
	
	/**
	 * Gets the course and inserts in the system.
	 * @param course Course to be inserted. It comes in JSON format and is converted to course model by Jackson.
	 * @return Response indicating if the operation has been successful.
	 */
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
