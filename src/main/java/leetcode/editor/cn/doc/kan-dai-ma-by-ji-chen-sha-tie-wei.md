### 解题思路
此处撰写解题思路
1. 明确三个概念：表头是个位数;a.next要比a高一位;两个链表的相同位置的结点是同一位。
2. 我设置了一个特殊的指针pointer,总是指向进位结点，是个暂时的结点，这个结点只有0和1两个值，为0表示上一位相加没有进位，如果为1则表明上一位的计算结果有进位。pointer的值要参与运算（因为在加法中按位相加要加上 上一位的进位）。每次算完一位之后要新建一个pointer结点。然后参与下一位的运算
3. 在循环计算的过程中。算完一次后要判断l1和l2是否为空，如果不为空则让两者指向后一个结点。一位一位地往后算，如果l1和l2的两个结点相加大于10，则往后进一位（即新建的pointer结点的值为1），本位的值为相加之和除以10的余数。如果小于0，则置pointer的值为两者之和，然后新建一个进位结点（值为0），让pointer指向它。。
### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l_result=new ListNode(0);
        ListNode pre=null;  //用来保存pointer的前一个结点，因为如果两个列表位数相同最后pointer有一个值，要消除这个pointer
        ListNode pointer=l_result;

        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val;
            if(pointer.val==0){
                pre=pointer;
                pointer=add(pointer,sum);
                l1=l1.next;
                l2=l2.next;
            }
            else{
                //从上一位有一个进位
                sum=l1.val+l2.val+1;
                pre=pointer;
                pointer=add(pointer,sum);
                l1=l1.next;
                l2=l2.next;
            }
        }
        if(pointer.val==0){
            if(l1!=null){
                pointer.val=l1.val;
                pointer.next=l1.next;
            }
            else if(l2!=null){
                pointer.val=l2.val;
                pointer.next=l2.next;
            }
            else{
                pre.next=null;
            }
        }
        else{ //最后的pointer还有一个进位，要处理这个进位
            //如果l1与l2还没有算完，要接着算其中一个没有算完的列表
            if(l1!=null){ //l1没有算完时
                while(l1!=null){
                    int sum=pointer.val+l1.val;
                    if(sum<10){
                        pointer.val=sum;
                        pointer.next=l1.next;
                        break;  //不用继续往下算了
                    }
                    else{ //还有进位的情况下，一直循环算下去知道没有进位了或者l1算完了
                        pre=pointer;
                        pointer=add(pointer,sum);
                        l1=l1.next;
                    }
                }
            }
            else if(l2!=null){
                while(l2!=null){
                    int sum=pointer.val+l2.val;
                    if(sum<10){
                        pointer.val=sum;
                        pointer.next=l2.next;
                        break;  //不用继续往下算了
                    }
                    else{ //还有进位的情况下，一直循环算下去知道没有进位了或者l1算完了
                        pre=pointer;
                        pointer=add(pointer,sum);
                        l2=l2.next;
                    }
                }
            }
        }


        return l_result;
    }

    public ListNode add(ListNode pointer,int sum){
        if(sum>=10){
            int lower=sum%10;
            pointer.val=lower;
            ListNode temp=new ListNode(1);  //有进位
            pointer.next=temp;
            pointer=pointer.next;
        }
        else{
            pointer.val=sum;
            ListNode temp=new ListNode(0);
            pointer.next=temp;
            pointer=pointer.next;
        }
        return pointer;
    }
}
```