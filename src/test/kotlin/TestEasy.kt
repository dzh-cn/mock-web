import com.google.gson.Gson

fun main(args: Array<String>) {
	var gson = Gson()
	var obj = gson.fromJson<Any>("0", Any::class.java)
	println(obj.javaClass)
}