package cursos.core.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursos.core.service.CursoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/resources/testApplicationContext.xml"})
public class CursoServiceTest {

	private CursoService cursoService;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
