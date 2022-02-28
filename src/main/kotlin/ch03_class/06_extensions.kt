package ch03_class

/*
Kotlin provides the ability to extend a class with new functionality without having to inherit from the class or
use design patterns such as Decorator. This is done via special declarations called extensions.

For example, you can write new functions for a class from a third-party library that you can't modify.
Such functions are available for calling in the usual way as if they were methods of the original class.
This mechanism is called extension functions. There are also extension properties that let you define new properties
for existing classes.
* */

fun main() {
    println("krissdoff".upperFirstAndLast())

    demo1()

    demo2()

    demoOverload()

    MyCompanionClass.printCompanion()

    Connection(Host("kotl.in"), 443).connect()

    // expected: error, the extension function is unavailable outside Connection
    // Host("kotl.in").printConnectionString(443)


    BaseCaller().call(Base()) // "Base extension function in BaseCaller"
    DerivedCaller().call(Base()) // "Base extension function in DerivedCaller" - dispatch receiver is resolved virtually
    DerivedCaller().call(Derived()) // "Base extension function in DerivedCaller" - extension receiver is resolved statically
}

// Add a help fun to String class in a illusion way. IDE is able to provide it as String method suggestion.
// 1. Extension functions
fun String.upperFirstAndLast(): String {
    return substring(0, 1).toUpperCase() +
            substring(1, length - 1) +
            substring(lastIndex).toUpperCase()
}

// 2. Extensions are resolved statically
fun demo1() {
    open class Shape
    class Rectangle : Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"
    fun printClassName(s: Shape) {
        println(s.getName())
    }
    printClassName(Rectangle())
}

/*
* If a class has a member function, and an extension function is de􏰀ned which has the same receiver type, the same name,
* and is applicable to given arguments, the member always wins.
* */
fun demo2() {
    class Example {
        fun printFunctionType() {
            println("Class method")
        }
    }

    fun Example.printFunctionType() {
        println("Extension function")
    }
    Example().printFunctionType()
}


fun demoOverload() {
    class Example {
        fun printFunctionType() {
            println("Class method")
        }
    }

    fun Example.printFunctionType(i: Int) {
        println("Extension function")
    }
    Example().printFunctionType(1)
}


// 3. Nullable receiver
fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}


// 4. Extension properties
/*
Similarly to functions, Kotlin supports extension properties:

val <T> List<T>.lastIndex: Int
    get() = size - 1

Note that, since extensions do not actually insert members into classes, there's no efficient way for an extension
property to have a backing field. This is why initializers are not allowed for extension properties.
Their behavior can only be defined by explicitly providing getters/setters.
Example:
val House.number = 1 // error: initializers are not allowed for extension properties
*/

// 5. Companion object extensions

class MyCompanionClass {
    companion object {} // will be called "Companion"
}

fun MyCompanionClass.Companion.printCompanion() {
    println("companion")
}

// 6. Declaring extensions as members
class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() {
        print(port)
    }

    fun Host.printConnectionString() {
        printHostname() // calls Host.printHostname()
        print(":")
        printPort() // calls Connection.printPort()
    }

    fun connect() { /*...*/
        host.printConnectionString()
    }
}

// Extensions declared as members can be declared as open and overridden in subclasses. This means that the dispatch of
// such functions is virtual with regard to the dispatch receiver type, but static with regard to the extension receiver type.
open class Base {}

class Derived : Base() {}

open class BaseCaller {
    open fun Base.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base) {
        b.printFunctionInfo() // call the
    }
}


class DerivedCaller : BaseCaller() {
    override fun Base.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}
