package ch01_datatype_null

fun main() {
    var str = "not empty"

    var res = if ( str != "") {
        print(str)
    } else {
        print("true")
    }


    var result = if ( str != "") {
        "zhang"
    } else {
        "li"
    }

    println(res)

    when (result) {
        "value" -> print("value")
        "zhang"-> println("result is string")
        else -> println("result is a string")
    }
}