package ch03_class

/*
Classes, objects, interfaces, constructors, functions, properties and their setters can have visibility modifiers.
There are four visibility modifiers in Kotlin:

1. Functions, properties and classes, objects and interfaces can be declared on the "top-level", i.e. directly inside a package:
1) private: it will only be visible inside the 􏰀le containing the declaration
2) protected: is not available for top-level declarations
3) internal: it is visible everywhere in the same module;
4) public (default)

2. Classes and Interfaces: for members declared inside a class:
1) private: means visible inside this class only (including all its members);
2) protected: same as private + visible in subclasses too;
3) internal: any client inside this module who sees the declaring class sees its internal members;
4) public: any client who sees the declaring class sees its public members.

3. Note that in Kotlin, outer class does not see private members of its inner classes.
4. By default, all constructors are public
5. Local declarations: Local variables, functions and classes can not have visibility modifiers.
*/

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 // public by default

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible // Nested and e are visible
    override val b = 5 // 'b' is protected
}

class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}
