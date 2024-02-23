package com.workforcepro.server.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.sql.Date

@Entity
class Application {
    @Id
    var leaveId: Long = 0
    var employeeId: Long = 0
    var leaveType: String = ""
    var startDate: Date? = null
    var endDate: Date? = null
    var reason: String = ""
    var status: String = ""

}