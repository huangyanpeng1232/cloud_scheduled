package com.admin.schedule.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class ScheduledJobTaskDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Column
	private String scheduledId;

	@Column
	private String jobTaskId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScheduledId() {
		return scheduledId;
	}

	public void setScheduledId(String scheduledId) {
		this.scheduledId = scheduledId;
	}

	public String getJobTaskId() {
		return jobTaskId;
	}

	public void setJobTaskId(String jobTaskId) {
		this.jobTaskId = jobTaskId;
	}
}
