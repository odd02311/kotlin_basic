package _18_scope_function

fun main() {
    
    val str = "안녕하세요"

    val length: Int = with(str) {
        length
    }

    println(length)

}