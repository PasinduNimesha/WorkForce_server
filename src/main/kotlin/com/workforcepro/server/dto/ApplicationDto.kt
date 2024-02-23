package com.workforcepro.server.dto

import java.sql.Date

class ApplicationDto {
    var applicationId: Long = 0
    var employeeId: Long = 0
    var leaveType: String = ""
    var startDate: Date? = null
    var endDate: Date? = null
    var reason: String = ""
    var status: String = ""
}