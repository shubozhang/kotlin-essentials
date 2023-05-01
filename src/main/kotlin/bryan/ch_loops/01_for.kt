package bryan.ch_loops

// 1. while, do while loops are exactly same as Java's.
// 2. for (int i, i < 10; i++) does not exist in Kotlin. Kotlin uses range.
// 3. Range: 1..5 means [1, 5]
//      1) start and end elements must be the same type and comparable
//      2) start<= e <= end
// 4. until: 1 util s means [1, 5)


fun main() {
    val iRange = 1..5
    val cRange = 'a'..'z'
    val sRange = "ABC".."XYZ"

    // 1.  loop all elements
    for (i in iRange) {
        println("ex1: $i")
    }

    // 2. check if one element is in the range: start <= i <= end
    println("4 in iRange ${4 in iRange}")
    println(6 in iRange)
    println('q' in cRange)
    println('Q' in cRange)
    println("AAA" in sRange)
    println("ZZZ" in sRange)
    println("CCC" in sRange)


    // 3. create backwardRange
    // wrong way: no compile error, but logic is wrong. i > end, so i will never be in the range
    val iBackrangeEx = 5..1
    println(3 in iBackrangeEx)

    // correct way
    val iBackRange = 5.downTo(1)
    println(3 in iBackRange)

    // 4. step range
    val iStepRange = 1..15
    val stepTwo = iStepRange.step(2)
    for (i in stepTwo) {
        println("stepTwo $i")
    }

    for (i in 1..20 step 3) {
        println("stepThree $i")
    }

    for (i in 30 downTo 20 step 2) {
        println("down range $i")
    }


    // 5. revered range
    val reversedRange = stepTwo.reversed()
    for (i in reversedRange) {
        println("reversedRange $i")
    }

    // 6. string range does not have iterator(), so it cannot be looped.
    //    string has iterator().
    val str = "hello"
    for (c in str) {
        println(c)
    }


    // 7. loop array
    val seasons = arrayOf("spring", "summer", "fall", "winter")
    for (season in seasons){
        println("season is $season")
    }

    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }
    seasons.forEach { println(it) }
    seasons.forEachIndexed{ index, value -> println("$value is season number $index")}

    println("June" !in seasons)
    println(11 !in 1..10)
}