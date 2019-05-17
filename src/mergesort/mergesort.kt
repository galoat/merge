package mergesort



fun mergeSort(array: IntArray, step: Int = 1): IntArray{
    println(" step : "+ step + " Array "+ array.toList())
    if(array.size === 1){
        return array
    }
    else{
        var left : IntArray
        var right: IntArray

        if(array.size  % 2 == 0){
            left= array.copyOfRange(0, (array.size /2))
            right = array.copyOfRange(((array.size/2) ), array.size)

        }
        else{
            left= array.copyOfRange(0, (array.size /2)+1)
            right = array.copyOfRange(((array.size/2)+1), array.size)
        }

        var  arrayLeft = mergeSort(left, step+1)
        var arrayRight: IntArray
        if(right.size > 1) {
            arrayRight = mergeSort(right, step + 1)
        }else {
            arrayRight = right;
        }
        return mergeTwoArray(arrayLeft, arrayRight)

    }
}

fun mergeTwoArray(leftArray : IntArray, rightArray : IntArray): IntArray{
    println("comparre array " + leftArray.toList() + " and " + rightArray.toList())
    var resultArray = IntArray(rightArray.size + leftArray.size)
    var indexRight = 0
    var indexLeft = 0
    for(i in 0 .. (rightArray.size + leftArray.size - 1)){
        if(rightArray.get(indexRight) >= leftArray.get(indexLeft)){
            resultArray.set(i, leftArray.get(indexLeft))
            indexLeft++
        }else{
            resultArray.set(i, rightArray.get(indexRight))
            indexRight++
        }
        if(indexRight == rightArray.size ){
            return copyFullArray(resultArray, i+1, leftArray, indexLeft)
        }
        if(indexLeft == leftArray.size){
           return copyFullArray(resultArray, i+1, rightArray, indexRight)
        }
    }

    return resultArray
}

private fun copyFullArray( resultArray: IntArray,  indexCurrentResultArray:  Int,  arrayToCopy: IntArray,  arrayToCopyIndex:  Int) : IntArray{
    var indexCopy = arrayToCopyIndex
    var indexCurrentResult = indexCurrentResultArray

    while(indexCopy < arrayToCopy.size){
        resultArray.set(indexCurrentResultArray, arrayToCopy.get(arrayToCopyIndex))
        indexCopy++
        indexCurrentResult++
    }
    return resultArray
}