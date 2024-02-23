package com.workforcepro.server.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

@Component
@ConfigurationProperties(prefix = "spring.datasource")
object DbProperties {
    var url: String = ""
    var username: String = ""
    var password: String = ""
    var driverClassName: String = ""
}

object DbConfig {

    val connection: Connection
        get() {
            println(DbProperties.url)
            println(DbProperties.username)
            println(DbProperties.password)
            println(DbProperties.driverClassName)
            try {
                return DriverManager.getConnection(
                    DbProperties.url,
                    DbProperties.username,
                    DbProperties.password
                )
            } catch (e: SQLException) {
                println("Connection failed")
                throw RuntimeException(e)
            } catch (e: ClassNotFoundException) {
                println("Driver not found")
                throw RuntimeException(e)
            }
        }
}