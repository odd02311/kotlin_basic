package _19_RunCatching

/*

    고급 예외처리
    코틀린은 try catch를 통한 예외 처리 외에도 함수형 스타일의 result 패턴을 구현한
    run catching을 제공한다.
    그래서 result 패턴이란 함수가 성공하면 캡슐화된 결과를 반환하거나 예외가 발생하면 지정한 작업을 수행하는 패턴을 일컫는다.
    run catching을 사용하면 함수형 스타일의 코드로서 성공, 실패에 대한 처리를 미리 지정해서 처리할 수 있다.

 */

fun getStr(): Nothing = throw Exception("예외 발생 기본 값")

//// 기존 try catch
//fun main() { // getStr은 항상 exception을 반환
//
//    val result = try {
//        getStr()
//    }catch (e: Exception){
//        println(e.message)
//        "기본값"
//    }
//
//    println(result)
//}

// run catching 방식
fun main() {

//    val result = runCatching {
//        getStr()
//    }.getOrElse { // exception이 발생 했을시
//            println(it.message)
//            "기본값"
//        }
//
//    println(result)

    // run catching에서 제공하는 다른 함수들
//    val result = runCatching {
//        getStr() }
////        .getOrNull()   // 성공인 경우에는 값을 반환, 예외가 발생한 경우에는 NULL
//        .exceptionOrNull() // 성공인 경우에는 NULL, 예외가 발생하면 throwable을 반환
//
//    result?.let{
//        println(it.message)
//        throw it
//    }

//    val result = runCatching {
//        getStr()
//    }.getOrDefault("기본 값") // 성공한 경우 값을 반환, 실패한 경우에는 함수 내에서 지정한 default 값이 반환됨
//    println(result)

//    val result = runCatching {
//        getStr()
//    }.getOrElse {  // 성공했을 시 runcatching 값을 받고, 실패했을 시 수신자 객체로서 it으로 throwable을 받고 함수 끝에 있는 결과를 반환
//        println(it.message)
//        "기본 값"
//    }

//    val result = runCatching { "성공" }
//        .getOrThrow() // 성공 시에는 값을 반환하고, 실패 시에는 예외를 발생시킨다

//    val result: String = runCatching { "안녕" }
//        .map { // map 함수를 사용하게 되면 기존에 runCatching에서 수행됐던 코드가 성공인 경우 map에서 it으로 참조 할 수 있고
//            "${it}하세요" // 그 상태에서 새로운 값으로 변경 할 수 있게 된다. :안녕이 아닌 안녕을 기반으로 한 안녕하세요가 출력
//        }.getOrThrow()
//
//    val result = runCatching { "안녕" }
//        .mapCatching {
//            throw Exception("예외")
//        }.getOrDefault("기본 값") // 예외가 발생하면 기본값이 반환되지만 이 코드에선 "예외"가 출력됐다. (map)
//    // 하지만 mapCatching을 사용하게 된다면, exception이 내외에서 발생한다 하더라도 기본값이 출력된다.

    // recover
    val result = runCatching { getStr() }
        .recover { "복구" } // 성공시에는 runCatching 값이 반환, 실패시에는 recover 블럭안의 내용을 반환
        .getOrNull() // 예외가 recover 블럭안에서 발생하면 recover catching을 사용하면 된다.

    println(result)
    
    
}