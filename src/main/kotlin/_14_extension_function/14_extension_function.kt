package _14_extension_function

/*
 확장함수: 상속이나 디자인 패턴 없이 클래스를 간단하게 확장할 수 있는 방법
 실제로 클래스 내부에 메서드나 프로퍼티가 생성되는 것은 아니며 정적 바인딩이 된다.

 ex): 일반적으로 수정할 수 없는 코틀린의 표준 라이브러리에 개발자가 커스텀한 기능을 추가하거나 확장할 수 있다.
      String
  
  리시버, 수신자 객체:
  확장 함수 내에는 this가 있는데 this는 확장이 되는 대상의 참조이다.
  아래 예제에서 this는 "ABCD"라는 문자열이 되는 것이다.

  디컴파일 해서 자바코드로 보면 static final로 선언된것을 볼 수 있다.
  인자에 보면 String $this$first라고 되어있다.
  코틀린에서 this라는 키워드를 통해서 확장이 되는 대상 객체의 참조를 가지고 올수 있다.
  하지만 아래 예제의 first() 확장함수에는 아무런 인자가 없다.
  자바에는 String $this$first가 있지만 코틀린에서는 표시가 되어있지 않다. $변수명$메서드명

  확장 함수 주의점: 확장하는 클래스에 동일한 명칭의 함수가 존재할 경우 클래스의 멤버 함수가 우선되는 규칙이 있다.

  항상 동일한 시그니처가 있는지 확인 해야한다. 컴파일 오류가 뜨지 않기때문에 유의해야한다.

  null 가능성이 있는 확장 함수:


 */

fun String.first() : Char {
  return this[0]
}

fun String.addFirst(char: Char) : String {
  return char + this.substring(0)
}

class MyExample {
  fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage(message: String) = println(message)

fun MyExample?.printNullOrNotNull() {
  if(this == null) println("널인 경우에만 출력")
  else println("널이 아닌 경우에만 출력")
}

fun main() {

  var myExample: MyExample? = null
  myExample.printNullOrNotNull() // ? 안전연산자를 쓰지 않았는데도 컴파일 오류가 발생 X
  // 내부에서 널에대한 처리를 하고 있기 때문에 컴파일러는 확장 함수는 널인 경우에도 처리를 하기 때문에 npe가 발생하지 않는다는 것을 안다.
  //

  myExample = MyExample()
  myExample.printNullOrNotNull()

//  MyExample().printMessage() // result: 클래스 출력
//MyExample().printMessage("확장 출력") // result 확장 출력

//  println("ABCD".first())
//
//  println("ABCD".addFirst('Z'))


}