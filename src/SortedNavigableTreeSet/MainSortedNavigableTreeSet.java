package SortedNavigableTreeSet;

import java.util.Scanner;

public class MainSortedNavigableTreeSet {
    public static void main(String[] args) {
        System.out.println("���������� ������� ����� ���������, ����� (� 1 �� 11 � ������� �,�,�,� - 1� ��� 5�)," +
                " �������, ������������ � 1 �� 5 ������");
        System.out.println("���������� ���������� ������ - ��������: �� ��� ���");
        Scanner scanner = new Scanner(System.in);
        String userYesNo = "";

        do {
            String parameter = "";
            String name = name();
            String classroom = classroom();
            int grade = grade();
            int age = age();

            text();

            userYesNo = scanner.nextLine();
            if(userYesNo.equals("��")){
                System.out.println("�������� �� ������ ��������� �����������!");
                parameter = scanner.nextLine();
                switch (parameter){
                    case "���", "�����", "������������", "�������": Student.setInfoStudents(name, classroom, grade, age, parameter);break;
                }
            } else {
                Student.setInfoStudents(name, classroom, grade, age, parameter);
            }
            System.out.println("���������� ���������� ������ - �� ��� ���");
            userYesNo = scanner.nextLine();
        } while (!userYesNo.equals("��"));

        for(Student student: Student.arrayList){
            System.out.println(student);
        }
        for(String student: Student.treeSet){
            System.out.println(student);
        }
    }
    static String name(){
        System.out.println("�������� ��� ��������");
        String nameStudent = new Scanner(System.in).nextLine();
        return nameStudent;
    }
    static String classroom(){
        System.out.println("�������� ����� ��������");
        String classroomStudent = new Scanner(System.in).nextLine();
        return classroomStudent;
    }
    static int grade(){
        System.out.println("�������� ������������ ��������");
        int gradeStudent = new Scanner(System.in).nextInt();
        return gradeStudent;
    }
    static int age(){
        System.out.println("�������� ������� ��������");
        int ageStudent= new Scanner(System.in).nextInt();
        return ageStudent;
    }
    static void text(){
        System.out.println("���������� ���������� �� �����(���������)-  ���, �����, ������������, �������");
        System.out.println("���������� �������� ����� - ��� ��� ����� ��� ������������ ��� �������");
        System.out.println("������ ����� ��������� ��� ����� ���....., �� ����!");
        System.out.println("����������� ������ - �� ��� ���");
    }
}
