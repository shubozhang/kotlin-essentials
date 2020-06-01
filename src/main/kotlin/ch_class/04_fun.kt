package ch_class

/*
* 1. fun default return type is unit
* 2. vararg
*   1) you can only have one vararg
    2) non-vararg needs to use name parameter if it is declared before vararg
* 3. spread operator: unpack array
* * */

fun main() {

    println(labelMultiply(3, 4, "The result is"))
    println(labelMultiply(label = "The result is", operand2 = 3, operand1 = 4))

    println(labelMultiply2(4, 5, "The result is"))

    val emp = Employee("Greg")
    println(emp.upperCaseFirstName())

    val car1 = Car("blue", "model3", 2018)
    val car2 = Car("red", "model3", 2018)
    val car3 = Car("yellow", "model3", 2018)
    printColors("Tesla", car1, car2, car3, color = "color")

    // array cannot be directly passed to vararg, it needs spread operator
    val manyCars = arrayOf(car1, car2, car3)
    printColors1(*manyCars)


    // example: spread operator
    val twoCars = arrayOf(car2, car3)
    val car4 = car3.copy()
    val combineCars = arrayOf(*twoCars, car4)
    combineCars.forEach { println(it) }

}

// using block body
fun labelMultiply(operand1: Int, operand2: Int, label: String) : String {
    return ("$label ${operand1 * operand2}")
}

// using expression body
fun labelMultiply2(operand1: Int, operand2: Int, label: String) = "$label ${operand1 * operand2}"


class Employee(private val firstName: String) {

    fun upperCaseFirstName () = firstName.toUpperCase()
}


// you can only have one vararg
// non-vararg needs to use name parameter if it is declared before vararg 
// example, color needs to be name parameter, but model not.
fun printColors(model: String, vararg cars: Car, color: String) {
    for(car in cars){
        println(car.color)
    }
}
fun printColors1(vararg cars: Car) {
    for(car in cars){
        println(car.color)
    }
}