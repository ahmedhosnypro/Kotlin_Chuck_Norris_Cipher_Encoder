package chucknorris

fun main() {
    val stringBuilder = StringBuilder()
    var seqChar = ' '
    println("Input string:\n")
    readln().apply {
        println("The result:")
    }.toCharArray().forEach { ch ->
        ch.code.toString(2).padStart(7, '0')
            .toCharArray().onEach {
                if (it == seqChar) {
                    stringBuilder.append("0")
                } else {
                    seqChar = it
                    stringBuilder.append(" ${if (it == '1') "0 " else "00 "}0")
                }
            }
    }

    print(stringBuilder.toString().trim())
}
