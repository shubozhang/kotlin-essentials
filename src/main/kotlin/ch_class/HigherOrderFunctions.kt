package ch_class

/*
* Higher order functions: either return a func or  take funcs as parameters.
* */

fun printFilteredString(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if (predicate(it)) {
            println(it)
        } else {
            println("false")
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("k")
}

fun getPrintPredicate(): (String) -> Boolean {
    return {it.startsWith("j")}
}
fun main() {
    val list = listOf("kotlin", "java", "c++")
    printFilteredString(list, predicate)

    printFilteredString(list, getPrintPredicate())

    list.filterNotNull()
        .associate { it to it.length }
        .forEach { println("${it.value}, ${it.key}")}
}