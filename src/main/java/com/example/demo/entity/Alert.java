package com.example.demo.entity;

import com.example.demo.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "alert")
public class Alert {

	@Id
	@Column(name = "alert_id")
	private String alert_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "users_id")
	private User user_alert;

	@Column(name = "message")
	private String message;

	public Alert() {

	}

	public Alert(String alert_id, User user_alert, String message) {
		this.alert_id = alert_id;
		this.user_alert = user_alert;
		this.message = message;
	}

	public String getAlert_id() {
		return alert_id;
	}

	public void setAlert_id(String alert_id) {
		this.alert_id = alert_id;
	}

	public User getUser_alert() {
		return user_alert;
	}

	public void setUser_alert(User user_alert) {
		this.user_alert = user_alert;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Alert [alert_id=" + alert_id + ", message=" + message + ", user_alert=" + user_alert + "]";
	}

}