package _4_null

import java.lang.NullPointerException


fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?: 0

fun main() {

//
////    val a : String = null // 컴파일 오류
////    var b : String = "aabbcc"
////    b = null // 컴파일 오류
//
//  var a : String? = null // nullable 타입인걸 ?를 사용해서 컴파일러에게 알려준다.
////    a.length // 컴파일 오류
//  a?.length // 컴파일 오류 X
//  println(a?.length)
//
//  // 코틀린에서는 삼항 연산자가 없기 때문에 if..else 구문을 통해서 조건에 대한 분기를 할 수 있다.
//  // null에 대한 조건이 들어왔을 때 값을 반환하는 방식
//
//  val b: Int = if(a != null) a.length else 0
//  println(b) // result = 0
//
//  // 코틀린에서 쫌 더 간편하게 처리가 가능하다.
//  // 엘비스 연산자
//  val c = a?.length  ?: 0
//  println(c)
//


  // *Java_NullSafety 코드를 코틀린으로 변환
  val nullableStr = getNullStr()

  // 자바코드에서는 intellij에서 경고는 해주지만 컴파일러 쪽에서는 오류가 나지 않는다.
  // 하지만 코틀린에서는 컴파일러 오류를 표시해 줌으로써 좀 더 nullpointerexception을 방지할 수 있다.
  val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
  println(nullableStrLength)

  val length = getLengthIfNotNull(null)
  println(length)

  // NullPointerException이 코틀린에서 발생하는 상황
//  throw NullPointerException() // 직접적으로 에러 던지기

  // 코틀린에서도 npe 가능성이 줄어들뿐이지 아예 없는 것은 아니다.
  val c : String? = null
  // 단언 연산자
  // 단언 연산자를 사용하게 되면 이 !! 연산자를 통해 해당 변수는 Null이 발생하지 않는다라고 컴파일러에게 알려주는 것이라고 보면 된다.
  // 단언 연산자는 null을 없애주는것은 아니다. 이렇게 사용하면 npe이 뜨고 이것은 개발자가 컴파일러에게 맡기는것이 아닌
  // 직접 핸들링 하겠다라는 뜻이라서 단언 연산자는 자주 사용되진 않는다.
  val d = c!!.length
  
  
}