import java.util.*

object Util {
    fun isPrime(number : Int):Boolean {
        if(number == 1 || number == 0)
            return false

        for(i in 2..number / 2){
            if(number % i == 0) {
                return false
            }
        }
        return true
    }

    fun getInt(): Int = Scanner(System.`in`).nextInt()

    fun getDigitCount(number:Int): Int {
        var number = number
        var count = 0

        while(number > 0) {
            number /= 10
            count++
        }
        return count
    }

    fun getDigitSum(number: Int):Int {
        var number = number
        var count = 0

        while(number > 0) {
            count += number % 10
            number /= 10
        }
        return count
    }

    fun factorial(number: Int): Int {
        return when(number) {
            0 -> 1
            else -> number * factorial(number - 1)
        }


    }

}