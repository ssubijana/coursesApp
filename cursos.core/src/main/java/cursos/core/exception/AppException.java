package cursos.core.exception;

public class AppException extends Exception{
	
	private static final long serialVersionUID = -3563604377383689069L;
	
	private int id;
	private String message;	
	
	/**
	 * @param id
	 * @param message
	 */
	public AppException(int id, String message) {
		super();
		this.id = id;
		this.message = message;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
