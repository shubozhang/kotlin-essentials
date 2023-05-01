package ch03_class

/*
* 1. interface is extendable by default, no open key word needed.
* 2. There is no backing field in interface
* 3. Interface can contain method implementations.
* 4. An interface with only one abstract method is called a functional interface,
* or a Single Abstract Method (SAM) interface. It can contain multiple non-abstract members.
* */

interface MyInterface {
    // abstract
    val num: Int

    // num2 is a concrete property that has default value 25, so subclass does not require to override it.
    // no backing field in interface
    val numWithImplementation: Int
        get() = 25

    fun myFun(str: String): String

    fun foo() {
        println(num)
    }
}

interface MySubInterface : MyInterface {

    fun mySubFun(num: Int): String
}

// functional (SAM) interface
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

class App(model: String, override val num: Int) : MySubInterface, Printer(model) {


    override fun mySubFun(num: Int): String {
        TODO("Not yet implemented")
    }

    override fun myFun(str: String): String {
        TODO("Not yet implemented")
    }

    override fun bestSellingPrice(): Double {
        TODO("Not yet implemented")
    }


    // Creating an instance of a class
    val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    // Creating an instance using lambda
    val isEvenLambda = IntPredicate { it % 2 == 0 }
}
