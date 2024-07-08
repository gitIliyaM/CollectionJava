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
        if(scan.equals("�������") || scan.equals("�������")) {
            mainMenu();
            catalog.setCatalogMenu();
            catalog.setCatalogGoods(cmsAdmin, shopCart);
        } else if(scan.equals("������ �������") || scan.equals("������ �������")) {
            mainMenu();
            personalAccount.setUserLKMenu();
            personalAccount.setUserEntry();
        } else if(scan.equals("�������") || scan.equals("�������")) {
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
        System.out.println("�������� � �������� ������ �� ����!");
        System.out.println("���������� ������� - ������ ����� - X");
        System.out.println("���� � cms - �����: �����");
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
                case 10   : System.out.print("�������");break;
                case 20   : System.out.print("������ �������");break;
                case 30   : System.out.print("�������");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    static void setDataCMS(AdminCMS cmsAdmin){
        System.out.println("���� � CMS ����� (������: �����)");
        System.out.println("������� ������ ��� �������� - ���");
        String orPasswordStop = new Scanner(System.in).nextLine();
        if(orPasswordStop.equals("�����")){
            do {
                System.out.println("���������� ���� ������ - �� ��� ���");
                orPasswordStop = new Scanner(System.in).nextLine();

                switch (orPasswordStop){
                    case "��","��","��" : cmsAdmin.setDataCMS();
                }

                switch (orPasswordStop){
                    case "���","���","���" :
                        String deleteYesOrNo = scannerYesOrNo(); // "������� ������ �� ���� ������ - �� ��� ���?"
                        while(yesYep(deleteYesOrNo)){
                            if(!cmsAdmin.checkDataCMS()){
                                break;
                            } else {
                                cmsAdmin.deleteDataCMS();
                            }
                        }
                }
            } while (noNot(orPasswordStop)); // !orPasswordStop.equals("���")
        } else if(noNot(orPasswordStop)){
                System.out.println("����� �� ���������� ������, ��������� ���� ������!");
                setDataCMS(cmsAdmin);
        }
    }
    static boolean yesYep(String deleteYesOrNo){
        if(deleteYesOrNo.equals("��") || deleteYesOrNo.equals("��") || deleteYesOrNo.equals("��")){
            return true;
        } else {
            return false;
        }
    }
    static boolean noNot(String orPasswordStop){
        if(!orPasswordStop.equals("���") && !orPasswordStop.equals("���") && !orPasswordStop.equals("���")){
            return true;
        } else {
            return false;
        }
    }
    static String scannerYesOrNo(){
        System.out.println("������� ������ �� ���� ������ - �� ��� ���?");
        Scanner scanner = new Scanner(System.in);
        String deleteYesOrNo = scanner.nextLine();
        return deleteYesOrNo;
    }
}
