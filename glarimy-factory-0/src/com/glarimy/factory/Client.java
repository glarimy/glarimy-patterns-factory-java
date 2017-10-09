package com.glarimy.factory;

public class Client {

	public static void main(String[] args) {
		AbstractProvider provider = Factory.get();
		provider.service();
	}

}
