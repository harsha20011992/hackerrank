/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author harsha-1916
 */
public class HackerRankAlgoPart2 {

    /**
     *
     * Lily likes to play games with integers and their reversals. For some
     * integer , we define to be the reversal of all digits in . For example, ,
     * , and .
     *
     * Logan wants to go to the movies with Lily on some day satisfying , but he
     * knows she only goes to the movies on days she considers to be beautiful.
     * Lily considers a day to be beautiful if the absolute value of the
     * difference between and is evenly divisible by .
     *
     * Given , , and , count and print the number of beautiful days when Logan
     * and Lily can go to the movies.
     *
     * Input Format
     *
     * A single line of three space-separated integers describing the respective
     * values of , , and .
     *
     * Constraints
     *
     * Output Format
     *
     * Print the number of beautiful days in the inclusive range between and .
     *
     * Sample Input
     *
     * 20 23 6 Sample Output
     *
     * 2
     * Explanation
     *
     * Logan wants to go to the movies on days , , , and . We perform the
     * following calculations to determine which days are beautiful:
     *
     * Day is beautiful because the following evaluates to a whole number: Day
     * is not beautiful because the following doesn't evaluate to a whole
     * number: Day is beautiful because the following evaluates to a whole
     * number: Day is not beautiful because the following doesn't evaluate to a
     * whole number: Only two days, and , in this interval are beautiful. Thus,
     * we print as our answer.
     */
    public static void beautifulDay(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        int counter = 0;
        for (int iter = i; iter <= j; iter++) {
            int rev = reverse(iter);
            int sub = rev - iter;

            if (sub < 0) {
                sub = -1 * sub;
            }
            //System.out.println(" rev: " + rev + " iter: " + iter + " sub: " + sub);
            if (sub % k == 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static int reverse(int iter) {
        int rev = 0;
        int i = 10;
        while (iter > 0) {
            //System.out.println("i: " + i + " rev: " + rev + " iter: " + iter);
            int digit = (int) iter % 10;
            rev = rev * i + digit;

            //i = 10;
            iter = iter / 10;
            //System.out.println("i: " + i + " rev: " + rev + " iter: " + iter);
        }
        return rev;
    }

    /**
     *
     * HackerLand Enterprise is adopting a new viral advertising strategy. When
     * they launch a new product, they advertise it to exactly people on social
     * media.
     *
     * On the first day, half of those people (i.e., ) like the advertisement
     * and each person shares it with of their friends; the remaining people
     * (i.e., ) delete the advertisement because it doesn't interest them. So,
     * at the beginning of the second day, people receive the advertisement.
     *
     * On the second day, half of the people who received the advertisement
     * share it with new friends. So, at the beginning of the third day, people
     * receive the advertisement. The diagram below depicts the advertisement's
     * virality over the first three days (green denotes a person that likes the
     * advertisement and red denotes a person that disliked and deleted it):
     *
     * strange ad.png
     *
     * Assume that at the beginning of the day, people received the
     * advertisement, people like and share it with new friends, and people
     * dislike and delete it. At the beginning of the day, people receive the
     * advertisement.
     *
     * Given an integer, , find and print the total number of people who liked
     * HackerLand Enterprise's advertisement during the first days. It is
     * guaranteed that no two people have any friends in common and, after a
     * person shares the advertisement with a friend, the friend always sees it
     * the next day.
     *
     * Input Format
     *
     * A single integer, , denoting a number of days.
     *
     * Constraints
     *
     * Output Format
     *
     * Print the number of people who liked the advertisement during the first
     * days.
     *
     * Sample Input
     *
     * 3
     * Sample Output
     *
     * 9
     * Explanation
     *
     * This example is depicted by the diagram at the top of the challenge.
     * people liked the advertisement on the first day, people liked the
     * advertisement on the second day and people liked the advertisement on the
     * third day, so the answer is .
     */
    public static void advertisement(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int init = 5;
        int currDay = init / 2;
        int sum = currDay;
        for (int i = 2; i <= n; i++) {
            currDay = (currDay * 3) / 2;
            sum += currDay;
        }
        System.out.println(sum);
    }

    /**
     * A jail has prisoners, and each prisoner has a unique id number, , ranging
     * from to . There are sweets that must be distributed to the prisoners.
     *
     * The jailer decides the fairest way to do this is by sitting the prisoners
     * down in a circle (ordered by ascending ), and then, starting with some
     * random , distribute one candy at a time to each sequentially numbered
     * prisoner until all candies are distributed. For example, if the jailer
     * picks prisoner , then his distribution order would be until all sweets
     * are distributed.
     *
     * But wait—there's a catch—the very last sweet is poisoned! Can you find
     * and print the ID number of the last prisoner to receive a sweet so he can
     * be warned?
     *
     * Input Format
     *
     * The first line contains an integer, , denoting the number of test cases.
     * The subsequent lines each contain space-separated integers: (the number
     * of prisoners), (the number of sweets), and (the prisoner ID),
     * respectively.
     *
     * Constraints
     *
     * Output Format
     *
     * For each test case, print the ID number of the prisoner who receives the
     * poisoned sweet on a new line.
     *
     * Sample Input 0
     *
     * 2
     * 5 2 1
     * 5 2 2
     * Sample Output 0
     *
     * 2
     * 3
     * Explanation 0
     *
     * In first query, there are prisoners and sweets. Distribution starts at ID
     * number , so prisoner gets the first sweet and prisoner gets the second
     * (last) sweet. Thus, we must warn prisoner about the poison, so we print
     * on a new line.
     *
     *
     */
    static int saveThePrisoner(int n, int m, int s) {
        // Complete this function
        return ((s - 1 + (m - 1)) % n) + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }

    /**
     * John Watson performs an operation called a right circular rotation on an
     * array of integers, . After performing one right circular rotation
     * operation, the array is transformed from to .
     *
     * Watson performs this operation times. To test Sherlock's ability to
     * identify the current element at a particular position in the rotated
     * array, Watson asks queries, where each query consists of a single
     * integer, , for which you must print the element at index in the rotated
     * array (i.e., the value of ).
     *
     * Input Format
     *
     * The first line contains space-separated integers, , , and , respectively.
     * The second line contains space-separated integers, where each integer
     * describes array element (where ). Each of the subsequent lines contains a
     * single integer denoting .
     *
     * Constraints
     *
     * Output Format
     *
     * For each query, print the value of the element at index of the rotated
     * array on a new line.
     *
     * Sample Input 0
     *
     * 3 2 3
     * 1 2 3
     * 0
     * 1
     * 2
     * Sample Output 0
     *
     * 2
     * 3
     * 1
     * Explanation 0
     *
     * After the first rotation, the array becomes . After the second (and
     * final) rotation, the array becomes .
     *
     * Let's refer to the array's final state as array . For each query, we just
     * have to print the value of on a new line:
     *
     * , so we print on a new line. , so we print on a new line. , so we print
     * on a new line.
     *
     *
     */
    public static void arrayRotation(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        for (int a0 = 0; a0 < q; a0++) {
            int m = in.nextInt();
            int newIndex = (n + m - (k % n)) % n;
            System.out.println(a[newIndex]);
        }
    }
    /*
     You are given a sequence of  integers, . Each element in the sequence is distinct and satisfies . For each  where , find any integer  such that  and print the value of  on a new line.

     Input Format

     The first line contains an integer, , denoting the number of elements in the sequence. 
     The second line contains  space-separated integers denoting the respective values of .

     Constraints

     , where .
     Each element in the sequence is distinct.
     Output Format

     For each  from  to , print an integer denoting any valid  satisfying the equation  on a new line.

     Sample Input 0

     3
     2 3 1
     Sample Output 0

     2
     3
     1
     Explanation 0

     Given the values of , , and , we calculate and print the following values for each  from  to :

     , so we print the value of  on a new line.
     , so we print the value of  on a new line.
     , so we print the value of  on a new line.
     */

    public static void sequenceFunction(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            int pn = sc.nextInt();
            p[pn - 1] = i;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(p[p[i]] + 1);
        }
    }

    /**
     *
     * Aerith is playing a cloud game! In this game, there are clouds numbered
     * sequentially from to . Each cloud is either an ordinary cloud or a
     * thundercloud.
     *
     * Aerith starts out on cloud with energy level . She can use unit of energy
     * to make a jump of size to cloud , and she jumps until she gets back to
     * cloud . If Aerith lands on a thundercloud, her energy () decreases by
     * additional units. The game ends when Aerith lands back on cloud .
     *
     * Given the values of , , and the configuration of the clouds, can you
     * determine the final value of after the game ends?
     *
     * Note: Recall that refers to the modulo operation.
     *
     * Input Format
     *
     * The first line contains two space-separated integers, (the number of
     * clouds) and (the jump distance), respectively. The second line contains
     * space-separated integers describing the respective values of clouds .
     * Each cloud is described as follows:
     *
     * If , then cloud is an ordinary cloud. If , then cloud is a thundercloud.
     * Constraints
     *
     * Output Format
     *
     * Print the final value of on a new line.
     *
     * Sample Input
     *
     * 8 2
     * 0 0 1 0 0 1 1 0
     * Sample Output
     *
     * 92 Explanation
     *
     * In the diagram below, red clouds are thunderclouds and purple clouds are
     * ordinary clouds:
     *
     * game board
     *
     * Observe that our thunderclouds are the clouds numbered , , and . Aerith
     * makes the following sequence of moves:
     *
     * Move: , Energy: . Move: , Energy: . Move: , Energy: . Move: , Energy: .
     * Thus, we print as our answer.
     */
    public static void clouds(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int energy = 100;
        int currCloud = 0;
        boolean isFirstTime = true;
        while (currCloud != 0 || isFirstTime) {
            currCloud = (currCloud + k) % n;
            energy--;
            if (c[currCloud] == 1) {
                energy -= 2;
            }
            isFirstTime = false;
        }
        System.out.println(energy);
    }

    /**
     * Given an integer, , traverse its digits (1,2,...,n) and determine how
     * many digits evenly divide (i.e.: count the number of times divided by
     * each digit i has a remainder of ). Print the number of evenly divisible
     * digits.
     *
     * Note: Each digit is considered to be unique, so each occurrence of the
     * same evenly divisible digit should be counted (i.e.: for , the answer is
     * ).
     *
     * Input Format
     *
     * The first line is an integer, , indicating the number of test cases. The
     * subsequent lines each contain an integer, .
     *
     * Constraints *
     *
     * Output Format
     *
     * For every test case, count and print (on a new line) the number of digits
     * in that are able to evenly divide .
     *
     * Sample Input
     *
     * 2
     * 12 1012 Sample Output
     *
     * 2
     * 3
     * Explanation
     *
     * The number is broken into two digits, and . When is divided by either of
     * those digits, the calculation's remainder is ; thus, the number of
     * evenly-divisible digits in is .
     *
     * The number is broken into four digits, , , , and . is evenly divisible by
     * its digits , , and , but it is not divisible by as division by zero is
     * undefined; thus, our count of evenly divisible digits is .
     *
     *
     */
    public static void evenlyDivisibleDigit(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();

            int counter = 0;
            int ntemp = n;
            while (ntemp > 0) {
                int digit = ntemp % 10;
                if (digit != 0) {
                    if (n % digit == 0) {
                        counter++;
                    }
                }
                ntemp = ntemp / 10;
            }
            System.out.println(counter);
        }

    }

    /*You are given an integer . Print the factorial of this number.

     Input 
     Input consists of a single integer , where .

     Output 
     Print the factorial of .

     Example 
     For an input of , you would print .

     Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.

     We recommend solving this challenge using BigIntegers.
        
     */
    public static void bigIntegerSum(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger bigInt = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            bigInt = bigInt.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigInt);
    }

