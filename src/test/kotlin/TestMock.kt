import net.bytebuddy.utility.RandomString
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class TestMock {

    @Mock
    lateinit var userDao: UserDao

    @Test
    fun testMain() {
        println(userDao?.getUser("dongzhihua"))

        println(RandomString.make(10))

    }


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
}

interface UserDao {
    fun getUser(name: String):Any?
}

class UserService {
    fun getUserByLoginName(loginName: String): Any? {
        print(loginName)
        if (loginName.startsWith("a")) {
            return null
        }
        return "{'user': $loginName}"
    }

    fun save(loginName: String):Any? {
        if (loginName.startsWith("a")) {
            return "已存在"
        }
        return "成功"
    }
}