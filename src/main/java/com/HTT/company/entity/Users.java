package com.HTT.company.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users {

	@Id
	@Column(name = "users_id")
	private String usersId;

	@Column(name = "pass_word")
	private String passWord;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "number_phone")
	private String numberPhone;

	@Column(name = "gmail")
	private String gmail;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "country")
	private String country;

	@Column(name = "state")
	private String state;

	@Column(name = "town_city")
	private String townCity;

	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "is_exist")
	private Boolean isExist;

	@Column(name = "is_admin")
	private Boolean isAdmin;
	
	@Column(name = "date_create")
	private Date dateCreate;

	@Column(name = "date_update")
	private Date dateUpdate;
}
