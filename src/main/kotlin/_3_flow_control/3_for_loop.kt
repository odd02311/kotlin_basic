package _3_flow_control

fun main() {
  // 범위 연산자 .. 를 사용해 for loop 돌리기
  // 코틀린에서 ..이 범위연산자로 for 루프를 쉽게 돌릴수 있다.
  // 특징은 뒤에 온 값도 포함된다
  for(i in 0..3){
    println(i)
  }
  // result == 0 1 2 3

  // 뒤에 온 값을 포함하지 않을려면 until을 사용해 루프를 돌리면 된다.
  // until은 뒤에 온 값은 포함 하지 않는다.
  for(i in 0 until 3){
    println(i)
  }
  // result == 0 1 2

  // 반복문을 돌 때 특정 값만큼 값을 증가시키면서 반복을 돌리고 싶다면 step을 사용하면 된다.
  // step 에 들어온 값 만큼 증가시킨다.
  for(i in 0 ..6 step 2) {
    println(i)
  }
  // result == 0 2 4 6
  // step 을 통해서 값을 2씩 증가시키도록 하였다.

  // 반대로 값을 감소 시키면서 반복을 돌리고 싶다면 downTo를 사용하면 된다.
  // downTo를 사용해 반복하면서 값을 감소시킨다.
  for(i in 3 downTo 1){
    println(i)
  }

  // 전달받은 배열을 반복
  val numbers = arrayOf(1,2,3)

  for (i in numbers) {
    println(i)
  }
  // result == 1, 2, 3
  
}