package chucknorris

fun main() {
    println("Input string:\n")

    val encryptedMessage = StringBuilder()
    var seqChar = ' '

    readln().apply {
        println("The result:")
    }.toCharArray().forEach { ch ->
        ch.code
            .toString(2)
            .padStart(7, '0')
            .toCharArray()
            .onEach {
                if (it == seqChar) {
                    encryptedMessage.append("0")
                } else {
                    seqChar = it
                    encryptedMessage.append(" ${if (it == '1') "0 " else "00 "}0")
                }
            }
    }

    print(encryptedMessage.toString().trim())
}
