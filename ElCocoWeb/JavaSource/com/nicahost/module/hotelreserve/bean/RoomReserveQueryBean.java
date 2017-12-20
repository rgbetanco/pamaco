package com.nicahost.module.hotelreserve.bean;

/**
 * @author henry
 * Version 1.0 Oct 5, 2006
 *
 * playaelcoco.com.ni
 */
public class RoomReserveQueryBean extends RoomReservePendingBean {

	private String approver;
	private String approverDate;
	private String reference;
	private String status;
	private String statusName;
	
	public RoomReserveQueryBean() {
		
	}
	
	/* (non-Javadoc)
	 * @see com.nicahost.module.hotelreserve.bean.RoomReservePendingBean#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		RoomReserveQueryBean bean = (RoomReserveQueryBean) arg0;	

		return getIniDate().getTime().compareTo(bean.getIniDate().getTime());
	}

	/**
	 * @return
	 */
	public String getApprover() {
		return approver;
	}

	/**
	 * @return
	 */
	public String getApproverDate() {
		return approverDate;
	}

	/**
	 * @return
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param string
	 */
	public void setApprover(String string) {
		approver = string;
	}

	/**
	 * @param string
	 */
	public void setApproverDate(String string) {
		approverDate = string;
	}

	/**
	 * @param string
	 */
	public void setReference(String string) {
		reference = string;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

	/**
	 * @return
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param string
	 */
	public void setStatusName(String string) {
		statusName = string;
	}

}
