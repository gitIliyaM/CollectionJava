package ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//import static java.util.Comparator.*;


public class MainComparableComparator {
    public static void main(String[] args) {
        int[] intInt = new int[]{0,5,2,8,4,1,7,6,9,3};
        int positive=0, negative=1;
        ArrayList<Integer> arrayListPos = new ArrayList<>();
        ArrayList<Integer> arrayListOd = new ArrayList<>();

        for(int i=0; i<intInt.length; i++){
            arrayListPos.add(intInt[i]);
        }
        for(int i=0; i<arrayListPos.size(); i++){
            int x = arrayListPos.get(i);
            if(x % 2 == 0){
                Collections.sort(arrayListPos);
            } else {
                arrayListOd.add(x);
                arrayListPos.remove(i);
                arrayListOd.sort(Comparator.reverseOrder());
                //Collections.sort(arrayListOd,Comparator.reverseOrder());
            }
        }
        for(Integer integer : arrayListOd){
            arrayListPos.add(integer);
        }
        System.out.println(arrayListPos);
    }


}
//  0 1 2 3 4 5 6 7 8 9