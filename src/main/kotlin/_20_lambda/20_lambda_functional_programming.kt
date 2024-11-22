package _20_lambda

/*

    함수형 프로그래밍: 수학의 함수적 개념을 참고해 만든 패러다임. 유지보수가 용의한 소프트웨어를 만들기 위해 사용
    부수 효과가 없고 똑같은 인풋이 들어오면 항상 동일한 아웃풋을 내놓는 순수함수의 개념을 기반으로 람다, 고차함수, 쿼리, 메모리제이션, 모나드 등의 개념을 포함한다.

    코틀린에서 어떻게 함수형 패러다임을 지원하는 지의 기본적인 내용

    fun으로 선언한 함수 같은 경우에는 1급 객체의 특성인 함수를 인자로 넘기거나 결과로 반환한다 또는 값으로 취급한다 라는 특성을 가지지 않기때문에 컴파일 오류가 발생한다.

    함수형 프로그래밍에서는 이름 없는 무명 함수를 익명 함수라고 칭한다.

 */


    
    // 함수를 값으로 사용하기
//    val func : () -> Unit = {}
//    val func : () -> String = {"Hello World"}

    val printHello: () -> Unit = { println("Hello") }
//
//    val list = mutableListOf(printHello) // 리스트에 넣는것 또한 가능
//
//    list[0]() // 값에 함수가 할당되었더라도 () 함수 표기명을 붙여줘야 사용이 가능
//
//    val func: () -> Unit = list[0] // 다시 꺼내서 할당도 가능하다
//    func()

    // 함수도 인자로 받아서 사용 가능
//    fun call (block: () -> Unit) {
//        block()
//    }

//    call(printHello)

//    fun printNo() = println("No!")

    // 인자를 받아서 결과를 리턴하는 함수 값
//    val printMessage: (String) -> Unit = { message: String -> println(message) }
//
//    val printMessage2: (String) -> Unit = { message -> println(message) }
//
//    val printMessage3: (String) -> Unit = { println(it)}

    // 다수의 인자를 이와 같이 받아서 처리할 수 있는 함수도 만들 수 있다.
//    val plus: (Int, Int, Int) -> Int = {a, b, c -> a + b + c}



// 함수를 받아서 유닛을 반환하는 함수
//fun outerFunc() : () -> Unit {
//
//    // 익명 함수, 함수명이 없다.
//    return fun() {
//        println("this is outerFunc")
//    }
//
//}

// 람다식
//fun outerFunc() : () -> Unit {
//    return {println("this is outerFunc")}
//}

// 코드 추상화
fun outerFunc() : () -> Unit = {println("this is outerFunc")}

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

// 최대한 생략한 람다 식/ 타입은 생략 불가
val sum2 = {x:Int, y:Int -> x + y}

// 고차 함수 : 함수를 인자로 받아서 처리를 하고 결과를 반환하는 함수들을 고차 함수라고 한다.
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for(item in collection){
        action(item)
    }
}

fun main() {


//    val list = mutableListOf(printNo) // 컴파일 오류
//    call(printNo) // 컴파일 오류
//    val func = printNo // 컴파일 오류

//    val result = plus(1, 3, 5)
//    println(result)

//    // a b c로 리스트 생성
//    val list = listOf("a","b","c")
//    // printStr 함수에서 각각의 스트링 인자를 받아서 개별로 println
//    val printStr : (String) -> Unit = { println(it) }
//
//    forEachStr(list, printStr) // list.forEach (printStr) 또한 동일한 값을 출력하는데, 이 forEach도 고차함수이기 때문이다.

//   val func =  outerFunc() // outerFunc 안에 있는 익명함수를 호출 하려면 ()()식으로 써줘야 한다.
//    func()
    
    // 후행 람다식으로 forEach문 쪽 재작성
    val list = listOf("a", "b", "c")

    val printStr : (String) -> Unit = {println(it)}
    
    // 후행 람다
    forEachStr(list) {
        printStr(it)
    }


// 람다 레퍼런스: 가독성 졸게 함수를 인자로 넘길 수 있다.
    // top 레벨에 속하거나 로컬에 있는 함수들 경우에는 앞에 클래스명은 필요없고 ::함수명으로 사용하면 된다.
    // 확장함수이거나 클래스의 멤버 함수인 경우 클래스 지시자를 사용해서 ex): (String::toInt) (어떤클래스::어떤함수이다)

//    val callReference : () -> Unit = { printHello() }
    val callReference = ::printHello
    callReference()()

    val numberList = listOf("1", "2", "3", "4")
//    numberList.map {it.toInt()}.forEach{println(it)}

    numberList.map(String::toInt).forEach(::println)

}

