package chucknorris

fun main() {
    println("Input string:")
    println(readln().chunked(1).joinToString(" "))
}