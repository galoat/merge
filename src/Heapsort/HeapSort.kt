import tree.BinaryTree
import tree.TreeNode

fun createTree( array: IntArray): IntArray? {
    println("Entry Array ${array.toList()}")


   var root = addNode(null, array,0 )
    var result: IntArray = IntArray(array.size )
    for(i in (0 until array.size)) {
        var change: Boolean
        do {
            change = tamiser(root!!)
        } while (change)
        result[array.size -1 - i ] = root.value
        root.value = addResultTab(result, root)
        println("Result iteration $i and ${result.toList()}")
    }
    return result

}

fun addResultTab(array : IntArray, root: BinaryTree<Int> ): Int{
    if(root.right != null){
        return addResultTab(array, root.right!!)
    }else if(root.left != null){
        return addResultTab(array, root.left!!)
    }
    else {
        if(root.parent!!.right  != null){
            root.parent!!.right = null

        }
        else if(root.parent!!.left == null){
            root.parent!!.left = null
        }
        else{
            // we are the root noode
            return root.value
        }
        return root.value
    }

}

fun tamiser(root : BinaryTree<Int>):Boolean{
    if(root.left ==null && root.right == null){
        return false
    }

    var result  = false
    if(root.left != null && root.value < root.left!!.value) {
        var tmp = root.value
        root.value = root.left!!.value
        root.left!!.value = tmp
        result = (tamiser(root.left!!) || true)
    }
    else if(root.left != null ){
        result = tamiser(root.left!!)
    }

    if(root.right != null && root.value < root.right!!.value) {
        var tmp = root.value
        root.value = root.right!!.value
        root.right!!.value = tmp
        result= (tamiser(root.right!!) || true )
    }
    else if(root.right !=null){
        result = tamiser(root.right!!)
    }

    return result
}



/**
 * Se base sur le fait que l'on sait que le prochain sous noeud est à 2*index
 */
fun  addNode(nodeRoot: BinaryTree<Int>?,  array: IntArray,index: Int): BinaryTree<Int>?{

    if( index > array.size - 1){
        return null
    }
    else{
       val nodeToAdd =  BinaryTree(array[index], nodeRoot)
        nodeToAdd.left = addNode(nodeToAdd, array, 2*index + 1)
        nodeToAdd.right = addNode(nodeToAdd, array, 2*index + 2)
        return nodeToAdd
    }
}