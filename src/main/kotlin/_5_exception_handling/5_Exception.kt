package _5_exception_handling

/*
  코틀린의 모든 예외 클래스는 최상위 예외 클래스인 Throwable을 상속한다.

  Throwable 아래에 Erro와 Exception이 있다.
  
  Error: unchecked error = 시스템에 비정상적인 상황이 발생. 예측이 어렵고 기본적으로 복구가 불가능 함
  ex): OutOfMemoryError, StackOverflowError
  
  Exception: RuntimeException(Unchecked exceptions), checked exceptions = 시스템에서 포착 가능하여 (try-catch) 복구 가능
  예외 처리 강제

 */

fun main() {

  // 코틀린은 checkedException을 강제하지 않기 때문에 컴파일 오류가 발생하지 않는다.
 try {
   Thread.sleep(1)
 } catch (e: Exception) {
   println("에러 발생")
 }

  // finally

  try {
    throw Exception()
  } catch (e: Exception){
    println("에러 발생!")
  } finally {
    println("finally 실행!")
  }

  // try-catch는 표현식이라 값을 반환할 수 있다.
  val a = try{
    "1234".toInt()
  }catch (e: Exception){
    println("예외 발생")
  }
  println(a)

  // 직접 exception 발생
//  throw Exception("예외 발생!")

  val b: String? = "not null"
  val c: String = b ?: failFast("a is null")

  println(c.length)


}

fun failFast(message: String): Nothing {
  throw IllegalArgumentException(message)
}