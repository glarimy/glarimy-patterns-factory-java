package com.glarimy.factory;

public class DirectoryClient {
	public static void main(String[] args) throws Exception {
		Directory dir = (Directory) CommonFactory.get("directory");
		long phoneNumber = dir.find("krishna");
		System.out.println(phoneNumber);
	}
}