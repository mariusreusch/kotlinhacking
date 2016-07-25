package ch.mare.kotlin.`when`

fun main(args: Array<String>) {
    val mode = 9
    when (mode) {
        1 -> println("ads")
        2 * 2 -> println("ads2")
        "Hatch".length -> println("hatch")
        in 1 .. 10 -> println("between")
        else -> println("3")
    }
}