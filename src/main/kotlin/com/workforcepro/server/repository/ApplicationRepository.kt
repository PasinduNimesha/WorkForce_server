package com.workforcepro.server.repository

import com.workforcepro.server.config.DbConfig
import com.workforcepro.server.entity.Application
import jakarta.persistence.Id
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class ApplicationRepository {
    final var connection: Connection? = null
    init {
        try {
            connection = DbConfig.connection
        } catch (e: SQLException) {
            throw RuntimeException(e)

        }
    }

    fun getAllApplications(): List<Application> {
        val applicationList: MutableList<Application> = ArrayList()

        try {
            val sqlQuery = "SELECT * FROM leaveapplication"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            val resultSet = preparedStatement.executeQuery()

            while (resultSet.next()) {
                applicationList.add(getApplication(Application(), resultSet))
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return applicationList
    }

    fun getApplicationById(id: Long): Application {
        val application = Application()
        val sqlQuery = "SELECT * FROM leaveapplication WHERE applicationId = ?"
        try {
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            preparedStatement.setLong(1, id)
            val resultSet = preparedStatement.executeQuery()
            if (resultSet.next()) {
                getApplication(application, resultSet)
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return application
    }

    fun createApplication(application: Application): Application {
        try {
            val sqlQuery = "INSERT INTO leaveapplication (employeeId, leaveType, startDate, endDate, reason, status) VALUES (?, ?, ?, ?, ?, ?)"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            preparedStatement.setLong(1, application.employeeId)
            preparedStatement.setString(2, application.leaveType)
            preparedStatement.setDate(3, application.startDate)
            preparedStatement.setDate(4, application.endDate)
            preparedStatement.setString(5, application.reason)
            preparedStatement.setString(6, application.status)
            preparedStatement.executeUpdate()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return application
    }

    private fun getApplication(application: Application, resultSet: ResultSet?): Application {
        application.leaveId = resultSet!!.getLong("leaveId")
        application.employeeId = resultSet.getLong("employeeId")
        application.leaveType = resultSet.getString("leaveType")
        application.startDate = resultSet.getDate("startDate")
        application.endDate = resultSet.getDate("endDate")
        application.reason = resultSet.getString("reason")
        application.status = resultSet.getString("status")

        return application
    }
}