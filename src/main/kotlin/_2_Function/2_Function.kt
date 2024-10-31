package _2_Function/*
  기본적인 함수 선언 스타일
  fun sum(a: Int, b: Int) : Int {
    return a + b
    }

   먼저 함수를 선언할 때는 function의 약자인 fun 키워드를 작성
   fun(키워드) 함수명(함수의 인자, 함수의 인자2) : 함수가 반환할 타입{
      함수의 로직
      } 으로 구성 되어있다.

   또한 코틀린에는 표현식 스타일을 제공하고 있다.
   ex): fun sum2(a: Int, b: Int) : Int = a + b
    { }(몸통) 없이  로직만 들어가 있는 이런 방법을 표현식 스타일이라고 한다.

  // { 함수의 로직 }이 있는 함수는 반환 타입을 제거하면 컴파일 오류가 발생한다.
  fun sum4(a: Int, b: Int) : {
    return a + b // 오류
    }

  반환타입이 없는 함수는 유닛이라는 타입을 반환한다. 자바의 void와 유사하다.
  ex): fun printSum(a: Int, b: Int) : {
              println("$a + $b = ${a + b}")
            }
   unit을 통해서 특별한 기능을 사용한다기 보다는 타입이 없는 경우에는 자동으로 유닛이라고 하는 타입을 반환한다.

  코틀린에서는 디폴트 파라미터 기능을 제공한다.

  아래 코드에서 디폴트 파라미터 부분을 보면 함수의 매개변수 부분에 message : String = "안녕하세요!!"
  라고 기본 파라미터를 설정 해놨기 때문에 main을 실행 했을시 greeting()은 안녕하세요가 출력된걸 볼수있다.
  2번째 greeting("HI!!!")는 매개변수로 HI!!!를 받아서 출력이 됐다.
  이와 같이 코틀린에서는 값이 없는 변수에 대해서 디폴트 파라미터로 값을 할당 해 줄 수 있따.
 ** Message.java 클래스에서 자바의 코드와 비교할수 있다. **

 클래스가 없는데도 함수 선언이 가능했다 ( 클래스 밖의 스코프 범위에서도 선언이 가능하다)


 */

fun sum(a: Int, b: Int) : Int {
  return a + b
}

// 표현식 스타일
fun sum2(a: Int, b: Int) : Int = a + b

// 표현식 스타일 + 반환타입 생략 || 변수 선언때와 마찬가지로 타입 추론이 되기 때문에 반환 타입을 생략 할 수 있다.
fun sum3(a: Int, b: Int) = a + b

// 반환타입 생략으로 컴파일 오류
fun sum4(a: Int, b: Int) : Int {
  return a + b
}

// 변환 타입이 없는 함수는 Unit을 반환한다.
fun printSum(a: Int, b: Int) : Unit {
  println("$a + $b = ${a + b}")
}

// default parameter || 디폴트 파라미터
fun greeting(message : String = "안녕하세요!!"){
  println(message)
}

//fun main() {
//  greeting()
//  greeting("HI!!!")
//}

// named argument
// 함수에 변수 값을 넣을 때 이름과 값을 맵핑하는 기법이 named argument이다.
fun log(level: String = "INFO", message: String) {
  println("[$level]$message")
}

fun main() {
  log(message = "인포 로그")
  log(level = "DEBUG", "디버그 로그")
  log("WARN", "워닝 로그")
  log(level = "ERROR", message = "에러 로그")
}
// ** Logger.java 코드와 비교 가능 **