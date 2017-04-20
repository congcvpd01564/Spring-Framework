package edu.poly.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Records")
public class Record {
	@Id
	@Column(name="Id")
	private String id;
	
	@NotNull
	@Column(name="Type")
	private Boolean type;
	
	@NotNull
	@Column(name="Reason")
	private String reason;
	
	@NotNull
	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="StaffId")
	private Staff staff;

	public Record() {
		super();
	}

	public Record(String id, Boolean type, String reason, Date date, Staff staff) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staff = staff;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
