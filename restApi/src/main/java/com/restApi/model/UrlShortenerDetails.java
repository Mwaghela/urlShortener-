package com.restApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Manish
 *
 */
@Entity
@Table(name = "URL_SHORTENER_DETAILS")
public class UrlShortenerDetails {
	/**
	 * 
	 */
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
	
}
