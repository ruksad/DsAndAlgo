# https://www.geeksforgeeks.org/introduction-to-binary-search-tree-data-structure-and-algorithm-tutorials/

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class BinarySearchTree:

    def __init__(self):
        self.root = None

    def minValueNode(root):
        temp = root
        if temp is not None and temp.left is not None:
            temp = temp.left

        return temp

    def addNode(self,key):
        if self.root is None:
            self.root = Node(key)
            return self.root

        temp = self.root

        while True:

            if key < temp.data:

                if temp.left is None:
                    temp.left = Node(key)
                    return self.root
                temp = temp.left

            if key > temp.data:
                if temp.right is None:
                    temp.right = Node(key)
                    return self.root
                temp = temp.right

    def fetchInOrderList(self, root, list):
        if root is not None:
            self.fetchInOrderList(root.left, list)
            list.append(root.data)
            self.fetchInOrderList(root.right, list)

    def delete(self, root, key):

        if root == None:
            return

        if key < root.data:
            root.left = self.delete(self, root.left, key)
        elif key > root.data:
            root.right = self.delete(self, root.right, key)
        else:

            # root has no left child
            if root.left is None:
                temp = root.right
                return temp

            # root has no right child
            elif root.right is None:
                temp = root.left
                return temp

            # root has both the children 

            minNode = self.minValueNode(root.right)
            root.data = minNode.data

            root.right = self.delete(self, root.right, minNode.data)

        return root


if __name__ == "__main__":
    bst = BinarySearchTree()
    bst.addNode(50)
    bst.addNode(30)
    bst.addNode(20)
    bst.addNode(40)
    bst.addNode(70)
    bst.addNode(60)
    bst.addNode(80)

    setele = []
    bst.fetchInOrderList(bst.root, setele)
    print("InOder traversal {}".format(setele))
