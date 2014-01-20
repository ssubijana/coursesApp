package cursos.core.model;

public class Teacher {
	
	private int id;
	private String name;
	
	
	/**
	 * Default constructor.
	 */
	public Teacher() {
		super();		
	}
	
	/**
	 * Constructor using fields.
	 * @param id Identifier of the teacher.
	 * @param name Name of the teacher.
	 */
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
