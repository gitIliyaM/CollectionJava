package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMaps {
    ArrayList<String> arrayList = new ArrayList<>();
    HashMap<String, String> hashMapPass = new HashMap<>();
    HashMap<String, String> hashMapNames = new HashMap<>();

    //HashMap<String, Integer> hashMapGrades = new HashMap<>();
    String password() {
        System.out.println("Напишите пароль");
        Scanner scanner = new Scanner(System.in);
        String textPassword = scanner.nextLine();
        return textPassword;
    }

    String name() {
        System.out.println("Напишите ваше Имя");
        Scanner scanner = new Scanner(System.in);
        String textName = scanner.nextLine();
        return textName;
    }

    int grade() {
        System.out.println("Напишите вашу оценку");
        Scanner scanner = new Scanner(System.in);
        int intGrade = scanner.nextInt();
        return intGrade;
    }

    void setHashMapNames() {
        String textPassword, textName;
        int intGrade;
        textPassword = password();
        textName = name();
        intGrade = grade();
        if (!hashMapPass.isEmpty()) {
            boolean userNewPassword = textPassword == hashMapPass.get(textPassword);
            if (!userNewPassword) {

                hashMapPass.put(textPassword, textPassword);
                hashMapNames.put(textPassword, textName);
                arrayList.add("пароль " + textPassword + " имя " + textName + " оценка " + intGrade);
                System.out.println("Ваши данные сохранены");
            } else if (userNewPassword) {
                textPassword = hashMapPass.get(textPassword);
                hashMapNames.put(textPassword, textName);
                arrayList.add("пароль " + textPassword + " имя " + textName + " оценка " + intGrade);
                System.out.println("Ваши данные сохранены");
            }
        } else {
            hashMapPass.put(textPassword, textPassword);
            hashMapNames.put(textPassword, textName);
            arrayList.add("пароль " + textPassword + " имя " + textName + " оценка " + intGrade);
        }
        if(MainHashMap.textMiddleGrade().equals("Да")){
            getMiddleGrade(arrayList, hashMapPass, hashMapNames);
        }
    }
    void getHashMaps() {
        System.out.println(arrayList);
    }

    void getMiddleGrade(ArrayList<String> arrayList, HashMap<String, String> hashMapPass, HashMap<String, String> hashMapNames) {
        String textPassword = password();
        String textName = name();
        int counterGrade = 0, counter = 0;
        if (hashMapPass.containsKey(textPassword) && hashMapNames.containsKey(textPassword)) {
            for (String textArrayList : arrayList) {
                if (textArrayList.contains(textPassword) && textArrayList.contains(textName)) {
                    int indexGrade = textArrayList.indexOf("оценка") + "оценка".length()+1;
                    int grade = Integer.parseInt(textArrayList.substring(indexGrade));
                    counterGrade = counterGrade + grade;
                    counter++;
                }
            }
            System.out.println("Средняя оценка студента "+textName+" равна = "+counterGrade/counter);
        }
    }
}
