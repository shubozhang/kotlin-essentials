# 01 Data Types

### Contents
1. [Numbers](#1-numbers)
2. [Characters](#2-characters)
3. [Booleans](#3-booleans)
4. [Array](#4-arrays)
5. [Unsigned integers](#5-unsigned-integers)
6. [Strings](#6-strings)




### 1. Numbers
* Numbers

    | Type  | Size(bits)| Min value| Max value|
    |---|---|---|---|
    | Byte  | 8 | -128| 127|
    | Short | 16| -32768| 32767|
    | Int   | 32| -2^31| 2^31 - 1|
    | Long  | 64| -2^63| 2^63 - 1|
    | Float | 32| | |
    | Double| 64| | |
    ```
    val oneByte: Byte = 1
    val oneShort: Short = 10
    val one = 1 // int
    val threeBillion = 3_000_000_000 // Long
    val oneLong = 1L // Long
    
    val pi = 3.14 // Double
    val e = 2.7182818284 // Double
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817
    
    val hexadecimals = 0x0F
    val binaries =  0b00001011
    ```
    * Boxing of numbers does not preserve identity, but equality.
        ```
        val a: Int = 10000
        println(a == a) // Prints 'true'
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
        println(boxedA == anotherBoxedA) // Prints 'true'
        ```
    * Smaller types are NOT implicitly converted to bigger types.
    * Every number type supports the following conversions:
        * `toByte()`: Byte
        * `toShort()`: Short 
        * `toInt()`: Int
        * `toLong()`: Long
        * `toFloat()`: Float
        * `toDouble()`: Double
        * `toChar()`: Char
    * Complete list of bitwise operations (available for Int and Long only):
        * `shl(bits)` – signed shift left
        * `shr(bits)` – signed shift right
        * `ushr(bits)` – unsigned shift right
        * `and(bits)` – bitwise and
        * `or(bits)` – bitwise or
        * `xor(bits)` – bitwise xor
        * `inv()` – bitwise inversion
        
    # TODO
    * Floating point numbers comparison
**[⬆ Back to top](#contents)**
        
### 2. Characters
* Characters are represented by the type Char . 
* They can not be treated directly as numbers. `toInt()` is used to do explicit conversions to numbers.
* Character literals go in single quotes: '1'.


**[⬆ Back to top](#contents)**

### 3. Booleans
* The type Boolean represents booleans, and has two values: true and false. 
* Booleans are boxed if a nullable reference is needed.
* Built-in operations on booleans include
    * `||` – lazy disjunction
    * `&&` – lazy conjunction
    * `!`   -negation

**[⬆ Back to top](#contents)**

### 4. Array
* `arrayOf(T)`
* `arrayOfNulls(int)`
* `IntArray(int)`
* `ShortArray(int)`
* `ByteArray(int)`

```
// Creates an Array<String> with values ["0", "1", "4", "9", "16"]
val asc = Array(5) { i -> (i * i).toString() } asc.forEach { println(it) }

 val x: IntArray = intArrayOf(1, 2, 3) x[0] = x[1] + x[2]
// Array of int of size 5 with values [0, 0, 0, 0, 0]
val arr = IntArray(5)
// e.g. initialise the values in the array with a constant // Array of int of size 5 with values [42, 42, 42, 42, 42] val arr = IntArray(5) { 42 }
// e.g. initialise the values in the array using a lambda
// Array of int of size 5 with values [0, 1, 2, 3, 4] (values initialised to their index value)
var arr = IntArray(5) { it * 1 }

```

**[⬆ Back to top](#contents)**


### 5. Unsigned Integers (since 1.3, currently experimental)

**[⬆ Back to top](#contents)**


### 6. Strings
* Immutable
* Can be access via : `s[i]`
* Can be iterate via for-loop


* for-loop
    ```
    for ( c in str) {
        println(c)
    }
    ```

* Use `+` for concatenate:
    ```
    println("abc" + 3) // abc3. The first element must be string.
    ```

* Raw string
    ```
    val text = """
    for (c in "foo")
    print(c) """
    ```

* escaped strings
    ```
    val s = "Hello, world!\n"
    ```
* String templates
    ```
    val i = 10
    println("i = $i") // prints "i = 10"
     
    val s = "abc"
    println("$s.length is ${s.length}") // prints "abc.length is 3"
    
    val price = """ 
    ${'$'}9.99
    """
    ```



**[⬆ Back to top](#contents)**


### Variables
* Kotlin uses type inference at compile time. So variable can be either assigning a value or declare a type.
    ```kotlin
    var age: Int 
    ```
    
    ```kotlin
    var age = 10
    ```

* var vs val
    * val is immutable, like final in Java.
    * var is mutable. Recommended in Kotlin. Unlike Java that prefers to use final.
    
    
    
### keywords
* hard keywords
* soft keywords


### Kotlin vs Java
* Kotlin does not have conditional operator `?` operation, you may use `if else`. 
    * In Kotlin, `?` (safety operator) is used to
    * `employee?.address?.country ?: "US"` // set default country = "US"
    * Elvis operator `?:` . It receives two inputs and returns the first argument if it is non-null or the second one otherwise.
check null.
* Kotlin has no `static` keyword in syntax, but still has the concept on variable and function
* Kotlin has no `new` keyword.
* In Java, `==` checks if both objects point to the same memory location. `.equals()` method for content comparison.
* In Kotlin, `==` (`!=`) and `.equals()` are used to compare content. `===` (`!==`) is used for reference comparison.
* In Kotlin, some symbol operators are replaced by `or`, `and`, `xor`, etc.
* In kotlin, `is` (`!is`) replaces `instance of`
* casting
    * Java: `(Employee) obj`
    * Kotlin: `obj as Employee`. Safety cast `str as? String`
* In Kotlin: String template
    * `Employee name is $name and id is $id` . Note, to print out $change, `\$change`.   
    * `the factor is ${numerator/denominator}`
    * `Employee is is ${employee.id}`
* Raw Strings: `""" this is a windows path: C:/Users/john"""` when you don't want to use escape. String
template can be used in raw string.
* REPL

