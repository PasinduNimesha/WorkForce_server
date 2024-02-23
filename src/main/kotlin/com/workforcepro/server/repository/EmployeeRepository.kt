package com.workforcepro.server.repository

import com.workforcepro.server.config.DbConfig
import com.workforcepro.server.entity.Employee
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class EmployeeRepository {
    final var connection: Connection? = null

    init {
        try {
            connection = DbConfig.connection
        } catch (e: SQLException) {
            throw RuntimeException(e)

        }
    }

    fun getAllEmployees(): List<Employee> {
        val employeeList: MutableList<Employee> = ArrayList()

        try {
            val sqlQuery = "SELECT * FROM Employee"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            val resultSet = preparedStatement.executeQuery()

            while (resultSet.next()) {
                employeeList.add(getEmployee(Employee(), resultSet))
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return employeeList
    }

    fun getEmployeeById(employeeId: Long): Employee {
        val employee = Employee()
        try {
            val sqlQuery = "SELECT * FROM Employee WHERE employeeId = ?"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            preparedStatement.setLong(1, employeeId)
            val resultSet = preparedStatement.executeQuery()
            if (resultSet.next()) {
                getEmployee(employee, resultSet)
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return employee
    }

    fun createEmployee(employee: Employee): Employee {
        try {
            val sqlQuery = "INSERT INTO Employee (fullName, birthDate, maritalStatus, emergencyContact, organizationId, jobId, address, employmentStatus, supervisor, branchId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            preparedStatement.setString(1, employee.fullName)
            preparedStatement.setDate(2, employee.birthDate)
            preparedStatement.setString(3, employee.maritalStatus)
            preparedStatement.setString(4, employee.emergencyContact)
            preparedStatement.setLong(5, employee.organizationId)
            preparedStatement.setLong(6, employee.jobId)
            preparedStatement.setString(7, employee.address)
            preparedStatement.setString(8, employee.employmentStatus)
            preparedStatement.setLong(9, employee.supervisor)
            preparedStatement.setLong(10, employee.branchId)
            preparedStatement.executeUpdate()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return employee
    }

    private fun getEmployee(employee: Employee, resultSet: ResultSet?): Employee {
        try {
            employee.employeeId = resultSet!!.getLong("employeeId")
            employee.fullName = resultSet.getString("fullName")
            employee.birthDate = resultSet.getDate("birthDate")
            employee.maritalStatus = resultSet.getString("maritalStatus")
            employee.emergencyContact = resultSet.getString("emergencyContact")
            employee.organizationId = resultSet.getLong("organizationId")
            employee.jobId = resultSet.getLong("jobId")
            employee.address = resultSet.getString("address")
            employee.employmentStatus = resultSet.getString("employmentStatus")
            employee.supervisor = resultSet.getLong("supervisor")
            employee.branchId = resultSet.getLong("branchId")
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return employee
    }

}