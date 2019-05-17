import tree.BinaryTree
import tree.TreeNode

fun createTree( array: IntArray): BinaryTree<Int>? {
    println("Entry Array ${array.toList()}")


   var root = addNode(null, array,0 )
    return root

}


/**
 * Se base sur le fait que l'on sait que le prochain sous noeud est à 2*index
 */
fun  addNode(nodeRoot: BinaryTree<Int>?,  array: IntArray,index: Int): BinaryTree<Int>?{

    if( index > array.size - 1){
        return nodeRoot
    }
    else{
       val nodeToAdd =  BinaryTree(array[index], nodeRoot)
        nodeToAdd.left = addNode(nodeToAdd, array, 2*index + 1)
        nodeToAdd.right = addNode(nodeToAdd, array, 2*index + 2)
        return nodeToAdd
    }
}