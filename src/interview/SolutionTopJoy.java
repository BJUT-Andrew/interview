package interview;

/**
 * @author andrew
 * @create 2021-12-06 14:52
 */
public class SolutionTopJoy {
    public String fun(String str, String subStr) {

        String res = "";

        int n = str.length();
        int m = subStr.length();

        //先找到子串位置
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int k = 0;
            for (; j < n && k < m; ) {
                if (str.charAt(j) == subStr.charAt(k)) {
                    j++;
                    k++;
                } else {
                    break;
                }
            }

            if (k == m) {
                start = i;
                end = j - 1;
            }
        }

        char[] strToArray = str.toCharArray();
        //先将字符串全部翻转
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            swap(strToArray, i, j);
        }

        //翻转后的子串位置
        start = n - start;
        end = n - end;

        //翻转子串
        for (int i = end, j = start; i < j; i++, j--) {
            swap(strToArray, i, j);
        }

        for (int i = 0; i < n; i++) {
            res += strToArray[i];
        }

        return res;
    }

    private void swap(char[] strToArray, int i, int j) {
        char temp = strToArray[i];
        strToArray[i] = strToArray[j];
        strToArray[j] = temp;
    }
}
