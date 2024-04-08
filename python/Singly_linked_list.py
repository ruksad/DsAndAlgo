class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.size = 0
        self.head = None


def add_node(linked_list, data):
    if linked_list is None:
        print("linkedList is not initialized")

    node = Node(data)
    node.next = None

    temp = linked_list.head

    if temp is None:
        linked_list.head = node
    else:
        while temp.next is not None:
            temp = temp.next

        temp.next = node

    linked_list.size += 1


def print_linked_list(linked_list):
    if is_empty(linked_list):
        print("Empty linked list")

    temp = linked_list.head
    while temp.next is not None:
        print(temp.data, end=",")
        temp = temp.next
    print(temp.data)


def is_empty(linked_list):
    return linked_list.size == 0 or linked_list is None


if __name__ == "__main__":
    linked_list = LinkedList()

    add_node(linked_list, str("Ruksad"))
    add_node(linked_list, str("Ruksad1"))
    add_node(linked_list, str("Siddiqui11"))
    add_node(linked_list, str("Siddiqui"))
    add_node(linked_list, str("Mohammad1"))
    print_linked_list(linked_list)
