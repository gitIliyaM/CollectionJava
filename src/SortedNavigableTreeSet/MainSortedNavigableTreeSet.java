package SortedNavigableTreeSet;

import java.util.Scanner;

public class MainSortedNavigableTreeSet {
    public static void main(String[] args) {
        System.out.println("Необходимо вводить имена студентов, класс (с 1 по 11 с буквами а,б,в,г - 1а или 5в)," +
                " возраст, успеваемость с 1 по 5 оценки");
        System.out.println("Прекратить заполнение данных - написать: Да или Нет");
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
            if(userYesNo.equals("Да")){
                System.out.println("Напишите по какому параметру сортировать!");
                parameter = scanner.nextLine();
                switch (parameter){
                    case "имя", "класс", "успеваемость", "возраст": Student.setInfoStudents(name, classroom, grade, age, parameter);break;
                }
            } else {
                Student.setInfoStudents(name, classroom, grade, age, parameter);
            }
            System.out.println("Прекратить заполнение данных - Да или Нет");
            userYesNo = scanner.nextLine();
        } while (!userYesNo.equals("Да"));

        for(Student student: Student.arrayList){
            System.out.println(student);
        }
        for(String student: Student.treeSet){
            System.out.println(student);
        }
    }
    static String name(){
        System.out.println("Напишите имя студента");
        String nameStudent = new Scanner(System.in).nextLine();
        return nameStudent;
    }
    static String classroom(){
        System.out.println("Напишите класс студента");
        String classroomStudent = new Scanner(System.in).nextLine();
        return classroomStudent;
    }
    static int grade(){
        System.out.println("Напишите успеваемость студента");
        int gradeStudent = new Scanner(System.in).nextInt();
        return gradeStudent;
    }
    static int age(){
        System.out.println("Напишите возраст студента");
        int ageStudent= new Scanner(System.in).nextInt();
        return ageStudent;
    }
    static void text(){
        System.out.println("Сортировка происходит по слово(параметру)-  Имя, Класс, Успеваемость, Возраст");
        System.out.println("Необходимо написано слово - имя или класс или успеваемость или возраст");
        System.out.println("Писать имена студентов или класс или....., не надо!");
        System.out.println("Сортировать данные - Да или Нет");
    }
}
