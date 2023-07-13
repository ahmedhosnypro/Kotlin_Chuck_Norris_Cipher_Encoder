package chucknorris

fun main() {

    println("Input string:\n")
    readln().apply {
        println("The result:")
    }.let { decode(it) }.let(::println)
}


fun encode(message: String): String {
    val encodedMessage = StringBuilder()
    var seqChar = ' '
    message.toCharArray().forEach { ch ->
        ch.code.toString(2).padStart(7, '0')
            .toCharArray().onEach {
                if (it == seqChar) {
                    encodedMessage.append("0")
                } else {
                    seqChar = it
                    encodedMessage.append(" ${if (it == '1') "0 " else "00 "}0")
                }
            }
    }
    return encodedMessage.toString().trim()
}

fun decode(encodeMessage: String): String {
    val decodedMessage = StringBuilder()
    var seqChar = ' '
    encodeMessage.split(" ").forEachIndexed() { index, s ->
        if (index % 2 == 0) {
            seqChar = if (s == "00") '0' else '1'
        } else {
            decodedMessage.append(seqChar.toString().repeat(s.length))
        }
    }

    return decodedMessage.chunked(7).map { it.toInt(2).toChar() }.joinToString("")
}