package com.workforcepro.server.config

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DbConfig {
<<<<<<< Updated upstream
=======
    @Value("\${spring.datasource.url}")
    private val dbUrl: String? = null
    @Value("\${spring.datasource.username}")
    private val dbUsername: String? = null
    @Value("\${spring.datasource.password}")
    private val dbPassword: String? = null
    @Value("\${spring.datasource.driver-class-name}")
    private val dbDriver: String? = null
>>>>>>> Stashed changes
    val connection: Connection
        get() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver")
                return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/wfp_db",
                    "root",
                    "30104771"
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