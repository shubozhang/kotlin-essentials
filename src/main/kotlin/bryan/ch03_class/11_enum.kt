package ch03_class

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main() {
    println(Department.IT.getDeptInfo())

    val a = 13
    val b = 31
    for (f in IntArithmetics.values()) {
        println("$f($a, $b) = ${f.apply(a, b)}")
    }


    printAllValues<RGB>() // prints RED, GREEN, BLUE
}


enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// Initialization
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


// anonymous class
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}


// Implementing Interfaces in Enum Classes
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}


// Working with Enum Constants
enum class RGB { RED, GREEN, BLUE }

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}



// semi-colon is required after the last enum member
enum class Department(val fullName: String, val numOfEmployees: Int) {
    HR("Human Resoures", 5),
    IT("Information technology", 100),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 50);


    fun getDeptInfo() = "Department full name is $fullName and number of employees is $numOfEmployees"
}
