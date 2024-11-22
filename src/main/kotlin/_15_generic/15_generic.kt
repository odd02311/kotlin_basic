package _15_generic

/*
   코틀린의 제네릭은 자바와 마찬가지로 type parameter를 선언해서 generic을 선언한다.
   generic으로 만든 클래스의 인스턴스를 만들려면 type argument를 제공해 주면 된다.

   생성자에 string, 데이터 타입이 들어가 있으면 컴파일러가 자동으로 데이터 타입을 추론하여
   type argument를 생략할 수도 있다.
   ex): val generics = MyGenerics<String>("테스트") = argument 제공
   val generics = MyGenerics("테스트") = argument 생략, 컴파일러가 데이터 타입 추론

   type argument는 생성자에서 추가해도 된다.

   코틀린의 제네릭은 어떤 type이 들어올지 알 수 없지만 안전하게 사용하고 싶은 경우에는
   stop projection 구문을 제공한다.

   변성: generic에서 파라미터화된 type이 서로 어떤 관계에 있는지 설명하는 개념
   공변성, 반공변성 무공변성 이렇게 세가지로 나뉘게 된다.

   PECS(Producer - Extends, Consumer - Super)
   공변성: 자바 제네릭의 extends 코틀린에선 out 키워드 사용
   반공변성: 자바 제네릭의 super 코틀린에선 in

   공변성을 사용하기 위해서는 type parameter에 아웃 키워드를 사용하면 된다.

   공변성: 제네릭 클래스의 타입 매개변수가 클래스의 상속 관계와 동일한 방향으로 유지되는 것을 의미
   공변성은 타입이 출력(읽기 전용)으로만 사용될 때 의미가 있다.
   규칙: out은 타입 매개변수를 읽기 전용으로 제한한다. 즉, 클래스 안에서 T를 반환 할수는 있지만 수정은 불가능하다.
   ex):
        open class Animal
        class Dog : Animal()
        
        class Box<out T>(val value: T) // T는 "출력" 전용으로만 사용됨
        
        val dogBox: Box<Dog> = Box(Dog())
        val animalBox: Box<Animal> = dogBox // 가능
    class Box<out T>(val value: T) {
        // fun setValue(v: T) { } // 불가능 "입력"으로 사용할 수 없음
        fun getValue(): T = value // 가능 "출력"만 가능
        }

   반공변성: 반공변성은 제네릭 클래스의 타입 매개변수가 클래스의 상속 관계와 반대 방향으로 유지 되는것을 의미한다.


   ex):
    open class Animal
    class Dog : Animal()

    class Box<in T> { // T는 "입력" 전용으로만 사용됨
        fun accept(value: T) { /* 처리 */ } //입력으로 사용
        }

    val animalBox: Box<Animal> = Box<Animal>()
    val dogBox: Box<Dog> = animalBox // 가능 (반공변성)

    class Box<in T> {
        fun accept(value: T) {/* 처리 */} // 가능 "입력"으로 사용
        // fun getValue(): T { } // 불가능 "출력"으로 사용할 수 없음
 */


class MyGenerics<out T>(val t: T) {

}

class Bag<T> {

    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {    
    // 반 공변성
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))

//    // 공변성
//    val generics = MyGenerics<String>("테스트")
//    val charGenerics : MyGenerics<CharSequence> = generics // 컴파일 오류

    // 제네릭을 사용한 클래스의 인스턴스
//    val generics = MyGenerics<String>("테스트")
//
//    // 변수의 타입에 제네릭을 사용한 경우
//    val list1: MutableList<String> = mutableListOf()
//
//    // type argument를 생성자에서 추가
//    val list2 = mutableListOf<String>()
//
//    // stop projection
//    val list3 : List<*> =listOf<String>("테스트")
//    val list4 : List<*> =listOf<Int>(1, 2, 3, 4)



}