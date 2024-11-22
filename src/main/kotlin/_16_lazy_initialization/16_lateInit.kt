package _16_lazy_initialization

/*
    lateinit은 가변 프로퍼티에 지연 초기화를 할수 있게 해주는 키워드이다.

    lteInit은 초기화가 먼저 돼야지 그렇지 않은 경우에는 사용할 때 exception을 볼 수 있다.

    isInitialized로 초기화된 상태인지를 확인이 가능하다.
    또한 클래스 내부에서만 사용이 가능하다.

    사용을 하고 싶으면
    ex): val textInitialized: Boolean
        get() = this::text.isInitialized
    이런식으로 사용이 가능하다.

 */

class LateInit {

    val textInitialized: Boolean
        get() = this::text.isInitialized

    lateinit var text: String // 아직 초기화전이지만 컴파일 오류 X

    fun printText() {
        println(text)
    }
}

fun main() {
    val test = LateInit()
    if (!test.textInitialized){
        test.text = "하이요"
    }
    test.printText()
}