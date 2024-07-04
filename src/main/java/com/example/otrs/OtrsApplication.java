package com.example.otrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*

@author ishani.s
 */

@SpringBootApplication
public class OtrsApplication {

	public static void main(String[] args) {

		SpringApplication.run(OtrsApplication.class, args);
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			String hostName = localHost.getHostName();
			String hostAddress = localHost.getHostAddress();

			System.out.println("Host Name: " + hostName);
			System.out.println("Host Address: " + hostAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
