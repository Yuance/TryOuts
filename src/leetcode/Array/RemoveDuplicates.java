package leetcode.Array;
import java.util.*;
import java.util.stream.Stream;

public class RemoveDuplicates {

    public static void main(String[] args){
        int[] nums1 = new int[3];
        int[] nums2 = new int[3];
        for (int i = 0; i < nums1.length; i++){
            nums1[i] = 5-i;
            nums2[i] = 6-i;
        }
        int count = 0;
        int[][] nums3 = new int[4][4];
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                nums3[i][j] = count++;
            }
        }
//        System.out.println(containDuplicate(nums));
        rotateMattix(nums3);
        System.out.println(Arrays.toString(nums3));
    }


    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] != nums[i + 1]) {
                count++;
                nums[count] = nums[i + 1];
            }
        }
        return count + 1;
    }

    public int maxProfit(int[] prices) {

        int i = 0;
        int profit = 0;
        int buy_price = 0, sell_price = 0;
        while (i < prices.length - 1) {
            //find buy price
            while (prices[i] >= prices[i + 1] && i < prices.length - 2) {
                i++;
            }
            buy_price = prices[i];
            while (prices[i] < prices[i + 1] && i < prices.length - 2) {
                i++;
            }
            if (prices[i] < prices[i + 1])
                sell_price = prices[i + 1];
            else
                sell_price = prices[i];
            profit += sell_price - buy_price;
            i++;
        }
        return profit;
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    public static boolean containDuplicate(int[] nums) {

        Set<Integer> h = new HashSet<>();
        boolean result = false;
        for (int num : nums) {
            if (!h.contains(num))
                h.add(num);
            else {
                result = true;
                break;
            }
        }
        return result;
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums){
            result ^= num;
        }
        return result;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] > nums2[j])
                j++;
            else if (nums2[j] == nums1[i]) {
                arr.add(nums1[i]);
                i++;
                j++;
            } else i++;
        }

        int[] result = new int[arr.size()];
        for (i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
    public int[] plusOne(int[] digits) {

        int [] new_digit = new int[digits.length];
        for (int i = digits.length - 1; i > -1 ; i--) {

            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0)
                return digits;
            if (digits[i] == 0 && i == 0)
                new_digit = move(digits);
        }
        return new_digit;
    }

    private int[] move(int[] digit){

        int[] new_digits = new int[digit.length + 1];
        new_digits[0] = 1;
        System.arraycopy(digit, 0,new_digits, 1, digit.length);
//        for (int i = 0; i < digit.length; i++) {
//            new_digits[i + 1] = digit[i];
//        }
        return new_digits;
    }

    public void moveZeroes(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0){
                count++;
                continue;
            }

            else nums[i - count] = nums[i];
        }
        for (int i = nums.length - 1; i > -1; i--) {

            if (count == 0)
                return;
            nums[i] = 0;
            count--;
        }
        return;
    }

    public int[] twoSum(int[] nums, int target) {

        int j = 0;
        int[] result = new int[2];
        int goal = 0;
        for (int i = 0; i < nums.length; i++){
            j = i;
            result[0] = i;
            goal = target - nums[i];
            while (j < nums.length) {
                if (nums[j] == goal) {
                    result[1] = j;
                    return result;
                }
                j++;
            }
        }
        return result;
    }
    public int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> ValueIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (ValueIndex.containsKey(target - nums[i]))
                return new int[]{i, ValueIndex.get(target - nums[i])};
            else
                ValueIndex.put(nums[i], i);
        }

        return new int[0];
    }

    public boolean isValidSudoku(char[][] board) {

        return CheckLine(board) && CheckColumn(board) && CheckGrid(board);

    }

    public boolean CheckLine(char[][] board){

        HashSet<Character> h = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            h.clear();
            for (int j = 0; j < 9; j++){
                if (h.contains(board[i][j]))
                    return false;
                else if (board[i][j] != '.'){
                    h.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public boolean CheckColumn(char[][] board){

        HashSet<Character> h = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            h.clear();
            for (int i = 0; i < 9; i++){
                if (h.contains(board[i][j]))
                    return false;
                else if (board[i][j] != '.'){
                    h.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public boolean CheckGrid(char[][] board){

        return CheckSmallGrid(0,0,board) &&
                CheckSmallGrid(0,3,board) &&
                CheckSmallGrid(0,6,board) &&
                CheckSmallGrid(3,0,board) &&
                CheckSmallGrid(3,3,board) &&
                CheckSmallGrid(3,6,board) &&
                CheckSmallGrid(6,0,board) &&
                CheckSmallGrid(6,3,board) &&
                CheckSmallGrid(6,6,board);
    }

    public boolean CheckSmallGrid(int a, int b, char[][] board) {

        HashSet<Character> h = new HashSet<>();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++){

                if (h.contains(board[a+i][b+j]))
                    return false;
                else if (board[a+i][b+j] != '.'){
                    h.add(board[a+i][b+j]);
                }
            }
        }
        return true;
    }

    public static void rotateMattix(int[][] matrix) {

        int iter;
        int n = matrix.length;
        iter = n - 1;

        int prev_value, temp;
        int[] start = new int[]{0,0};
        int[] next = new int[]{0,0};
        int[] cur;

        for (int i = 0; i < iter; i++){
            for (int j = i; j <= iter - i - 1; j++) {
                start[0] = i; start[1] = j;
                next[0] = j; next[1] = n - i - 1;
                prev_value = GetMatrix(matrix,start);
                do {
                    temp = GetMatrix(matrix, next);
                    SetMatrix(matrix, next, prev_value);
                    cur = Arrays.copyOf(next,2);
                    transform(next,n);
                    prev_value = temp;
                } while (!Arrays.equals(start, cur));
            }
        }
    }
    public static int GetMatrix(int[][] matrix, int[] pos) {
        return matrix[pos[0]][pos[1]];
    }
    public static void SetMatrix(int[][] matrix, int[] pos, int value){
        matrix[pos[0]][pos[1]] = value;
    }
    public static void transform(int[] pos, int n) {
        int temp;
        temp = pos[1];
        pos[1] = n - pos[0] - 1;
        pos[0] = temp;
    }
}