package cursos.core.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursos.core.service.ProfesorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/resources/testApplicationContext.xml"})
public class ProfesorServiceTest {
	
	private ProfesorService profesorService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
