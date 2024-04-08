# https://www.geeksforgeeks.org/introduction-to-binary-search-tree-data-structure-and-algorithm-tutorials/
# BST can be used to implement the graph
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

            min_node = find_min(root.right)
            root.data = min_node.data

            root.right = self.delete(root.right, min_node.data)

        return root

    def find_height(self, root):
        if root is None:
            return 0

        left_height = self.find_height(root.left) + 1
        right_height = self.find_height(root.right) + 1

        if left_height > right_height:
            return left_height
        else:
            return right_height

    def count_number_of_nodes(self,root):
        if root is None:
            return 0
        return self.count_number_of_nodes(root.left)+ self.count_number_of_nodes(root.right)+1

    def print_all_lead_node(self, root, list):
        if root is not None:

            if root.left is None and root.right is None:
                list.append(root.data)

            if root.left is not None:
                self.print_all_lead_node(root.left, list)

            if root.right is not None:
                self.print_all_lead_node(root.right, list)

    def print_all_non_leaf_node(self, root, list):
        if root is not None:

            if root.left is None and root.right is None:
                return

            list.append(root.data)
            self.print_all_non_leaf_node(root.left, list)
            self.print_all_non_leaf_node(root.right, list)

    def print_all_nodes_at_level(self, root, level, list):
        if root is not None:

            if level == 1:
                list.append(root.data)
            else:
                self.print_all_nodes_at_level(root.left, level - 1, list)
                self.print_all_nodes_at_level(root.right, level - 1, list)

    def print_all_nodes_level_wise(self, root, list):
        if root is not None:
            height = self.find_height(root)

            for i in range(1, height + 1):
                self.print_all_nodes_at_level(root, i, list)

    def isBST(self, node):
        if node is None:
            return True
        
        if node.left is not None and find_max(node.left).data > node.data:
            return False
        
        if node.right is not None and find_min(node.right).data < node.data:
            return False
        
        if self.isBST(node.left) is False or self.isBST(node.right) is False:
            return False
        
        return True




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

    elements1 = []
    bst.print_all_nodes_at_level(bst.root, 3, elements1)
    print("all elements at given level {}".format(elements1))

    elements2 = []
    bst.print_all_nodes_level_wise(bst.root,elements2)
    print("all elements level wise {}".format(elements2))

    print("no of nodes in bst: {}".format(bst.count_number_of_nodes(bst.root)))

    bst.root.data=200
    print("Chekc if BST {}".format(bst.isBST(bst.root)))
    # bst.delete(bst.root, 50)
    # elemets1 = []
    # bst.inorder_traversal(bst.root, elemets1)
    # print("InOrder traversal {}".format(elemets1))

    bst1 = BinarySearchTree()
    bst1.add_node(1)
    bst1.add_node(2)
    bst1.add_node(3)
    bst1.add_node(4)
    bst1.add_node(5)
    bst1.add_node(6)
    bst1.add_node(7)
    print(bst.find_height(bst.root))
    list1 = []
    bst.print_all_lead_node(bst.root, list1)
    print("print all leaf nodes {}".format(list1))

    list2 = []
    bst1.print_all_non_leaf_node(bst1.root, list2)
    print("print all non leaf nodes {}".format(list2))

    print("Chekc if BST {}".format(bst1.isBST(bst1.root)))
