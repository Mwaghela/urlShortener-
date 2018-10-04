package com.restApi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Manish
 *
 */
@Entity
@Table(name = "URL_SHORTENER_DETAILS")
public class UrlShortenerDetails {

	@Id
	@Column(name = "USD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "ABSOLUTE_URL")
	private String absoluteUrl;

	@Column(name = "TINY_URL")
	private String tinyUrl;

	@Column(name = "EXPIRY")
	private Date expiry;

	@Column(name = "DESCIPTION")
	private String description;

	@Column(name = "IS_DISABLED")
	private int isDisabled;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAbsoluteUrl() {
		return absoluteUrl;
	}

	public void setAbsoluteUrl(String absoluteUrl) {
		this.absoluteUrl = absoluteUrl;
	}

	public String getTinyUrl() {
		return tinyUrl;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(int isDisabled) {
		this.isDisabled = isDisabled;
	}

}
