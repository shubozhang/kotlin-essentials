package ch03_class


/*
* Sealed classes represent restricted class hierarchies that provide more control over inheritance. All subclasses of
* a sealed class are known at compile time. No other subclasses may appear after a module with the sealed class is
* compiled. For example, third-party clients can't extend your sealed class in their code. Thus, each instance of
* a sealed class has a type from a limited set that is known when this class is compiled.
* */
fun main(){

}
