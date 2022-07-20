import java.util.*
import kotlin.math.absoluteValue

fun main() {
    prettyPrint() // 1
    printDuration(49984) // 2
    getPrimeFactor() // 3
    printPrettyVertical() //4
    goldBach() //5
}

private fun goldBach() {

    val input = Util.getInt()
        for(i in 3 until input/2) {
        if(Util.isPrime(input - i) && Util.isPrime(i)) {
            println("$i + ${input -i}")
        }
    }
}

private fun printPrettyVertical() {
    val height = Util.getInt()
    val width = Util.getInt()
    var counter = 0

    var sign = -1;
    for(i in 0..height){
        print("|")


        for(k in 0 until counter)
            print(" ")


        print("*")

        for(k in counter until width - 1)
            print(" ")

        if(counter % (width -1) == 0)
            sign *= -1;

        counter += sign;

        println("|")
    }
}

private fun getPrimeFactor() {
    var number = Util.getInt()

    while (number % 2 == 0)
    {
        print("2 ")
        number /= 2
    }

    for (i in 3..number step 2) {
        while (number % i == 0) {
            print("$i ")
            number /= i
        }
    }
}


private fun printDuration(input: Long) {
    if (input == 0L)
        return

    val seconds = input.rem(60)
    val minutes = input.div(60).rem(60)
    val hours = input.div(3600)
    println("sec = $seconds, min = $minutes, hours = $hours")
}

private fun prettyPrint() {
    val n = Util.getInt()

    if(n == 0)
        return
    for(i in 0 until n * 2 + 1) {
        for(j in 0 until (n - i).absoluteValue)
            print(" ")
        for(k in 1..(n * 2 + 1) - 2 * (n - i).absoluteValue)
            print("*")

        println()
    }
}

