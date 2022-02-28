package ch03_class

/*
* Everything in kotlin is public final by default.
*
* Any is the default superclass: equals(), hashCode(), and toString()
*
* Inheritance modifiers:
* 1. final is default, class is not extendable and fun is not overridable.
* 2. open modifier marks classes and methods as overridable. You need one per each method you want to be overridable
* 3. The abstract modifier tell us that a class is extendable (so open key word can be omitted) and has at least one
*    abstract method. An abstract method is a method that has no implementation.
*    1) You can’t create an instance of an abstract class.
*    2) The abstract method has to be marked also with the abstract modifier.
*    3) abstract methods are open by default and must be overridden.
* 4. override: Overridden members are open by default.
*    1) you can use final to declare fun as not overridable.
*
* 5. If the derived class has a primary constructor, the base class can (and must) be initialized right there, using
* the parameters of the primary constructor.

  6. If the derived class has no primary constructor, then each secondary constructor has to initialize the base
type using the super keyword, or to delegate to another constructor which does that.
* */

fun main() {
    val laserPrinter = LaserPrinter("brother", 15)
    laserPrinter.printModel()
    println(laserPrinter.bestSellingPrice())
}

// open key word is redundant
abstract class Printer(val model: String) {

    open fun printModel() = println("The model name is $model")

    abstract fun bestSellingPrice(): Double
}

// override funs are open by default.
// Use final to make it not overridable
open class LaserPrinter(model: String, ppm: Int): Printer(model) {
    final override fun printModel() = println("The laser printer model name is $model")
    override fun bestSellingPrice(): Double = 139.99
}

class SpecialLaserPrinter(model: String, ppm: Int): LaserPrinter(model, ppm) {

    override fun bestSellingPrice() = 99.99
}
