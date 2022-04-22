package interview;

/**
 * @author andrew
 * @create 2022-04-01 0:50
 */


import java.util.*;
public class Main {
    public static void main(String args[]) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] height = new int[n];
        for(int i = 0; i < n; i++){
            height[i] = sc.nextInt();
        }

        int[] height2 = new int[n - 1];
        for(int i = 0; i < n - 1; i++){
            height2[i] = height[i + 1];
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> board = new LinkedList<>();
        get(res, board, height2);

        for(List list : res){
            int oneResult = 0;
            for(int i = 1; i < n; i++){
                height[i] = (Integer) list.get(i - 1);
            }

        }


    }

    public static void get(List<List<Integer>> res, LinkedList<Integer> board, int[] nums){
        if(board.size() == nums.length){
            res.add(new LinkedList<>(board));
            return;
        }

        for(int num : nums){
            if(board.contains(num)){
                continue;
            }
            board.add(num);
            get(res, board, nums);
            board.removeLast();
        }
    }
}

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        String s = "";
//        int result = 0;
//        List<Integer> bList = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> rList = new ArrayList<>();
//
//        while (sc.hasNext()){
//            for(int i = 0; i < n; i++){
//                nums[i] = sc.nextInt();
//            }
//            s = sc.next();
//
//            for(int i = 0; i < s.length(); i++){
//                if(s.charAt(i) == 'B'){
//                    Integer count = map.get(nums[i]);
//                    if(count == null){
//                        map.put(nums[i], 1);
//                    }else{
//                        map.put(nums[i], count + 1);
//                    }
//                }else{
//                    rList.add(nums[i]);
//                }
//            }
//
//            int bLength = bList.size();
//            int rLength = rList.size();
//
//
//            for(Map.Entry<Integer, Integer> entry : map){
//                int oneResult = 0;
//                for(int i = 0; i < rLength; i++){
//                    if(entry.getKey() == rList.get(i)){
//                        oneResult++;
//                    }
//                }
//                result += 1;
//            }
//        }
//
//        System.out.println(result);
//    }
//}

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        String s = "";
//        int result = 0;
//        List<Integer> bList = new ArrayList<>();
//        List<Integer> rList = new ArrayList<>();
//
//        while (sc.hasNext()){
//            for(int i = 0; i < n; i++){
//                nums[i] = sc.nextInt();
//            }
//            s = sc.next();
//
//            for(int i = 0; i < s.length(); i++){
//                if(s.charAt(i) == 'B'){
//                    bList.add(nums[i]);
//                }else{
//                    rList.add(nums[i]);
//                }
//            }
//
//            int bLength = bList.size();
//            int rLength = rList.size();
//
//            for(int i = 0; i < bLength; i++){
//                for (int j = 0; j < rLength; j++){
//                    if(bList.get(i) == rList.get(j)){
//                        result++;
//                    }
//                }
//            }
//        }
//
//        System.out.println(result);
//    }
//}

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        String s = "";
//        int result = 0;
//
//        while (sc.hasNext()){
//            for(int i = 0; i < n; i++){
//                nums[i] = sc.nextInt();
//            }
//            s = sc.next();
//
//            for(int i = 0; i < n; i++){
//                for(int j = i + 1; j < n; j++){
//                    if(nums[i] == nums[j] && s.charAt(i) != s.charAt(j)){
//                        result++;
//                    }
//                }
//            }
//        }
//
//        System.out.println(result);
//    }
//}

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        //前3n行
//        for(int i = 0; i < 3 * n; i++){
//
//            for(int j = 0; j < n; j++){
//                System.out.print("*");
//            }
//            for(int j = 0; j < 2 * n; j++){
//                System.out.print(".");
//            }
//            for(int j = 0; j < n; j++){
//                System.out.print("*");
//            }
//
//            System.out.println();
//        }
//
//        for(int i = 3 * n; i < 4 * n; i++){
//
//            for(int j = 0; j < i - 3 * n + 1; j++){
//                System.out.print(".");
//            }
//            for(int j = 0; j < n; j++){
//                System.out.print("*");
//            }
//            for(int j = 0; j < 2 * (4 * n - 1 - i); j++){
//                System.out.print(".");
//            }
//            for(int j = 0; j < n; j++){
//                System.out.print("*");
//            }
//            for(int j = 0; j < i - 3 * n + 1; j++){
//                System.out.print(".");
//            }
//
//            System.out.println();
//        }
//    }
//}

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
