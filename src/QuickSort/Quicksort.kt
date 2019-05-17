package QuickSort

fun quickSort(array: IntArray, start: Int = 0,end : Int =array.size-1 ): IntArray{
    val pivot = array[start + ((end-start)/2)]
    println("========== start $start end $end : array ${array.copyOfRange(start, end).toList()} pivot $pivot" )
    var tmp : Int
    var i = start
    var j = end
    while(i < j){
        while(array[i] < pivot){
            i++
        }
        while(array[j] > pivot){
            j--
        }
        if(i <= j){
            println(" pivot : $pivot array : ${array.toList()} switch ($i) ${array[i]} and ($j) ${array[j]}")
            tmp = array[i]
            array[i] = array[j]
            array[j] = tmp
            j--
            i++
        }
    }
    println("array ${array.toList()}")
    if(i < end){
         quickSort(array, start, i)
    }
    if(j > start){
         quickSort(array, j, end)

    }

    return array
}