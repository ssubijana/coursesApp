package cursos.core.model;

import java.io.Serializable;

public class Course implements Serializable {
	
	private static final long serialVersionUID = -3563604377383689069L;

	private Integer id;
	private String title;
	private Integer level;
	private Integer hours;
	private Boolean active;
	private Integer id_teacher;
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", level=");
		builder.append(level);
		builder.append(", hours=");
		builder.append(hours);
		builder.append(", active=");
		builder.append(active);
		builder.append(", id_teacher=");
		builder.append(id_teacher);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * Constructor by default.
	 */
	public Course() {
		super();
	}
	
	/**
	 * Constructor with param fields.
	 * @param id Identifier of the course.
	 * @param title Title of the course.
	 * @param level Level of the course.
	 * @param hours Hours of the course.
	 * @param active If the course is active or not.
	 * @param id_teacher Identifier of the teacher.
	 */
	public Course(Integer id, String title, Integer level, Integer hours, Boolean active, Integer id_teacher) {
		super();
		this.id = id;
		this.title = title;
		this.level = level;
		this.hours = hours;
		this.active = active;
		this.id_teacher = id_teacher;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the hours
	 */
	public Integer getHours() {
		return hours;
	}
	/**
	 * @param hours the hours to set
	 */
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	/**
	 * @return the active
	 */
	public Boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the id_teacher
	 */
	public Integer getId_teacher() {
		return id_teacher;
	}
	/**
	 * @param id_teacher the id_teacher to set
	 */
	public void setId_teacher(Integer id_teacher) {
		this.id_teacher = id_teacher;
	}
	
	

}
