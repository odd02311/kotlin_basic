package _18_scope_function

/*
    run 과의 차이점, run let with 같은 경우에는 코드의 마지막이 그 함수 블록의 마지막이 반환 타입이 되었다
    apply 같은 경우에는 결과값으로 아래 예제에선 데이터베이스의 리퍼런스가 출력되는걸 볼 수 있다.
    apply의 용도는 컨텍스 객체에 대한 내부, 즉 프로퍼티를 초기화를 해준다던지 수정을 한다던지 그런 상황에서
    적용을 할때 사용한다.

 */


fun main() {

    val client: DatabaseClient =  DatabaseClient().apply{ // this를 자동으로 해주기때문에 생략 가능
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }

    val connected = client.connect()
    println(connected) // == client.connect().run { println(this) }
//    println(client) // 결과값으로 데이터베이스의 리퍼런스가 출력됨

    // 또한 체이닝 형태로도 사용이 가능하다.
    DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }.connect()
        .run { println(this) } // 좋은 방법은 아니다.
}