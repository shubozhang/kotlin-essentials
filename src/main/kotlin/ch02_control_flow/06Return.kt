package ch02_control_flow

fun main() {
    testRegular()

    testExplicitReturnLabel()

    testImplicitReturnLabel()

    testAnonymousFun()
}

fun testRegular() {
    listOf(1, 2, 3, 4, 5)
        .forEach {
            if (it == 3) return // non-local return directly to the caller of testRegular()
        }
    println("this point is unreachable")
}


fun testExplicitReturnLabel() {
    listOf(1, 2, 3, 4, 5)
        .forEach lit@{
            if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop print(it)
        }
    print(" done with explicit label")
}

fun testImplicitReturnLabel() {
    listOf(1, 2, 3, 4, 5)
        .forEach {
            if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
            print(it)
        }
    print(" done with implicit label")
}


fun testAnonymousFun() {
    listOf(1, 2, 3, 4, 5)
        .forEach(fun(value: Int) {
            if (value == 3) return // local return to the caller of the anonymous fun, i.e. the forEach loop
        })
    print(" done with anonymous function")

}
