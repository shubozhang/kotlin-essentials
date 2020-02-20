package ch_class

class Person(val _fname: String, val _lname: String) {
    var nickName: String? = null
        set(value) {
            field = value
            println("setting value is $field")
        }
        get() {
            return field
        }

    init {
        println("1")
    }

    constructor(): this("peter", "chang") {
        println("secondary constructor")
    }

    init {
        println("2")
    }

    fun printInfo() {
        val nickNamePrint = nickName ?: "no nick name"
        println("$_fname ($nickNamePrint) $_lname")
    }

}