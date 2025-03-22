package com.avro;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

import lombok.Data;

@Data
public class AvroExample {

	
	public static Schema getClientIdentifierSchema() {
		Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier").
				namespace("com.avro.model").
				fields().
				requiredString("hostName").
				requiredString("ipAddress").endRecord();
		
		return clientIdentifier;
	}
	
	public static Schema getClientSchema() {
		
		Schema avroHttpRequest = SchemaBuilder.record("AvroHttpRequest").
				namespace("org.avro.request").
				fields().
					requiredLong("requestTime").
					name("clientIdentifier").
					type(getClientIdentifierSchema()).noDefault().
					name("employeeNames").
					type().array().
					items().stringType().arrayDefault(null).
					name("active").
					type().enumeration("Active").
					symbols("YES", "NO").noDefault().
					endRecord();
		
		return avroHttpRequest;
	}
	
	
	public static void main(String[] args) {

		System.out.println(getClientIdentifierSchema().toString());
		System.out.println(getClientSchema().toString());
		
	}
}
