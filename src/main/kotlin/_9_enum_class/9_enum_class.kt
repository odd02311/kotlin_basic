package _9_enum_class

/*
  enum 클래스 또한 클래스이기 때문에 생성자 와 프로퍼티를 정의할 수 있다.

  상수 뒤에 함수를 정의할 경우가 있는데, 그때는 세미콜론을 이용한다.

  valueOf()는 인자로 들어온 프로퍼티를 가지고 이 PaymentStatus의 상수와 일치하는 것들을 찾아서 인스턴스화 시킨다.

  코틀린의 enum 클래스는 values라는 함수를 제공하고 있다.
  values는 enum 클래스에서 선언된 상수들의 리스트를 가지고 있을 수 있다.

  enum 클래스의 상수에는 두 가지의 기본 프로퍼티가 존재한다.
  1. name: 상수의 이름
  2. ordinal: 프로퍼티의 선언된 순서


 */


enum class PaymentStatus(val label: String) {
  UNPAID("미지급"){
               override fun isPayable(): Boolean = true
               },
  PAID("지급 완료"){
               override fun isPayable() = false
               },
  FAILED("지급 실패"){
                 override fun isPayable() = false
                 },
  REFUNDED("환불"){
                  override fun isPayable() = false
  };

  abstract fun isPayable(): Boolean
}

fun main() {

//  if(PaymentStatus.UNPAID.isPayable()){
//    println("결제 가능 상태")
//  }
//  val paymentStatus = PaymentStatus.valueOf("PAID")
//
//  println(paymentStatus.label)
//
//  // 동등성 비교
//  if(paymentStatus == PaymentStatus.PAID){
//    println("결제 완료 상태")
//  }
//
//  for (status in PaymentStatus.values()){
//    println("[$status] (${status.label}")
//  }

  for (status in PaymentStatus.values()){
    println("[${status.name}] (${status.label}) : ${status.ordinal}")
  }

}