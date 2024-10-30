/*
  코틀린 기초: 변수

  코틀린에서 변수를 선언 하는 방법

  ex): val a : Int = 1
      키워드 변수명 : 타입 = 할당된 값
      으로 이루어져 있다.

  또한 타입을 생략하고도 사용이 가능하다.
  val b = 1 // 컴파일 오류 x
  이는 코틀린 컴파일러가 변수에 대입될 값을 검사해서 타입을 자동으로 추론해주기 때문에 가능하다.

  코틀린에서 변수를 선언할때는 2가지 키워드가 있다.
  1. val : value = 자바의 final 키워드처럼 한번 값을 초기화한 후에는 재할당이 불가능하다.
  2. var : variable = 초기화하고 나서 이후에 재할당이 가능하다.

  타입이 고정되면 그 타입은 변경이 불가능하다.

  코틀린에서는 변수를 함수/ 클래스 밖에서도 선언이 가능하다.

  ex): var x = 5
  fun main() {
   x+=1
   println(x)
  }
  result: 6

 */


fun main() {

  val a : Int = 1

  val b = 1

  // 지연 할당
  val c : Int
  c = 3

  // 지연 할당시 주의 해야할 점: 타입을 명시해 주지 않으면 오류가 발생

//  val d // 오류
//  d = 123
  
  // val 재할당 불가 예제
//  val e : String = "Hello"
//  e = "Wolrd" // 오류

  // var 재할당
  var d : String = "Hello"
  d = "World"

  // var은 재할당이 가능하지만 타입이 다르면 컴파일 오류가 발생
//  var f = 123
//  f = "hi" // 오류



}