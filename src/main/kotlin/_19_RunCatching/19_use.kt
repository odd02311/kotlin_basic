package _19_RunCatching

import java.io.FileWriter

fun main() {
    FileWriter("test.txt").use {
        it.write("Hello Kotlin")
    }
}