package interview;

/**
 * @author andrew
 * @create 2022-04-01 0:50
 */

import java.util.*;
public class Main {
    public static void main(String args[]) {
        int n;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            int[] nums = new int[n];
            int result = 0;
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }

            for(int i = 1; i < n; i++){
                if(nums[i] < nums[i - 1]){
                    nums[i] = nums[i - 1] + 1;
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}

//import java.util.*;
//public class Main{
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n, m, a, b;
//        while(sc.hasNext()){
//            n = sc.nextInt();
//            m = sc.nextInt();
//            a = sc.nextInt();
//            b = sc.nextInt();
//
//            int minWeight = Integer.MAX_VALUE, maxWeight = Integer.MIN_VALUE;
//            int[] weight = new int[m];
//            for(int i = 0; i < m; i++){
//                weight[i] = sc.nextInt();
//                if(weight[i] < minWeight){
//                    minWeight = weight[i];
//                }
//                if(weight[i] > maxWeight){
//                    maxWeight = weight[i];
//                }
//            }
//
//            if(minWeight < Math.min(a, b) || maxWeight > Math.max(a, b)){
//                System.out.println("NO");
//                continue;
//            }
//
//            if(maxWeight == Math.max(a, b) && minWeight == Math.min(a, b)){
//                System.out.println("YES");
//            }else if((maxWeight == Math.max(a, b) || minWeight == Math.min(a, b)) && n - m >= 1){
//                System.out.println("YES");
//            }else if((maxWeight != Math.max(a, b) || minWeight != Math.min(a, b)) && n - m >= 2){
//                System.out.println("YES");
//            }else{
//                System.out.println("NO");
//            }
//        }
//    }
//}

//import javafx.scene.media.SubtitleTrack;
//import org.junit.Test;
//
//import java.util.*;
//public class Main{
//
//    List<String> result = new ArrayList<>();
//
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        String biaoYu = "";
//        String heXinSiXiang = "";
//
//        while(sc.hasNext()){
//            biaoYu = sc.next();
//            heXinSiXiang = sc.next();
//            int result = 0;
//
//            List<String> allSubStrings = getAllSubStrings(biaoYu);
//            for(String subString : allSubStrings){
//                if(isZiXuLie(subString, heXinSiXiang)){
//                    result++;
//                }
//            }
//
//            System.out.println(result);
//        }
//    }
//
//
//    private static boolean isZiXuLie(String s, String sub){
//        int m = s.length();
//        int n = sub.length();
//
//        if(n > m){
//            return false;
//        }
//
//        int i = 0, j = 0;
//        while(i < m && j < n){
//            if(s.charAt(i) == sub.charAt(j)){
//                i++;
//                j++;
//            }else{
//                i++;
//            }
//        }
//
//        if(j == n){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//
//    private static List<String> getAllSubStrings(String s){
//        List<String> allSubStrings = new ArrayList<>();
//        for(int i = 0; i < s.length(); i++){
//            for (int j = i + 1; j < s.length() + 1; j++){
//                allSubStrings.add(s.substring(i, j));
//            }
//        }
//        return allSubStrings;
//    }
//}
