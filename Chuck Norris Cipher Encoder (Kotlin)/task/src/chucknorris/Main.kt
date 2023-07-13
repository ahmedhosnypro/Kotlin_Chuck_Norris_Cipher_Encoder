package chucknorris

fun main() {
    var operation: String
    while (true) {
        println("Please input operation (encode/decode/exit):")
        operation = readln()
        when (operation) {
            "encode" -> runOperation("Input string:", "Encoded string:", ::encode)
            "decode" -> runOperation("Input encoded string:", "Decoded string:", ::decode)
            "exit" -> {
                println("Bye!")
                break
            }

            else -> println("There is no '$operation' operation")
        }
    }
}

fun runOperation(inputMessage: String, resHeader: String, operationFunction: (String) -> String?) {
    println(inputMessage).apply {
        operationFunction(readln()).let { println(if (it == null) "Input is not valid." else "$resHeader:\n$it") }
    }
}

fun encode(message: String): String {
    val encodedMessage = StringBuilder()
    var seqChar = ' '
    message.toCharArray().forEach { ch ->
        ch.code.toString(2).padStart(7, '0').toCharArray().onEach {
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

fun decode(encodeMessage: String): String? {
    if (Regex("""[^01 ]""").containsMatchIn(encodeMessage)) return null
    val decodedMessage = StringBuilder()
    var seqChar = ' '
    encodeMessage.split(" ").apply {
        if (this.size % 2 != 0) return null
    }.forEachIndexed { index, s ->
        if (index % 2 == 0) {
            seqChar = if (s == "00") '0' else if (s == "0") '1' else return null
        } else {
            decodedMessage.append(seqChar.toString().repeat(s.length))
        }
    }

    return decodedMessage.apply {
        if (this.length % 7 != 0) return null
    }.chunked(7).map { it.toInt(2).toChar() }.joinToString("")
}