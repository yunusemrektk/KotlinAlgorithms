import java.util.Scanner

fun main() {
    sorting(getIntInputs()) // 1
    println(getMid(3, 2, 8))  // 2
    println(signum(-5))     // 3
}

private fun signum(input: Int): Int{
    return when {
        input > 0 -> 1
        input < 0 -> -1
        else -> 0
    }
}

private fun getMid(in1: Int, in2: Int, in3:Int): Int{
    val list = arrayOf(in1, in2, in3)
    list.sortDescending()
    list[list.size / 2]
    return list[list.size / 2]
}

private fun getIntInputs(): ArrayList<Int> {
    val inputList: ArrayList<Int> = ArrayList()
    val reader =  Scanner(System.`in`)

    for(i in 0..2){
        val input = reader.nextInt()
        inputList.add(input)
    }
    return inputList
}

private fun sorting( myList: ArrayList<Int>) {
    myList.sortByDescending { it }
    myList.reverse()
    for(i in 0.. myList.size) {
        print(myList[i])

        if(i + 1 == myList.size)
            return

        if(myList[i] == myList[i+1])
            print(" = ")
        else
            print(" < ")
    }
}