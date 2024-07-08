package HashSet_LinkedHashSet;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Poem {
    String poem = "������ ������������� �� ����� ������ ��������� �������. \n" +
            "\n" +
            "������ ������ ������������� �� ����� ������ ��������� �������� ����������� �������. ��� ���� �� ����� ��������� ���������� ������������ �������. ���� ��� ����� ��������� ���������, � ������ ���� ����� �������� ��������. � 1819 �. �� ������������ � �. �. ����, ������� �� ������ ����� ��������� ��� �����������. � 1825 �., �� ����� ������ ����� � ������������, ���������� ������ ������� ����� � ����. ��� �������� ���� ����������� ������� ������ � ������� ������������� �� ����� ������ ���������. \n" +
            "\n" +
            "�������� ������������ �������� �������� ������������ ��������� � �����. ����� � ���������� ������� ������ ������������� ����� ��������� ������ ������� ��������������� � ����. ��������� ������ ������ �������� ����� ���� ������������� ������������ ����������� ����� ��������. ���� �������� � ������� �������, �� ���� �� ����� ������ ������� ���� ������� � �� ����� �������� �� ���������� �����. ����� ���������� ������� ���������� ������. �� ������ �� ��������� ��� ��������� ������� � ����. ��� ������ ���� ������� �� ������ ����� ������ ������. \n" +
            "\n" +
            "������ �� ������������� ����� � ������������ ������ ��������� �� �����. ��� �������� �� ����� �� ��������� �����, � ������� �� ��������� ������ ���������. ������� ��������� ������� ��� ����� ���������� ��� ����� �� ���������� ����������� ��������, ���������� ����������� ���������� � ���-������ ������ ���������. �������� �� ������, ��� � �������� ���������� �������� ��������� �. ����. ��������� ������ � ���. ���� ������������ ��������� �����. ��� ������� ��� ������� ����� ������������ ����� �������. � ��� ���� ����� ����������� �� �����, � �����, � �������. \n" +
            "\n" +
            "� ������������� �� ����� ������ ��������� ������ ���������� ���� ������� �������� �����. �� ������� ������������ ������������ ������� � ���������� ������ ����� ���� � ���������� �������. � ��������� ����� ����� ���� ��������� ���������� � ��������� ���. �������� �� �������� � �������� ����� ����� ������� �� �������� �������� � ����� �������� ����������, ��������� �������� ������� � ������ ������ � ���. \n" +
            "\n" +
            "������������� �������� � ����� ������ �������� ������. ������������� ����������� ������� ������������ ��������� ���������� ����. �� ������ ����������� ������� ������������ ���� �������������� � ���������. \n" +
            "\n" +
            "���������� �������� �������� ���������� ���������� ������� �������. �� ����� ������ ��������� � ���� �� ����� ������� �������� ����� ���������.";
    String pathFile = "C:\\Users\\30.07.2018\\Desktop\\www\\Poem.rtf";
    Poem(){
        printToFile();
        try {
            readFromFile();
        } catch (IOException e){
            System.out.println(e);
            System.out.println("�������� � ������� �� �����");
        }
    }
    void printToFile(){
        try{
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(pathFile,true)),true);
        printWriter.write(poem);
        printWriter.close();
        } catch (IOException e){
            System.out.println(e);
            System.out.println("�������� � ������");
        }
    }
    void readFromFile() throws IOException{
        String stringText;

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));

        while ((stringText = bufferedReader.readLine()) != null){
            stringBuilder.append(stringText);
        }
        String text = stringBuilder.toString();
        getWords(text);
    }
    void getWords(String text){
        int length = text.length();

        for(int i = 0; i < length; i++){
            char chars = text.charAt(i);
            switch (chars){
                case '�', '�', '.', '�', ',': text = text.replace(chars,' ');break;
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();
        String[] arrayText = text.split(" ");

        for(String word : arrayText){
            if(arrayList.contains("")){
                arrayList.remove(word);
            } else {
                arrayList.add(word);
            }
        }
        checkWords(arrayList);
    }
    void checkWords(ArrayList<String> arrayList){
        String firstWord, secondWord, words="";
        System.out.println("-------ArrayList<String> arrayListCopy = arrayList;----------");
        ArrayList<String> arrayListCopy = arrayList;
        Collections.sort(arrayListCopy);
        System.out.println(arrayListCopy);
        System.out.println("-------ArrayList - ������������ !");

        System.out.println("-------HashSet<String> hashSet = new HashSet<>();----------");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(arrayList);
        System.out.println(hashSet);
        System.out.println("-------HashSet - ������������ !");

        System.out.println("-------LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();----------");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(arrayList);
        System.out.println(linkedHashSet);
        System.out.println("-------LinkedHashSet - ������������ !");

        int l = arrayListCopy.size();
        int counter=0;
        for(int i = 0; i < l; i++){
            int count=0;
            firstWord = arrayListCopy.get(i);
            for(int j = i + 1; j < l; j++){
                secondWord = arrayListCopy.get(j);
                if(firstWord.equals(secondWord)){
                    words = firstWord;
                    count++;
                    i = j;
                }
            }
            counter = counter +count;
            if(count>0){
                System.out.println("�����/����� - "+words+" - �����������: "+ count+" ���");
                System.out.println();
                System.out.println("���-�� ���������� ����: "+hashSet.size());
                System.out.println();
                System.out.println("���-�� �� ���������� ����: "+counter);
                System.out.println();
            }
        }
    }
}
