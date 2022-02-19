package ch01_datatype

fun main() {
    loopStr()

    concateStr()

    literalsStr1()

    literalsStr2()

    strTemplates()
}

fun loopStr() {
    val str = "abcd"
    for (c in str) {
        println(c)
    }
}

fun concateStr() {
    val s = "abc" + 1
    println(s + "def")
}


fun literalsStr1() {
    val s = "Hello, world!\n"
    println("my literals is $s")
}

fun literalsStr2() {
    val text = """
                for (c in "foo")
                print(c) 
                """
    println("my literals text is $text")


    val text2 = """
                |Tell me and I forget.  
                |Teach me and I remember. 
                |Involve me and I learn. 
                |(Benjamin Franklin) """.trimMargin()

    println("my text2 is $text2")
}


fun strTemplates(){
    val s = "abc"
    println("$s.length is ${s.length}")
}
