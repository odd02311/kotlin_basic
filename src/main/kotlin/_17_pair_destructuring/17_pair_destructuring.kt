package _17_pair_destructuring

/*
    함수형 프로그래밍의 접근법을 사용한다면 plus 함수에 tuple이라는 개념을 적용 할 수있다.
    tuple: 함수에 하나의 인자로서 (1, 3) 이런식으로 들어온 것을 tuple이라고 한다.
    tuple 같은 경우에는 f(1, 3) 이런식으로 괄호가 생략이 가능하다

    코틀린에서는 tuple을 직접 작성할 필요없이
    pair 클래스를 사용하면 된다.

    또한 pair는 불변이고 데이터 클래스 기반이다.
    데이터 클래스가 제공하는 함수 equals, hashcode 등을 사용 가능하다.

    toList: immutable 형태의 불변 리스트를 제공한다.

    triple: 3개의 요소를 가질수 있다.

    4개부터는 별도의 자료구조를 만들던가 데이터 구조로 만들어서 사용해야한다.

    triple 또한 불변이다.

    구조분해할당 : val (a, b, c) = new Triple
    내부적으로 값을 분해한다. 여러개의 변수를 한번에 초기화가 가능한 문법

    배열이나 리스트에서도 구조분해 할당이 사용 가능하다.
 */

//data class Tuple(val a: Int, val b : Int)

fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

fun plus(a: Int, b: Int) = a + b


fun main () {

    val plus = plus(Pair(1,3))
    println(plus)

    val pair = Pair("A", 1)
//    pair.first = "B" // 컴파일 오류
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList()
    println(list)

    val triple = Triple("A", "b", "C")
    println(triple)
    triple.first
    triple.second
    triple.third

    val newTriple = triple.copy(third = "D")
    println(newTriple)

    println(newTriple.component3())

    val (a: String, b: String, c: String) = newTriple // 각각의 변수를 할당
    /*
        String a = (String)newTriple.component1();
        String b = (String)newTriple.component2();
        String c = (String)newTriple.component3();
     */
    println("$a, $b, $c")

    val list3: List<String> =  newTriple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")

    val map = mutableMapOf("이상훈" to "개발자")
    for ((key, value) in map) {
        println("$key -> $value")
    }

    
}