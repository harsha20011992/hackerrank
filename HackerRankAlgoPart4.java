/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author harsha-1916
 */
public class HackerRankAlgoPart4 {
    /**
     * 
     * Happy Ladybugs is a board game having the following properties:

The board is represented by a string, , of length . The  character of the string, , denotes the  cell of the board.
If  is an underscore (i.e., _), it means the  cell of the board is empty.
If  is an uppercase English alphabetic letter (i.e., A through Z), it means the  cell contains a ladybug of color .
String  will not contain any other characters.
A ladybug is happy only when its left or right adjacent cell (i.e., ) is occupied by another ladybug having the same color.
In a single move, you can move a ladybug from its current position to any empty cell.
Given the values of  and  for  games of Happy Ladybugs, determine if it's possible to make all the ladybugs happy. For each game, print YES on a new line if all the ladybugs can be made happy through some number of moves; otherwise, print NO to indicate that no number of moves will result in all the ladybugs being happy.

Input Format

The first line contains an integer, , denoting the number of games. The  subsequent lines describes a Happy Ladybugs game in the following format:

The first line contains an integer, , denoting the number of cells on the board.
The second line contains a string, , describing the  cells of the board.
Constraints

It is guaranteed that string  consists of underscores and/or uppercase English alphabetic letters (i.e., _ and A through Z).
Output Format

For each game, print YES on a new line if it is possible to make all the ladybugs happy; otherwise, print NO.

Sample Input 0

4
7
RBY_YBR
6
X_Y__X
2
__
6
B_RRBR
Sample Output 0

YES
NO
YES
YES
Explanation 0

The first three games of Happy Ladybugs are explained below:

Initial board: 
lady.png
After the first move: 
lady(1).png
After the second move: 
lady(2).png
After the third move: 
lady(3).png
Now all the ladybugs are happy, so we print YES on a new line.
There is no way to make the ladybug having color Y happy, so we print NO on a new line.
There are no unhappy ladybugs, so we print YES on a new line. 
     */
        public static void happyLadyBugs(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
        
            Map<Character,Integer> letterCount = new HashMap<>();
            boolean isAlreadyInOrder = true;
            if(b.length() == 1){
                if(b.charAt(0) == '_'){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
            for(int i=0;i<b.length();i++){
                char curr = b.charAt(i); 
                if(letterCount.keySet().contains(curr)){
                    letterCount.put(b.charAt(i),2);
                }else{
                    letterCount.put(curr,1);
                }
                
                if(i == 0){
                    if(curr != b.charAt(i+1)){
                        isAlreadyInOrder = false;
                    }
                }else if(i==b.length()-1){
                    if(curr != b.charAt(i-1)){
                        isAlreadyInOrder = false;
                    }
                }else{
                    if(curr != b.charAt(i-1) && curr != b.charAt(i+1)){
                        isAlreadyInOrder = false;
                    }
                }
            }
            boolean isPossible = true;
            Set<Character> letterCountKeyset = letterCount.keySet();
            for(char key: letterCountKeyset){
                if(key!= '_' && letterCount.get(key) == 1){
                    isPossible = false;
                }
            }
 
            if(!isAlreadyInOrder && !letterCountKeyset.contains('_') ){
                isPossible = false;
            }
            if(isPossible){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            }
        }
        
    }
        
        
        /***
         * Bob has a strange counter. At the first second, , it displays the number . At each subsequent second, the number displayed by the counter decrements by .

The counter counts down in cycles. In the second after the counter counts down to , the number becomes  the initial number for that countdown cycle and then continues counting down from the new initial number in a new cycle. The diagram below shows the counter values for each time  in the first three cycles:

strange(1).png

Given a time, , find and print the value displayed by the counter at time .

Input Format

A single integer denoting the value of .

Constraints

Subtask

 for  of the maximum score.
Output Format

Print the value displayed by the strange counter at the given time .

Sample Input

4
Sample Output

6
Explanation

Time  marks the beginning of the second cycle in which the counter displays a number that is double the initial number displayed at the beginning of the previous cycle (i.e., ). This is also shown in the diagram in the Problem Statement above.
         */
        
public static void strangeCounter(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //System.out.println("TestBefore");
        long t = in.nextLong();
       // System.out.println("TestAfter");
        // System.out.println(t);
        long startCount =3;
        //long count = 1;
        long i =1;
        while(i < t){
            //count = count+startCount;
            i = i+startCount;
            
            startCount = startCount*2;
           
        }
        if(i == t){
          System.out.println(startCount);  
        }else{
            startCount = startCount/2;
            long prevI = i-startCount;
            startCount = startCount-(t-prevI);
            System.out.println(startCount);
        
        }
        /*long count = 4;
        long initCount = 3;
        for(long i=1;i<=t;i++){
           
            if(count-1 == 0){
                count = 2*initCount;
                initCount = count;
                 System.out.println(initCount);
            }else{
                count--;
            }
            
        }*/
        
        //System.out.println("Test");
    }
/**
 * You have a string, , of lowercase English alphabetic letters. You can perform two types of operations on :

Append a lowercase English alphabetic letter to the end of the string.
Delete the last character in the string. Performing this operation on an empty string results in an empty string.
Given an integer, , and two strings,  and , determine whether or not you can convert  to  by performing exactly  of the above operations on . If it's possible, print Yes; otherwise, print No.

Input Format

The first line contains a string, , denoting the initial string. 
The second line contains a string, , denoting the desired final string. The third line contains an integer, , denoting the desired number of operations.

Constraints

 and  consist of lowercase English alphabetic letters.
Output Format

Print Yes if you can obtain string  by performing exactly  operations on ; otherwise, print No.

Sample Input 0

hackerhappy
hackerrank
9
Sample Output 0

Yes
Explanation 0

We perform  delete operations to reduce string  to hacker. Next, we perform  append operations (i.e., r, a, n, and k), to get hackerrank. Because we were able to convert  to  by performing exactly  operations, we print Yes.

Sample Input 1

aba
aba
7
Sample Output 1

Yes
Explanation 1

We perform  delete operations to reduce string  to the empty string (recall that, though the string will be empty after  deletions, we can still perform a delete operation on an empty string to get the empty string). Next, we perform  append operations (i.e., a, b, and a). Because we were able to convert  to  by performing exactly  operations, we print Yes.
 */
   public static void appendAndDelete(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        
        int counter =0;
        boolean isDeleteNeeded = false;
        int delIndex = getDeleteIndex(s,t);
        
        /*counter += (s.length() - delIndex);
        
        
        
        if(s.length() - counter != t.length()){
            int append = t.length()-(s.length() - counter);
            counter += append;
        }
        
       if(counter == k){
           System.out.println("Yes");
       }else{
           System.out.println("No");
       }*/
        
       if((s.length() + t.length() - 2 * delIndex) > k){
            System.out.println("No");
        }else if((s.length() + t.length() - 2 * delIndex)%2 == k%2){
           System.out.println("Yes");
       }else if((s.length() + t.length() -k) < 0){
           System.out.println("Yes");
       }else{
           System.out.println("No");
       }
        
    }
    
    private static boolean isDeletedNeeded(String s,String t){
        return !s.equals(t);
    }
    private static int getDeleteIndex(String s,String t){
        int index =0;
        
        while(index < s.length() && index < t.length() && s.charAt(index) == t.charAt(index)){
            index++;
        }
        return index;
    }
    
    /**
     *  Given the time in numerals we may convert it into words, as shown below:

Write a program which prints the time in words for the input given in the format mentioned above.

Input Format

There will be two lines of input:
, representing the hours
, representing the minutes

Constraints


Output Format

Display the time in words.

Sample Input

5  
47  
Sample Output

thirteen minutes to six
     * 
     */
    public static void timeInWords(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        
        String[] numbersToLetter = new String[]{"o' clock","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","quarter","sixteen","seventeen","eighteen","nineteen","twenty","twenty one","twenty two","twenty three","twenty four","twenty five","twenty six","twenty seven","twenty eight","twenty nine","half"};
        String time = "";
        if(m == 0){
            time = numbersToLetter[h] + " " +numbersToLetter[m];
        }else if(m == 15 || m==30){
            time = numbersToLetter[m] + " past" + " " +numbersToLetter[h];
        }else if(m == 1){
            time = numbersToLetter[m] + " minute" + " past" + " " +numbersToLetter[h];
        }else if(m < 30){
            time = numbersToLetter[m] + " minutes" + " past" + " " + numbersToLetter[h];
        }else{
            m = 60 - m;
            h = h+1;
            if(m == 1){
                time = numbersToLetter[m] + " minute" + " to" + " " + numbersToLetter[h];
            }else if(m == 15){
                time = numbersToLetter[m] + " to" + " " +numbersToLetter[h];
            }else{
                time = numbersToLetter[m] + " minutes" + " to" + " " +numbersToLetter[h];
            }
        }
        System.out.println(time);
    }
    /*
    An English text needs to be encrypted using the following encryption scheme. 
First, the spaces are removed from the text. Let  be the length of this text. 
Then, characters are written into a grid, whose rows and columns have the following constraints:

, where  is floor function and  is ceil function
For example, the sentence if man was meant to stay on the ground god would have given us roots after removing spaces is  characters long, so it is written in the form of a grid with 7 rows and 8 columns.

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots
Ensure that 
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. .
The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:

imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

You will be given a message in English with no spaces between the words. The maximum message length can be characters. Print the encoded message.

Here are some more examples:

Sample Input:

haveaniceday
Sample Output:

hae and via ecy
Sample Input:

feedthedog    
Sample Output:

fto ehg ee dd
Sample Input:

chillout
Sample Output:

clu hlt io
    
    */
    
    public static void encryption(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int slen = s.length();
        float lenSqr = (float)Math.sqrt(slen);
        int rows = (int)Math.floor(lenSqr);
        int columns = (int)Math.ceil(lenSqr);
        
        if(rows * columns < slen){
            rows++;
        }
        
        for(int i=0;i<columns;i++){
            for(int j=0;j<s.length();j=j+columns){
                int k = i+j;
                if(k < s.length()){
                System.out.print(s.charAt(k));
                }
                }
            System.out.print(" ");
            }
            
        }
    
    /**
     * David has  containers and  different types of balls, both of which are numbered from  to . The distribution of ball types per container are described by an  matrix of integers, , where each  is the number of balls of type  in container . For example, consider the following diagram for :

image

In a single operation, David can swap two balls located in different containers (i.e., one ball is moved from container  to  and the other ball is moved from  to ).

For example, the diagram below depicts a single swap operation:

image

David wants to perform some number of swap operations such that both of the following conditions are satisfied:

Each container contains only balls of the same type.
No two balls of the same type are located in different containers.
You must perform  queries where each query is in the form of a matrix, . For each query, print Possible on a new line if David can satisfy the conditions above for the given matrix; otherwise, print Impossible instead.

Input Format

The first line contains an integer denoting  (the number of queries). The subsequent lines describe each query in the following format:

The first line contains an integer denoting  (the number of containers and ball types).
Each line  of the  subsequent lines contains  space-separated integers describing row  in matrix .
Constraints

Scoring

For  of score, .
For  of score, .
Output Format

For each query, print Possible on a new line if David can satisfy the conditions above for the given matrix; otherwise, print Impossible instead.

Sample Input 0

2
2
1 1
1 1
2
0 2
1 1
Sample Output 0

Possible
Impossible
Explanation 0

We perform the following  queries:

The diagram below depicts one possible way to satisfy David's requirements for the first query: image
Thus, we print Possible on a new line.
The diagram below depicts the matrix for the second query: image
No matter how many times we swap balls of type  and  between the two containers, we'll never end up with one container only containing type  and the other container only containing type . Thus, we print Impossible on a new line.
     */
public static void organizingContainers(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] M = new int[n][n];
            for(int M_i=0; M_i < n; M_i++){
                for(int M_j=0; M_j < n; M_j++){
                    M[M_i][M_j] = in.nextInt();
                }
            }
            
            int[] ballsInEachContr = new int[n];
            int[] ballsOfEachType =new int[n];
            
            for(int i=0;i<n;i++){                
                for(int j=0;j<n;j++){
                    //System.out.println("i: " + i + " j: " + j);
                 ballsInEachContr[i] += M[i][j];    
                 ballsOfEachType[j] += M[i][j];
                }
            }
            
            Arrays.sort(ballsInEachContr);
            Arrays.sort(ballsOfEachType);
            boolean isPossible =true; 
            for(int i=0;i<n;i++){
                if(ballsInEachContr[i] != ballsOfEachType[i]){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }
            // your code goes here
        }
    }

/**
 * A queen is standing on an  chessboard. The chessboard's rows are numbered from  to , going from bottom to top; its columns are numbered from  to , going from left to right. Each square on the board is denoted by a tuple, , describing the row, , and column, , where the square is located.

The queen is standing at position  and, in a single move, she can attack any square in any of the eight directions (left, right, up, down, or the four diagonals). In the diagram below, the green circles denote all the cells the queen can attack from :

image

There are  obstacles on the chessboard preventing the queen from attacking any square that has an obstacle blocking the the queen's path to it. For example, an obstacle at location  in the diagram above would prevent the queen from attacking cells , , and :

image

Given the queen's position and the locations of all the obstacles, find and print the number of squares the queen can attack from her position at .

Input Format

The first line contains two space-separated integers describing the respective values of  (the side length of the board) and  (the number of obstacles). 
The next line contains two space-separated integers describing the respective values of  and , denoting the position of the queen. 
Each line  of the  subsequent lines contains two space-separated integers describing the respective values of and , denoting the position of obstacle .

Constraints

A single cell may contain more than one obstacle; however, it is guaranteed that there will never be an obstacle at position  where the queen is located.
Subtasks

For  of the maximum score:

For  of the maximum score:

Output Format

Print the number of squares that the queen can attack from position .

Sample Input 0

4 0
4 4
Sample Output 0

9
Explanation 0

The queen is standing at position  on a  chessboard with no obstacles:

image

We then print the number of squares she can attack from that position, which is .

Sample Input 1

5 3
4 3
5 5
4 2
2 3
Sample Output 1

10
Explanation 1

The queen is standing at position  on a  chessboard with  obstacles:

image

We then print the number of squares she can attack from that position, which is .
 *  
 */
    //timeout solution
    public static void queenAttack(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int a0 = 0; a0 < k; a0++){
            obstacles[a0][0] = in.nextInt();
            obstacles[a0][1] = in.nextInt();
            
            // your code goes here
        }
        
