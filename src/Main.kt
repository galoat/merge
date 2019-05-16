import mergesort.mergeSort

fun main(args: Array<String>) {

    val intArray= intArrayOf(38, 27 , 43,3, 9, 82, 10)
   var result = mergeSort(intArray)
    println("result " +result.toList().toString())
}