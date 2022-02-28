package ch03_class

/*
* Data class is a concise way to provide an immutable class.
* 1. Good candidate: if a class only has property and get/set
* 2. Data class will automatically generate equals(), hashCode(), copy(), and toString() for you.
* 3. Data class requires:
*   1) primary constructor at least has one parameter.
*   2) All parameters must declare var or val
*   3) Data class is not extendable and cannot be abstract, inner, or sealed classes.
*   4) You can declare extra properties other than primary constructor, but they won't be counted in
*      kotlin auto-generated equals(), hashCode(), and toString(), etc.
*
* copy() is a shallow copy, not deep copy. Also, copy list will only copy the reference. If one element is changed,
* the change will apply to both obj and copiedObj.
*
* Constants
* */


val MY_CONSTANT = 100

fun main(args: Array<String>) {
    println(MY_CONSTANT)

    // test toString()
    val car = Car("blue", "4runner", 2018 )
    println(car.toString())

    // test equals()
    val car1 = Car("blue", "4runner", 2018)
    val car2 = Car("black", "4runner", 2018)
    println(car == car1)
    println(car == car2)

    // test override equals(): ignore color property
    val hondaCar1 = HondaCar("red", "accord", 2020)
    val hondaCar2 = HondaCar("black", "accord", 2020)
    println(hondaCar1 == hondaCar1)


    val hondaCar3 = hondaCar1.copy()
    println(hondaCar3 == hondaCar1)

    val hondaCar4 = hondaCar1.copy(year = 2021)
    println(hondaCar4 == hondaCar1)
}

data class Car(val color: String, val model: String, val year: Int) {

}

data class HondaCar(val color: String, val model: String, val year: Int) {

    override fun equals(other: Any?): Boolean {
        val obj = other as HondaCar
        return model == obj.model && year == obj.year
    }
}

