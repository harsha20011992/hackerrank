/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author harsha-1916
 */
public class HackerRankAlgoPart3 {
    /**
     * 
     * Emma is playing a new mobile game involving  clouds numbered from  to . A player initially starts out on cloud , and they must jump to cloud . In each step, she can jump from any cloud  to cloud  or cloud .

There are two types of clouds, ordinary clouds and thunderclouds. The game ends if Emma jumps onto a thundercloud, but if she reaches the last cloud (i.e., ), she wins the game!

jump(1).png

Can you find the minimum number of jumps Emma must make to win the game? It is guaranteed that clouds  and  are ordinary-clouds and it is always possible to win the game.

Input Format

The first line contains an integer,  (the total number of clouds). 
The second line contains  space-separated binary integers describing clouds .

If , the  cloud is an ordinary cloud.
If , the  cloud is a thundercloud.
Constraints

Output Format

Print the minimum number of jumps needed to win the game.

Sample Input 0

7
0 0 1 0 0 1 0
Sample Output 0

4
Sample Input 1

6
0 0 0 0 1 0
Sample Output 1

3
Explanation

Sample Case 0: 
Because  and  in our input are both , Emma must avoid  and . Bearing this in mind, she can win the game with a minimum of  jumps:

jump(2).png

Sample Case 1: 
The only thundercloud to avoid is . Emma can win the game in  jumps:

jump(5).png 
     */
    
        public static void Cloud(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int i=0;
        int jump =0;
        while(i != n-1){
            if(i+2 <= n-1){
                if(c[i+2] == 0){
                    i +=2;
                    jump++;
                }else{
                  i+=1;  
                    jump++;
                }
            }else{
                i+=1;
                jump++;
            }
        }
        System.out.println(jump);
    }
        
    /*
        Karl has an array of  integers defined as . In one operation, he can delete any element from the array.

Karl wants all the elements of the array to be equal to one another. To do this, he must delete zero or more elements from the array. Find and print the minimum number of deletion operations Karl must perform so that all the array's elements are equal.

Input Format

The first line contains an integer, , denoting the number of elements in array . 
The next line contains  space-separated integers where element  corresponds to array element  (.

Constraints

Output Format

Print a single integer denoting the minimum number of elements Karl must delete for all elements in the array to be equal.

Sample Input

5
3 3 2 1 3
Sample Output

2   
Explanation

Array . If we delete  and , all of the elements in the resulting array, , will be equal. Deleting these  elements is minimal because our only other options would be to delete  elements to get an array of either  or . Thus, we print  on a new line, as that is the minimum number of deletions resulting in an array where all elements are equal.
        */    
        
    public static void equalizeArray(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt(); 
        }
        int max =a[0];
        for(int i=1;i<n;i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        int maxArr[] = new int[max+1];
        for(int i=0;i<=max;i++){
            maxArr[i] = 0;
        }
        
        for(int i=0;i<n;i++){
            maxArr[a[i]]++;
        }
        
        int maxRep = maxArr[0];
        for(int i=1;i<=max;i++){
            if(maxArr[i] > maxRep){
                maxRep = maxArr[i];
            }
        }
        //System.out.println(maxRep);
        int count =0;
        int removeCount = 0;
        for(int i=1;i<=max;i++){
            if(maxArr[i] != maxRep){
                count += maxArr[i];
            }else{
                removeCount++;
            }
        }
        
            count += (removeCount - 1)*maxRep;
       
        System.out.println(count);
    }
    
    
    /*
    You are given a list of  people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-person team can know. And also find out how many teams can know that maximum number of topics.

Note Suppose a, b, and c are three different people, then (a,b) and (b,c) are counted as two different teams.

Input Format

The first line contains two integers,  and , separated by a single space, where  represents the number of people, and  represents the number of topics.  lines follow.
Each line contains a binary string of length . If the th line's th character is , then the th person knows the th topic; otherwise, he doesn't know the topic.

Constraints 
 

Output Format

On the first line, print the maximum number of topics a 2-person team can know. 
On the second line, print the number of 2-person teams that can know the maximum number of topics.

Sample Input

4 5
10101
11100
11010
00101
Sample Output

5
2
Explanation

(1, 3) and (3, 4) know all the 5 topics. So the maximal topics a 2-person team knows is 5, and only 2 teams can achieve this.
    */
    
