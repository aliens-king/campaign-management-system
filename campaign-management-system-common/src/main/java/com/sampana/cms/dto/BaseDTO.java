/**
 * 
 */
package com.sampana.cms.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Sudhanshu Chaturvedi
 *
 */
@JsonInclude(Include.NON_NULL)
public class BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2517561974281512788L;

	/**
	 * Handles created current date
	 */
	private Date createdDate;

	/**
	 * Handles Modified time stamp
	 */
	private Date modifiedDate;

	/**
	 * created By null able true.
	 */
	private Long createdBy;

	/**
	 * Modified By null able true.
	 */
	private Long modifiedBy;

	/**
	 * Is deleted true or false. By default is false.
	 */
	private boolean isArchived;
	
	

	public BaseDTO() {
	}
	
	

	public BaseDTO(boolean isArchived) {
		this.isArchived = isArchived;
	}



	/**
	 * @return the createdDate
	 */
	public final Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public final void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public final Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public final void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the createdBy
	 */
	public final Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public final void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedBy
	 */
	public final Long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public final void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the isArchived
	 */
	public final boolean isArchived() {
		return isArchived;
	}

	/**
	 * @param isArchived
	 *            the isArchived to set
	 */
	public final void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
}
