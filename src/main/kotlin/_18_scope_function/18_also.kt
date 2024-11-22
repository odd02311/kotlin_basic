package _18_scope_function

/*

    also

 */

class User(val name: String, val password: String){

    fun validate() {
        if(name.isNotEmpty() && password.isNotEmpty()){
            println("검증 성공!")
        } else {
            println("검증 실패!")
        }
    }

    fun printName() = println(name)

}

fun main() {

//    val user: User = User(name = "tony", password = "1234")
//    user.validate()

    User(name = "tony", password = "123").also {
        it.validate()
        it.printName()
    }

}