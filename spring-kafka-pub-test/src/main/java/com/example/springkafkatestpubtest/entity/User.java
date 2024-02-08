package com.example.springkafkatestpubtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, length = 20, columnDefinition = "BIGINT(20) UNSIGNED")
	private Long id;

	@Column(name = "name", columnDefinition = "VARCHAR(100)")
	private String name;

	@Column(name = "age", columnDefinition = "INT(3)")
	private Integer age;

	public static User of(
		String name,
		Integer age) {
		return User.builder()
			.name(name)
			.age(age)
			.build();
	}

	public void update(
		String name,
		Integer age) {
		this.name = name;
		this.age = age;
	}

}
