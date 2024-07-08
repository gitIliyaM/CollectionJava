package SortedMapNavigableMapTreeMap;

import java.util.Scanner;

public class MainInetMag {
    public static void main(String[] args) {
        mainMenu();
        CatalogInetMag catalog = new CatalogInetMag();
        AccountInetMag personalAccount = new AccountInetMag();
        ShopCartInetMag shopCart = new ShopCartInetMag();
        AdminCMS cmsAdmin = new AdminCMS();
        String scan=scanner();
        if(scan.equals("Каталог") || scan.equals("каталог")) {
            mainMenu();
            catalog.setCatalogMenu();
            catalog.setCatalogGoods(cmsAdmin, shopCart);
        } else if(scan.equals("Личный кабинет") || scan.equals("личный кабинет")) {
            mainMenu();
            personalAccount.setUserLKMenu();
            personalAccount.setUserEntry();
        } else if(scan.equals("Корзина") || scan.equals("корзина")) {
            mainMenu();
            shopCart.setBasketMenu();
            shopCart.setMainTableBasket(cmsAdmin);
        } else {
            setDataCMS(cmsAdmin);
            mainMenu();
        }
    }
    static String scanner(){
        System.out.println();
        System.out.println("Выберите и напишите раздел из Меню!");
        System.out.println("прекратить покупку - ввести букву - X");
        System.out.println("Вход в cms - логин: админ");
        String scanner = new Scanner(System.in).nextLine();
        return scanner;
    }
    static void mainMenu(){
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,44 : System.out.print("|");break;
                case 10   : System.out.print("Каталог");break;
                case 20   : System.out.print("Личный кабинет");break;
                case 30   : System.out.print("Корзина");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    static void setDataCMS(AdminCMS cmsAdmin){
        System.out.println("Вход в CMS сайта (пароль: админ)");
        System.out.println("Введите пароль или напишите - Нет");
        String orPasswordStop = new Scanner(System.in).nextLine();
        if(orPasswordStop.equals("админ")){
            do {
                System.out.println("Продолжить ввод данных - Да или Нет");
                orPasswordStop = new Scanner(System.in).nextLine();

                switch (orPasswordStop){
                    case "Да","да","ДА" : cmsAdmin.setDataCMS();
                }

                switch (orPasswordStop){
                    case "Нет","нет","НЕТ" :
                        String deleteYesOrNo = scannerYesOrNo(); // "Удалить товары из базы банных - Да или Нет?"
                        while(yesYep(deleteYesOrNo)){
                            if(!cmsAdmin.checkDataCMS()){
                                break;
                            } else {
                                cmsAdmin.deleteDataCMS();
                            }
                        }
                }
            } while (noNot(orPasswordStop)); // !orPasswordStop.equals("Нет")
        } else if(noNot(orPasswordStop)){
                System.out.println("Ввели не правильный пароль, повторите ввод пароля!");
                setDataCMS(cmsAdmin);
        }
    }
    static boolean yesYep(String deleteYesOrNo){
        if(deleteYesOrNo.equals("Да") || deleteYesOrNo.equals("да") || deleteYesOrNo.equals("ДА")){
            return true;
        } else {
            return false;
        }
    }
    static boolean noNot(String orPasswordStop){
        if(!orPasswordStop.equals("Нет") && !orPasswordStop.equals("нет") && !orPasswordStop.equals("НЕТ")){
            return true;
        } else {
            return false;
        }
    }
    static String scannerYesOrNo(){
        System.out.println("Удалить товары из базы банных - Да или Нет?");
        Scanner scanner = new Scanner(System.in);
        String deleteYesOrNo = scanner.nextLine();
        return deleteYesOrNo;
    }
}
