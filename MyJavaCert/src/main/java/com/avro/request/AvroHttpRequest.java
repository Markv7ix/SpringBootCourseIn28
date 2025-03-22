package com.avro.request;

import java.util.List;

import com.avro.model.Active;
import com.avro.model.ClientIdentifier;

public class AvroHttpRequest {

	private long requestTime;
	private ClientIdentifier clientIdentifier;
	private List<String> employeeName;
	private Active active;
}
