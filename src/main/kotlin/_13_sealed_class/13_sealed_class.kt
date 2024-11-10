package _13_sealed_class

import javax.print.attribute.standard.MediaSize.Other

/*
  sealed class는 하나의 상위 클래스 또는 인터페이스에서 하위 클래스에 대한 정의를 제한할 수 있는 방법이다.

  아래의 예제에서 when(developer) 형식을 쓸때 else가 없다면 컴파일 오류가 난다.
  이때 sealed class Developer로 변경을 하게 되면 컴파일 오류가 사라진다.

  코틀린 1.6 버전 기준으로는 sealed 클래스의 하위 클래스들은 이제 같은 패키지 또는 같은 모듈 안에 있는 경우에만
  하위 클래스를 정의할 수가 있다.



 */

sealed class Developer {

    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {

  override fun code(language: String) {
    println("저는 백엔드 개발자입니다. ${language}를 사용합니다.")
  }
}

data class FrontendDeveloper(override val name: String) : Developer() {

  override fun code(language: String) {
    println("저는 프론트엔드 개발자입니다. ${language}를 사용합니다.")
  }
}

object OtherDeveloper : Developer() {

  override val name: String = "익명"
    

  override fun code(language: String) {
    TODO("Not yet implemented")
  }
}

data class AndroidDeveloper(override val name: String) : Developer() {

  override fun code(language: String) {
    println("저는 안드로이드 개발자입니다. ${language}를 사용합니다.")
  }
}


// 싱글톤 객체
// 목적: 생성된 developer 객체를 보관하거나 꺼내 쓸 수 있는
object DeveloperPool {
  val pool = mutableMapOf<String, Developer>()

  fun add(developer: Developer) = when(developer) {
    is BackendDeveloper -> pool[developer.name] = developer
    is FrontendDeveloper -> pool[developer.name] = developer
    is AndroidDeveloper -> pool[developer.name] = developer
    is OtherDeveloper-> println("지원하지않는 개발자 종류입니다.")
  }

  fun get(name: String) = pool[name]
}

fun main() {
  val backendDeveloper = BackendDeveloper("토니")
  DeveloperPool.add(backendDeveloper)
  
  val frontendDeveloper = FrontendDeveloper("키리")
  DeveloperPool.add(frontendDeveloper)
  
  val androidDeveloper = AndroidDeveloper("안드로")
  DeveloperPool.add(androidDeveloper)

  println(DeveloperPool.get("토니"))
  println(DeveloperPool.get("키리"))
  println(DeveloperPool.get("안드로"))
}