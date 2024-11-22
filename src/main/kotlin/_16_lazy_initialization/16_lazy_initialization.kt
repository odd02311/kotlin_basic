package _16_lazy_initialization

/*
    지연 초기화: 대상에 대한 초기화를 미뤘다가 실제 사용시점에 초기화하는 기법
    초기화 과정에서 자원을 많이 쓰거나 오버헤드가 발생할 경우 지연 초기화를 사용하는게 유리
    지연초기화는 많은 상황에서 쓰이고 있다.
    ex): 웹페이지에서 특정 스크롤에 도달했을때 컨텐츠를 보여주는 무한 스크롤
         싱글톤 패턴의 지연 초기화
    
    코틀린은 2가지 지연 초기화 방법을 제공 한다

    by lzay를 사용할 경우 항상 val로 불변성을 유지해야 한다.
    또한 사용시점에 1회만 초기화 로직이 동작한다.
 */

class HelloBot  {

    val greeting: String by lazy {
        println("초기화 로직 수행")
        getHello()
    }
    // sayHello를 사용하는 시점에 by lazy를 통해 greeting에 초기화
    fun sayHello() = println(greeting)

}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()

    for (i in 1..5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }
}