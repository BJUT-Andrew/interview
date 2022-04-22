package interview;

import org.junit.Test;

import javax.swing.text.html.HTML;
import java.util.*;

/**
 * @author andrew
 * @create 2021-11-30 10:16
 */
public class Solution {

    public int mySqrt(int x) {
        int l = 0, r = x;
        int res = 1;
        while (l <= r) {

            int mid = (l + r) / 2;

            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int jiaoXiaoIndex = n - 1;
        int i = n - 1;
        for (; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                jiaoXiaoIndex = i - 1;
                break;
            }
        }

        if (i == 0) {
            reverse(nums, 0, n - 1);
        }

        int jiaoDaIndex = n - 1;
        for (i = n - 1; i > jiaoXiaoIndex; i--) {
            if (nums[i] > nums[jiaoXiaoIndex]) {
                jiaoDaIndex = i;
                break;
            }
        }

        swap(nums, jiaoXiaoIndex, jiaoDaIndex);
        reverse(nums, jiaoXiaoIndex, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testNextPermutation() {
        nextPermutation(new int[]{1, 2, 3});

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        while(sc.hasNext()){
            num += sc.nextInt();
        }
        System.out.println(num);
    }

    public int maximumProduct(int[] nums) {

        int n = nums.length;
        //min1表示数组中最小的元素，min2表示数组中第2小的元素；
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        //max1表示数组中最大的元素，max2表示数组中第2大的元素，max3表示数组中第3大的元素
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[2];
            }

            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public boolean isPalindrome(String s) {
        int m = s.length();
        s = s.toLowerCase();
        int i = 0, j = m - 1;
        while (i < j) {
            while (i < j && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 0 && s.charAt(i) <= 9))) {
                i++;
            }
            while (i < j && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 0 && s.charAt(j) <= 9))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String reverseWords(String s) {

        int n = s.length();
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            if (sb.toString() != "") {
                stack.push(sb.toString());
            }
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            if (stack.size() != 1) {
                result += (stack.pop() + " ");
            }
        }

        return result;
    }

