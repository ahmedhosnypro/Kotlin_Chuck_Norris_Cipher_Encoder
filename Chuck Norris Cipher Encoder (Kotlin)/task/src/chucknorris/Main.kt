package chucknorris

fun main() {
    println("Input string:\n")
    readln()
        .apply {
            println("The result:")
        }
        .toCharArray()
        .forEach {
            println("$it = ${it.code.toString(2).padStart(7, '0')}")
        }
}
