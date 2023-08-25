package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapKey;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feuser")
public class FeUser {
	@Id
	/*
	 * @GeneratedValue
	 * 
	 * @Column(name = "feUserId", columnDefinition = "BINARY(16)")
	 */
	@Column(name = "feuserid", length = 35)
	private Character feUserId='d';
	@Column(name = "firstname", length = 100)
	private String firstName;
	@Column(name = "lastname", length = 100)
	private String lastName;
	@Column(name = "email", length = 255)
	private String email;
	@Column(name = "password", length = 40)
	private String password;
	@Column(name = "phone", length = 20)
	private String phone;
	@Column(name = "cell", length = 20)
	private String cell;
	@Column(name = "defaultschoolid")
	private Integer defaultSchoolId;
	@Column(name = "wid", length = 100)
	private String wid ="hj-fl-tampa";
	@Column(name = "textable")
	private Integer textable =0;

}
