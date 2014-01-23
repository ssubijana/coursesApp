package cursos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cursos.core.exception.AppException;
import cursos.core.model.Course;
import cursos.core.service.CourseService;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;	
	
	/**
	 * @param courseService the courseService to set
	 */
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
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

}
