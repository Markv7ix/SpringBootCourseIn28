package com.modernjava.record;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.modernjava.records.Product;

class ProductTest {

	@Test
	void createProductComparison() {
		var product1 = new Product("Iphone", new BigDecimal("1000"), "ELECTRONICS");
		var product2 = new Product("Iphone", new BigDecimal("1000"), "TELECOM");
		
		assertEquals(product1, product2);
	}

}