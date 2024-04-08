# https://www.geeksforgeeks.org/introduction-to-binary-search-tree-data-structure-and-algorithm-tutorials/

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def find_min(root):
    if root is not None:
        temp = root
        while temp.left is not None:
            temp = temp.left
        return temp


def find_max(root):
    if root is not None:
        temp = root
        while temp.right is not None:
            temp = temp.right
        return temp


class BinarySearchTree:

    def __init__(self):
        self.root = None

    # def min_value_node(root):
    #     temp = root
    #     if temp is not None and temp.left is not None:
    #         temp = temp.left
    #
    #     return temp

    def add_node(self, key):
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

    def inorder_traversal(self, root, list):
        if root is not None:
            self.inorder_traversal(root.left, list)
            list.append(root.data)
            self.inorder_traversal(root.right, list)

    def preorder_traversal(self, root, list):
        if root is not None:
            list.append(root.data)
            self.preorder_traversal(self, root.left, list)
            self.preorder_traversal(self, root.right, list)

    def postorder_traversal(self, root, list):
        if root is not None:
            self.postorder_traversal(self, root, list)
            self.postorder_traversal(self, root, list)
            list.append(root.data)

    def delete(self, root, key):

        if root is None:
            return

        if key < root.data:
            root.left = self.delete(root.left, key)
        elif key > root.data:
            root.right = self.delete(root.right, key)
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

            minNode = find_min(root.right)
            root.data = minNode.data

            root.right = self.delete(root.right, minNode.data)

        return root


if __name__ == "__main__":
    bst = BinarySearchTree()
    bst.add_node(50)
    bst.add_node(30)
    bst.add_node(20)
    bst.add_node(40)
    bst.add_node(70)
    bst.add_node(60)
    bst.add_node(80)

    elemets = []
    bst.inorder_traversal(bst.root, elemets)
    print("InOder traversal {}".format(elemets))
    print("maximum of bst {}".format(find_max(bst.root).data))
    print("Minimum of bst {}".format(find_min(bst.root).data))

    bst.delete(bst.root, 50)
    elemets1 = []
    bst.inorder_traversal(bst.root, elemets1)
    print("InOrder traversal {}".format(elemets1))
