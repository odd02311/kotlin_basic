package _6_class_property
/*
  클래스는 class 키워드를 통해 만든다.
  코틀린에서는 class 본문을 생략할 수도 있다.
  ex: class EmptyClass

  코틀린에서는 클래스의 생성자를 만들 때 기본적으로 constructor라는 키워드를 사용할 수가 있다.

  ex): class Coffee constructor() {

  }

  또한 생성자 키워드도 생략이 가능하다.
  class Coffee(val name:String) {

  }

  코틀린에서는 lcass property를 선언할 때 property 간에 후행 쉼표를 사용할 수가 있다.

  ex): class Coffee(
            val name: String,
            val price: Int,
            ) {

            }
  뒤에 필드가 없음에도 불구하고 콤마를 넣을 수가 있다.
 */


/*
  Property:

  ex): class Coffee(
        var name: String = "",
        var price: Int = 0,
        )
    이러한 프로퍼티를 사용하기 위해서는 직접 참조를 사용하면 된다.

    fun main() {
      val coffee = Coffee()
      coffee.name = "아이스 아메리카노"
      coffee.price = 2000

      println("${coffee.name} 가격은 ${coffee.price}") // result = 아이스 아메리카노 가격은 2000

    }

    코틀린에서 바로 선언된 키워드는 기본적으로 getter setter를 자동으로 생성 해준다.
    실제로 coffe.name 과 price는 실제로 setter를 사용해서 값을 할당하게 된다.
    따로 코드에서 getter setter는 보이지 않지만 컴파일러가 자동 생성 해준다.

    프로퍼티를 var 타입이 아닌 val 타입으로 선언하게 되면
    setter는 존재하지 않고 getter만 존재하게 된다.

    코틀린은 커스텀 getter setter를 만들 수가 있다.

    코틀린의 프로퍼티는 매우 객체 지향적이다.
    기본적으로 객체지향 언어에서 객체의 상태는 프로퍼티로 표현하고 행위는 메서드로 표현한다.
    하지만 자바의 경우에는 그렇지 못하고 이제 그 상태를 프로퍼티가 아닌 메서드로 나타난다.
    * Java_Coffee 참고


 */


class Coffee (
  var name: String = "",
  var price: Int = 0,
  var iced: Boolean = false,
  ){
    val brand: String
      get() = "스타벅스" // 커스텀 getter 값 초기화
      // 또한 함수처럼 몸통을 넣어서 로직도 작성이 가능
      // get() {
      //    return "스타벅스"
      // }

    // 커스텀 setter
    var quantity : Int = 0
      set(value) {
        if (value > 0) {  // 수량이 0 이상인 경우에만 할당
          field = value
        }
      }
      // field 는 식별자이다. 코틀린에서는 filed를 사용해서 실제 필드의 참조에 접근을 한다.
      // 이를 backing field에 접근한다고 한다.
      // filed를 사용하지 않고 quantity = value 를 사용하게 되면 스택오버플로우가 발생한다.



      

}

fun main() {
  val coffee = Coffee()
  coffee.name = "아이스 아메리카노"
  coffee.price = 2000
  coffee.quantity = 1
  coffee.iced = true

  if (coffee.iced) { // 이 코드는 메서드가 아니다.
    println("아이스 입니다.")
  }

  println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 입니다. 수량은 ${coffee.quantity} 입니다.")

  // 이때 커피의 브랜드 필드를 사용하게 되면 자동으로 getter를 매번 호출하기 때문에
  // "스타벅스"를 항상 가지고 오는 것을 확인할 수 있다.
}