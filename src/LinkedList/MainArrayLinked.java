package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainArrayLinked {
    public static void main(String[] args) {
        System.out.println("---------- Задание 1 ----------");
        System.out.println("ArrayList - может быть обычным объектом и с Типом (дженерик), если хотим привязать к типу/классу" +
                "это Объект класса, который состоит из внутреннего массива, состоящий из elementData(хранилище) и size(размер по умолчанию = 10)" +"\n"+
                "Это обычный массив из объектов, у каждого объекта свой индекс");
        System.out.println("---------- Задание 2 ----------");
        System.out.println("LinkedList - это список или как я думаю массив список, состоящий из элементов, связанных друг с другом ссылками, у ArrayList ссылок нет" +
                "каждый элемент ничем не связан ни с каким другим, а у данного массива элемент имеет ссылку"+"\n"+"на предыдущий элемент и на след.элемент, " +
                "и как я думаю, чтобы получить какой элемент в данном списке, нужно пройтись по всем элементам, потому что они связаны и ссылаются друг на друга" +
                "то есть, чтобы получить" +"\n"+"2 элемент LinkedList, цикл пройдется от начала, в отличие от ArrayList, где каждый элемент отдельно живет" +
                "это можно увидеть в задание 3, если использовать Дибаггер можно увидеть, как первый элемент" +"\n"+"ссылается на пред.элемент пустой и на " +
                "след. элемент, и след.элемент на предыдщий первый и на след.элемент и так далее....из дебаггера видно итератор ссылается на каждый элемент" +
                "из ArrayList, "+"\n"+"а итератор1 ссылается на первый элемент LinkedList, который ссылается на пустой предыдущий и на след.элемент Lulu и так далее..");
        System.out.println("---------- Задание 3 ----------");
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        List arrayListList = arrayList;
        arrayListList.add("Tom");
        arrayListList.add("Hoop");
        arrayListList.add("Goof");
        List linkedListList = linkedList;
        linkedListList.add("Jon");
        linkedListList.add("Lulu");
        linkedListList.add("Poof");
        Iterator iterator = arrayListList.iterator();
        Iterator iterator1 = linkedListList.iterator();
        while (iterator.hasNext() && iterator1.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(linkedListList.get(2));
        }
    }
}
