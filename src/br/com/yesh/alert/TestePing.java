package br.com.yesh.alert;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestePing {

	public static Boolean TesteConect() throws IOException {
		Boolean valor = true;
		InetAddress address = null;
		try {
			address = InetAddress.getByName("192.168.5.199");
			int timeout = 300;
			if(!address.isReachable(timeout)) {
				valor = false;
			}
		} catch (UnknownHostException e) {
			System.out.println("Cannot lookup host 192.168.5.199");
			valor = false;
		}
		return valor;
	}

	
}
