package ch.mare.kotlin.extensionfunctions


internal fun String.hatch(): String {
    return "hatch $this hatch"
}

fun main(args: Array<String>) {
    val s = "hello"
    println(s.hatch())
}