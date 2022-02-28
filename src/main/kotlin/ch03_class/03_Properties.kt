package ch03_class


/*
* Declaring Properties:
* 1) var: mutable
* 2) val: immutable and read-only
*
* The full syntax for declaring a property is
        var <propertyName>[: <PropertyType>] [= <property_initializer>]
                                                [<getter>]
                                                [<setter>]
        The initializer, getter and setter are optional. Property type is optional if it can be inferred from the
        initializer (or from the getter return type)


* 1. The private property in kotlin cannot use get/set directly like Java (private field, but public get/set). Its get/set has the
* same visibility which is private.
*
* 2. Backing field
*     // 1) wrong way in kotlin
*     class Sample {
        var counter = 0
        set(value) {
            if (value >= 0) this.counter = value // this means setCounter
        }
    }

*   // equivalent in java
    * class Sample {
        private int counter = 0;
        public void setCounter(int value) {
            if (value >= 0) setCounter(value); // infinite loop
        }
        public int getCounter() {
            return counter;
        }
    }
    * Java has fields while Kotlin has properties, which is a rather higher level concept than fields. There are
    * two types of properties: one with a backing field, one without.

    A property with a backing field will store the value in the form of a field. That field makes storing value in memory possible.
    * An example of such property is the first and second properties of Pair. That property will change the in-memory representation
    * of Pair.

    A property without a backing field will have to store their value in other ways than directly storing it in memory.
    * It must be computed from other properties, or, the object itself. An example of such property is the indices
    * extension property of List, which is not backed by a field, but a computed result based on size property.
    * So it won't change the in-memory representation of List (which it can't do at all because Java is statically typed).
* */
fun main() {
    val d = Demo("John")
    println(d.toString())

    val d33 = Demo3("Anna")
    println(d33.toString())

    val d3 = Demo3("Blili")
    println(d3.toString())
    d3.fullTime = false
    println(d3.toString())
}

class Demo (val firstName: String, var fullTime: Boolean = true) {

    override fun toString(): String {
        return "Demo(firstName='$firstName', fullTime=$fullTime)"
    }
}

/*
* private property can only be used inside class.
* */
class Demo1 (val firstName: String, private var fullTime: Boolean = true) {

    override fun toString(): String {
        return "Demo(firstName='$firstName', fullTime=$fullTime)"
    }
}

/*
* If customize get/set needed, field has to be used.
* */
class Demo3 (val firstName: String, fullTime: Boolean = true) {
    var fullTime = fullTime
    get() {
        println("running get")
        return field
    }
    set(value) {
        println("running set")
        field = value
    }

    override fun toString(): String {
        return "Demo3(firstName='$firstName', fullTime=$fullTime)"
    }


}
