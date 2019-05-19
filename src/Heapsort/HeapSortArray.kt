package Heapsort

fun HeapSortArray(array: IntArray){
    var end =0
    println("start ${array.toList()}")
    while(end != array.size){
        do{

        }while(tamiser(array, 0, end))
        println("iteration $end  ${array.toList()}")
        val tmp = array[array.size - 1 - end ]
        array[array.size - 1 -end] = array[0]
        array[0] = tmp

        end ++
    }


}

fun tamiser(array: IntArray, index: Int, end : Int): Boolean{

    if(index > array.size-end){
        return false
    }
    var result  = false
    if(index * 2 + 1 < array.size - end && array[index*2 + 1 ] > array[index]){
        val tmp = array[index *2 +1]
        array[index * 2 + 1] = array[index]
        array[index] = tmp
        result = tamiser(array, index * 2 + 1, end) || true

    }else if( index * 2 +1 < array.size - end){
        result =  tamiser(array, index * 2 + 1, end)
    }

    if(index * 2 + 2 < array.size - end && array[index * 2 + 2] > array[index]){
        val tmp = array[index *2 + 2]
        array[index * 2 + 2] = array[index]
        array[index] = tmp
        result = tamiser(array, index * 2 + 2, end) || true

    }else if(index * 2+ 2 < array.size - end){
        result = tamiser(array, index*2 + 2, end)
    }

    return result
}