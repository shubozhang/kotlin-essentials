package ch_class


// 1. only primary constructor declare val or var, they are not allowed in secondary constructor
// Parameters in Kotlin are always immutable. Marking a constructor parameter as a val turns it into a property of a class,
// and this can only be done in the primary constructor, because the set of properties of a class cannot vary depending
// on the constructor used to create an instance of the class.


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
}


// 1. long  way to create a class with primary constructor
// 1) primary constructor cannot contain code, so init block is doing the logic
class Employee1 constructor(firstName: String){
    val firstName: String
    init {
        this.firstName = firstName
    }

}


// 2. without init block
class Employee2 constructor(firstName: String){
    val firstName: String = firstName
}

// 3. concise way
class Employee3 constructor(val firstName: String) {
}


// 4. more concise way without constructor keyword
class Employee4 (val firstName: String) {
}

// 5. default access modifier is public
class Employee5 private constructor(val firstName: String) {

}


// 6. constructor with default value
class Employee6 (val firstName: String) {
    var fullTime: Boolean = true
    // only primary constructor declare val or var, they are not allowed in secondary constructor
    constructor(firstName: String, fullTime: Boolean): this(firstName) {
        this.fullTime = fullTime
    }

    override fun toString(): String {
        return "Employee6(firstName='$firstName', fullTime=$fullTime)"
    }


}

// 7. concise  way: constructor with default value
class Employee7 (val firstName: String, var fullTime: Boolean = true) {

    override fun toString(): String {
        return "Employee7(firstName='$firstName', fullTime=$fullTime)"
    }
}