package ch02_control_flow

fun main(){

    testIf()

    testIfElse()

    testExpression()

    testBlock()
}

fun testIf(){
    val a = 10
    val b = 20
    var max = a


    if(a < b) max = b

    println("max is $max")
}


fun testIfElse(){
    val a = 10
    val b = 20
    var max = a

    if(a > b) {
        max = a
    } else {
        max = b
    }

    println("max is $max")
}

// Replace ternary operator (condition ? then : else)
fun testExpression(){
    val a = 10
    val b = 20
    val max = if(a > b) a else b

    println("max is $max")
}

fun testBlock(){
    val a = 10
    val b = 20

    val max = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }

    println("max is $max")
}
