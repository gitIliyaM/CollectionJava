package SortedMapNavigableMapTreeMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class AdminCMS {
    SortedMap<String,String> SortedMapArticle = new TreeMap<>();
    HashMap<String,String> hashMapName = new HashMap<>();
    HashMap<String,String> hashMapPrice = new HashMap<>();

    void setDataCMS(){
        System.out.println("������� ������� �� 7 ����, ������������ �� 12 ����, ���� ������ �� 6 ����");

        String article = getArticle();

        if(checkArticle(SortedMapArticle,article)){
            SortedMapArticle.put(article,article);

            String name = getName();
            String price = getPrice();

            hashMapName.put(article,name);
            hashMapPrice.put(article,price);
        } else {
            System.out.println("��������� ������� � ���� ����������, ������� �����");
            setDataCMS();
        }
    }
    boolean checkDataCMS(){
        if(SortedMapArticle.isEmpty()){
            System.out.println("���� ��������� ������!");
            return false;
        } else {
            return true;
        }
    }
    void deleteDataCMS(){
        System.out.println("������� ������� �� 7 ����");
        String article = getArticle();
        SortedMapArticle.remove(article);
    }
    String getArticle() {
        System.out.println("�������:");
        String article = new Scanner(System.in).nextLine();
        while(article.length()>7){
            System.out.println("����� �������� ������ 7 ���� ��������� ����");
            article = getArticle();
        }
        while(article.equals("")){
            System.out.println("�� ����� ������� ��������� ����");
            article = getArticle();
        }
        return article;
    }
    String getName(){
        System.out.println("������������:");
        String name = new Scanner(System.in).nextLine();
        while(name.length()>12){
            System.out.println("����� ����� ������ 12 ���� ��������� ����");
            name = getName();
        }
        while(name.equals("")){
            System.out.println("�� ����� ����� ��������� ����");
            name = getName();
        }
        return name;
    }
    String getPrice(){
        System.out.println("����:");
        String price = new Scanner(System.in).nextLine();
        while(price.length()>6){
            System.out.println("����� ���� ������ 6 ���� ��������� ����");
            price = getPrice();
        }
        while(price.equals("")){
            System.out.println("�� ����� ���� ��������� ����");
            price = getPrice();
        }
        return price;
    }
    boolean checkArticle(SortedMap<String,String> hashMapArticle, String article){
        if(hashMapArticle.containsKey(article)){
            return false;
        } else {
            return true;
        }
    }
    SortedMap<String, String> getSortedMapArticle(){
        return SortedMapArticle;
    }
    HashMap<String, String> getMapName(){
        return hashMapName;
    }
    HashMap<String, String> getMapPrice(){
        return hashMapPrice;
    }
}
