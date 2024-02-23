package com.workforcepro.server.controller

import com.workforcepro.server.dto.EmployeeDto
import com.workforcepro.server.service.EmployeeService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/employee")
class EmployeeController @Autowired constructor(
    private val employeeService: EmployeeService?,
    private val modelMapper: ModelMapper?
){
    @GetMapping
    fun getAllEmployees(): List<EmployeeDto> {
        return employeeService!!.getAllEmployees()
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): EmployeeDto {
        return employeeService!!.getEmployeeById(id)
    }

    @PostMapping
    fun createEmployee(@RequestBody employee: EmployeeDto): EmployeeDto {
        return employeeService!!.createEmployee(employee)
    }

}