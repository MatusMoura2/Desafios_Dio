package model;

import java.util.UUID;

public class Task {

	private UUID id;
	private String title;
	private String description;
	private String status;

	public Task(UUID id, String title, String description, String status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public Task() {
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
