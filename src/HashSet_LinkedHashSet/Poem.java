package HashSet_LinkedHashSet;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Poem {
    String poem = "Анализ стихотворения «Я помню чудное мгновенье» Пушкина. \n" +
            "\n" +
            "Первые строки стихотворения «Я помню чудное мгновенье» известны практически каждому. Это одно из самых известных лирических произведений Пушкина. Поэт был очень влюбчивым человеком, и многие свои стихи посвящал женщинам. В 1819 г. он познакомился с А. П. Керн, которая на долгое время захватила его воображение. В 1825 г., во время ссылки поэта в Михайловском, состоялась вторая встреча поэта с Керн. Под влиянием этой неожиданной встречи Пушкин и написал стихотворение «Я помню чудное мгновенье». \n" +
            "\n" +
            "Короткое произведение является образцом поэтического признания в любви. Всего в нескольких строфах Пушкин разворачивает перед читателем долгую историю взаимоотношений с Керн. Выражение «гений чистой красоты» очень емко характеризует восторженное преклонение перед женщиной. Поэт влюбился с первого взгляда, но Керн во время первой встречи была замужем и не могла ответить на ухаживания поэта. Образ прекрасной женщины преследует автора. Но судьба на несколько лет разлучает Пушкина с Керн. Эти бурные годы стирают из памяти поэта «милые черты». \n" +
            "\n" +
            "Ссылка за недозволенные стихи в Михайловское тяжело действует на поэта. Его угнетает не отрыв от столичной жизни, к которой он испытывал только презрение. Главной проблемой Пушкина «во мраке заточенья» был отрыв от привычного творческого общества, отсутствие возможности поделиться с кем-нибудь своими замыслами. Внезапно он узнает, что в соседнем Тригорском поместье находится А. Керн. Александр спешит к ней. Керн благосклонно встречает поэта. Для Пушкина эта встреча стала спасительным лучом надежды. В его душе вновь просыпаются «и жизнь, и слезы, и любовь». \n" +
            "\n" +
            "В стихотворении «Я помню чудное мгновенье» Пушкин показывает себя великим мастером слова. Он обладал удивительной способностью сказать о бесконечно многом всего лишь в нескольких строках. В небольшом стихе перед нами предстает промежуток в несколько лет. Несмотря на сжатость и простоту слога автор доносит до читателя перемены в своем душевном настроении, позволяет пережить радость и печаль вместе с ним. \n" +
            "\n" +
            "Стихотворение написано в жанре чистой любовной лирики. Эмоциональное воздействие усилено лексическими повторами нескольких фраз. Их точная расстановка придает произведению свою неповторимость и изящество. \n" +
            "\n" +
            "Творческое наследие великого Александра Сергеевича Пушкина огромно. «Я помню чудное мгновенье» — одна из самых дорогих жемчужин этого сокровища.";
    String pathFile = "C:\\Users\\30.07.2018\\Desktop\\www\\Poem.rtf";
    Poem(){
        printToFile();
        try {
            readFromFile();
        } catch (IOException e){
            System.out.println(e);
            System.out.println("Проблема с чтением из файла");
        }
    }
    void printToFile(){
        try{
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(pathFile,true)),true);
        printWriter.write(poem);
        printWriter.close();
        } catch (IOException e){
            System.out.println(e);
            System.out.println("Проблема с файлом");
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
                case '«', '»', '.', '—', ',': text = text.replace(chars,' ');break;
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
        System.out.println("-------ArrayList - отсортирован !");

        System.out.println("-------HashSet<String> hashSet = new HashSet<>();----------");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(arrayList);
        System.out.println(hashSet);
        System.out.println("-------HashSet - отсортирован !");

        System.out.println("-------LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();----------");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(arrayList);
        System.out.println(linkedHashSet);
        System.out.println("-------LinkedHashSet - отсортирован !");

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
                System.out.println("Слово/буква - "+words+" - повторялось: "+ count+" раз");
                System.out.println();
                System.out.println("Кол-во уникальных слов: "+hashSet.size());
                System.out.println();
                System.out.println("Кол-во не уникальных слов: "+counter);
                System.out.println();
            }
        }
    }
}
