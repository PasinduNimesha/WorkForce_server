package com.workforcepro.server.service

import com.workforcepro.server.dto.EmployeeDto
import com.workforcepro.server.entity.Employee
import com.workforcepro.server.repository.EmployeeRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService @Autowired constructor(
    private val employeeRepository: EmployeeRepository,
    private val modelMapper: ModelMapper,
) {

    fun getAllEmployees() : List<EmployeeDto> {
        val employeeList = employeeRepository.getAllEmployees()
        return employeeList.map { modelMapper.map(it, EmployeeDto::class.java) }

    }

    fun getEmployeeById(id: Long): EmployeeDto {
        val employee = employeeRepository.getEmployeeById(id)
        return modelMapper.map(employee, EmployeeDto::class.java)
    }

    fun createEmployee(employee: EmployeeDto): EmployeeDto {
        val employeeEntity = modelMapper.map(employee, Employee::class.java)
        return modelMapper.map(employeeRepository.createEmployee(employeeEntity), EmployeeDto::class.java)

    }
}