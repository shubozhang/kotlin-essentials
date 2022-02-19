package ch02_control_flow

fun main(){

    testWhile()

    testDoWhile()
}

fun testWhile(){
    var x = 100
    while (x > 0) {
        x--
    }
}

fun testDoWhile(){
    do {
        var x = 100
        println("x is $x")
        x--
    } while (x > 0)
}
