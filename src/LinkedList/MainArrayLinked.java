package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainArrayLinked {
    public static void main(String[] args) {
        System.out.println("---------- ������� 1 ----------");
        System.out.println("ArrayList - ����� ���� ������� �������� � � ����� (��������), ���� ����� ��������� � ����/������" +
                "��� ������ ������, ������� ������� �� ����������� �������, ��������� �� elementData(���������) � size(������ �� ��������� = 10)" +"\n"+
                "��� ������� ������ �� ��������, � ������� ������� ���� ������");
        System.out.println("---------- ������� 2 ----------");
        System.out.println("LinkedList - ��� ������ ��� ��� � ����� ������ ������, ��������� �� ���������, ��������� ���� � ������ ��������, � ArrayList ������ ���" +
                "������ ������� ����� �� ������ �� � ����� ������, � � ������� ������� ������� ����� ������"+"\n"+"�� ���������� ������� � �� ����.�������, " +
                "� ��� � �����, ����� �������� ����� ������� � ������ ������, ����� �������� �� ���� ���������, ������ ��� ��� ������� � ��������� ���� �� �����" +
                "�� ����, ����� ��������" +"\n"+"2 ������� LinkedList, ���� ��������� �� ������, � ������� �� ArrayList, ��� ������ ������� �������� �����" +
                "��� ����� ������� � ������� 3, ���� ������������ �������� ����� �������, ��� ������ �������" +"\n"+"��������� �� ����.������� ������ � �� " +
                "����. �������, � ����.������� �� ��������� ������ � �� ����.������� � ��� �����....�� ��������� ����� �������� ��������� �� ������ �������" +
                "�� ArrayList, "+"\n"+"� ��������1 ��������� �� ������ ������� LinkedList, ������� ��������� �� ������ ���������� � �� ����.������� Lulu � ��� �����..");
        System.out.println("---------- ������� 3 ----------");
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
