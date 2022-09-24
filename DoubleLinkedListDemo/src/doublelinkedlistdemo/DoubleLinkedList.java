package doublelinkedlistdemo;

public class DoubleLinkedList<T> {
    private Node head,tail;
    private int i=0;
    
    private class Node<T> {
     T value;
    Node next,prev;
         Node(T value) {
            this.value = value;
            this.next = null;
            this.prev=null;
        }}
     public void add(T data)
    {
        // Create a new node
        Node newNode = new Node(data);
  
        // Checks if the list is empty
        if (head == null) {
  
            // If list is empty, both head and tail will
            // point to new node
            head = newNode;
            tail = newNode;
        }
        else {
            
            tail.next=newNode;
            newNode.prev=tail;
  
            // newNode will become new tail of the list
           tail = newNode;
        }
        i++;
    }
     public T peek(){
         if(head!=null){
          return (T) head.value; 
          }
         return null;
       }
        public T peekLast(){
          if(tail!=null)
          { return (T) tail.value; }
             
           return null;
    }
      int size(){
        return i;
    } 
      
      
   // insert before the element that you selected it...
    public void insertBefore(T item,T value){
        if(isExist(item)){
        Node n=new Node(value);
         Node temp=head;
           if(head.value==item){
            n.next=head;
            n.prev=null;
                head.prev=n;
                head=n;
                i++;
         }
         else{
        while(temp!=null&&temp.next.value!=item)
        { temp=temp.next; }
        
               n.next=temp.next;
               n.prev=temp;
                temp.next=n;
                 temp.next.prev=n;
                i++;
                
           }}
        else{
            System.out.println("the element not found!");
        }
           
     }
    
     public void insertAfter(T item,T value){
        if(isExist(item)){
        Node n=new Node(value);
         Node temp=head;
      
        while(temp!=null&&temp.value!=item)
        { temp=temp.next; }
        
               n.next=temp.next;
               n.prev=temp;
                temp.next=n;
                temp.next.prev=n;
                i++;
           }
        else{
            System.out.println("the element not found!");
        }
           
     }
     
     //Retrieves and removes the head (first element) of this list.
     public T pop(){
         
         if(size()==1){
          Node temp=head;
          head=null; 
          i--;
          return (T) temp.value;
         }
         
           if(size()>1){
         Node temp=head;
          head=head.next;
          head.prev=null;
          i--;
          return (T) temp.value;
           }
           else 
           {return null;}
     }
     public T popLast(){
        if(size()==1)
            return pop();
           if(size()>1){
         Node temp=tail;
          tail=tail.prev;
          tail.next=null;
          
          i--;
          return (T) temp.value;
           }
           else 
           {return null;}
     }
     
         // Removes the element at the specified position in this list.
   
   public T remove(int index){
       if(index>=size()||index<0)  
          return null;
      T element;
         int counter=0;
        if(index==0){
             element=(T) head.value;
             pop();
         }
        
         
         else{
             Node current=head;

               while(current!=null){
                  if(counter==index)
                  {break;}
                   counter++;
                   current=current.next;
                 }
         element=(T) current.value;
               if(counter<size()-1){
                   current.prev.next = current.next;
                   current.next.prev = current.prev;
                   i--;
              }
                   else{
                       popLast();
                     
                   }
               
         }
    return element;
    
       }  
     // this method return the index of the element...
    public int search(T value){
         
       int counter=0;
       
        if(isExist(value)){
          
         Node temp=head;
        while(temp!=null){
            if(temp.value==value){
                break;
            }
             counter++;
            temp=temp.next;
        }}
        else{
            return -1;
        }
        return  counter;
    }
     
     //Returns the element at the specified position in this list.
     public T get(int index){
         int counter=0;
         T element=null;
        if(size()>0){
         Node temp=head;
         
        while(temp!=null&&counter<=index){
            if(counter==index){
              element=(T) temp.value;
              break;
            }
            
            temp=temp.next;
             counter++;
        }}

        return  element;

     }
     
     
    public boolean isExist(T value){
        boolean flag=false;
         Node temp=head;
        while(temp!=null){
            if(temp.value==value)
            {flag=true; break;}
            
            temp=temp.next;
        }
        return flag;
    }
    public void print(){
        Node temp=head;
        System.out.print("[ ");
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
          }
        System.out.println("]");
          }

        public void reversePrint(){
        Node temp=tail;
        System.out.print("[ ");
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.prev;
          }
        System.out.println("]");
          }
 }
