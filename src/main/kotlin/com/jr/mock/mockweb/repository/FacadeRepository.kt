package com.jr.mock.mockweb.repository

import com.jr.mock.mockweb.entity.Facade
import com.jr.mock.mockweb.entity.Param
import com.jr.mock.mockweb.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

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