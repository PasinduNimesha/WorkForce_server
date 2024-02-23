package com.workforcepro.server.service

import com.workforcepro.server.dto.ApplicationDto
import com.workforcepro.server.entity.Application
import com.workforcepro.server.repository.ApplicationRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ApplicationService @Autowired constructor(
    private val applicationRepository: ApplicationRepository,
    private val modelMapper: ModelMapper
){
    fun getAllApplications() : List<Application> {
        val applicationList = applicationRepository.getAllApplications()
        return applicationList

    }

    fun getApplicationById(id: Long): Application {
        val application = applicationRepository.getApplicationById(id)
        return application
    }

    fun createApplication(application: Application): Application {
        return applicationRepository.createApplication(application)

    }

}