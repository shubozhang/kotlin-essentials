package ch03_class


/*
1. Nested class: all combinations of classes and interfaces are possible:
- You can nest interfaces in classes, classes in interfaces, and interfaces in interfaces.

2. Inner class: A nested class marked as inner can access the members of its outer class. Inner classes carry a
reference to an object of an outer class.

3. Anonymous inner class instances are created using an object expression
*/
fun main() {

    val innerClassDemo = InnerDemo().Inner().foo()
    println(innerClassDemo)
}

// 1. Nested class examples
interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}


// 2. Inner class demo
class InnerDemo {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}


// 3. Anonymous inner classes