    /**
     *
     * You have a string, , of lowercase English alphabetic letters. You can
     * perform two types of operations on :
     *
     * Append a lowercase English alphabetic letter to the end of the string.
     * Delete the last character in the string. Performing this operation on an
     * empty string results in an empty string. Given an integer, , and two
     * strings, and , determine whether or not you can convert to by performing
     * exactly of the above operations on . If it's possible, print Yes;
     * otherwise, print No.
     *
     * Input Format
     *
     * The first line contains a string, , denoting the initial string. The
     * second line contains a string, , denoting the desired final string. The
     * third line contains an integer, , denoting the desired number of
     * operations.
     *
     * Constraints
     *
     * and consist of lowercase English alphabetic letters. Output Format
     *
     * Print Yes if you can obtain string by performing exactly operations on ;
     * otherwise, print No.
     *
     * Sample Input 0
     *
     * hackerhappy hackerrank 9 Sample Output 0
     *
     * Yes Explanation 0
     *
     * We perform delete operations to reduce string to hacker. Next, we perform
     * append operations (i.e., r, a, n, and k), to get hackerrank. Because we
     * were able to convert to by performing exactly operations, we print Yes.
     */
    public static void stringAppend(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();

        int counter = 0;
        boolean isDeleteNeeded = false;
        int delIndex = getDeleteIndex(s, t);
        counter += (s.length() - delIndex);

        if (s.length() - counter != t.length()) {
            int append = t.length() - (s.length() - counter);
            counter += append;
        }

        if (counter == k) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isDeletedNeeded(String s, String t) {
        return !s.equals(t);
    }

    private static int getDeleteIndex(String s, String t) {
        int index = 0;

        while (index < s.length() && index < t.length() && s.charAt(index) == t.charAt(index)) {
            index++;
        }
        return index;
    }

    /*
     Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:

     If the book is returned on or before the expected return date, no fine will be charged (i.e.: .
     If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
     If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
     If the book is returned after the calendar year in which it was expected, there is a fixed fine of .
     Input Format

     The first line contains  space-separated integers denoting the respective , , and  on which the book was actually returned. 
     The second line contains  space-separated integers denoting the respective , , and  on which the book was expected to be returned (due date).

     Constraints

     Output Format

     Print a single integer denoting the library fine for the book received as input.

     Sample Input

     9 6 2015
     6 6 2015
     Sample Output

     45
     Explanation

     Given the following return dates: 
     Actual:  
     Expected: 

     Because , we know it is less than a year late. 
     Because , we know it's less than a month late. 
     Because , we know that it was returned late (but still within the same month and year).

     Per the library's fee structure, we know that our fine will be . We then print the result of  as our output.
    
     */
    public static void libraryFine(String[] args) {
        Scanner in = new Scanner(System.in);
        int da = in.nextInt();
        int ma = in.nextInt();
        int ya = in.nextInt();
        int de = in.nextInt();
        int me = in.nextInt();
        int ye = in.nextInt();
        int fine = 0;
        if (ya > ye) {
            fine = 10000;
        } else if (ya == ye && ma > me) {
            fine = 500 * (ma - me);
        } else if (ya == ye && ma == me && da > de) {
            fine = 15 * (da - de);
        }

        System.out.println(fine);
    }

    /**
     *
     * You are given sticks, where the length of each stick is a positive
     * integer. A cut operation is performed on the sticks such that all of them
     * are reduced by the length of the smallest stick.
     *
     * Suppose we have six sticks of the following lengths:
     *
     * 5 4 4 2 2 8
     * Then, in one cut operation we make a cut of length 2 from each of the six
     * sticks. For the next cut operation four sticks are left (of non-zero
     * length), whose lengths are the following: * 3 2 2 6 The above step is
     * repeated until no sticks are left.
     *
     * Given the length of sticks, print the number of sticks that are left
     * before each subsequent cut operations.
     *
     * Note: For each cut operation, you have to recalcuate the length of
     * smallest sticks (excluding zero-length sticks).
     *
     * Input Format The first line contains a single integer . The next line
     * contains integers: a0, a1,...aN-1 separated by space, where represents
     * the length of the stick.
     *
     * Output Format For each operation, print the number of sticks that are
     * cut, on separate lines.
     *
     * Constraints
     *
     * Sample Input 0
     *
     * 6
     * 5 4 4 2 2 8
     * Sample Output 0
     *
     * 6
     * 4
     * 2
     * 1
     * Sample Input 1
     *
     * 8
     * 1 2 3 4 3 3 2 1
     * Sample Output 1
     *
     * 8
     * 6
     * 4
     * 1
     * Explanation
     *
     * Sample Case 0 :
     *
     * sticks-length length-of-cut sticks-cut 5 4 4 2 2 8 2 6 3 2 2 _ _ 6 2 4 1
     * _ _ _ _ 4 1 2 _ _ _ _ _ 3 3 1 _ _ _ _ _ _ DONE DONE Sample Case 1
     *
     * sticks-length length-of-cut sticks-cut 1 2 3 4 3 3 2 1 1 8 _ 1 2 3 2 2 1
     * _ 1 6 _ _ 1 2 1 1 _ _ 1 4 _ _ _ 1 _ _ _ _ 1 1 _ _ _ _ _ _ _ _ DONE DONE
     */
    public static void cutTheSticks(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] <= 0) {
                continue;
            }
            int cutCount = 0;
            for (int j = i + 1; j < n; j++) {
                cutCount++;
                arr[j] = arr[j] - arr[i];
            }
            System.out.println(cutCount + 1);
        }
        if (arr[n - 1] > 0) {
            System.out.println(1);
        }

    }

    /*
     Given a set, , of  distinct integers, print the size of a maximal subset, , of  where the sum of any  numbers in  is not evenly divisible by .

     Input Format

     The first line contains  space-separated integers,  and , respectively. 
     The second line contains  space-separated integers (we'll refer to the  value as ) describing the unique values of the set.

     Constraints

     All of the given numbers are distinct.
     Output Format

     Print the size of the largest possible subset ().

     Sample Input

     4 3
     1 7 2 4
     Sample Output

     3
     Explanation

     The largest possible subset of integers is , because no two integers will have a sum that is evenly divisible by :

     , and  is not evenly divisible by .
     , and  is not evenly divisible by .
     , and  is not evenly divisible by .
     The number  cannot be included in our subset because it will produce an integer that is evenly divisible by when summed with any of the other integers in our set:

     , and .
     , and .
     , and .
     Thus, we print the length of  on a new line, which is . 
     */
    static int max = 0;

    public static void divisibleSetUneffectiveSol(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        boolean b[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            b[i] = false;
        }
        findAllSubsets(a, b, 0, k);
        System.out.println(max);
    }

    private static void checkifSumIsDivByK(boolean[] b, int[] a, int k) {
        int size = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                size++;
            }
        }

        int c[] = new int[size];

        for (int i = 0, c_i = 0; i < b.length; i++) {
            if (b[i]) {
                c[c_i] = a[i];
                c_i++;
            }
        }
        boolean isNotDivisble = true;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = c[i] + c[j];
                if (sum % k == 0) {
                    isNotDivisble = false;
                    break;
                }
            }
        }

        if (isNotDivisble && size > max) {
            max = size;
        }
    }

    private static void findAllSubsets(int[] a, boolean[] b, int i, int k) {
        if (i == a.length) {
            /*System.out.println("Printing subset");
             for(int j=0;j<a.length;j++){
             if(b[j]){
             System.out.print(a[j] + " ");
             }
             }*/
            checkifSumIsDivByK(b, a, k);
            return;
        } else {
            b[i] = true;
            findAllSubsets(a, b, i + 1, k);
            b[i] = false;
            findAllSubsets(a, b, i + 1, k);
        }
    }

    private static void setSum() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < n;++i) {
            arr[i] = scan.nextInt();
        }
        int[] cnts = new int[k];
        for (int i = 0;i < k;++i) {
            cnts[i] = 0;
        }
        for (int i = 0;i < n;++i) {
            cnts[arr[i] % k] += 1;
        }
        int cnt = cnts[0] < 1 ? cnts[0] : 1;
        for (int i = 1;i < k/ 2 + 1; ++i) {
            if (i != k - i) {
                cnt += cnts[i] > cnts[k - i] ? cnts[i] : cnts[k - i];
            }
        }
        if (k% 2 == 0) {
            cnt += 1;
        }

        System.out.println(cnt);
    }
    
    
    /**
     * Given a set, , of  distinct integers, print the size of a maximal subset, , of  where the sum of any  numbers in  is not evenly divisible by .

Input Format

The first line contains  space-separated integers,  and , respectively. 
The second line contains  space-separated integers (we'll refer to the  value as ) describing the unique values of the set.

Constraints

All of the given numbers are distinct.
Output Format

Print the size of the largest possible subset ().

Sample Input

4 3
1 7 2 4
Sample Output

3
Explanation

The largest possible subset of integers is , because no two integers will have a sum that is evenly divisible by :

, and  is not evenly divisible by .
, and  is not evenly divisible by .
, and  is not evenly divisible by .
The number  cannot be included in our subset because it will produce an integer that is evenly divisible by when summed with any of the other integers in our set:

, and .
, and .
, and .
Thus, we print the length of  on a new line, which is .
     */
    
    public static void nonDivisibleSet() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //System.out.println(k);
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            a[i] = a[i]%k;
        }
        int karr[] = new int[k];
        for(int i=0;i<k;i++){
            karr[i] =0;
        }
        //System.out.println(k);
        for(int i=0;i<n;i++){
            karr[a[i]]++;
        }
        /*for(int i=0;i<k;i++){
          System.out.print(karr[i] + " ");
        }*/
         //System.out.println();
        int result =0;
        
        result += Math.min(karr[0],1);
         //System.out.println(k);
        for(int i=1;i<=k/2;i++){
            if(i != k-i){
                result += Math.max(karr[i],karr[k-i]);
            }
        }
        //System.out.println(k);
        if(k%2 == 0){
            //System.out.println((k/2) + 1);
            
            if(k==2){
                result += Math.min(karr[(k/2)],1);
            }else{
    
            result += Math.min(karr[(k/2) + 1],1);
            }
            }
        System.out.println(result);
    }
    
    
    /*
    Lilah has a string, , of lowercase English letters that she repeated infinitely many times.

Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

Input Format

The first line contains a single string, . 
The second line contains an integer, .

Constraints

For  of the test cases, .
Output Format

Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.

Sample Input 0

aba
10
Sample Output 0

7
Explanation 0 
The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.

Sample Input 1

a
1000000000000
Sample Output 1

1000000000000
Explanation 1 
Because all of the first  letters of the infinite string are a, we print  on a new line.
    */
    
    
    public static void repeatedString(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int s_length = s.length();
        int count = 0;
        for(int i=0;i<s_length && i<=n;i++){
            if(s.charAt(i) == 'a'){
                count++;
            }
        }
        int i = s_length;
        
        
        
        long div = (long)n/s_length;
       // BigInteger div = BigInteger()
        //BigInteger acutalCount = new BigInteger(count)
          long acutalCount=  count * div;
        long rem = (long)n%s_length;    
        //System.out.println(count);
        for(int j=0;j<rem;j++){
            if(s.charAt(j) == 'a'){
                acutalCount++;
            }
            //System.out.println(j);
        }
        System.out.println(acutalCount);
    }
}
