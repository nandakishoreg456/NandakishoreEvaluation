package com.hospital.patient.beans;

/** Represents a Patient Delete response.
 * @author Nanda Kishore Reddy Gangireddygari
 * @author nandakishoreg456@gmail.com
 * @version 1.2
 * @since 1.0
*/
public class DeleteResponse {

	private String status;

	/** Gets the patient's delete operation response status.
	 * @return A String representing the patient’s delete operation response status.
	*/
	public String getStatus() {
		return status;
	}

	/** Sets the patient’s delete operation response status..
	 * @param status A String containing the patient's delete operation response status.
	*/
	public void setStatus(String status) {
		this.status = status;
	}
	
}
