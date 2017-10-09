package com.glarimy.factory;

public class DirectoryClient {
	public static void main(String[] args) throws Exception {
		Directory dir = DirectoryFactory.getDirectory("db");
		long phoneNumber = dir.find("Krishna");
		System.out.println(phoneNumber);
	}
}