package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.avro.request.AvroHttpRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AvroSerializer {

	public byte[] serializeAvroHttpRequestJSON(AvroHttpRequest request) {

		DatumWriter<AvroHttpRequest> writer = new SpecificDatumWriter<>(AvroHttpRequest.class);
		byte[] data = new byte[0];
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Encoder jsonEncoder = null;
		try {
			// Json encoder
			jsonEncoder = EncoderFactory.get().jsonEncoder(AvroHttpRequest.getClassSchema(), stream);

			// Binary encoder
//			jsonEncoder = EncoderFactory.get().binaryEncoder(stream, null);

			writer.write(request, jsonEncoder);
			jsonEncoder.flush();
			data = stream.toByteArray();
		} catch (IOException e) {
			log.error("Serialization error:" + e.getMessage());
		}
		return data;
	}

	public AvroHttpRequest deSerializeAvroHttpRequestJSON(byte[] data) {
		DatumReader<AvroHttpRequest> reader = new SpecificDatumReader<>(AvroHttpRequest.class);
		Decoder decoder = null;
		try {
			decoder = DecoderFactory.get().jsonDecoder(AvroHttpRequest.getClassSchema(), new String(data));
			return reader.read(null, decoder);
		} catch (IOException e) {
			log.error("Deserialization error:" + e.getMessage());
		}
		return null;
	}
}
