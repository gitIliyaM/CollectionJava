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
        System.out.println("Введите артикул из 7 букв, наименование из 12 букв, цену товара из 6 букв");

        String article = getArticle();

        if(checkArticle(SortedMapArticle,article)){
            SortedMapArticle.put(article,article);

            String name = getName();
            String price = getPrice();

            hashMapName.put(article,name);
            hashMapPrice.put(article,price);
        } else {
            System.out.println("Введенный артикул в базе существует, введите новый");
            setDataCMS();
        }
    }
    boolean checkDataCMS(){
        if(SortedMapArticle.isEmpty()){
            System.out.println("База артикулов пустая!");
            return false;
        } else {
            return true;
        }
    }
    void deleteDataCMS(){
        System.out.println("Введите артикул из 7 букв");
        String article = getArticle();
        SortedMapArticle.remove(article);
    }
    String getArticle() {
        System.out.println("Артикул:");
        String article = new Scanner(System.in).nextLine();
        while(article.length()>7){
            System.out.println("Длина артикула больше 7 букв повторите ввод");
            article = getArticle();
        }
        while(article.equals("")){
            System.out.println("Не ввели артикул повторите ввод");
            article = getArticle();
        }
        return article;
    }
    String getName(){
        System.out.println("Наименование:");
        String name = new Scanner(System.in).nextLine();
        while(name.length()>12){
            System.out.println("Длина слова больше 12 букв повторите ввод");
            name = getName();
        }
        while(name.equals("")){
            System.out.println("Не ввели слово повторите ввод");
            name = getName();
        }
        return name;
    }
    String getPrice(){
        System.out.println("Цена:");
        String price = new Scanner(System.in).nextLine();
        while(price.length()>6){
            System.out.println("Длина цены больше 6 цифр повторите ввод");
            price = getPrice();
        }
        while(price.equals("")){
            System.out.println("Не ввели цену повторите ввод");
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
