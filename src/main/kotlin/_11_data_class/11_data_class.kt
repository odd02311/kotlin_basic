package _11_data_class
/*
  데이터 클래스란 데이터를 보관하거나 전달하는 목적을 가진 객체를 만들 때 사용된다.
  예를 들어 DTO와 같은 데이터를 전달하고 저장하는 목적을 가진 객체를 만들때 사용한다.

  데이터 클래스를 만들때는 data 키워드를 클래스앞에 붙여서 사용한다.

  데이터 클래스를 사용하면 컴파일러가 자동으로 만들어주느 함수들이 있다.
  equals, hashcode, toString, componentAnd, copy

  자바에서는 이러한 함수들을 만들어주는 클래스를 생성하기 위해서는 IDEA에서 직접 구현하거나 롬복을 사용한다.
  ex) @Data, toString...

  JDK-C 부터는 recored라는 이름으로 코틀린의 데이터 클래스와 흡사한 기능을 자바에서 제공한다.

  데이터 클래스는 데이터를 저장하는 목적으로 하는 클래스이기 때문에
  필수적인 함수 3가지가 toString, equals, hashcode 이다.
  equals는 기본적으로 객체에 대한 동등성 비교를 하게 된다. 그래서 일반적으로 2개의 인스턴스의 동등성 비교를 하기 위해
  equals를 재정의한다.

  equals가 true를 반환하는 코드는 hashCode도 true가 나와야 한다.

  copy: 데이터 클래스에서 제공하는 copy를 사용하면 객체의 불변성을 쉽게 유지할 수 있다.
  불변성이 깨졌을때 문제점은 hash 게열의 자료구조에서 의도치 않은 버그가 발생할 수 있다.

  객체의 불변성을 유지하는 것은 동기화 동시성에 대한 동기화 처리를 조금 줄여주고 안전성을 유지하는데 중요하다.

  componentN
  ex): println("이름=${person1.component1()}, 나이=${person1.component2()}")

 */


data class Person(val name: String, val age: Int)


fun main() {
  val person1 = Person(name = "tony", age = 12)

  val (name, age) = person1 // 구조분의 할당

  println("이름=${name}, 나이=${age}")

//  val person2 = person1.copy(name="strange")
//
//  println(person2)


//  val set = hashSetOf(person1)
//  println(set.contains(person1))

//  person1.name = "strange"
//  println(set.contains(person1))
}