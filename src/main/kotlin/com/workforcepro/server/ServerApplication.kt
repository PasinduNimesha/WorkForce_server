package com.workforcepro.server

import com.workforcepro.server.config.DbConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerApplication

fun main(args: Array<String>) {
	try {
		runApplication<ServerApplication>(*args);
	} catch (e: Exception) {
		e.printStackTrace();
	}


}
