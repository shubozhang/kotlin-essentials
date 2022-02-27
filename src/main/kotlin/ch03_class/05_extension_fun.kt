package ch03_class

/*
* Extension fun lets you to extend any class you want to extend.
* */

// Add a help fun to String class in a illusion way. IDE is able to provide it as String method suggestion.
fun String.upperFirstAndLast(): String {
    return substring(0,1).toUpperCase() +
            substring(1, length - 1) +
            substring(lastIndex).toUpperCase()
}

fun main() {
    println("krissdoff".upperFirstAndLast())
}
