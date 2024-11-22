package _18_scope_function


class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null
    
    // DB에 접속하고 Boolean 결과를 반환
    fun connect(): Boolean {
        println("DB 접속 중...")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }
}

fun main() {

//    val config = DatabaseClient()
//    config.url = "localhost:3306"
//    config.username = "mysql"
//    config.password = "1234"
//    val connected = config.connect()
    
    // run 스코프 함수 사용
    // run도 마지막 코드를 return한다
    val connected: Boolean =  DatabaseClient().run{ // this를 자동으로 해주기때문에 생략 가능
        this.url = "localhost:3306"
        this.username = "mysql"
        this.password = "1234"
        connect() // 반환
    }

    println(connected)

    val result: Boolean = with(DatabaseClient()) {
        this.url = "localhost:3306"
        this.username = "mysql"
        this.password = "1234"
        connect() // 반환
    }

}