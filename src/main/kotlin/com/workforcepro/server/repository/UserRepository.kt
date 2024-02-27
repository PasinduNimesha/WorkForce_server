package com.workforcepro.server.repository

import com.workforcepro.server.config.DbConfig
import com.workforcepro.server.entity.User
import org.springframework.stereotype.Repository
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

@Repository
class UserRepository (){
    final var connection: Connection? = null

    init {
        try {
            connection = DbConfig.connection
        } catch (e: SQLException) {
            throw RuntimeException(e)

        }
    }

    fun createUser(user: User): User {
            try {
                val sqlQuery = "INSERT INTO Users (username, password, email, role, firstName, lastName, employeeId, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                val preparedStatement = connection!!.prepareStatement(sqlQuery)
                preparedStatement.setString(1, user.username)
                preparedStatement.setString(2, user.password)
                preparedStatement.setString(3, user.email)
                preparedStatement.setString(4, user.role)
                preparedStatement.setString(5, user.firstName)
                preparedStatement.setString(6, user.lastName)
                preparedStatement.setLong(7, user.employeeId)
                preparedStatement.setString(8, user.gender)
                preparedStatement.executeUpdate()
            } catch (e: SQLException) {
                throw java.lang.RuntimeException(e)
            }
            return user
    }



    fun getAllUsers(): List<User> {
        val userList: MutableList<User> = ArrayList()

        try {
            val sqlQuery = "SELECT * FROM Users"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            val resultSet = preparedStatement.executeQuery()

            while (resultSet.next()) {
                userList.add(getUser(User(), resultSet))
            }
        } catch (e: SQLException) {
            throw java.lang.RuntimeException(e)
        }
        return userList
    }

    fun getUserById(id: Long): User {
        val user = User()
        try {
            val sqlQuery = "SELECT * FROM Users WHERE id = ?"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            preparedStatement.setLong(1, id)
            val resultSet = preparedStatement.executeQuery()
            if (resultSet.next()) {
                getUser(user, resultSet)
            }
        } catch (e: SQLException) {
            throw java.lang.RuntimeException(e)
        }
        return user
    }

    fun updateUser(user: User): User {
        try {
            val sqlQuery = "UPDATE Users SET username = ?, password = ?, email = ?, firstName = ?, lastName = ?, gender = ? WHERE id = ?"
            val preparedStatement = connection!!.prepareStatement(sqlQuery)
            preparedStatement.setString(1, user.username)
            preparedStatement.setString(2, user.password)
            preparedStatement.setString(3, user.email)
            preparedStatement.setString(4, user.firstName)
            preparedStatement.setString(5, user.lastName)
            preparedStatement.setString(6, user.gender)
            preparedStatement.setLong(7, user.id)
            if (preparedStatement.executeUpdate() == 0) {
                print("User not found")
            }
            return user
        } catch (e: SQLException) {
            throw java.lang.RuntimeException(e)
        }
    }





    private fun getUser(user: User, resultSet: ResultSet): User {
        try {
            user.id = resultSet.getInt("id").toLong()
            user.username = resultSet.getString("username")
            user.password = resultSet.getString("password")
            user.email = resultSet.getString("email")
            user.role = resultSet.getString("role")
            user.firstName = resultSet.getString("firstName")
            user.lastName = resultSet.getString("lastName")
            user.employeeId = resultSet.getInt("employeeId").toLong()
            user.gender = resultSet.getString("gender")

        } catch (e: SQLException) {
            throw java.lang.RuntimeException(e)
        }
        return user
    }
}