package ch.mare.kotlin.nullchecks

fun strLen(s: String): Int = s.length


fun main(args: Array<String>) {
    //try with null as parameter and with null!!
    strLen("")


//    var s: String? = ""
//
//    if (s != null) {
//        strLen(s)
//    }
//
//    s?.let { println(strLen(it)) }
}





