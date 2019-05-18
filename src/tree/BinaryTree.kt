package tree

import java.util.*


class BinaryTree<T>(value: T, parent: BinaryTree<T>?){
    var value: T = value
    var parent :BinaryTree<T>? = parent

    //IN Kotlin List are read only but MutableList hhave delete/add
    var left: BinaryTree<T>? = null
    var right: BinaryTree<T>? = null

fun display(root: BinaryTree<T>): String{
    if(root == null) return "";
    var leftDisplay : String = ""
    if(root.left !=null) {
        leftDisplay = "$value" + display(root.left!!)
    }
    var rightDisplay: String=""
    if(root.right != null) {
        rightDisplay  = "$value"+ display(root.right!!)
    }
    return StringBuffer().apply {
        append("value ${root.value}")
        if (root.left != null)
            append(", ${leftDisplay}")
        if (root.right != null) {
            append(", $rightDisplay }")
        }
    }.toString()
}


    override fun toString(): String {
        return StringBuffer().apply {
            append("value $value")
        }.toString()
    }


}