class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class Doubly_linked_list:
    def __init__(self):
        self.size = 0
        self.head = None
        self.tail = None


def print_doubly_linked_list(linked_list):
    if is_none(linked_list) or is_empty(linked_list):
        print("Please pass a non empty linked list")
        return

    temp = linked_list.head

    while temp.next is not None:
        print(temp.data, end=",")
        temp = temp.next
    print(temp.data)


def add_note_at(linked_list, data, location):
    node = Node(str(data))
    if is_empty(linked_list):
        linked_list.head = node
        linked_list.tail = node
        linked_list.size += 1
    else:
        temp = linked_list.head
        if location <= 0:
            location = 1
        elif location > linked_list.size:
            location = linked_list.size

        for i in range(1, location + 1):

            if i == location:
                if location == 1:
                    node.next = linked_list.head
                    linked_list.head.prev = node
                    linked_list.head = node
                elif location == linked_list.size:
                    node.prev = linked_list.tail
                    linked_list.tail.next = node
                    linked_list.tail = node
                else:
                    node.next = temp
                    node.prev = temp.prev
                    temp.prev.next = node
                    temp.prev = node
                linked_list.size += 1
            temp = temp.next


def is_none(linked_list):
    return linked_list == None


def is_empty(linked_list):
    return linked_list.size == 0


if __name__ == "__main__":
    dll = Doubly_linked_list()
    add_note_at(dll, "Mohammad", -1)
    add_note_at(dll, "Ruksad", -1)
    add_note_at(dll, "derric", 100)
    add_note_at(dll, "Siddiqui", -10)
    add_note_at(dll, "samuel", 2)
    print_doubly_linked_list(dll)
    add_note_at(dll, "samuel1", 2)
    print_doubly_linked_list(dll)
    add_note_at(dll, "samuel2", 3)
    print_doubly_linked_list(dll)
