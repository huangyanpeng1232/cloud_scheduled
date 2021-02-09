package com.admin.schedule.bean;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

@MappedSuperclass
public class ScheduledDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Date createTime;

	@Column
	private String cron;

	@Column
	private String status;

	@Column
	private String name;

	@Column
	private String details;


	public Integer getId() {
 		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
 		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCron() {
 		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getStatus() {
 		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
 		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
 		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
