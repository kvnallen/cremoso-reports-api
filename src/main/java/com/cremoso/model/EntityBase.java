package com.cremoso.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.User;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter(AccessLevel.PROTECTED)
//@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
public @Data class EntityBase {

	@Id
	@GeneratedValue
	private int id;
	
	@CreatedDate
	private Date createdAt;

	@LastModifiedDate
	private Date updatedAt;

	@CreatedBy
	private User createdBy;

	@LastModifiedBy
	private User updatedBy;

}
