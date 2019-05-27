package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class ObjectMapperFactory {

	
	public static final ObjectMapper getInstance() {
		return new ObjectMapper();
	}
}