        public static void acmICPC(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        int maxKnow = 0;
        int maxCount=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int knowledge = 0;
                for(int k=0;k<m;k++){
                    if(topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1'){
                        knowledge++;
                    } 
                }
                if(knowledge > maxKnow){
                    maxKnow = knowledge;
                    maxCount=1;
                }else if(knowledge == maxKnow){
                    maxCount++;
                }
                
                
            }
            
        }
         System.out.println(maxKnow);
        System.out.println(maxCount);
    }
        
        /**
         * 
         * Taum is planning to celebrate the birthday of his friend, Diksha. There are two types of gifts that Diksha wants from Taum: one is black and the other is white. To make her happy, Taum has to buy  number of black gifts and number of white gifts.

The cost of each black gift is  units.
The cost of every white gift is  units.
The cost of converting each black gift into white gift or vice versa is  units.
Help Taum by deducing the minimum amount he needs to spend on Diksha's gifts.

Input Format

The first line will contain an integer  which will be the number of test cases.
There will be  pairs of lines. The first line of each test case will contain the values of integers  and . Another line of each test case will contain the values of integers , , and .

Constraints 
 

Output Format

 lines, each containing an integer: the minimum amount of units Taum needs to spend on gifts.

Sample Input

5
10 10
1 1 1
5 9
2 3 4
3 6
9 1 1
7 7
4 2 1
3 3
1 9 2
Sample Output

20
37
12
35
12
Explanation

Sample Case #01: 
There is no benefit to converting the white gifts into black or the black gifts into white, so Taum will have to buy each gift for 1 unit. So cost of buying all gifts will be: .

Sample Case #02: 
Again, we can't decrease the cost of black or white gifts by converting colors. We will buy gifts at their original price. So cost of buying all gifts will be: .

Sample Case #03: 
We will buy white gifts at their original price, . For black gifts, we will first buy white one and color them to black, so that their cost will be reduced to . So cost of buying all gifts will be: .

Sample Case #04: 
Similarly, we will buy white gifts at their original price, . For black gifts, we will first buy white one and color them to black, so that their cost will be reduced to . So cost of buying all gifts will be: .

Sample Case #05: We will buy black gifts at their original price, . For white gifts, we will first black gifts worth unit and color them to white with another  units, so cost for white gifts is reduced to  units. So cost of buying all gifts will be: . 
         */
    public static void gifts(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
           
               if(isBlackCheap(x,y)){
                   if(x + z >= y){
                       System.out.println(((b*x) + (w*y)));
                   }else{
                       System.out.println(((b*x) + (w*(x+z))));
                   }
            }else {
                  if(y + z >= x){
                      System.out.println(((b*x) + (w*y)));
                  } else{
                      System.out.println(((b*(y+z)) + (w*y)));
                  }
               }
            
        }
    }
    private static boolean isBlackCheap(long x,long y){
        if(x > y){
            return false;
        }
        return true;
    }
    /**
     * 
     * A modified Kaprekar number is a positive whole number  with  digits, such that when we split its square into two pieces - a right hand piece  with  digits and a left hand piece  that contains the remaining  or  digits, the sum of the pieces is equal to the original number (i.e.  +  = ).

Note: r may have leading zeros.

Here's an explanation from Wikipedia about the ORIGINAL Kaprekar Number (spot the difference!): In mathematics, a Kaprekar number for a given base is a non-negative integer, the representation of whose square in that base can be split into two parts that add up to the original number again. For instance, 45 is a Kaprekar number, because 45² = 2025 and 20+25 = 45.

The Task 
You are given the two positive integers  and , where  is lower than . Write a program to determine how many Kaprekar numbers are there in the range between  and  (both inclusive) and display them all.

Input Format

There will be two lines of input: , lowest value , highest value

Constraints: 

Output Format

Output each Kaprekar number in the given range, space-separated on a single line. If no Kaprekar numbers exist in the given range, print INVALID RANGE.

Sample Input

1
100
Sample Output

1 9 45 55 99

Explanation

, , , , and  are the Kaprekar Numbers in the given range. 
     */
    
    
    public static void karperkarNumber(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        boolean isKaprekarnumSet = false;
        for(int i=p;i<=q;i++){
            
            if(isKaprekarNum(i)){
                System.out.print(i + " ");
                isKaprekarnumSet = true;
            }
        }
        if(!isKaprekarnumSet){
            System.out.println("INVALID RANGE");
        }
    }
    
    private static boolean isKaprekarNum(int numInt){
        BigInteger num = BigInteger.valueOf(numInt);
        BigInteger square = num.multiply(num);
        //System.out.println(square);
        ArrayList<Integer> digits = getDigits(square);
        int l = 0;
        for(int i=0;i<digits.size()/2;i++){
            l = l*10 + digits.get(i);
            
        }
        //System.out.println(l);
        int r =0;
        for(int i=digits.size()/2;i<digits.size();i++){
            r = r*10 + digits.get(i);
        }
        //System.out.println(r);
        if(l + r == numInt){
            return true;
        }
        return false;
    }
    
    private static ArrayList<Integer> getDigits(BigInteger num){
        if(num.compareTo(BigInteger.valueOf(10)) < 0) {
            ArrayList<Integer> digits = new ArrayList<>();
            //System.out.println("digit added: " + num);
            digits.add(num.intValue());
            return digits;
        }else{
            ArrayList<Integer> digits = getDigits(num.divide(BigInteger.valueOf(10)));
            //System.out.println("digit added: " + (num.mod(BigInteger.valueOf(10))).intValue());
            digits.add((num.mod(BigInteger.valueOf(10))).intValue());
            return digits;
        }
    }
    /**
     * Erica wrote an increasing sequence of  numbers () in her notebook. She considers a triplet  to be beautiful if:

Given the sequence and the value of , can you help Erica count the number of beautiful triplets in the sequence?

Input Format

The first line contains  space-separated integers,  (the length of the sequence) and  (the beautiful difference), respectively. 
The second line contains  space-separated integers describing Erica's increasing sequence, .

Constraints

 for 
Output Format

Print a single line denoting the number of beautiful triplets in the sequence.

Sample Input

7 3
1 2 4 5 7 8 10
Sample Output

3
Explanation

Our input sequence is , and our beautiful difference . There are many possible triplets , but our only beautiful triplets are  ,  and . Please see the equations below:

 



Recall that a beautiful triplet satisfies the following equivalence relation:  where .


     *  
     */
     public static void beautifulTriplets(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int count =0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(a[j]-a[i] == d){
                    for(int k=j+1;k<n;k++){
                    if(a[k]-a[j] == d){
                        count++;
                    }
                    if(a[k]-a[j] > d){
                        break;
                    }
                }    
                }
                if(a[j]-a[i] > d){
                    break;
                }
                
            }
        }
        System.out.println(count);
    }
     
     /**
      * 
      * Consider an array of  integers, . The distance between two indices,  and , is denoted by .

Given , find the minimum  such that  and . In other words, find the minimum distance between any pair of equal elements in the array. If no such value exists, print .

Note:  denotes the absolute value of .

Input Format

The first line contains an integer, , denoting the size of array . 
The second line contains  space-separated integers describing the respective elements in array .

Constraints

Output Format

Print a single integer denoting the minimum  in ; if no such value exists, print .

Sample Input

6
7 1 3 4 1 7
Sample Output

3
Explanation 
Here, we have two options:

 and  are both , so .
 and  are both , so .
The answer is .
      */
     public static void beautifulTriplets_1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int minDist = Integer.MAX_VALUE;
        List<Integer> setNum = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(setNum.contains(A[i])){
                int dist = i-setNum.indexOf(A[i]);
                //System.out.println(i + "-" + setNum.indexOf(A[i]) + ": " + (i-setNum.indexOf(A[i])) + " (" + A[i] + ")");
                if(dist < minDist){
                    minDist = dist;
                }
            }
                setNum.add(A[i]);
            
        }
        if(minDist == Integer.MAX_VALUE){
            minDist = -1;
        }
        System.out.println(minDist);
    }
     
     
     /**
      * Little Bobby loves chocolate, and he frequently goes to his favorite  store, Penny Auntie, with  dollars to buy chocolates. Each chocolate has a flat cost of  dollars, and the store has a promotion where they allow you to trade in  chocolate wrappers in exchange for  free piece of chocolate.

For example, if  and Bobby has  dollars that he uses to buy  chocolates at  dollar apiece, he can trade in the  wrappers to buy  more chocolates. Now he has  more wrappers that he can trade in for  more chocolate. Because he only has  wrapper left at this point and , he was only able to eat a total of  pieces of chocolate.

Given , , and  for  trips to the store, can you determine how many chocolates Bobby eats during each trip?

Input Format

The first line contains an integer, , denoting the number of trips Bobby makes to the store. 
Each line  of the  subsequent lines contains three space-separated integers describing the respective , , and values for one of Bobby's trips to the store.

Constraints

Output Format

For each trip to Penny Auntie, print the total number of chocolates Bobby eats on a new line.

Sample Input

3
10 2 5
12 4 4
6 2 2
Sample Output

6
3
5
Explanation

Bobby makes the following  trips to the store:

He spends his  dollars on  chocolates at  dollars apiece. He then eats them and exchanges all  wrappers to get  more chocolate. We print the total number of chocolates he ate, which is .
He spends his  dollars on  chocolates at  dollars apiece; however, he needs  wrappers to trade for his next chocolate. Because he only has  wrappers, he cannot purchase or trade for any more chocolates. We print the total number of chocolates he ate, which is .
He spends  dollars on  chocolates at  dollars apiece. He then exchanges  of the  wrappers for  additional piece of chocolate. Next, he uses his third leftover chocolate wrapper from his initial purchase with the wrapper from his trade-in to do a second trade-in for  more piece of chocolate. At this point he has  wrapper left, which is not enough to perform another trade-in. We print the total number of chocolates he ate, which is .
      */
     
    public static void wrappers(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int totalChoc = n/c;      
            int totalChocCover =totalChoc;
            while(totalChocCover >= m){
                int totalChocFromCover= totalChocCover/m;
                totalChocCover =  totalChocFromCover + (totalChocCover%m);
                totalChoc = totalChoc + totalChocFromCover;
            }
            System.out.println(totalChoc);
        }
    }
    /**
     *Calvin is driving his favorite vehicle on the 101 freeway. He notices that the check engine light of his vehicle is on, and he wants to service it immediately to avoid any risks. Luckily, a service lane runs parallel to the highway. The length of the service lane is  units. The service lane consists of  segments of equal length and different width.

Calvin can enter to and exit from any segment. Let's call the entry segment as index  and the exit segment as index . Assume that the exit segment lies after the entry segment () and . Calvin has to pass through all segments from index  to index  (both inclusive).

Paradise Highway

Calvin has three types of vehicles - bike, car, and truck - represented by ,  and , respectively. These numbers also denote the width of the vehicle.

You are given an array  of length , where  represents the width of the th segment of the service lane. It is guaranteed that while servicing he can pass through at most  segments, including the entry and exit segments.

If , only the bike can pass through the th segment.
If , the bike and the car can pass through the th segment.
If , all three vehicles can pass through the th segment.
Given the entry and exit point of Calvin's vehicle in the service lane, output the type of the largest vehicle which can pass through the service lane (including the entry and exit segments).

Input Format

The first line of input contains two integers,  and , where  denotes the length of the freeway and  the number of test cases. The next line has  space-separated integers which represent the  array.

 test cases follow. Each test case contains two integers,  and , where  is the index of the segment through which Calvin enters the service lane and  is the index of the lane segment through which he exits.

Constraints

Output Format

For each test case, print the number that represents the largest vehicle type that can pass through the service lane.

Note: Calvin has to pass through all segments from index  to index  (both inclusive). 
     */
    
 public static void serviceLane(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int width[] = new int[n];
        for(int width_i=0; width_i < n; width_i++){
            width[width_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < t; a0++){
            int i = in.nextInt();
            int j = in.nextInt();
            int min = 3;
            for(int k=i;k<=j;k++){
                if(width[k] < min){
                    min = width[k];
                }
            }
            System.out.println(min);
        }
    }
    
    
 /**
  *Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters.

There are  chapters in Lisa's workbook, numbered from  to .
The -th chapter has  problems, numbered from  to .
Each page can hold up to  problems. There are no empty pages or unnecessary spaces, so only the last page of a chapter may contain fewer than  problems.
Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
The page number indexing starts at .
Lisa believes a problem to be special if its index (within a chapter) is the same as the page number where it's located. Given the details for Lisa's workbook, can you count its number of special problems?

Note: See the diagram in the Explanation section for more details.

Input Format

The first line contains two integers  and  — the number of chapters and the maximum number of problems per page respectively. 
The second line contains  integers , where  denotes the number of problems in the -th chapter.

Constraints

Output Format

Print the number of special problems in Lisa's workbook.

Sample Input

5 3  
4 2 6 1 10
Sample Output

4
Explanation

The diagram below depicts Lisa's workbook with  chapters and a maximum of  problems per page. Special problems are outlined in red, and page numbers are in yellow squares.

bear_workbook.png

There are  special problems and thus we print the number  on a new line.
  */
    public static void LisaWorkBook(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numOfChaps = sc.nextInt();
        int sumsPerPage = sc.nextInt();
        int sumsPerChap[] = new int[numOfChaps]; 
         for(int i=0;i<numOfChaps;i++){
            sumsPerChap[i] = sc.nextInt();
         }
        
        int sumsIter = 0;
        int pageIter = 1;
        int i =0;
        int count=0;
        while(i < sumsPerChap.length){
            if(sumsIter + sumsPerPage >= sumsPerChap[i]){
                if(pageIter <= sumsPerChap[i]  && pageIter >= sumsIter+1    ){
                    count++;
                }
                i++;
                sumsIter =0;
            }else{
                if(pageIter <= sumsIter + sumsPerPage  && pageIter >= sumsIter+1  ){
                    count++;
                }
                sumsIter += sumsPerPage;
            }
            pageIter++;
        }
        System.out.println(count);
    }
 
    /**
     * Flatland is a country with  cities,  of which have space stations. Each city, , is numbered with a distinct index from  to , and each city  is connected to city  by a bidirectional road that is  in length.

For example, if  and cities  and  have space stations, then Flatland looks like this:

hreasy(5).png

For each city, determine its distance to the nearest space station and print the maximum of these distances.

Input Format

The first line consists of two space-separated integers,  and  . 
The second line contains  space-separated integers describing the respective indices of each city having a space-station. These values are unordered and unique.

Constraints

It is guaranteed that there will be at least  city with a space station, and no city has more than one.
Output Format

Print an integer denoting the maximum distance that an astronaut in a Flatland city would need to travel to reach the nearest space station.

Sample Input 0

5 2
0 4
Sample Output 0

2
Explanation 0

This sample corresponds to the example given in the problem statement above. The distance to the nearest space station for each city is listed below:

 has distance , as it contains a space station.
 has distance  to the space station in .
 has distance  to the space stations in  and .
 has distance  to the space station in .
 has distance , as it contains a space station.
We then take , and print  as our answer.

Sample Input 1

6 6
0 1 2 4 3 5
Sample Output 1

0
Explanation 1

In this sample,  so every city has space station and we print  as our answer.
     */
    
    private static void spaceLand(){       
            Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        Arrays.sort(c);
        int maxDist = 0;
        if(c.length > 1){
            for(int i=0;i<c.length-1;i++){
                int splitSize = c[i+1] - c[i] -1;
                int dist =0;
                if(splitSize % 2 == 0){
                    dist = splitSize/2;
                }else{
                    dist = (splitSize/2) + 1;
                }
                if(dist > maxDist){
                    maxDist = dist;
                }
            }
            if(c[0] != 0){
                int splitSize = c[0];
                int dist =splitSize;               
                if(dist > maxDist){
                    maxDist = dist;
                }
            }
            if(c[c.length-1] != n-1){
                int splitSize = n-1 - (c[c.length-1]);
                int dist=splitSize;
                if(dist > maxDist){
                    maxDist = dist;
                }
            }
            
        }else{
            if(c[0] == 0 || c[0] == n-1){
                maxDist = n-1;
            }else{
                int splitSize1 = c[0];
                int splitSize2 = n-1 - (c[0]);
                int splitSize = 0;
                int dist=0;
                if(splitSize1 > splitSize2){
                    splitSize = splitSize1;
                }else{
                    splitSize = splitSize2;
                }
                if(splitSize % 2 == 0){
                    dist = splitSize/2;
                }else{
                    dist = (splitSize/2) + 1;
                }
                if(dist > maxDist){
                    maxDist = dist;
                }
 
            }
            
            
        }
        System.out.println(maxDist);
    }
    /**
     * 
     * 
     * You are the benevolent ruler of Rankhacker Castle, and today you're distributing bread to a straight line of subjects. Each  subject (where ) already has  loaves of bread.

Times are hard and your castle's food stocks are dwindling, so you must distribute as few loaves as possible according to the following rules:

Every time you give a loaf of bread to some person , you must also give a loaf of bread to the person immediately in front of or behind them in the line (i.e., persons  or ). In other words, you can only give a loaf of bread each to two adjacent people at a time.
After all the bread is distributed, each person must have an even number of loaves.
Given the number of loaves already held by each citizen, find and print the minimum number of loaves you must distribute to satisfy the two rules above. If this is not possible, print NO.

Input Format

The first line contains an integer, , denoting the number of subjects in the bread line. 
The second line contains  space-separated integers describing the respective loaves of bread already possessed by each person in the line (i.e., ).

Constraints

, where 
Output Format

Print a single integer denoting the minimum number of loaves you must distribute to adjacent people in the line so that every person has an even number of loaves; if it's not possible to do this, print NO.

Sample Input 0

5
2 3 4 5 6
Sample Output 0

4
Sample Input 1

2
1 2
Sample Output 1

NO
Explanation

Sample Case 0: 
The initial distribution is . You can satisfy the problem's requirements by performing the following actions:

Give  loaf of bread each to the second and third people so that the distribution becomes .
Give  loaf of bread each to the third and fourth people so that the distribution becomes .
Because each of the  subjects now has an even number of loaves, we can stop distributing bread. We then print the total number of loaves distributed, which is , on a new line.

Sample Case 1: 
The initial distribution is . As there are only  people in the line, any time you give one person a loaf you must always give the other person a loaf. Because the first person has an odd number of loaves and the second person has an even number of loaves, no amount of distributed loaves will ever result in both subjects having an even number of loaves. Thus, we print NO as our answer. 
     */
    
        public static void bread(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        int sum =0;
        for(int i=0;i<N;i++){
            sum += B[i];
        }
        if(sum%2 != 0){
            System.out.println("NO");
        }else{
            int breadGiven = 0;
            for(int i=0;i<N-1;i++){
                if(B[i] %2 == 1){
                   B[i]++;
                   B[i+1]++; 
                    breadGiven += 2;
                }
            }
            System.out.println(breadGiven);
        }
        
    }
        
        /**
         * 
         * You are given a square map of size . Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, , denoting the size of the map. Each of the following  lines contains  positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints 

Output Format

Output  lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
Explanation

The two cells with the depth of 9 fulfill all the conditions of the Cavity definition and have been replaced by X.
         * 
         *  
         */
        public static void cavityMap(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
                grid[grid_i] = in.next();    
        }
        System.out.println(grid[0]);
        for(int i=1;i<n-1;i++){
            String curr = grid[i];
            System.out.print(curr.charAt(0));
            for(int j=1;j<curr.length()-1;j++){
                if(curr.charAt(j) > curr.charAt(j-1) && curr.charAt(j) > curr.charAt(j+1) && curr.charAt(j) > grid[i-1].charAt(j) && curr.charAt(j) > grid[i+1].charAt(j)){
                    System.out.print("X");
                }else{
                    System.out.print(curr.charAt(j));
                }
            }
            System.out.print(curr.charAt(curr.length()-1));
            System.out.println();
        }
        if(grid.length > 1){
        System.out.print(grid[n-1]);
        }
    }
     
        /**
         * Problem
Submissions
Leaderboard
Discussions
Editorial 
Tutorial
Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the trail and notices that two consecutive stones have a difference of either  or . Legend has it that there is a treasure trove at the end of the trail and if Manasa can guess the value of the last stone, the treasure would be hers. Given that the number on the first stone was , find all the possible values for the number on the last stone.

Note: The numbers on the stones are in increasing order.

Input Format

The first line contains an integer , i.e. the number of test cases.  test cases follow; each has 3 lines. The first line contains  (the number of stones). The second line contains , and the third line contains .

Constraints

Output Format

Space-separated list of numbers which are the possible values of the last stone in increasing order.

Sample Input

2
3 
1
2
4
10
100
Sample Output

2 3 4 
30 120 210 300 
Explanation

All possible series for the first test case are given below:

0,1,2
0,1,3
0,2,3
0,2,4
Hence the answer 2 3 4.

Series with different number of final steps for second test case are the following:

0, 10, 20, 30
0, 10, 20, 120
0, 10, 110, 120
0, 10, 110, 210
0, 100, 110, 120
0, 100, 110, 210
0, 100, 200, 210
0, 100, 200, 300
Hence the answer 30 120 210 300.
         *  
         */
        //This one given timeout due to recursion
        public static void manassaStones(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            Set<Integer> finalList = new TreeSet<>();
            finalList = findLastElem(n-1,a,b,0,finalList,0);
            for(int elem : finalList){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
    private static Set<Integer> findLastElem(int n,int a,int b,int curr,Set<Integer> finalList,int i){
        if(i == n){
            if(!finalList.contains(curr)){
                finalList.add(curr);
                
            }
            return finalList;
        }else{
            findLastElem(n,a,b,curr+a,finalList,i+1);
            findLastElem(n,a,b,curr+b,finalList,i+1);
            return finalList;
        }
    }
    
    //This is the correct answer:
    public static void manasaaStones(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            //Set<Integer> finalList = new TreeSet<>();
            //finalList = findLastElem(n-1,a,b,0,finalList,0);
            /*for(int elem : finalList){
                System.out.print(elem + " ");
            }
            System.out.println();*/
            if(a == b){
                System.out.print((n-1)*a);    
            }else{ 
             if(a > b){
                int temp = a;
                 a = b;
                 b = temp;
            }
                int startElem = (n-1)*a;
                int endElem = (n-1)*b;
                for(int j = startElem; j<= endElem;j=j+(b-a)){
                    System.out.print(j + " ");
                }
            }
            
            System.out.println();
        }
    }
}
