class Node:
      def __init__(self,data):
          self.data=data
          self.next= None


class LinkedList:
     def __init__(self):
          self.size=0
          self.head= None

def addNode(linked_list, data):
     if(linked_list==None):
          print("linkedList is not initialized")
        
     node= Node(data)
     node.next= None
     
     temp= linked_list.head
     
     if(temp==None):
        linked_list.head= node
     else:
        while(temp.next!=None):
            temp=temp.next

        temp.next= node   

     linked_list.size+=1
     

def printLinkedList(linked_list):
     if(isEmpty(linked_list)):
          print("Empty linked list")
    
     temp=linked_list.head
     while(temp.next!=None):
          print(temp.data, end=",")
          temp=temp.next

    
    
def isEmpty(linked_list):
     return (linked_list.size==0 or linked_list==None)

if __name__=="__main__":
     linked_list= LinkedList()

     addNode(linked_list, str("Ruksad"))
     addNode(linked_list,str("Ruksad1"))
     addNode(linked_list, str("Siddiqui"))
     addNode(linked_list, str("Siddiqui"))
     addNode(linked_list, str("Mohammad"))
     printLinkedList(linked_list)


