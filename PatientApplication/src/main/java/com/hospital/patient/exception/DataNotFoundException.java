package com.hospital.patient.exception;

/** Represents a Patient.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.2
 * @since 1.0
*/
public class DataNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	/**
	* Creates constructor for class DataNotFoundException
	* @param resourceName  A String containing the which operation is performed.
	* @param fieldName  A String containing the fieldName.
	* @param fieldValue  A String containing the fieldValue.
	*/
	public DataNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s '%s : %s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	/** Gets the resourceName.
	 * @return A String representing the which operation is performed.
	*/
	public String getResourceName() {
		return resourceName;
	}
	/** Sets the resourceName
	 * @param resourceName A String containing the resourceName.
	*/
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	/** Gets the fieldName.
	 * @return A String representing the fieldName.
	*/
	public String getFieldName() {
		return fieldName;
	}
	/** Sets the fieldName
	 * @param fieldName A String containing the fieldName.
	*/
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	/** Gets the fieldValue.
	 * @return A String representing the fieldValue.
	*/
	public String getFieldValue() {
		return fieldValue;
	}
	/** Sets the fieldValue
	 * @param fieldValue A String containing the fieldValue.
	*/
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
	
}
