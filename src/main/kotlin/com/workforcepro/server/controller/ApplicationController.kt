package com.workforcepro.server.controller

import com.workforcepro.server.dto.ApplicationDto
import com.workforcepro.server.entity.Application
import com.workforcepro.server.service.ApplicationService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/application")
class ApplicationController @Autowired constructor(
    private val applicationService: ApplicationService?,
    private val modelMapper: ModelMapper?
){
    @GetMapping
    fun getAllApplications(): ResponseEntity<List<Application>> {
        val applications = applicationService!!.getAllApplications()
        print(applications)
        Thread.sleep(2000)
        return ResponseEntity.ok(applications)
    }

    @GetMapping("/{id}")
    fun getApplicationById(@PathVariable id: Long): ResponseEntity<Application> {
        return ResponseEntity.ok(applicationService!!.getApplicationById(id))
    }

    @PostMapping
    fun createApplication(@RequestBody application: Application): ResponseEntity<Application> {
        return ResponseEntity.ok(applicationService!!.createApplication(application))
    }
}