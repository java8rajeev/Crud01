package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "std_tab02")
public class Student {
	@Id
	// @GeneratedValue
	@Column(name = "std_id_col")
	private Integer stdId;
	@Column(name = "std_name_col")
	private String stdName;

	/*
	 * public Student(Integer stdId, String stdName) { super(); this.stdId = stdId;
	 * this.stdName = stdName; }
	 */
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + "]";
	}

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	/*
	 * public Student() { super(); }
	 */

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

}
