package com.modernjava.records;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(String name, BigDecimal price, String type) {

	public Product {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Name cannot be blank or null");
		if (price == null || price.compareTo(BigDecimal.ZERO) <= 0)
			throw new IllegalArgumentException("Price cannot be null or less than or equal to 0");
		if (type == null || type.isBlank())
			throw new IllegalArgumentException("Type cannot be blank or null");
	}
	
	public Product(String name, BigDecimal price) {
		this(name, price, "GENERAL");
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	
	
}
