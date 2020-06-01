package ch_class

/*
* 1. interface is extendable by default, no open key word needed.
* 2. There is no backing field in interface
* */

interface MyInterface {
    val num: Int

    // num2 is a concrete property that has default value 25, so subclass does not require to override it.
    // no backing field in interface
    val num2: Int
    get() = 25

    fun myFun(str: String): String
}

interface  MySubInterface: MyInterface {

    fun mySubFun(num: Int): String
}

class App(model: String,     override val num: Int): MySubInterface, Printer(model) {


    override fun mySubFun(num: Int): String {
        TODO("Not yet implemented")
    }

    override fun myFun(str: String): String {
        TODO("Not yet implemented")
    }

    override fun bestSellingPrice(): Double {
        TODO("Not yet implemented")
    }

}