    @Test
    public void testReverseWords() {
        System.out.println(reverseWords("the sky is blue"));
    }

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0 || n == 0) {
            return "";
        }

        int[] need = new int[128];
        for (int i = 0; i < n; i++) {
            need[t.charAt(i)]++;
        }

        int l = 0, r = 0, needCount = n, curMinSize = Integer.MAX_VALUE, curMinStart = 0;
        while (r < m) {
            while (r < m && needCount > 0) {
                if (need[s.charAt(r)] > 0) {
                    needCount--;
                }
                need[s.charAt(r)]--;
                r++;
            }

            if (needCount == 0) {
                if (r - l + 1 < curMinSize) {
                    curMinSize = r - l;
                    curMinStart = l;
                }

                while (l < r && needCount == 0) {
                    if (need[s.charAt(l)] == 0) {
                        needCount++;
                    }
                    need[s.charAt(l)]++;
                    l++;
                }
            }
        }

        return curMinSize == Integer.MAX_VALUE ? "" : s.substring(curMinStart, curMinStart + curMinSize);
    }

    @Test
    public void testMinWindow() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test() {
        String str = "2222";
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        //将链表从中间断开
        ListNode fast = dummyHead, slow = dummyHead;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        //翻转后面一半链表
        head2 = reverseList(head2);

        //依次比较前半段链表和反转后的后半段链表
        ListNode curr1 = head, curr2 = head2;
        while(curr1 != null && curr2 != null){
            if(curr1.val != curr2.val){
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;

    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    @Test
    public void testIsPalindrome(){
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println(isPalindrome(head));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = nums1[0] == nums2[0] ? 1 : 0;
                }else if(i == 0){
                    dp[i][j] = nums1[i] == nums2[j] ? dp[i][j - 1] + 1 : dp[i][j - 1];
                }else if(j == 0){
                    dp[i][j] = nums1[i] == nums2[j] ? dp[i - 1][j] + 1 : dp[i - 1][j];
                }else{
                    dp[i][j] = nums1[i] == nums2[j] ? dp[i - 1][j - 1] + 1 : Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
                dp[i][j] = Math.min(dp[i][j], Math.min(i, j) + 1);
            }
        }

        return dp[m - 1][n - 1];
    }

    @Test
    public void testFindLength(){
        System.out.println(findLength(new int[]{0,1,1,1,1}, new int[]{1,0,1,0,1}));
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int result = 1;
        for(int i = 0; i < n; i++){
            int x = nums[i];
            int curResult = 1;
            //优化，如果set中存在nums[i] - 1，则答案肯定不是以nums[i]为起始的
            if(set.contains(x - 1)){
                continue;
            }

            while(set.contains(x + 1)){
                x++;
                curResult++;
            }

            result = Math.max(result, curResult);
        }

        return result;
    }

    @Test
    public void testLongestConsecutive(){
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int[] sortArray(int[] nums) {
        heapify(nums);

        int n = nums.length;

        for(int i = n - 1; i >= 0; i--){
            swap(nums, 0, i);
            siftdown(nums, 0, i - 1);
        }

        return nums;
    }

    private void heapify(int[] nums){
        int n = nums.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            siftdown(nums, i, n - 1);
        }
    }

    private void siftdown(int[] nums, int k, int heapEnd){
        while(2 * k + 1 <= heapEnd){
            int j = 2 * k + 1;
            if(j + 1 <= heapEnd && nums[j + 1] > nums[j]){
                j++;
            }

            if(nums[j] > nums[k]){
                swap(nums, k, j);
                k = j;
            }else{
                break;
            }
        }
    }

    @Test
    public void testHeapSortArray(){
        sortArray(new int[]{1,3,5,2,4,2});
    }

    private boolean isShuiXianHua(int i){
        int i1 = i % 10;
        int i2 = i / 10 % 10;
        int i3 = i / 100;

        return i == Math.pow(i1, 3) + Math.pow(i2, 3) + Math.pow(i3, 3);
    }

    @Test
    public void testIsShuiXianHua(){
        System.out.println(isShuiXianHua(222));
    }


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> oneRes = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        used = new boolean[n];
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int begin){
        //1.递归终止条件；
        if(begin == nums.length){
            res.add(new ArrayList<>(oneRes));
            return;
        }

        //2.for 选择 in 选择列表：
        for(int i = 0; i < nums.length; i++){
            //3.选择；
            if(!used[i]){
                oneRes.add(nums[i]);
                used[i] = true;

                //4.递归进入下一层；
                dfs(nums, begin + 1);

                //5.撤销选择；
                oneRes.remove(oneRes.size() - 1);
                used[i] = false;
            }
        }
    }

    @Test
    public void testPermute(){
        System.out.println(permute(new int[]{1,2,3}));
    }

    public int reverse(int x) {
        int result = 0;

        while(x > 0){
            //每次取x的最后一位
            int temp = x % 10;
            x /= 10;

            //★改变result之前判断，改变后是否会越界★
            if(result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10){
                return 0;
            }

            result = result * 10 + temp;
        }

        return result;
    }

    @Test
    public void testReverse(){
        System.out.println(reverse(-123));
    }

    public void moveZeroes(int[] nums) {
        int nextNotZeroIndex = 0;
        boolean hasMetZero = false;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                hasMetZero = true;
            }
            if(nums[i] != 0 && hasMetZero){
                nextNotZeroIndex = i;
                break;
            }
        }

        int i = 0;
        while(i < n){
            if(nums[i] == 0){
                swap(nums, i, nextNotZeroIndex);
                i = nextNotZeroIndex;
                for(int j = nextNotZeroIndex; j < n; j++){
                    if(nums[j] != 0){
                        nextNotZeroIndex = j;
                        break;
                    }
                }
            }else{
                i++;
            }
        }
    }

    @Test
    public void testMoveZeroes(){
        moveZeroes(new int[]{0, 1, 0, 3, 12});

        StringBuilder sb = new StringBuilder();
    }

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = s.length();

        while(i < n){
            char c = s.charAt(i);

            //1.字母和'['入栈；
            if(Character.isLetter(c) || c == '['){
                stack.push(c + "");
                i++;
                //2.遇到数字，将相邻数字也记录下来一起入栈，直到'['
            }else if(Character.isDigit(c)){
                StringBuilder num = new StringBuilder();
                while(Character.isDigit(s.charAt(i))){
                    num.append(s.charAt(i));
                    i++;
                }
                stack.push(num.toString());
                //3.遇']'，出栈拼接
            }else{
                //获取[]内的字符串
                i++;
                StringBuilder temp = new StringBuilder();
                while(!"[".equals(stack.peek())){
                    temp.append(stack.pop());
                }
                temp = temp.reverse();
                String oneResult = temp.toString();
                //[出栈
                stack.pop();
                //取当前字符串的重复次数
                int repeatTime = Integer.parseInt(stack.pop());
                //重复repeatTime次，再入栈
                temp = new StringBuilder();
                while(repeatTime != 0){
                    temp.append(oneResult);
                    repeatTime--;
                }
                stack.push(temp.toString());
            }
        }

        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    @Test
    public void testDecodeString(){
        String string = decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
    }

