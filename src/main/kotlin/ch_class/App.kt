package ch_class

fun main() {
    val p = Person("john", "doe")
    println("${p._lname} and ${p._fname}")

    p.nickName = "Joe"
    println(p.toString())

    p.printInfo()

    val p2 = Person()
    p2.printInfo()
}