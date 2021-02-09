package com.admin.schedule.bean;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

@MappedSuperclass
public class JobTaskDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private String server;

	@Column
	private String url;

	@Column
	private String number;


	public Integer getId() {
 		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
 		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServer() {
 		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getUrl() {
 		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNumber() {
 		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
