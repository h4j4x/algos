package com.h4j4x.algos.kotlin.structure

class BinarySearchTree<T : Comparable<T>>(var root: BinaryTreeNode<T>? = null) {
    fun add(value: T) {
        if (root == null) {
            root = BinaryTreeNode(value)
            return
        }
        var node = root
        var parent: BinaryTreeNode<T> = root!!
        while (node != null) {
            parent = node
            node = if (parent.key < node.key) {
                node.left
            } else {
                node.right
            }
        }
        if (value < parent.key) {
            parent.left = BinaryTreeNode(value, parent = parent)
        } else {
            parent.right = BinaryTreeNode(value, parent = parent)
        }
    }

    fun delete(value: T) {
        val node = search(value) ?: return
        if (node.left == null) {
            transplant(node, node.right)
        } else if (node.right == null) {
            transplant(node, node.left)
        } else {
            val rightMinNode = min(node.right)
            if (rightMinNode != null && rightMinNode != node.right) {
                transplant(rightMinNode, rightMinNode.right)
                rightMinNode.right = node.right
                rightMinNode.right?.parent = rightMinNode
            }
            transplant(node, rightMinNode)
            if (rightMinNode != null) {
                rightMinNode.left = node.left
                rightMinNode.left?.parent = rightMinNode
            }
        }
    }

    private fun transplant(to: BinaryTreeNode<T>, from: BinaryTreeNode<T>?) {
        if (to.parent == null) {
            root = from
        } else if (to == to.parent?.left) {
            to.parent?.left = from
        } else {
            to.parent?.right = from
        }
        from?.parent = to.parent
    }

    fun inOrderTreeWalk(visitor: (BinaryTreeNode<T>) -> Unit) {
        inOrderTreeWalk(root, visitor)
    }

    fun search(value: T): BinaryTreeNode<T>? {
        var node = root
        while (node != null && node.key != value) {
            node = if (value < node.key) {
                node.left
            } else {
                node.right
            }
        }
        return node
    }

    fun min() = min(root)

    fun max() = max(root)

    private fun min(from: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
        var node = from
        while (node?.left != null) {
            node = node.left
        }
        return node
    }

    private fun max(from: BinaryTreeNode<T>?): BinaryTreeNode<T>? {
        var node = from
        while (node?.right != null) {
            node = node.right
        }
        return node
    }

    fun successor(value: T): BinaryTreeNode<T>? {
        val valueNode = search(value)
        if (valueNode?.right != null) {
            return min(valueNode.right)
        } else if (valueNode != null) {
            return next(valueNode) { it.right }
        }
        return null
    }

    fun predecessor(value: T): BinaryTreeNode<T>? {
        val valueNode = search(value)
        if (valueNode?.left != null) {
            return max(valueNode.left)
        } else if (valueNode != null) {
            return next(valueNode) { it.left }
        }
        return null
    }

    private fun next(from: BinaryTreeNode<T>, supplier: (BinaryTreeNode<T>) -> BinaryTreeNode<T>?): BinaryTreeNode<T>? {
        var parent = from.parent
        var node = from
        while (parent != null && node != supplier(parent)) {
            node = parent
            parent = node.parent
        }
        return parent
    }

    private fun inOrderTreeWalk(node: BinaryTreeNode<T>?, visitor: (BinaryTreeNode<T>) -> Unit) {
        if (node != null) {
            inOrderTreeWalk(node.left, visitor)
            visitor(node)
            inOrderTreeWalk(node.right, visitor)
        }
    }
}

class BinaryTreeNode<T>(
    val key: T,
    var parent: BinaryTreeNode<T>? = null,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BinaryTreeNode<*>
        return key == other.key
    }

    override fun hashCode(): Int {
        return key.hashCode()
    }
}