        int numOfTopMoves = getNumOfTopMoves(n,r,c,k,obstacles);
        int numOfDownMoves = getNumOfDownMoves(n,r,c,k,obstacles);
        int numOfLeftMoves = getNumOfLeftMoves(n,r,c,k,obstacles);
        int numOfRightMoves = getNumOfRightMoves(n,r,c,k,obstacles);
        int numOfDRightLowMoves = getNumOfDRightLowMoves(n,r,c,k,obstacles);
        int numOfDRightUpMoves = getNumOfDRightUpMoves(n,r,c,k,obstacles);
        int numOfDLeftLowMoves = getNumOfDLeftLowMoves(n,r,c,k,obstacles);
        int numOfDLeftUpMoves = getNumOfDLeftUpMoves(n,r,c,k,obstacles);
        
        System.out.println((numOfTopMoves + numOfDownMoves + numOfLeftMoves + numOfRightMoves + numOfDRightLowMoves + numOfDRightUpMoves + numOfDLeftLowMoves + numOfDLeftUpMoves));
    
    /*System.out.println("numOfTopMoves: " + numOfTopMoves);    
    System.out.println("numOfDownMoves: " + numOfDownMoves);
        
        System.out.println("numOfLeftMoves: " + numOfLeftMoves);
        System.out.println("numOfRightMoves:" + numOfRightMoves);
        System.out.println("numOfDRightLowMoves: " + numOfDRightLowMoves);
        System.out.println("numOfDRightUpMoves: " + numOfDRightUpMoves);
        System.out.println("numOfDLeftLowMoves: " + numOfDLeftLowMoves);
        System.out.println("numOfDLeftUpMoves:" + numOfDLeftUpMoves);*/
    }
    
       
    static int getNumOfTopMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        for(int i=r+1;i<=n;i++){
           if(!isValidRow(i,c,k,obstacles)){
               break;
           }
           count++; 
        }
        return count;
    }
    
    static int getNumOfDownMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        for(int i=r-1;i>=1;i--){
           if(!isValidRow(i,c,k,obstacles)){
               break;
           }
           count++; 
        }
        return count;
    }
    
    static int getNumOfLeftMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        for(int j=c-1;j>=1;j--){
           if(!isValidRow(r,j,k,obstacles)){
               break;
           }
           count++; 
        }
        return count;
    }
    
     static int getNumOfRightMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        for(int j=c+1;j<=n;j++){
           if(!isValidRow(r,j,k,obstacles)){
               break;
           }
           count++; 
        }
        return count;
    }
    
    static int getNumOfDRightLowMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        int i=r-1;
        for(int j=c+1;j<=n && i>=1;j++){
           if(!isValidRow(i,j,k,obstacles)){
               break;
           }
           count++;
           i--;
        }
        return count;
    }
    
    static int getNumOfDRightUpMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        int i=r+1;
        for(int j=c+1;j<=n && i<=n;j++){
           if(!isValidRow(i,j,k,obstacles)){
               break;
           }
           count++;
           i++;
        }
        return count;
    }
    
    static int getNumOfDLeftLowMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        int i=r-1;
        for(int j=c-1;j>=1 && i>=1;j--){
           if(!isValidRow(i,j,k,obstacles)){
               break;
           }
           count++;
           i--;
        }
        return count;
    }
    
     static int getNumOfDLeftUpMoves(int n,int r,int c,int k,int[][] obstacles){
        int count =0;
        int i=r+1;
        for(int j=c-1;j>=1 && i<=n;j--){
           if(!isValidRow(i,j,k,obstacles)){
               break;
           }
           count++;
           i++;
        }
        return count;
    }
    
    static boolean isValidRow(int r,int c,int k,int[][] obstacles){
        for(int i=0;i<k;i++){
            int obsR = obstacles[i][0];
            int obsC = obstacles[i][1];
            if(obsR == r && obsC == c){
                return false;
            }
        }
        return true;
    }
    
    
    //correct solution for queen attack
    public static void queenAttack2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();
        
        //Row Column coordinates of the closes object in each direction
        int rRObstacle = -1;
        int cRObstacle = -1;
        int rBRObstacle = -1;
        int cBRObstacle = -1;
        int rBObstacle = -1;
        int cBObstacle = -1;
        int rBLObstacle = -1;
        int cBLObstacle = -1;
        int rLObstacle = -1;
        int cLObstacle = -1;
        int rTLObstacle = -1;
        int cTLObstacle = -1;
        int rTObstacle = -1;
        int cTObstacle = -1;
        int rTRObstacle = -1;
        int cTRObstacle = -1;
        
        //Total squares attacked by the queen
        int reachableSquares = 0;
        
        //Finds the closest object in each direction
        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            
            //Right
            if((cObstacle < cRObstacle || rRObstacle == -1) && cObstacle > cQueen && rObstacle == rQueen)
            {
                rRObstacle = rObstacle;
                cRObstacle = cObstacle;
            }
            
            //Bottom Right
            if(rQueen - rObstacle == cObstacle - cQueen && cObstacle > cQueen && rObstacle < rQueen 
               && ((rObstacle > rBRObstacle && cObstacle < cBRObstacle) || rBRObstacle == -1))
            {
                rBRObstacle = rObstacle;
                cBRObstacle = cObstacle;
            }
            
            //Bottom    
            if((rObstacle > rBObstacle || rBObstacle == -1) && rObstacle < rQueen && cObstacle == cQueen)
            {
                rBObstacle = rObstacle;
                cBObstacle = cObstacle;
            }
            
            //Bottom Left
            if(rQueen - rObstacle == cQueen - cObstacle && cObstacle < cQueen && rObstacle < rQueen 
               && ((rObstacle > rBLObstacle && cObstacle > cBLObstacle) || rBLObstacle == -1))
            {
                rBLObstacle = rObstacle;
                cBLObstacle = cObstacle;
            }
            
            //Left
            if((cObstacle > cLObstacle || rLObstacle == -1) && cObstacle < cQueen && rObstacle == rQueen)
            {
                rLObstacle = rObstacle;
                cLObstacle = cObstacle;
            }
            
            //Top Left
            if(cQueen - cObstacle == rObstacle - rQueen && cObstacle < cQueen && rObstacle > rQueen 
               && ((rObstacle < rTLObstacle && cObstacle > cTLObstacle) || rTLObstacle == -1))
            {
                rTLObstacle = rObstacle;
                cTLObstacle = cObstacle;
            }
            
            //Top
            if((rObstacle < rTObstacle || rTObstacle == -1) && rObstacle > rQueen && cObstacle == cQueen)
            {
                rTObstacle = rObstacle;
                cTObstacle = cObstacle;
            }
            
            //Top Right
            if(rObstacle - rQueen == cObstacle - cQueen && cObstacle > cQueen 
               && rObstacle > rQueen && ((rObstacle < rTRObstacle && cObstacle < cTRObstacle) || rTRObstacle == -1))
            {
                rTRObstacle = rObstacle;
                cTRObstacle = cObstacle;
            }
                           
        }
        
        //Calculates the distance to the closest obstacle in each direction and adds it to reachableSquares
        //R B L T
        reachableSquares += (cRObstacle != -1) ? (cRObstacle - cQueen -1) : n - cQueen;     
        reachableSquares += (rBObstacle != -1) ? (rQueen - rBObstacle - 1) : rQueen - 1;   
        reachableSquares += (cLObstacle != -1) ? (cQueen - cLObstacle -1) : cQueen - 1;  
        reachableSquares += (rTObstacle != -1) ? (rTObstacle - rQueen - 1) : n - rQueen;

        //BR BL TL TR
        reachableSquares += (cBRObstacle != -1) ? (cBRObstacle - cQueen -1) : Math.min(n - cQueen, rQueen - 1); 
        reachableSquares += (rBLObstacle != -1) ? (cQueen - cBLObstacle - 1) : Math.min(cQueen - 1, rQueen - 1); 
        reachableSquares += (cTLObstacle != -1) ? (cQueen - cTLObstacle -1) : Math.min(cQueen - 1, n - rQueen);  
        reachableSquares += (rTRObstacle != -1) ? (cTRObstacle - cQueen - 1) : Math.min(n - cQueen, n - rQueen); 
        System.out.println(reachableSquares);
    }
    
    
    /**
     * Given a 2D array of digits, try to find the occurrence of a given 2D pattern of digits. For example, consider the following 2D matrix:

1234567890  
0987654321  
1111111111  
1111111111  
2222222222  
Assume we need to look for the following 2D pattern:

876543  
111111  
111111
If we scan through the original array, we observe that the 2D pattern begins at the second row and the third column of the larger grid (the  in the second row and third column of the larger grid is the top-left corner of the pattern we are searching for).

So, a 2D pattern of  digits is said to be present in a larger grid , if the latter contains a contiguous, rectangular 2D grid of digits matching with the pattern , similar to the example shown above.

Input Format

The first line contains an integer, , which is the number of test cases.  test cases follow, each having a structure as described below: 
The first line contains two space-separated integers,  and , indicating the number of rows and columns in the grid , respectively. 
This is followed by  lines, each with a string of  digits, which represent the grid . 
The following line contains two space-separated integers,  and , indicating the number of rows and columns in the pattern grid . 
This is followed by  lines, each with a string of  digits, which represent the pattern .

Constraints

 
 
 

Output Format

Display 'YES' or 'NO', depending on whether (or not) you find that the larger grid  contains the rectangular pattern . The evaluation will be case sensitive.

Sample Input

2
10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
15 15
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
2 2
99
99
Sample Output

YES
NO
Explanation

The first test in the input file is:

10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
As one may see, the given 2D grid is indeed present in the larger grid, as marked in bold below.

7283455864  
6731158619  
8988242643  
3830589324  
2229505813  
5633845374  
6473530293  
7053106601  
0834282956  
4607924137  
The second test in the input file is:

15 15
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
2 2
99
99
The search pattern is:

99
99
This cannot be found in the larger grid.
     */
    
    public static void gridSearch(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            boolean isMatchFound = false;
            for(int i=0;i<R;i++){
                String curr = G[i];
                int fromIndex = 0;
                while(!isMatchFound){
                    int index = curr.indexOf(P[0],fromIndex);
                    //System.out.println("curr: " + curr + " index: " + index);
                    isMatchFound = isMatchFound(index,P,G,i);
                        if(index == -1){
                            break;
                        }
                    fromIndex = index+1;
                }
                if(isMatchFound){
                    break;
                }
            }
            if(isMatchFound){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    private static boolean isMatchFound(int index,String[] P,String[] G,int i){
           if(index > -1){
                    int k = i+1;
                    //int currIndex = index;
                    int result = 1; 
                    for(int j=1;j<P.length;j++){
                        if(k < G.length){
                            int nextIndex = G[k].indexOf(P[j],index);
                            //System.out.println("G[k]: " + G[k] + " PK: " + P[j] + " index: " + index);
                            if(nextIndex == index){
                                result++;
                            }
                        }
                        k++;
                    }
                    if(result == P.length){
                        return true;                
                    }
                }
        return false;
    }
}
