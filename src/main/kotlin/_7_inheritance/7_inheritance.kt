package _7_inheritance

/*
  자바의 상속: 기존 코드의 재사용성, 확장성을 위해 사용
  기본적으로 모든 클래스가 상속이 가능하나 부작용을 대비해 final 키워드로 방지 가능


  코틀린의 클래스는 자바와 다르게 기본적으로 파이널 클래스이다.
  final은 상속을 막지만, 상속이 필요한 경우에는 open이라는 키워드를 통해서 상속을 허용할 수 있다.

  코틀린에서 이제 함수나 property를 재정의할 때도 마찬가지로 open 키워드를 사용한다.

  메서드 재정의는 override 키워드를 사용해서 한다.

  또한 코틀린에서는 기본 생성자를 사용하게 되면 그 프로퍼티를 간결하게 재정의할 수 있다.

  상속받은 클래스에서 기본생성자 안에 프로퍼티를 넣어 사용할 수 있다.

  코틀린에서는 override가 되면 기본적으로 이 하위 클래스에서는 override된 프로퍼티나 함수는 자동으로 오픈 상태가 된다.

  하위 클래스에서 재정의를 하지 못하도록 막을려면 final 키워드를 사용하면 된다.

  자바와 동일하게 super 키워드를 사용해서 상위클래스의 메서드를 그대로 사용이 가능하다.

  추상 클래스는 abstract 키워드를 사용하면 된다.

 */

open class Dog{
  open var age: Int = 0

  open fun bark() {
    println("멍멍")
  }
}

open class Bulldog (final override var age : Int = 0) : Dog() // 상속을 하는 코드
{

  final override fun bark() {
    println("컹컹")

  }
}

abstract class Developer {

  abstract var age: Int
  abstract fun code(language: String)

}

class BackEndDeveloper(override var age: Int = 0) : Developer() {


  override fun code(language: String){
    println("I code with $language")
  }

}


fun main() {

//  val dog = Bulldog(2)
//  println(dog.age)
//  dog.bark()

  val backEndDeveloper = BackEndDeveloper(20)
  println(backEndDeveloper.age)
  backEndDeveloper.code("Kotlin")

}