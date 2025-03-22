package com.example.demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

import org.avro.request.Active;
import org.avro.request.AvroHttpRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avro.model.ClientIdentifier;

@SpringBootApplication
public class AvroExampleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AvroExampleApplication.class, args);

		AvroSerializer serializer = new AvroSerializer();

		ClientIdentifier clientId = new ClientIdentifier("myhost", "127.0.0.1");
		List<CharSequence> employeeList = List.of("mhernandez", "ternd", "malfaro");
		AvroHttpRequest request = new AvroHttpRequest(Instant.now().toEpochMilli(), clientId, employeeList, Active.YES);
		byte[] data = serializer.serializeAvroHttpRequestJSON(request);

		File file = new File("src/main/resources/request.dat");
		try (FileOutputStream fos = new FileOutputStream(file);) {
			fos.write(data);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		byte [] fileData = new byte [0];
		try (FileInputStream fis = new FileInputStream(file);) {
			fileData = fis.readAllBytes();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		AvroHttpRequest loadedRequest = serializer.deSerializeAvroHttpRequestJSON(fileData);
		System.out.println(loadedRequest);
	}

}
