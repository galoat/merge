fun main(args: Array<String>) {
    println("Hello World!")
    val intArray= intArrayOf(38, 27 , 43,3, 9, 82, 10)
    mergeSort(intArray)
}

fun mergeSort(array: IntArray): IntArray{
    if(array.size === 1){
       return array
    }
    else{
        //divid the array by two
        var left : IntArray
        var right: IntArray? = null
        val pair: Boolean;
        if(array.size  % 2 == 0){
            left= array.copyOfRange(0, (array.size /2))
            right = array.copyOfRange(((array.size/2) ), array.size)

           pair= true
        }
        else{
            left= array.copyOfRange(0, (array.size /2)+1)
            right = array.copyOfRange(((array.size/2)+1), array.size)
            pair = false
        }
        var  arrayLeft = mergeSort(left)
        var arrayRight: IntArray
        if(pair == true) {
            arrayRight = mergeSort(right)
        }else {
            arrayRight = right;
        }
        return mergeTwoArray(arrayLeft, arrayRight)
      //  return null
    }
}

fun mergeTwoArray(leftArray : IntArray, rightArray : IntArray): IntArray{
    println("comparre array " + leftArray.toList() + " and " + rightArray.toList())
    var resultArray:IntArray = IntArray(rightArray.size + leftArray.size)
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

            var currentIndex = i+1
            while (indexLeft < leftArray.size){
                resultArray.set(currentIndex, leftArray.get(indexLeft))
                indexLeft++
                currentIndex++
            }
            println("the element result array  " + resultArray.toList().toString())
            return resultArray
        }
        if(indexLeft == leftArray.size){
            var currentIndex = i+1
            while(indexRight < rightArray.size){
                resultArray.set(currentIndex, rightArray.get(indexRight))
                indexRight++
                currentIndex++
            }
            println("the element result array  " + resultArray.toList().toString())
            return resultArray
        }
    }

    return resultArray
}