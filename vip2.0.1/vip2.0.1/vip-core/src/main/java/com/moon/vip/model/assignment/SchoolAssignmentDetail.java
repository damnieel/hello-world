package com.moon.vip.model.assignment;

import java.util.Date;

public class SchoolAssignmentDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.ID
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.profession_id
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private Integer sacId;
    
    private Integer classId;
    
    


	private Integer studentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.check_date
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private Date checkDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.check_status
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private Integer checkStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.create_time
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.creator
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.modify_time
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.modify_user
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private String modifyUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_school_assignment_detail.version
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    private Integer version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.ID
     *
     * @return the value of vip_school_assignment_detail.ID
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.ID
     *
     * @param id the value for vip_school_assignment_detail.ID
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSacId() {
		return sacId;
	}

	public void setSacId(Integer sacId) {
		this.sacId = sacId;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.student_id
     *
     * @return the value of vip_school_assignment_detail.student_id
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.student_id
     *
     * @param studentId the value for vip_school_assignment_detail.student_id
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.check_date
     *
     * @return the value of vip_school_assignment_detail.check_date
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.check_date
     *
     * @param checkDate the value for vip_school_assignment_detail.check_date
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.check_status
     *
     * @return the value of vip_school_assignment_detail.check_status
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.check_status
     *
     * @param checkStatus the value for vip_school_assignment_detail.check_status
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.create_time
     *
     * @return the value of vip_school_assignment_detail.create_time
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.create_time
     *
     * @param createTime the value for vip_school_assignment_detail.create_time
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.creator
     *
     * @return the value of vip_school_assignment_detail.creator
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.creator
     *
     * @param creator the value for vip_school_assignment_detail.creator
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.modify_time
     *
     * @return the value of vip_school_assignment_detail.modify_time
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.modify_time
     *
     * @param modifyTime the value for vip_school_assignment_detail.modify_time
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.modify_user
     *
     * @return the value of vip_school_assignment_detail.modify_user
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.modify_user
     *
     * @param modifyUser the value for vip_school_assignment_detail.modify_user
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_school_assignment_detail.version
     *
     * @return the value of vip_school_assignment_detail.version
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_school_assignment_detail.version
     *
     * @param version the value for vip_school_assignment_detail.version
     *
     * @mbggenerated Wed Dec 23 15:57:22 CST 2015
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}
}