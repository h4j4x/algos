package com.h4j4x.algos.kotlin.structure

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchTreeTests {
    @Test
    fun testAddInsertsNodeInOrder() {
        val tree = BinarySearchTree(2)
        tree.addAll(1, 3)
        var inOrder = ""
        tree.inOrderTreeWalk { inOrder += it.key.toString() }
        assertEquals("123", inOrder)
        tree.addAll(0, 4)
        inOrder = ""
        tree.inOrderTreeWalk { inOrder += it.key.toString() }
        assertEquals("01234", inOrder)
        tree.add(5)
        inOrder = ""
        tree.inOrderTreeWalk { inOrder += it.key.toString() }
        assertEquals("012345", inOrder)
        tree.clear()
        tree.addAll(3, 2, 5, 1, 4, 6)
        inOrder = ""
        tree.inOrderTreeWalk { inOrder += it.key.toString() }
        assertEquals("123456", inOrder)
    }

    @Test
    fun testDeletePutsNodeSuccessorInPlace() {
        val tree = BinarySearchTree(2)
        tree.addAll(1, 3, 0, 4, 5)
        var inOrder = ""
        tree.inOrderTreeWalk { inOrder += it.key.toString() }
        assertEquals("012345", inOrder)
        tree.delete(3)
        inOrder = ""
        tree.inOrderTreeWalk { inOrder += it.key.toString() }
        assertEquals("01245", inOrder)
        tree.add(3)
        tree.delete(4)
        inOrder = ""
        tree.inOrderTreeWalk { inOrder += it.key.toString() }
        assertEquals("01235", inOrder)
    }

    @Test
    fun testSearchReturnsCorrectNode() {
        val tree = BinarySearchTree(2)
        tree.addAll(1, 3, 0, 4, 5)
        var node = tree.search(3)
        assertNotNull(node)
        assertEquals(3, node?.key)
        assertNotNull(node?.parent)
        assertEquals(2, node?.parent?.key)
        node = tree.search(10)
        assertNull(node)
    }

    @Test
    fun testMinAndMaxReturnsCorrectNode() {
        val tree = BinarySearchTree(2)
        tree.addAll(1, 3, 0, 4, 5)
        var node = tree.min()
        assertNotNull(node)
        assertNotNull(node?.parent)
        assertEquals(0, node?.key)
        node = tree.max()
        assertNotNull(node)
        assertNotNull(node?.parent)
        assertEquals(5, node?.key)
    }

    @Test
    fun testSuccessorAndPredecessorReturnsCorrectNode() {
        val tree = BinarySearchTree(2)
        tree.addAll(1, 3, 0, 4, 5)
        var node = tree.successor(3)
        assertNotNull(node)
        assertNotNull(node?.parent)
        assertEquals(4, node?.key)
        node = tree.predecessor(5)
        assertNotNull(node)
        assertNotNull(node?.parent)
        assertEquals(4, node?.key)
    }
}
