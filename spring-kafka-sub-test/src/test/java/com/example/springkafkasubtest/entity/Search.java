package com.example.springkafkasubtest.entity;

import java.time.ZonedDateTime;

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
public class Search {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, length = 20, columnDefinition = "BIGINT(20) UNSIGNED")
	private Long id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "keyword")
	private String keyword;

	@Column(name = "sale_start_date")
	private ZonedDateTime saleStartDate;

	@Column(name = "review_count")
	private Long reviewCount;

	@Column(name = "purchase_count")
	private Long purchaseCount;

	@Column(name = "sale_price")
	private Long salePrice;

	public static Search of(
		String productName,
		String brandName,
		String keyword,
		ZonedDateTime saleStartDate,
		Long reviewCount,
		Long purchaseCount,
		Long salePrice) {
		return Search.builder()
			.productName(productName)
			.brandName(brandName)
			.keyword(keyword)
			.saleStartDate(saleStartDate)
			.reviewCount(reviewCount)
			.purchaseCount(purchaseCount)
			.salePrice(salePrice)
			.build();
	}
}
