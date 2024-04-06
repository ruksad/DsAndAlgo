class Node:
    def __init__(self,data):
        self.data=data
        self.next=None
        self.prev=None
    

class Doubly_linked_list:
    def __init__(self):
        self.size=0
        self.head=None
        self.tail=None

def printDoublyLinkedList(linked_list):

    if isNone(linked_list) or isEmpty(linked_list):
        print("Please pass a non empty linked list")
        return

    temp= linked_list.head

    while temp.next!=None :
        print(temp.data,end=",")
        temp=temp.next
    print(temp.data)


def addNodeAt(linked_list, data,location):
    node =Node(str(data))
    if isEmpty(linked_list):
        linked_list.head=node
        linked_list.tail=node
        linked_list.size+=1
    else:
        temp= linked_list.head
        if location<=0:
            location=1
        elif location> linked_list.size:
            location= linked_list.size

        for i in range(1,location+1):

            if i == location:
                if location==1:
                    node.next=linked_list.head
                    linked_list.head.prev=node
                    linked_list.head= node                 
                elif location==linked_list.size:
                    node.prev=linked_list.tail
                    linked_list.tail.next=node
                    linked_list.tail=node
                else:
                    node.next=temp
                    node.prev=temp.prev
                    temp.prev.next=node
                    temp.prev=node
                linked_list.size+=1
            temp=temp.next


def isNone(linked_list):
    return linked_list==None

def isEmpty(linked_list):
    return linked_list.size==0


if __name__ == "__main__":

    dll= Doubly_linked_list()
    addNodeAt(dll,"Mohammad",-1)
    addNodeAt(dll,"Ruksad",-1)
    addNodeAt(dll,"derric",100)
    addNodeAt(dll,"Siddiqui",-10)
    addNodeAt(dll,"samuel",2)
    printDoublyLinkedList(dll)
    addNodeAt(dll,"samuel1",2)
    printDoublyLinkedList(dll)
    addNodeAt(dll,"samuel2",3)
    printDoublyLinkedList(dll)