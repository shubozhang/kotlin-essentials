package bryan.ch_collections

// immutable by default
// vararg support 0 to many args
// named args
// default args

fun main() {

    testArray()

    testList()

    testMap()

    testMutableMap()

    testVararg("hi")
    testVararg("hi", "kotlin", "groovy")
    val args = arrayOf("quarkus", "java")
    testVararg("hi", *args)

    testNamedArg(name = "Br", greeting = "hi")

    testDefaultArg(fname = "Celop")
}

fun testArray() {
    // immutable return a read-only array
    val arr = arrayOf("kotlin", "programming", "comic books")
    println(arr.size)

    // `it` is the default name of collection element
    arr.forEach { println(it) }

    arr.forEachIndexed {index, it -> println("$it is the $index")}
}

fun testList() {
    // immutable return a read-only list
    val l = listOf("groovy", "sc", "na")
    l.forEach { println(it)}
}

fun testMap(){
    // immutable
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { (key, value) -> println("$key -> $value") }
}

fun testMutableMap() {
    val map = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    map["d"] = 4
    map.forEach {(key, value) -> println("$key -> $value")}
}


fun testVararg(greeting: String, vararg items: String) {
    items.forEach { println("$greeting $it") }
}

fun testNamedArg(greeting: String, name: String) {
    println("$greeting $name")
}

fun testDefaultArg(greeting: String = "hello", fname: String="io") {
    println("$greeting $fname")
}