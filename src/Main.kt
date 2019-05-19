import QuickSort.quickSort
import mergesort.mergeSort

fun main(args: Array<String>) {
/*
    val intArray= intArrayOf(38, 27 , 43,3, 9, 82, 10)
   var result = mergeSort(intArray)
   val result =quickSort(intArray);
   */

    val intArray = intArrayOf(3, 7, 8, 5, 2, 1, 9, 5, 4)
    val result : IntArray? = createTree(intArray)
    println("result " + (result?.toList()))
}

fun test(i:Int){
    println("$i")
}