//    public int calculate(String s) {
//        Stack<Integer> nums = new Stack<>();
//        Stack<Character> ops = new Stack<>();
//        int n = s.length();
//
//        int i = 0;
//        while(i < n){
//            char c = s.charAt(i);
//            if(c == ' '){
//                i++;
//            }else if(c >= '0' && c <= '9'){
//                int num = 0;
//                while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
//                    num = num * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                nums.push(num);
//            }else if(c == '('){
//                ops.push(c);
//                i++;
//            }else if(c == ')'){
//                while(ops.peek() != '('){
//                    cacl(nums, ops);
//                }
//                ops.pop();
//                i++;
//            }else{
//                while(!ops.isEmpty() && ops.peek() != '('){
//                    cacl(nums, ops);
//                }
//                ops.push(c);
//                i++;
//            }
//        }
//
//        while(!ops.isEmpty()){
//            cacl(nums, ops);
//        }
//        return nums.pop();
//    }
//
//    private void cacl(Stack<Integer> nums, Stack<Character> ops){
//        if(nums.size() < 2 || ops.isEmpty()){
//            return;
//        }
//
//        int num1 = nums.pop();
//        int num2 = nums.pop();
//        char op = ops.pop();
//
//        int result = op == '+' ? num2 + num1 : num2 - num1;
//        nums.push(result);
//    }

//    public int calculate(String s) {
//        Stack<Integer> nums = new Stack<>();
//        //① 解决s的首个字符为'-'
//        nums.push(0);
//        Stack<Character> ops = new Stack<>();
//        int n = s.length();
//
//        //运算符优先级
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('+', 1);
//        map.put('-', 1);
//        map.put('*', 2);
//        map.put('/', 2);
//
//        int i = 0;
//        while(i < n){
//            char c = s.charAt(i);
//            if(c == ' '){
//                i++;
//            }else if(c >= '0' && c <= '9'){
//                int num = 0;
//                while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
//                    num = num * 10 + (s.charAt(i) - '0');
//                    i++;
//                }
//                nums.push(num);
//            }else if(c == '('){
//                ops.push(c);
//                i++;
//                //② 解决'('后第一个字符为'-'
//                if(s.charAt(i) == '-'){
//                    nums.push(0);
//                }
//            }else if(c == ')'){
//                while(ops.peek() != '('){
//                    cacl(nums, ops);
//                }
//                ops.pop();
//                i++;
//            }else{
//                while(!ops.isEmpty() && ops.peek() != '('){
//                    if(map.get(ops.peek()) >= map.get(c)){
//                        cacl(nums, ops);
//                    }else{
//                        break;
//                    }
//                }
//                ops.push(c);
//                i++;
//            }
//        }
//
//        while(!ops.isEmpty()){
//            cacl(nums, ops);
//        }
//        return nums.pop();
//    }
//
//    private void cacl(Stack<Integer> nums, Stack<Character> ops){
//        if(nums.size() < 2 || ops.isEmpty()){
//            return;
//        }
//
//        int num1 = nums.pop();
//        int num2 = nums.pop();
//        char op = ops.pop();
//
//        //计算时，注意操作数先后顺序
//        int result = 0;
//        switch(op){
//            case '+':
//                result = num2 + num1;
//            case '-':
//                result = num2 - num1;
//            case '*':
//                result = num2 * num1;
//            case '/':
//                result = num2 / num1;
//        }
//        nums.push(result);
//    }
//
//    @Test
//    public void caclTest(){
//        calculate("3+2*2");
//    }





    //1 7 5 11   12
    public static List<Integer> solution(int[] nums, int target){
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        //map存储(nums[i], i)
        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < n; i++){
            if (map.get(target - nums[i]) != null && map.get(target - nums[i]) != i){
                res.add(i);
                res.add(map.get(target - nums[i]));
                return res;
            }
        }

        return res;
    }

    @Test
    public void testSolution(){
        List<Integer> result = solution(new int[]{1, 7, 6, 11}, 12);
        for(Integer i : result){
            System.out.println(i);
        }

    }










}
