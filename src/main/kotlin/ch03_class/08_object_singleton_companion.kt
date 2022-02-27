package ch03_class

import java.time.Year

// object keyword
// 1. singleton class
// 2. companion object:
//      1) no static keyword in kotlin
//      2) companion object is used to access a public property without creating an instance
//      3) only one companion object allowed in one class
// 3. object expression: anonymous object

fun main() {
    // 1. singleton
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyRightLine())

    // 2. companion
    // Need to create an instance to access its public property
    val obj = SomeClass1()
    obj.accessPrivateVar()

    // companion object: companion keyword can be omitted.
    SomeClass2.accessPrivateVar()

    val someClass3One = SomeClass3.getFirstConst("this should be lower case string")
    val someClass3Two = SomeClass3.getSecondConst("this should be upper case string", false)
    println(someClass3One.someString)
    println(someClass3Two.someString)


    var mutableNum = 1
    // 3. object expression
    //      1) this object instance is not singleton
    //      2) object expression can access local variable
    //      3) object expression is able to implement multiple interfaces
    setEastConfig(object: Config{
        override fun setResource(num: Int): String = "setResource fun: ${num * 25}"
    })
    setWestConfig(object: Config{
        override fun setResource(num: Int): String {
            mutableNum++
            return "setResource fun: ${num * 25}"
        }
    })
    println(mutableNum)

}

// 1. create a singleton class
object CompanyCommunications {
    private val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks !"
    fun getCopyRightLine() = "Copyright \u00A9 $currentYear Our company, All rights reserved."
 }

// 2. companion object example
// 1) regular class
class SomeClass1 {
    private val privateVar = 6

    fun accessPrivateVar() {
        println("Accessing private var $privateVar")
    }
}

// 2) class with companion object
class SomeClass2 {
    val someString: String
    constructor(str: String) {
        someString = str
    }

    constructor(str: String, lowerCase: Boolean) {
        someString = if (lowerCase) str.toLowerCase() else str.toUpperCase()
    }
    // like static property in Java
    companion object {
        private const val privateVar = 6
        fun accessPrivateVar() {
            println("Accessing private var $privateVar from companion object")
        }
    }
}

// 3) companion implements constructor
//      a). implement constructor inside companion object
//      b). make it private constructor that SomeClass3 can only be instantiated via companion object, like factory pattern
class SomeClass3 private constructor(val someString: String) {
    companion object MyCompanion{
        private const val privateVar = 6
        fun accessPrivateVar() {
            println("Accessing private var $privateVar from companion object")
        }

        fun getFirstConst(str: String) = SomeClass3(str)
        fun getSecondConst(str: String, lowerCase: Boolean): SomeClass3 =
            if (lowerCase) SomeClass3(str.toLowerCase()) else SomeClass3(str.toUpperCase())
    }
}


// 3. object expression example
interface Config {
    fun setResource(num: Int): String
}
fun setEastConfig(iConfig: Config) = println("printing from setEastConfig with 10 times ${iConfig.setResource(10)}")
fun setWestConfig(iConfig: Config) = println("printing from setWestConfig with 100 times ${iConfig.setResource(100)}")
