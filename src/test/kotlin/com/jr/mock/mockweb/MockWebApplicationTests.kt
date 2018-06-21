package com.jr.mock.mockweb

import com.jr.mock.mockweb.entity.Facade
import com.jr.mock.mockweb.repository.FacadeRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class MockWebApplicationTests {

	@Autowired
	lateinit var facadeRepository: FacadeRepository

	@Test
	fun contextLoads() {
		var facade = Facade()
		facade.createdDate = Date()
		facade.name = "保存会员信息"
//		println(facadeRepository.save(facade))
		println(facadeRepository.findAll())
	}

}
