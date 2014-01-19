package cursos.core.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;	
	
	/**
	 * Constructor por defecto
	 */
	public MyBatisUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	/**
	 * Session factory inicializado y configurando el entorno de conexión con base de datos.
	 * @return sessionFactory, instancia única de clase
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}
}
