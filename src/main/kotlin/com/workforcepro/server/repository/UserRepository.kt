package com.workforcepro.server.repository

import com.workforcepro.server.config.DbConfig
import com.workforcepro.server.entity.User
import org.springframework.stereotype.Repository
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

@Repository
class UserRepository (){
    var connection: Connection? = null

    init {
        try {
            connection = DbConfig.connection
        } catch (e: SQLException) {
            throw RuntimeException(e)

        }
    }
    fun getAllUsers(): List<User> {
        val userList: MutableList<User> = ArrayList()

        try {
            val sqlQuery = "SELECT * FROM user"
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
            val sqlQuery = "SELECT * FROM user WHERE id = ?"
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



    private fun getUser(user: User, resultSet: ResultSet): User {
        try {
            user.id = resultSet.getInt("id").toLong()
            user.username = resultSet.getString("username")
            user.password = resultSet.getString("password")
            user.email = resultSet.getString("email")
            user.role = resultSet.getString("role")
            user.enabled = resultSet.getBoolean("enabled")
            user.accountNonExpired = resultSet.getBoolean("accountNonExpired")
            user.credentialsNonExpired = resultSet.getBoolean("credentialsNonExpired")
            user.accountNonLocked = resultSet.getBoolean("accountNonLocked")
            user.firstName = resultSet.getString("firstName")
            user.lastName = resultSet.getString("lastName")

        } catch (e: SQLException) {
            throw java.lang.RuntimeException(e)
        }
        return user
    }
}