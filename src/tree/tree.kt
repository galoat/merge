package tree

class TreeNode<T>(value: T){
    var value: T = value
    var parent :TreeNode<T>? = null

    //IN Kotlin List are read only but MutableList hhave delete/add
    var childrens: MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(node: TreeNode<T>){
        childrens.add(node)
        node.parent = this
    }

    override fun toString(): String {
        var s = "${value}"
        if (!childrens.isEmpty()) {
            s += " {" + childrens.map { it.toString() } + " }"
        }
        return s
    }
}