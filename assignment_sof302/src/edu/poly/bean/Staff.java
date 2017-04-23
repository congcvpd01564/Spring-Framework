package edu.poly.bean;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Staffs")
public class Staff {
	@Id
	@Column(name="Id")
	private String id;
	
	@NotNull
	@Column(name="Name")
	private String name;
	
	@NotNull
	@Column(name="Gender")
	private Boolean gender;
	
	@NotNull
	@Column(name="Birthday")
	@Temporal(TemporalType.DATE)
	
	private Date birthday;
	
	@NotNull
	@Column(name="Photo")
	private String photo;
	
	@NotNull
	@Column(name="Email")
	private String email;
	
	@NotNull
	@Column(name="Phone")
	private String phone;
	
	@NotNull
	@Column(name="Salary")
	private Double salary;
	
	@NotNull
	@Column(name="Notes")
	private String notes;
	
	//lk voi bang Derpart(N-1)
	@ManyToOne
	@JoinColumn(name="departId")
	private Depart depart;
	
	//lk voi bang Record(1-N)
	@OneToMany(mappedBy="staff", fetch = FetchType.EAGER)
	private Collection<Record> records;
	
	public Staff() {
		super();
	}

	public Staff(String id, String name, Boolean gender, Date birthday, String photo, String email, String phone,
			Double salary, String notes, Depart depart, Collection<Record> records) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.depart = depart;
		this.records = records;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public Collection<Record> getRecords() {
		return records;
	}

	public void setRecords(Collection<Record> records) {
		this.records = records;
	}
	
}
