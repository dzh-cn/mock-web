package com.jr.mock.mockweb.service

import com.jr.mock.mockweb.document.Project
import com.jr.mock.mockweb.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService {
    @Autowired
    lateinit var projectRepository: ProjectRepository

    fun list(roles: Array<String>?): List<Project> {
        return projectRepository.findAll()
    }

    fun save(project: Project):Project {
        return projectRepository.save(project)
    }
}