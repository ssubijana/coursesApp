package cursos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/courses")
public class CourseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getPages() {
	      return "index"; 
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getCoursesList() { 
		ModelAndView model = new ModelAndView("list");
		return model;
 
	}

}
