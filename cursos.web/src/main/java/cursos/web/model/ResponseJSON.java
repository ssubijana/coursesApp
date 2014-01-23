package cursos.web.model;

public class ResponseJSON {
	
	private boolean success;
	private Object data;
	private String messageError;	
	
	/**
	 * Default constructor
	 */
	public ResponseJSON() {
		super();
	}
	
	/**
	 * Constructor using fields
	 * @param data
	 * @param messageError
	 * @param success
	 */
	public ResponseJSON(Object data, String messageError,boolean succes) {
		super();
		this.data = data;
		this.messageError = messageError;
		this.success = succes;
	}
	
	
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return the messageError
	 */
	public String getMessageError() {
		return messageError;
	}
	/**
	 * @param messageError the messageError to set
	 */
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	
	

}
