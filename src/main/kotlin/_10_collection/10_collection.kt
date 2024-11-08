package _10_collection

import java.util.*

/*
  컬렉션 타입
  - 코틀린 표준 라이브러리는 기본 컬렉션 타입인 List, Set, Map을 제공한다.
  - 컬렌션은 두가지 종류로 나뉜다.
    -- 불변 컬렉션(Immutable): 읽기 전용 컬렉션
    -- 가변 컬렉션(Mutable): 삽입, 수정, 삭제와 같은 쓰기 작업이 가능한 컬렉션

  컬렉션을 생성할때 가장 일반적인 방법은 표준 라이브러리 함수를 사용하는 것이다.

  listOf == 리스트를 만들어주는 팩토리 함수

  immutable 컬렉션은 값을 할당(초기화) 하면 새로운 값을 추가하거나 기존 값을 수정할 수 없다.

  mutable 컬렉션에는 apply 키워드를 통해 가독성을 좋게 리스트에 값을 할당 할 수 있다.

  또한 컬렉션 빌더를 사용하면 쉽게 컬렉션을 생성할 수 있다.

  특정 구현체를 사용하고 싶다면 해당 구현체의 생성자를 사용하면 된다.
  ex): linkedList, ArrayList...

 */


fun main() {

  // immutable
  val currencyList = listOf("달러", "유로", "원")



  // mutable
  val mutableCurrencyList = mutableListOf<String>().apply {
    add("달러")
    add("유로")
    add("원")
  }

  // immutable set
  val numberSet = setOf(1, 2, 3, 4)

  // mutable set
  val mutableSet = mutableSetOf<Int>().apply {
    add(1)
    add(2)
    add(3)
    add(4)
  }

  // immutable map
  val numberMap = mapOf("one" to 1, "two" to 2)

  // mutable map
  val mutableNumberMap = mutableMapOf<String, Int>()
  mutableNumberMap["one"] = 1
  mutableNumberMap["two"] = 2
  mutableNumberMap["three"] = 3

  // collection builder
  val numberList : List<Int> = buildList{
    add(1)
    add(2)
    add(3)
    add(4)
  }

  // linkedList
  val linkedList = LinkedList<Int>().apply{
    addFirst(3)
    add(2)
    addLast(1)
  }

  // arrayList
  val arrayList = ArrayList<Int>().apply {
    add(1)
    add(2)
    add(3)
  }
  
  // 순차적 반복
  // iterator pattern

  val iterator = currencyList.iterator()
  while(iterator.hasNext()) {
    println(iterator.next())
  }

  println("=======================")

  for(currency in currencyList){
    println(currency)
  }

  println("=======================")

  currencyList.forEach{
    println(it)
  }

  println("=======================")

  // for loop -> map
  val lowerList = listOf("a", "b", "c")
//  val upperList = mutableListOf<String>()

//  for (lowerCase in lowerList) {
//    upperList.add(lowerCase.uppercase())
//  }

  val upperList = lowerList.map { it.uppercase() }
//  println(upperList)
  // 필터의 역할은 특정 조건이 만족하는 경우에만
  // 그 값을 리스트에 담하서 리턴하는 역할이다.
//  val filteredList = mutableListOf<String>()
//  for (upperCase in upperList){
//    if(upperCase == "A" || upperCase == "C"){
//      filteredList.add(upperCase)
//    }
//  }
  val filteredList = upperList.filter {it == "A" || it == "C"}
  println(filteredList)


}