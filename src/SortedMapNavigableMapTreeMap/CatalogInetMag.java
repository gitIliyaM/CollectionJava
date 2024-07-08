package SortedMapNavigableMapTreeMap;

import java.util.*;

public class CatalogInetMag {
    // убрал hashMapGoods - вместо нее вызываю - shopCart.getHashMapAddedGoods()
    // getTableGoods(hashMapArticle, hashMapName, hashMapPrice, shopCart.getHashMapAddedGoods())

    //HashMap<String,String> hashMapGoods = new HashMap<>();

    /*Catalog(){
        MainInterface.mainMenu();
    }*/
    void setCatalogMenu(){
        System.out.println();
        for(int i=0; i<70; i++){
            switch (i){
                case 0,55 : System.out.print("|");break;
                case 25   : System.out.print("Каталог товаров");break;
                default   : System.out.print(" ");
            }
        }
        System.out.println();
        setSubCatalogMenu();
        System.out.println();
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
    void setSubCatalogMenu(){
        for(int i=0; i<70; i++){
            switch (i){
                case 0,32 : System.out.print("|");break;
                case 5   : System.out.print("Артикул");break;
                case 13   : System.out.print("Наименование");break;
                case 21   : System.out.print("Цена");break;
                case 28   : System.out.print("Добавить в корзину");break;
                default   : System.out.print(" ");
            }
        }
    }
    void setCatalogGoods(AdminCMS cmsAdmin, ShopCartInetMag shopCart){
        SortedMap<String,String> SortedMapArticle = cmsAdmin.getSortedMapArticle();
        HashMap<String,String> hashMapName = cmsAdmin.getMapName();
        HashMap<String,String> hashMapPrice = cmsAdmin.getMapPrice();


        System.out.println();
        if(SortedMapArticle.isEmpty()){
            for(int i=0; i<70; i++){
                if(i==0 || i==41){
                    System.out.print("|");
                }
                else if(i==20){
                    System.out.print("товары не добавлены в каталог");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            for(int i=0; i<70; i++){
                System.out.print("-");
            }
        } else if (shopCart.getTreeMapAddedGoods().isEmpty()) {
            for (String keys : cmsAdmin.getSortedMapArticle().keySet()) {
                String valueKey = cmsAdmin.getSortedMapArticle().get(keys);
                shopCart.getTreeMapAddedGoods().put(valueKey, "Товар не добавлен!");
            }
            getTableGoods(SortedMapArticle, hashMapName, hashMapPrice, shopCart.getTreeMapAddedGoods());
            shopCart.setGoodsBasket(cmsAdmin);
        } else{
            getTableGoods(SortedMapArticle, hashMapName, hashMapPrice, shopCart.getTreeMapAddedGoods());
            shopCart.setGoodsBasket(cmsAdmin);
            shopCart.setBasketGoods(cmsAdmin);
        }
    }
    void getTableGoods(SortedMap<String,String> hashMapArticle,HashMap<String,String> hashMapName, HashMap<String,String> hashMapPrice, NavigableMap<String,String> NavigableMapAddGoods){

        // в цикле for-each в выражении () указывать без типа Set - for (Map.Entry<String,String> setMapArticleName: hashMapArticleName.entrySet())
        // вне цикла for-each указывать тип Set - Set<Map.Entry<String,String>> setMapArticleName =  hashMapArticleName.entrySet();

        // в цикле for-each в выражении () указывать без типа Set - for (String key = hashMapArticleName.keySet())
        // аналогично для джинерик Строка - Set<String> key = hashMapArticleName.keySet();

        /* Set<Map.Entry<String,String>> setMapArticleName =  hashMapArticleName.entrySet();
           Set<Map.Entry<String,Integer>> sethMapArticlePrice =  hashMapArticlePrice.entrySet(); */
        String article = "",
               name = "",
               price = "";



        ArrayList<String> arrayArticles = new ArrayList<>();
        ArrayList<String> arrayNames = new ArrayList<>();
        ArrayList<String> arrayPrices = new ArrayList<>();
        ArrayList<String> arrayAddedGoods = new ArrayList<>();

        for(String articles: hashMapArticle.keySet()) {
            article = hashMapArticle.get(articles);
            arrayArticles.add(article);
            }
        for(String names: hashMapName.keySet()){
            name = hashMapName.get(names);
            arrayNames.add(name);
            }
        for(String prices: hashMapPrice.keySet()){
            price = hashMapPrice.get(prices);
            arrayPrices.add(price);
            }
        for(String addedGoods: NavigableMapAddGoods.keySet()){
            addedGoods = NavigableMapAddGoods.get(addedGoods);
            arrayAddedGoods.add(addedGoods);
        }

        int length = arrayArticles.size();
        int lItems;
        for(int j=0; j<length; j++){
            // минусы это для цикла for он начинается с 0, чтобы не смог войти в оператор if
            int counterName = -1,
                counterPrice = -1,
                counterBasket = -1,
                counterEnd = -1;
            //System.out.println();
            for(int i=0; i<70; i++){
                if(i==0){
                    System.out.print("|");
                } else if(i==5){ // необходимо убрать одно тире, чтобы все слова вставали в одну вертикальную линию можно без этого,
                    // но придется вкладывать оператор if в if и так далее, получится не очень удобно читать
                    System.out.print("");
                } else {
                    System.out.print(" ");
                }
                if(i==5){
                    lItems = arrayArticles.get(j).length();
                    lItems = 7-lItems;    // разница между = размер поля (Артикул) для слова и введенное слова
                    counterName = lItems+i+7; // фиксация нового(следующего) слова - в поле Наименование.
                    // Слово в поле артикул встает на 5 позиции,
                    // поле Артикул размер = 7, разница между поле Артикул и словом дает нам пустые ячейки в не зависимости
                    // от длины слов в поле Артикул, остается добавить эту разницу = размер поле Артикул - размер слова в этом поле
                    // к позиции самого слова это = 5, плюс считаем ячейки от поля Артикул до поля Наименование = 7
                    // складываем все эти значения = получается фиксация в поле Наименование. Для остальных слов аналогичные расчеты.
                    System.out.print(arrayArticles.get(j));
                }
                if(counterName==i){
                    System.out.print(arrayNames.get(j));
                    lItems = arrayNames.get(j).length();
                    lItems = 12-lItems;
                    counterPrice = lItems+counterName+7;
                }
                if(counterPrice==i){
                    System.out.print(arrayPrices.get(j));
                    lItems = arrayPrices.get(j).length();
                    lItems = 6-lItems;
                    counterBasket = lItems+counterPrice+4;
                }
                if(counterBasket==i) {

                    String value = arrayArticles.get(j);
                    // первый вариант
                    if(NavigableMapAddGoods.size()!=0){
                        for(Map.Entry<String,String> entry: NavigableMapAddGoods.entrySet()){
                            String key = entry.getKey();
                            String added = entry.getValue();
                            if(value.equals(key)){
                                System.out.print(added);
                                break;
                            }
                        }
                    }
                    /*if(!hashMapAddGoods.isEmpty()){
                        if(hashMapAddGoods.containsKey(value)){
                            System.out.print(hashMapAddGoods.get(value));
                        } else {
                            System.out.print("Товар не добавлен!");
                        }
                    } else {
                        System.out.print("Товар не добавлен!");
                    }*/

                    /*if(hashMapAddGoods.containsKey(value)){
                        System.out.print("Товар добавлен!   ");
                    } else {
                        System.out.print("Товар не добавлен!");
                    }*/
                    // второй вариант
                    counterEnd = counterBasket + 3;
                }
                if(counterEnd==i){

                    System.out.print("|");
                    break;
                }
            } System.out.println();
        }
        for(int i=0; i<70; i++){
            System.out.print("-");
        }
    }
}
