package HashMap;

import java.util.Scanner;

public class MainHashMap {
    public static void main(String[] args) {
        HashMaps hashMaps = new HashMaps();

        for(String textYesOrNo = textBegin(); !textYesOrNo.equals("Нет"); textYesOrNo = textBegin()){

            hashMaps.setHashMapNames();
            hashMaps.getHashMaps();

        }
    }
    static String textBegin(){
        System.out.println("Необходимо написать пароль, имя и оценку");
        System.out.println("Будете вводить данные Студентов? Да или Нет");
        String scanner = new Scanner(System.in).nextLine();
        return scanner;
    }
    static String textMiddleGrade(){
        System.out.println("Вывести среднюю оценку студента? Да или Нет");
        String scanner = new Scanner(System.in).nextLine();
        return scanner;
    }
}
