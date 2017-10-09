package com.glarimy.factory;

import java.util.HashMap;
import java.util.Map;

public class SimpleDirectory implements Directory {
	private Map<String, Long> entries;

	public SimpleDirectory() {
		entries = new HashMap<>();
		entries.put("Krishna", 9731423166L);
	}

	public long find(String name) {
		Long phoneNumber = entries.get(name);
		if (phoneNumber == null)
			throw new NameNotFoundException();
		return phoneNumber;
	}
}
