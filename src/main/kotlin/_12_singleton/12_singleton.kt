package _12_singleton

import java.time.LocalDateTime

/*
  싱글톤:
   - 싱글톤 패턴은 클래스의 인스턴스를 하나의 단일 인스턴스로 제한하는 디자인 패턴이다.
   - 싱글톤 패턴을 구현할때는 몇가지 제약사항을 통해 구현한다.
     -- 직접 인스턴스화 하지 못하도록 생성자를 private 으로 숨긴다.
     -- getInstance() 라는 클래스의 단일 인스턴스를 반환하는 static 메서드를 제공한다.
     -- 멀티-스레드 환경에서도 안전하게 유일한 인스턴스를 반환해야한다.

   코틀린에서는 오브젝트 키워드를 사용하는 것으로 쉽게 싱글톤 객체를 생성할 수 있다.
   싱글톤 객체인 오브젝트 키워드를 사용한 이 싱글에서 함수나 변수를 사용할 때는
   클래스 한정자를 사용한다.

   싱글톤을 사용하게 되면 자바의 static을 사용해서 보통 유틸리티를 만들게 된다.
   객체 선언을 통해서도 이제 싱글톤 기반의 유틸리티를 만든다.

   ex): datetimeUtility

   동반 객체: companion object라는 키워드를 사용하는 클래스 내부에서 생성되는 객체


 */

//object Singleton {
//
//  val a = 1234
//
//  fun printA() = println(a)
//
//}
//
//fun main() {
//  println(Singleton.a)
//  Singleton.printA()
//}

//object DatetimeUtils {
//
//  val now : LocalDateTime
//    get() = LocalDateTime.now()
//
//  const val DEFAULT_FORMAT = "YYYY-MM-DD"
//
//  fun same(a: LocalDateTime, b: LocalDateTime) : Boolean {
//    return a == b
//  }
//
//
//}
//
//fun main() {
//  println(DatetimeUtils.now)
//  println(DatetimeUtils.now)
//  println(DatetimeUtils.now)
//
//  println(DatetimeUtils.DEFAULT_FORMAT)
//
//  val now = LocalDateTime.now()
//  println(DatetimeUtils.same(now, now))
//}

// 동반 객체
class MyClass{

  private constructor()

  companion object MyCompanion{ // 이 자체의 이름을 가질수 있다.
    val a =1234

    fun newInstance() = MyClass() // 직접 생성자를 통해서 초기화를 못하게 하는 용도

  }

}

fun main() {
  println(MyClass.a)
  println(MyClass.newInstance())

  println(MyClass.MyCompanion.a) // companion 생략 가능
  println(MyClass.MyCompanion.newInstance())

}