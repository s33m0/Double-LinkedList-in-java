
package doublelinkedlistdemo;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> l=new DoubleLinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        
        System.out.println(l.remove(0));
        System.out.println(l.popLast());
        System.out.println(l.get(2));
        System.out.println(l.search(3));
        System.out.println(l.size());
        l.print();
        l.reversePrint();
    }
    
}
