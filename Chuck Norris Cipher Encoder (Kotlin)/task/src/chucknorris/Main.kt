package chucknorris

fun main() {
    val stringBuilder = StringBuilder()
    var seqChar = "-1"
    println("Input string:\n")
    readln().apply {
        println("The result:")
    }.toCharArray().forEach { ch ->
        ch.code.toString(2).padStart(7, '0')
            .toCharArray().onEach {
                if (it == '0') {
                    if (seqChar == "0") {
                        stringBuilder.append("0")
                    } else {
                        stringBuilder.append(" 00 0")
                        seqChar = "0"
                    }
                } else {
                    if (seqChar == "1") {
                        stringBuilder.append("0")
                    } else {
                        stringBuilder.append(" 0 0")
                        seqChar = "1"
                    }
                }
            }
    }

    print(stringBuilder.toString().trim())
}
