package com.workforcepro.server.dto

import java.sql.Date

class EmployeeDto {
    var employeeId: Long = 0
    var fullName: String = ""
    var birthDate: Date? = null
    var maritalStatus: String = ""
    var emergencyContact: String = ""
    var organizationId: Long = 0
    var jobId: Long = 0
    var address: String = ""
    var employmentStatus: String = ""
    var supervisor: Long = 0
    var branchId: Long = 0
}