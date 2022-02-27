package ch03_class


/*
 1. Kotlin does not have new keyword

 2. only primary constructor declare val or var, they are not allowed in
 secondary constructor

 3. Parameters in Kotlin are always immutable. Marking a constructor parameter
 as a val turns it into a property of a class, and this can only be done in the
 primary constructor, because the set of properties of a class cannot vary
 depending on the constructor used to create an instance of the class.

 4. If a non-abstract class does not declare any constructors (primary or secondary),
 it will have a generated public primary constructor with no arguments.

 5. If you do not want your class to have a public constructor, you need to declare an empty primary
 constructor with non-default visibility: class DontCreateMe private constructor () { /*...*/ }
*/


fun main() {

    val emp = Employee1("John")
    println(emp.firstName)

    val emp6 = Employee6("Annaa", false)
    println(emp6.firstName)
    println(emp6.fullTime)

    val emp7 = Employee7("Elsa")
    val emp71 = Employee7("Olaf", false)
    println(emp7.toString())
    println(emp71.toString())

    InitOrderDemo("hello")
}


// 1. long  way to create a class with primary constructor
// 1) primary constructor cannot contain code, so init block is doing the logic
class Employee1 constructor(firstName: String) {
    val firstName: String

    // initializer blocks
    init {
        this.firstName = firstName
    }

}

// 2. without init block
class Employee2 constructor(firstName: String) {
    val firstName: String = firstName
}

// 3. concise way
class Employee3 constructor(val firstName: String) {
}


// 4. more concise way without constructor keyword
class Employee4(val firstName: String) {
}

// 5. default access modifier is public
class Employee5 private constructor(val firstName: String) {

}


// 6. constructor with default value
class Employee6(val firstName: String) {
    var fullTime: Boolean = true

    // 1) only primary constructor declare val or var, they are not allowed in
    // secondary constructor
    // 2) this refers to primary constructor
    constructor(firstName: String, fullTime: Boolean) : this(firstName) {
        this.fullTime = fullTime
    }

    override fun toString(): String {
        return "Employee6(firstName='$firstName', fullTime=$fullTime)"
    }


}

// 7. concise  way: constructor with default value
class Employee7(private val firstName: String, private var fullTime: Boolean = true) {

    override fun toString(): String {
        return "Employee7(firstName='$firstName', fullTime=$fullTime)"
    }
}

// 8. Note that code in initializer blocks effectively becomes part of the
// primary constructor.
// Even if the class has no primary constructor, the delegation still happens
// implicitly, and the initializer blocks are still executed.
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}
