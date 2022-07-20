import kotlin.math.pow

fun main() {

    getPrimeCombines() // 1
    val input = Util.getInt()
    println(isPrimeX(input)) //2
    println(calculateDigitalRoot(input)) //3
    isFactorian() //4
    isSuperPrime() // 5
    hardyRamanujan() // 6
    println(harshadNumber(input))
    printCollatz(input)
}

private fun printCollatz(number: Int) {
    var number = number
    print("$number ")

    if(number == 1)
        return

    if(number % 2 == 0) {
        number /= 2
    }else {
        number = 3 * number + 1
    }

    return printCollatz(number)
}

private fun harshadNumber(number: Int):Boolean {
    if(number < 0) {
        return false
    }

    if(number % Util.getDigitSum(number) != 0) {
        return false
    }

    return true
}

private fun hardyRamanujan() {
    for (i in 1..10000) {
        val cubicRoot = i.toDouble().pow(1.0 / 3.0).toInt()
        for (j in 1..cubicRoot) {
            for(k in j..cubicRoot) {
                if(j != k  && (j*j*j + k*k*k) == i) {
                    for(l in j..cubicRoot) {
                        for (m in l..cubicRoot){
                            if(l != m && l != k && l != j && (l*l*l + m*m*m) == i) {
                                println("$i = $k^3 + $j^3 = $l^3 + $m^3")
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun isSuperPrime(){
    var list = ArrayList<Int>()
    for (i in 2..1000) {
        if(Util.isPrime(i)) {
            list.add(i)
        }
    }

    for(i in 1 until list.size) {
        if(Util.isPrime(list[i]) && Util.isPrime(i)){
            println("$i -> ${list[i - 1]}")
        }
    }
}

private fun isFactorian() {
    val list = ArrayList<Int>()
    for(number in 1..100000) {
        val digits = getDigits(number)
        var result = 0
        for (i in digits) {
            result += Util.factorial(i)
        }

        if(result == number) {
            list.add(number)
        }
    }

    println(list)
}

private fun calculateDigitalRoot(number: Int): Int {
    val sum = getDigits(number).sum()
    if(Util.getDigitCount(sum) == 1) {
        return sum
    }

    return calculateDigitalRoot(sum)
}

private fun isPrimeX(input:Int):Boolean {

    if (!Util.isPrime(input)) {
        return false
    }

    val sumDigits = sumDigits(input)
    if (!Util.isPrime(sumDigits)) {
        return false
    }

    if(Util.getDigitCount(sumDigits) == 1) {
        return true
    }

    return isPrimeX(sumDigits)
}

private fun sumDigits(number: Int):Int {
    var number = number
    var retVal = 0
    while(number > 0) {
        retVal += number %10
        number /= 10
    }
    return retVal

}

private fun getPrimeCombines() {
    val input = Util.getInt()

    if(Util.getDigitCount(input) == 3) {
        if(reverseNumber(input) > input) {
            for(i in combineNumbers(input)){
                if(Util.isPrime(i)){
                    println("$i asal")
                }
            }
        }
    }
}

private fun combineNumbers(number:Int): Array<Int> {
    var number = number
    val retVal = Array(6) {0}
    val list = getDigits(number)
    retVal[0] = reverseNumber(number)
    retVal[1] = reverseNumber(reverseNumber(number))
    retVal[2] = list[0] + list[1] * 10
    retVal[3] = list[1] + list[0] * 10
    retVal[4] = list[1] + list[2] * 10
    retVal[5] = list[2] + list[1] * 10

    return retVal
}

private fun reverseNumber(number: Int): Int {
    val reverse = getDigits(number)
    var number = 0
    for (element in reverse) {
        number = number * 10 + element
    }
    return number
}

private fun getDigits(number:Int):ArrayList<Int> {
    var number = number
    val list = ArrayList<Int>()
    while (number > 0) {
        list.add(number % 10)
        number /= 10
    }
    return list
}

