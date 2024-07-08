package SortedNavigableTreeSet;

import java.util.*;

public class Student implements Comparator<Student> {
    String name, classroom;
    int grade, age;
    static ArrayList<Student> arrayList = new ArrayList<>();
    static TreeSet<String> treeSet = new TreeSet<>();
    public static String parameters = "";

    Student(String name, String classroom, int grade, int age){
        this.name = name;
        this.classroom = classroom;
        this. grade = grade;
        this.age = age;
    }
    static void setInfoStudents(String name, String classroom, int grade, int age, String parameter) {
        Student student = new Student(name, classroom, grade, age);
        parameters = parameter;
        arrayList.add(student);
        treeSet.add(name);
        FilterStudents filterStudents = new FilterStudents();
        switch (parameter){
    // Collections.sort(arrayList, filterStudents) ��� Collections.sort(arrayList, student) ��� Collections.sort(arrayList, new FilterStudents());
            case "���", "�����", "������������", "�������": Collections.sort(arrayList, filterStudents);
                break;
        }
    }
    @Override
    public String toString (){
        String string =
                this.name + " - " +
                this.classroom + " - " +
                this.grade + " - " +
                this.age;
        return string;
    }
    @Override
    public int compare(Student o1, Student o2) {
        switch (parameters){
            case "���"          : return o1.name.compareTo(o2.name);
            case "�����"        : return o1.classroom.compareTo(o2.classroom);
            case "������������" : return o1.grade - o2.grade;
            case "�������"      : return o1.age - o2.age;
        }
        return 0;
    }
    public String getName(){
        return name;
    }
    public static class FilterStudents implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2){
            switch (parameters){
                case "���"          : return o1.name.compareTo(o2.name);
                case "�����"        : return o1.classroom.compareTo(o2.classroom);
                case "������������" : return o1.grade - o2.grade;
                case "�������"      : return o1.age - o2.age;
            }
            return 0;
        }
    }
}


