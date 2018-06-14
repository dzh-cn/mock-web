package com.jr.mock.mockweb.repository

import com.jr.mock.mockweb.document.Facade
import com.jr.mock.mockweb.document.Param
import com.jr.mock.mockweb.document.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * 项目Repository
 */
interface ProjectRepository : JpaRepository<Project, Int>

/**
 * 接口Repository
 */
interface FacadeRepository : JpaRepository<Facade, Int>

/**
 * 参数Repository
 */
interface ParamRepository : JpaRepository<Param, Int>