package HashMap;

import java.util.Scanner;

public class MainHashMap {
    public static void main(String[] args) {
        HashMaps hashMaps = new HashMaps();

        for(String textYesOrNo = textBegin(); !textYesOrNo.equals("���"); textYesOrNo = textBegin()){

            hashMaps.setHashMapNames();
            hashMaps.getHashMaps();

        }
    }
    static String textBegin(){
        System.out.println("���������� �������� ������, ��� � ������");
        System.out.println("������ ������� ������ ���������? �� ��� ���");
        String scanner = new Scanner(System.in).nextLine();
        return scanner;
    }
    static String textMiddleGrade(){
        System.out.println("������� ������� ������ ��������? �� ��� ���");
        String scanner = new Scanner(System.in).nextLine();
        return scanner;
    }
}
