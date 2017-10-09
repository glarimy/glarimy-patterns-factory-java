package com.glarimy.factory;

public class DirectoryFactory {
	public static Directory getDirectory(String req) throws Exception {
		if (req.equalsIgnoreCase("memory"))
			return new SimpleDirectory();
		else if (req.equalsIgnoreCase("db"))
			return new PersistentDirectory();
		else
			throw new Exception("Unknown Directory");
	}
}
