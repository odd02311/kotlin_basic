package _8_interface

/*
  코틀린에서 interface 생성은 interface 키워드를 사용한다.

  코틀린의 인터페이스는 내부에 구현해야하는 추상 함수와
  java8의 default 메서드처럼 구현을 가진 함수를 모두 정의할 수가 있다.

  클래스에서 인터페이스를 구현할 때는 :을 붙이고 인터페이스의 이름을 붙이면 된다.

  클래스 상속 부분에서는 생성자 호출이 들어가는데 인터페이스의 경우에는 생성자 호출이 아닌
  인터페이스 명만 추가하는게 다른 점이다.

  코틀린에서는 인터페이스 내에 프로퍼티도 존재할 수 있다.

  ex): var coin: Int가 인터페이스 cart에 있다면
  cart를 수현한 클래스에서 무조건 구현해야되는 추상 프로퍼티가 된다.

  인터페이스의 다중 구현은 ,(콤마)로 구분하면 된다.

  다중 구현을 할때 문제점은 동이한 시그니처를 가진 함수를 구현할 때 문제점이 생긴다.

  상속과 마찬가지로 super 키워를 사용해 참조를 하지만 <>안에 인터페이스 명을 넣어서 사용한다.



 */

class Product(val name: String, val price: Int)

interface Wheel{
  fun roll()

}

interface Cart : Wheel{

  var coin: Int

  val weight : String
    get() = "20KG"

  fun add(product: Product)

  fun rent(){
    if(coin > 0) {
      println("카트를 대여한다.")
    }
  }

  override fun roll() {
    println("카트가 굴러간다.")
  }

  fun printId() = println("1234")

}

interface Order{
  fun add(product: Product){
    println("${product.name} 주문이 완료되었습니다.")
  }

  fun printId() = println("5678")
}


class MyCart(override var coin: Int) : Cart, Order {

  override fun add(product: Product){
    if( coin <= 0) println("코인을 넣어주세요")
    else println("${product.name}이(가) 카트에 추가됐습니다.")

    // 주문하기
    super<Order>.add(product)
  }

  override fun printId() {
    super<Cart>.printId()
    super<Order>.printId()
  }

}


fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 10000))
    cart.printId()
}