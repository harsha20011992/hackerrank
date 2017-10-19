/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author harsha-1916
 */
public class HackerRankAlgo {
    
      static int divisibleSumPairs(int n, int k, int[] ar) {
        // Complete this function
        
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(ar[i] + ar[j] % k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void divisiblePairs(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
    
        static int migratoryBirds(int n, int[] ar) {
    // Complete this function
        int ary[] = new int[n];
        for(int i = 0; i < n ; i++ )
        ary[ar[i]]++; 
        int max = 0,maxpos=0;
        for(int i = 0 ; i < n ; i++)
            {
            if(ary[i] > max)
                {
                max = ary[i];
                maxpos = i;
            }
        }
        return maxpos;
    }

    public static void migrtoryBirdsHelper() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
    
  
     
     /**
      * Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the  day of the year) during a year in the inclusive range from  to .

From  to , Russia's official calendar was the Julian calendar; since  they used the Gregorian calendar system. The transition from the Julian to Gregorian calendar system occurred in , when the next day after January  was February . This means that in , February  was the  day of the year in Russia.

In both calendar systems, February is the only month with a variable amount of days; it has  days during a leap year, and  days during all other years. In the Julian calendar, leap years are divisible by ; in the Gregorian calendar, leap years are either of the following:

Divisible by .
Divisible by  and not divisible by .
Given a year, , find the date of the  day of that year according to the official Russian calendar during that year. Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .

Input Format

A single integer denoting year .

Constraints

Output Format

Print the full date of Day of the Programmer during year  in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .

Sample Input 0

2017
Sample Output 0

13.09.2017
Explanation 0

In the year , January has  days, February has  days, March has  days, April has  days, May has days, June has  days, July has  days, and August has  days. When we sum the total number of days in the first eight months, we get . Day of the Programmer is the day, so then calculate  to determine that it falls on day  of the  month (September). We then print the full date in the specified format, which is 13.09.2017.

Sample Input 1

2016
Sample Output 1

12.09.2016
Explanation 1

Year  is a leap year, so February has  days but all the other months have the same number of days as in . When we sum the total number of days in the first eight months, we get . Day of the Programmer is the  day, so then calculate  to determine that it falls on day  of the  month (September). We then print the full date in the specified format, which is 12.09.2016.
    **/
    
    
      
    
    static String solve(int year){
        // Complete this function
        int daysInMonths[] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};  
        if(year == 1918){
            daysInMonths[1] = 15;
            return find256Day(daysInMonths,year);
        }else if(year > 1918){
            if(isGreogorianLeap(year)){
                daysInMonths[1] = 29;
            }
            return find256Day(daysInMonths,year);
        }else{
            if(isJulianLeap(year)){
                 daysInMonths[1] = 29;
            }
            return find256Day(daysInMonths,year);
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
    
    private static boolean isGreogorianLeap(int year){
            if(year%400 == 0 || (year %4 ==0 && year % 100 != 0)){
                return true;
            }
            return false;
    }
    
    
     private static boolean isJulianLeap(int year){   
            if(year %4 ==0){
                return true;
            }
         return false;
        
    }
    
    private static String find256Day(int[] daysInMonths,int year){
        String _256Day = "";
        int days =0;
            int month=0;
            for(;month <12;month++){
                days += daysInMonths[month];
                //System.out.println(days);
                if(days >=256){
                    break;
                }
            }
            if(days == 256){
                _256Day = daysInMonths[month] + "." +"0" +(++month) + "." + year;
            }else{
                //System.out.println(days);
                int _256_diff_day = days - 256;
                //System.out.println(_256_diff_day);
                int dayIncurrMonth = daysInMonths[month] - _256_diff_day;
                //System.out.println(dayIncurrMonth);
                _256Day = dayIncurrMonth + "." + "0"+(++month) + "." + year;
            }
        return _256Day;
    }
    
    
    /**
     * 
     *Anna and Brian order  items at a restaurant, but Anna declines to eat any of the  item (where ) due to an allergy. When the check comes, they decide to split the cost of all the items they shared; however, Brian may have forgotten that they didn't split the  item and accidentally charged Anna for it.

You are given , , the cost of each of the  items, and the total amount of money that Brian charged Anna for her portion of the bill. If the bill is fairly split, print Bon Appetit; otherwise, print the amount of money that Brian must refund to Anna.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of items ordered) and  (the -based index of the item that Anna did not eat). 
The second line contains  space-separated integers where each integer  denotes the cost, , of item  (where ). 
The third line contains an integer, , denoting the amount of money that Brian charged Anna for her share of the bill.

Constraints

Output Format

If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the difference (i.e., ) that Brian must refund to Anna (it is guaranteed that this will always be an integer).

Sample Input 0

4 1
3 10 2 9
12
Sample Output 0

5
Explanation 0 
Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Brian charged her  for her portion of the bill, which is more than the  dollars worth of food that she actually shared with him. Thus, we print the amount Anna was overcharged, , on a new line.

Sample Input 1

4 1
3 10 2 9
7
Sample Output 1

Bon Appetit
Explanation 1 
Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Because this matches the amount, , that Brian charged Anna for her portion of the bill, we print Bon Appetit on a new line. 
     */
    
        static void bonAppetit(int n, int k, int b, int[] ar) {
        // Complete this function
        int totalSum =0;
        for(int i=0;i<n;i++){
            if(i!=k){
                totalSum += ar[i];
            }
        }
        int actualShare = totalSum/2;
        if(b==actualShare){
             System.out.println("Bon Appetit");
        }else{
        System.out.println(b - actualShare);
        }
    }

    public static void bonAppetiteHelper(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        bonAppetit(n, k, b, ar);
        
    }
    
    
   

     /**
      * 
      * John's clothing store has a pile of  loose socks where each sock  is labeled with an integer, , denoting its color. He wants to sell as many socks as possible, but his customers will only buy them in matching pairs. Two socks,  and , are a single matching pair if they have the same color ().

Given  and the color of each sock, how many pairs of socks can John sell?

Input Format

The first line contains an integer, , denoting the number of socks. 
The second line contains  space-separated integers describing the respective values of .

Constraints

Output Format

Print the total number of matching pairs of socks that John can sell.

Sample Input

9
10 20 20 10 10 30 50 10 20
Sample Output

3
Explanation

sock.png

As you can see from the figure above, we can match three pairs of socks. Thus, we print  on a new line.
      * 
      */
     static int sockMerchant(int n, int[] ar) {
        // Complete this function
        ArrayList<Integer> pairedIndex = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(!pairedIndex.contains(i)){
                for(int j=i+1;j<n;j++){
                    if(!pairedIndex.contains(j)){
                        if(ar[i] == ar[j]){
                        pairedIndex.add(i);
                        pairedIndex.add(j);
                        break;    
                        }
                        
                    }
                }
            }
        }
        return pairedIndex.size()/2;
    }
    
    public static void sockMerchantHelper(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
    
    static int solve(int n, int p){
        // Complete this function
        int i=1;
        int fcount=0;
        for(;i<=n;i+=2){
            if(p<=i){
                break;
            }
            fcount++;
        }
        int bCount=0;
        int j=n;
        if(n%2 == 1){
            j--;
        }
        for(;j>=1;j-=2){
            if(p>=j){
                break;
            }
            bCount++;
        }
        return bCount > fcount ? fcount:bCount;
    }
    
    /***
     * 
     * Brie’s Drawing teacher asks her class to open their -page book to page number . Brie can either start turning pages from the front of the book (i.e., page number ) or from the back of the book (i.e., page number ), and she always turns pages one-by-one (as opposed to skipping through multiple pages at once). When she opens the book, page  is always on the right side:

image

Each page in the book has two sides, front and back, except for the last page which may only have a front side depending on the total number of pages of the book (see the Explanation sections below for additional diagrams).

Given  and , find and print the minimum number of pages Brie must turn in order to arrive at page .

Input Format

The first line contains an integer, , denoting the number of pages in the book. 
The second line contains an integer, , denoting the page that Brie's teacher wants her to turn to.

Constraints

Output Format

Print an integer denoting the minimum number of pages Brie must turn to get to page .

Sample Input 0

6
2
Sample Output 0

1
Explanation 0

If Brie starts turning from page , she only needs to turn  page:

Untitled Diagram(6).png

If Brie starts turning from page , she needs to turn  pages:

Untitled Diagram(3).png

Because we want to print the minumum number of page turns, we print  as our answer.

Sample Input 1

5
4
Sample Output 1

0
Explanation 1

If Brie starts turning from page , she needs to turn  pages:

Untitled Diagram(4).png

If Brie starts turning from page , she doesn't need to turn any pages:

Untitled Diagram(5).png

Because we want to print the minimum number of page turns, we print  as our answer. 
     */

    public static void pageTurner(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
    
    /***
     * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike, he took exactly  steps. For every step he took, he noted if it was an uphill or a downhill step. Gary's hikes start and end at sea level. We define the following terms:

A mountain is a non-empty sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
A valley is a non-empty sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

Input Format

The first line contains an integer, , denoting the number of steps in Gary's hike. 
The second line contains a single string of  characters. Each character is  (where U indicates a step up and D indicates a step down), and the  character in the string describes Gary's  step during the hike.

Constraints

Output Format

Print a single integer denoting the number of valleys Gary walked through during his hike.

Sample Input

8
UDDDUDUU
Sample Output

1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

_/\      _
   \    /
    \/\/
It's clear that there is only one valley there, so we print  on a new line.
     * 
     *  
     */
    
    public static void valleyFinder(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        String steps ="";
        while(sc.hasNextLine()){
            steps = sc.nextLine();
        }
        calculateValleys(n,steps);
        
    }
    
    private static void calculateValleys(int n,String steps){
        boolean insideValley=false;
        int vCount =0;
        int currPoint =0;
        for(int i=0;i<n;i++){
            if(insideValley){
                if(steps.charAt(i) == 'U'){
                    currPoint++;
                    if(currPoint == 0){
                        insideValley = false;
                        vCount++;
                    }
                    
                }else{
                    currPoint--;
                }
            }else{
                if(steps.charAt(i) == 'U'){
                    currPoint++;
                }else{
                    currPoint--;
                    if(currPoint < 0){
                        insideValley = true;
                    }
                }
            }
        }
        
        System.out.println(vCount);
    }
/**
 Monica wants to buy exactly one keyboard and one USB drive from her favorite electronics store. The store sells different brands of keyboards and  different brands of USB drives. Monica has exactly  dollars to spend, and she wants to spend as much of it as possible (i.e., the total cost of her purchase must be maximal).

Given the price lists for the store's keyboards and USB drives, find and print the amount money Monica will spend. If she doesn't have enough money to buy one keyboard and one USB drive, print -1 instead.

Note: She will never buy more than one keyboard and one USB drive even if she has the leftover money to do so.

Input Format

The first line contains three space-separated integers describing the respective values of  (the amount of money Monica has),  (the number of keyboard brands) and  (the number of USB drive brands). 
The second line contains  space-separated integers denoting the prices of each keyboard brand. 
The third line contains  space-separated integers denoting the prices of each USB drive brand.

Constraints

The price of each item is in the inclusive range .
Output Format

Print a single integer denoting the amount of money Monica will spend. If she doesn't have enough money to buy one keyboard and one USB drive, print -1 instead.

Sample Input 0

10 2 3
3 1
5 2 8
Sample Output 0

9
Explanation 0

She can buy the  keyboard and the  USB drive for a total cost of .

Sample Input 1

5 1 1
4
5
Sample Output 1

-1
Explanation 1

There is no way to buy one keyboard and one USB drive because , so we print .   
    
    **/
     static int getMoneySpent(int[] keyboards, int[] drives, int s){
        // Complete this function
        ArrayList<Integer> totalCost = new ArrayList<>();
        for(int i=0;i<keyboards.length;i++){
            for(int j=0;j<drives.length;j++){
                if(keyboards[i] + drives[j] <= s){
                    totalCost.add(keyboards[i] + drives[j]);
                }
            }
        }
        if(totalCost.size() == 0){
            return -1;
        }
        Collections.sort(totalCost);
        return totalCost.get(totalCost.size()-1);
    }

    public static void keyboardDrives(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
    /**
     * We define a magic square to be an  matrix of distinct positive integers from  to  where the sum of any row, column, or diagonal (of length ) is always equal to the same number (i.e., the magic constant).

Consider a  matrix, , of integers in the inclusive range . We can convert any digit, , to any other digit, , in the range  at cost .

Given , convert it into a magic square at minimal cost by changing zero or more of its digits. Then print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range .

Input Format

There are  lines of input. Each line describes a row of the matrix in the form of  space-separated integers denoting the respective first, second, and third elements of that row.

Constraints

All integers in  are in the inclusive range .
Output Format

Print an integer denoting the minimum cost of turning matrix  into a magic square.

Sample Input 0

4 9 2
3 5 7
8 1 5
Sample Output 0

1
Explanation 0

Matrix  initially looks like this:

4 9 2
3 5 7
8 1 5
Observe that it's not yet magic, because not all rows, columns, and center diagonals sum to the same number.

If we change the bottom right value, , from  to  at a cost of ,  becomes a magic square at the minimum possible cost. Thus, we print the cost, , on a new line.

Sample Input 1

4 8 2
4 5 7
6 1 6
Sample Output 1

4
Explanation 1

Considering 0 - based indexing if we make -> at a cost of :  , -> at a cost of : and -> at a cost of :  , then net cost will be (  ).
     * 
     *  
     */
    
    public static void magicSquareNumberDiff(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i=0; s_i < 3; s_i++){
            for(int s_j=0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
    int magic_mat[][][] = {
    {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
    {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
    {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
    {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
    {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}}, 
    {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, 
    {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
    {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},  
};
        int minDiff = Integer.MAX_VALUE ;
        for(int k=0;k<8;k++){
            int diff =0;
            for(int i=0;i<3;i++){
                for(int  j=0;j<3;j++){
                    if(magic_mat[k][i][j] != s[i][j]){
                        diff+=Math.abs(s[i][j]- magic_mat[k][i][j]); 
                    }
                }
            }
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        System.out.println(minDiff);
        //  Print the minimum cost of converting 's' into a magic square
    }
 
    
    /**
     * 
     * Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference between any two of the chosen integers is .

Input Format

The first line contains a single integer, , denoting the size of the array. 
The second line contains  space-separated integers describing the respective values of .

Constraints

The answer will be .
Output Format

A single integer denoting the maximum number of integers you can choose from the array such that the absolute difference between any two of the chosen integers is .

Sample Input 0

6
4 6 5 3 3 1
Sample Output 0

3
Explanation 0

We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e.,  and ), so we print the number of chosen integers, , as our answer.

Sample Input 1

6
1 2 2 3 1 2
Sample Output 1

5
Explanation 1

We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e., , , and ), so we print the number of chosen integers, , as our answer. 
     */
    public static void diffLessThan2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        int maxCount =0;
        for(int i=0;i<n-1;i++){
            int count =0;
            for(int j=i+1;j<n;j++){
            if(Math.abs(a[i]-a[j]) > 1){
                if(count > maxCount){
                    maxCount = count;
                }
                break;
            }else if(j==n-1){
                count++;
                if(count > maxCount){
                    maxCount = count;
                }
            }else{
                count++;
            }
            }
        }
        System.out.println(maxCount+1);
    }
    
    
    
    /**
     * 
     * Alice is playing an arcade game and wants to climb to the top of the leaderboard. Can you help her track her ranking as she beats each level? The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
For example, four players have the scores , , , and . Those players will have ranks , , , and , respectively.

When Alice starts playing, there are already  people on the leaderboard. The score of each player  is denoted by . Alice plays for  levels, and we denote her total score after passing each level  as . After completing each level, Alice wants to know her current rank.

You are given an array, , of monotonically decreasing leaderboard scores, and another array, , of Alice's cumulative scores for each level of the game. You must print  integers. The  integer should indicate the current rank of alice after passing the  level.

Input Format

The first line contains an integer, , denoting the number of players already on the leaderboard. 
The next line contains  space-separated integers describing the respective values of . 
The next line contains an integer, , denoting the number of levels Alice beats. 
The last line contains  space-separated integers describing the respective values of .

Constraints

 for 
 for 
The existing leaderboard, , is in descending order.
Alice's scores are cumulative, so  is in ascending order.
Subtask

For  of the maximum score:

Output Format

Print  integers. The  integer should indicate the rank of alice after passing the  level.

Sample Input 0

7
100 100 50 40 40 20 10
4
5 25 50 120
Sample Output 0

6
4
2
1
Explanation 0

Alice starts playing with  players already on the leaderboard, which looks like this:

image

After Alice finishes level , her score is  and her ranking is :

image

After Alice finishes level , her score is  and her ranking is :

image

After Alice finishes level , her score is  and her ranking is tied with Caroline at :

image

After Alice finishes level , her score is  and her ranking is :

image
     *  
     */
    public static void rankFinder(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        // your code goes here
        ArrayList<Integer> scoreList = removeDuplicatesinScores(scores);
        int startIndex = scoreList.size()-1;
        for(int i=0;i<alice.length;i++){
            startIndex = StartfindRankinArrayList(scoreList,alice[i],startIndex);
        }
    }
    
    private static int StartfindRankinArrayList(ArrayList<Integer> scoreList,int alice,int startIndex){
        int i=startIndex;
        for(;i>=0;i--){
            if(alice < scoreList.get(i)){
                break;
            }
        }
        System.out.println(i+2);
        return i;
    }
    
    private static  ArrayList<Integer> removeDuplicatesinScores(int[] scores){
        ArrayList<Integer> arrays = new ArrayList<>();
        arrays.add(scores[0]);
        for(int i=1;i<scores.length;i++){
            if(scores[i] != scores[i-1]){
                arrays.add(scores[i]);
            }
        }
        return arrays;
    }
    
    /**
     Dan is playing a video game in which his character competes in a hurdle race by jumping over  hurdles with heights . He can initially jump a maximum height of  units, but he has an unlimited supply of magic beverages that help him jump higher! Each time Dan drinks a magic beverage, the maximum height he can jump during the race increases by  unit.

Given , , and the heights of all the hurdles, find and print the minimum number of magic beverages Dan must drink to complete the race.

Input Format

The first line contains two space-separated integers describing the respective values of  (the number of hurdles) and  (the maximum height he can jump without consuming any beverages). 
The second line contains  space-separated integers describing the respective values of .

Constraints

Output Format

Print an integer denoting the minimum number of magic beverages Dan must drink to complete the hurdle race.

Sample Input 0

5 4
1 6 3 5 2
Sample Output 0

2
Explanation 0

Dan's character can jump a maximum of  units, but the tallest hurdle has a height of :

image

To be able to jump all the hurdles, Dan must drink  magic beverages.

Sample Input 1

5 7
2 5 4 5 2
Sample Output 1

0
Explanation 1

Dan's character can jump a maximum of  units, which is enough to cross all the hurdles:

image

Because he can already jump all the hurdles, Dan needs to drink  magic beverages. 
     */
    
        public static void hurdles(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        int maxHeight=0;
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
            if(height[height_i] > maxHeight){
                maxHeight = height[height_i];
            }
        }
        if(maxHeight > k){
        System.out.println(maxHeight-k);
        }else{
            System.out.println(0);
        }
        
        // your code goes here
        
    }
    
        /**
         * When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle. In a new kind of PDF viewer, the selection of each word is independent of the other words; this means that each rectangular selection area forms independently around each highlighted word. For example:

PDF-highighting.png

In this type of PDF viewer, the width of the rectangular selection area is equal to the number of letters in the word times the width of a letter, and the height is the maximum height of any letter in the word.

Consider a word consisting of lowercase English alphabetic letters, where each letter is  wide. Given the height of each letter in millimeters (), find the total area that will be highlighted by blue rectangle in  when the given word is selected in our new PDF viewer.

Input Format

The first line contains  space-separated integers describing the respective heights of each consecutive lowercase English letter (i.e., ). 
The second line contains a single word, consisting of lowercase English alphabetic letters.

Constraints

, where  is an English lowercase letter.
Word contains no more than  letters.
Output Format

Print a single integer denoting the area of highlighted rectangle when the given word is selected. The unit of measurement for this is square millimeters (), but you must only print the integer.

Sample Input 0

1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
abc
Sample Output 0

9
Explanation 0

We are highlighting the word abc:

The tallest letter in abc is b, and . The selection area for this word is .
Note: Recall that the width of each character is .

Sample Input 1

1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7
zaba
Sample Output 1

28
Explanation 1

We are highlighting the word :

The tallest letter in  is  and  is . The selection area for this word is .
         * 
         *  
         */
        
    public static void pdfDocViewer(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int maxHeight = 0;
        for(int i=0;i<word.length();i++){
            int index = (word.charAt(i)) - 97;
            //System.out.println(index);
            if (h[index] > maxHeight){
                maxHeight = h[index];
            }
        }
        System.out.println((maxHeight*word.length()));
    }
    
    /**
     * A Discrete Mathematics professor has a class of  students. Frustrated with their lack of discipline, he decides to cancel class if fewer than  students are present when class starts.

Given the arrival time of each student, determine if the class is canceled.

Input Format

The first line of input contains , the number of test cases.

Each test case consists of two lines. The first line has two space-separated integers,  (students in the class) and (the cancelation threshold). The second line contains  space-separated integers () describing the arrival times for each student.

Note: Non-positive arrival times () indicate the student arrived early or on time; positive arrival times () indicate the student arrived  minutes late.

Constraints

Output Format

For each test case, print the word YES if the class is canceled or NO if it is not.

Note 
If a student arrives exactly on time , the student is considered to have entered before the class started.
     * 
     */
    public static void angryProfessor() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            int positiveNums=0;
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                if(a[a_i] > 0){
                    positiveNums++;
                }
            }
            if(n-positiveNums >= k){
               System.out.println("NO"); 
            }else{
                 System.out.println("YES"); 
            }
        }
    }
}
