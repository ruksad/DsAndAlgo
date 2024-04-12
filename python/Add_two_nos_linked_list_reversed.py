# https://leetcode.com/problems/add-two-numbers/description/

class ListNode:
    def __init__(self,val=0,next=None):
        self.val=val
        self.next=next

class TowLLAdd:

    def addTwoLLNumberinReverse(self,ll1,ll2) -> ListNode :

        if ll1 is None :
            return ll2
        
        if ll2 is None:
            return ll1
        
        listNode= ListNode()
        curr= listNode 
        carry=0
        
        while ll1 is not None or ll2 is not None or carry !=0:

            x= ll1.val if ll1 is not None else 0
            y= ll2.val if ll2 is not None else 0

            sum= carry+x+y


            curr.next=ListNode()
            curr=curr.next
            curr.val=sum%10
            carry= sum/10

            ll1=ll1.next if ll1 else None
            ll2= ll2.next if ll2 else None
        
        return listNode.next


    def printLL(self,ll):
        temp=ll
        while temp is not None:
            print(int(temp.val))
            temp=temp.next


if __name__== "__main__":

    node3= ListNode(3)
    node2= ListNode(4,node3)
    node1= ListNode(2,node2)


    node6= ListNode(4)
    node5= ListNode(6,node6)
    node4= ListNode(5,node5)


    add= TowLLAdd()
    reverse = add.addTwoLLNumberinReverse(node1, node4)
    add.printLL(reverse)
    #print("add ll {}".format(reverse))



