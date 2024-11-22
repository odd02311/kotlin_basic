package _18_scope_function

/*
    스코프 함수: 객체의 컨텍스트 내에서 코드 블록을 실행하기 위해서만 존재하는 함수
    
    스코프 함수를 제대로 사용하면 불필요한 변수 선언이 없어지면 코드를 더 간결하고 읽기 쉽게 만든다.
    스코프 함수의 코드 블록 내부에서는 변수명을 사용하지 않고도 객체에 접근할 수 있는데 그 이유는 수신자 객체에
    접근할 수 있기 때문이다.
    수신자 객체는 람다식 내부에서 사용할 수 있는 객체의 참조이다
    스코프 함수를 사용하면 수신자 객체에 대한 참조로 this 또는 it을 사용한다.

    스코프 함수가 중첩될수록 비동기 프로그래밍의 콜백과 유사하게 코드의 가독성을 해칠 수가 있기 때문에
    많이 중첩이 되는 경우 ifElse를 사용하는게 가독성면에서 더 좋은 방법이다.

    스코프 함수 선택 방법: 코틀린은 총 5개의 유용한 스코프 함수를 제공
    
    함수명   수신자 객체 참조 방법   반환 값            확장 함수 여부
    let     it                  함수의 결과         O
    run     this                함수의 결과         O
    with    this                함수의 결과         x
    apply   this                컨텍스트 객체       O
    also    it                  컨텍스트 객체       O

    let: null이 아닌 경우 사용될 로직을 작성하고 거기에 따른 새로운 결과를 반환하고 싶을때 사용한다.
    run: 수신객체 프로퍼티를 구성하거나 새로운 결과를 반환하고 싶을때 사용
    with: 결과 반환 없이 내부에서 수신 객체를 이용해서 다른 함수를 호출하고 싶을 때 사용한다.
    apply: 수신 객체의 프로퍼티를 구성하고 수신 객체의 결과를 그대로 반환하고 싶을 때 사용한다.
    also: 부수 작업을 수행하거나 전달받은 수신객체를 그대로 결과로 반환하고 싶을 때 사용

    실제 실무에서는 섞어 쓰는 경우도 많다.

 */

fun main() {

    val str: String? = "안녕"

    val result: Int? =  str?.let {
        println(it)

//        val abc: String? = "abc" // 중첩 let 함수 가능
//        abc?.let {
//
//            val def : String? = "def" // 하지만 가독성 면에서 좋지 않음
//            def?.let {
//                println("abcdef가 null이 아님")
//            }
//        }
        // ifElse문으로 대체가 가능
        val abc: String? = "abc"
        val def: String? = "def"
        if(!abc.isNullOrEmpty() && !def.isNullOrEmpty()){
            println("abcdef가 null이 아님")
        }



        1234    // return 키워드로 지정하지 않았지만 let 함수의 마지막 코드가 자동으로 반환값이 된다.
    } // str이 null이면 출력이 되지않음

    println(result)

//    val this: String? = null // this는 키워드(사전에 정의된 예약어)이기 때문에 사용불가
//    val it: String? = null // 하지만 it은 사용이 가능하다

    val hello = "hello"
    val hi = "hi"

    hello.let { a : String ->
//        println(a.length)

        hi.let { b ->
            println(b.length)
            println(a.length)
            // 중첩해서 it을 사용할 경우 가독성도 안좋고, 어디 스코프의 it인지 헷갈릴수 있다.
            // 이런 중첩된 코드는 많이 사용하지 않는게 좋다
            // 사용하게 된다면 it이 아닌 직접 변수를 사용하는게 좋다
        }
    }

}

