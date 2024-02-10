package com.workforcepro.server

import com.workforcepro.server.config.DbConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerApplication

fun main(args: Array<String>) {
	runApplication<ServerApplication>(*args);
	try {
		val config = DbConfig.connection
		println("Connection success")
	} catch (e: Exception) {
		e.printStackTrace()
	}
}
