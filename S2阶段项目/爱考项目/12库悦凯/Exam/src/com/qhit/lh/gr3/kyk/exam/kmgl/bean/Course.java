package com.qhit.lh.gr3.kyk.exam.kmgl.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.qhit.lh.gr3.kyk.exam.tkgl.bean.MachineQuestion;
import com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer csId;
	private String csName;
	private String stage;
	private String major;
	
	//1-n
	private Set<MachineQuestion> MachineTests = new HashSet<>();
	private Set<WrittenQuestion> WrittenTests = new HashSet<>();

	// Constructors

	public Set<MachineQuestion> getMachineTests() {
		return MachineTests;
	}

	public void setMachineTests(Set<MachineQuestion> machineTests) {
		MachineTests = machineTests;
	}

	public Set<WrittenQuestion> getWrittenTests() {
		return WrittenTests;
	}

	public void setWrittenTests(Set<WrittenQuestion> writtenTests) {
		WrittenTests = writtenTests;
	}

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String csName, String stage, String major) {
		this.csName = csName;
		this.stage = stage;
		this.major = major;
	}

	// Property accessors

	public Integer getCsId() {
		return this.csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsName() {
		return this.csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}