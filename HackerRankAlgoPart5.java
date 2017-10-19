/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author harsha-1916
 */
public class HackerRankAlgoPart5 {
        public static void AbsolutePermutation(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            if(k == 0){
                for(int i=1;i<=n;i++){
                    System.out.print(i + " ");
                }
            }else if((n%(2*k))==0 && 2*k <= n){
                int loopValue = n/(2*k);
                //System.out.println(loopValue);
                for(int i=0;i<loopValue;i++){
                    //System.out.println("i:" + i);
                    int j=(i*2*k) + 1;
                    //System.out.println("j:" + j);
                    int iter = j;
                    for(;iter<=j+k-1;iter++){
                        System.out.print(iter+k + " ");
                    }
                    for(;iter<=j+(2*k)-1;iter++){
                        System.out.print(iter-k + " ");
                    }
                }
            }else{
                 System.out.print("-1");
            }
            System.out.println();
        }
    }
        /**
         *nothing at all.

Each bomb can be planted in any cell of the grid but, once planted, it will detonate after exactly 3 seconds. Once a bomb detonates, it's destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell , cells  and  are cleared (note that cells at the edge of the grid have less than four neighboring cells). If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating (i.e., no chain reaction occurs).

Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:

Initially, Bomberman arbitrarily plants bombs in some of the cells.
After one second, Bomberman does nothing.
After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. It is guaranteed that no bombs will detonate at this second.
After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
Bomberman then repeats steps 3 and 4 indefinitely.
Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.

Given the initial configuration of the grid with the locations of Bomberman's first batch of planted bombs, determine the state of the grid after  seconds.

Input Format

The first line contains three space-separated integers denoting the respective values of , , and . 
Each line  of the  subsequent lines describes row  of the grid's initial state as a single string of  characters; the . character denotes an empty cell, and the O character (ascii 79) denotes a bomb.

Constraints

Subtask

 for  of the maximum score.
Output Format

Print the grid's final state. This means  lines where each line contains  characters, and each character is either a . or an O (ascii 79). This grid must represent the state of the grid after  seconds.

Sample Input

6 7 3
.......
...O...
....O..
.......
OO.....
OO.....
Sample Output

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO
Explanation

The initial state of the grid is:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman spends the first second doing nothing, so this is the state after 1 second:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman plants bombs in all the empty cells during his second second, so this is the state after 2 seconds:

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
In his third second, Bomberman sits back and watches all the bombs he planted 3 seconds ago detonate. This is the final state after  seconds:

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO 
         * 
         * 
         */
        public static void bomberMan(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        String[] initConfig= new String[r];
        for(int i=0;i<r;i++){
            initConfig[i] = sc.next();
        }
        char[][] initMat = new char[r][c];
        for(int i=0;i<r;i++){
            String currString = initConfig[i];
            for(int j=0;j<c;j++){
                initMat[i][j] = currString.charAt(j);
            }
        }
        
        char[][] afterBombMat3 = new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                afterBombMat3[i][j] = 'O';
            }
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(initMat[i][j] == 'O'){
                     afterBombMat3[i][j] = '.';
                    if(i+1 < r){
                       afterBombMat3[i+1][j] = '.'; 
                   }
                   if(i-1 >=0){
                       afterBombMat3[i-1][j] = '.';
                   }
                   if(j+1 < c){
                       afterBombMat3[i][j+1] = '.';
                   }
                   if(j-1 >=0){
                       afterBombMat3[i][j-1] = '.';
                   }
                }
            }
        }
        
        char[][] afterBombMat5 = new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                afterBombMat5[i][j] = 'O';
            }
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(afterBombMat3[i][j] == 'O'){
                     afterBombMat5[i][j] = '.';
                    if(i+1 < r){
                        afterBombMat5[i+1][j] = '.'; 
                   }
                   if(i-1 >=0){
                        afterBombMat5[i-1][j] = '.';
                   }
                   if(j+1 < c){
                        afterBombMat5[i][j+1] = '.';
                   }
                   if(j-1 >=0){
                        afterBombMat5[i][j-1] = '.';
                   }
                }
            }
        } 
        
        
        
        char[][] fullBombMat = new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                fullBombMat[i][j] = 'O';
            }
        }
        char[][] resultBombMat = null;
        if(n%2 == 0){
            resultBombMat = fullBombMat; 
        }else if(n==1){
            resultBombMat = initMat;
        }else if(n%4 == 1){
            resultBombMat = afterBombMat5;
        }else if(n%4 == 3){
             resultBombMat = afterBombMat3;
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(resultBombMat[i][j]);
            }
            System.out.println();
        }
    }
        
            /**
             *Ema built a quantum computer! Help her test its capabilities by solving the problem below.

Given a grid of size , each cell in the grid is either  or .

A valid plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.

In the diagram below, the blue pluses are valid and the orange ones are not valid. pluseses.png

Find the  valid pluses that can be drawn on  cells in the grid, and print an integer denoting the maximum product of their areas.

Note: The two pluses cannot overlap, and the product of their areas should be maximal.

Input Format

The first line contains two space-separated integers,  and .
The  subsequent lines contains  characters, where each character is either G () or B (). If the character in the  line is G, then  is a  cell (otherwise it's a  cell).

Constraints



Output Format

Find  pluses that can be drawn on  cells of the grid, and print an integer denoting the maximum product of their areas.

Sample Input 0

5 6
GGGGGG
GBBBGB
GGGGGG
GGBBGB
GGGGGG
Sample Output 0

5
Sample Input 1

6 6
BGBBGB
GGGGGG
BGBBGB
GGGGGG
BGBBGB
BGBBGB
Sample Output 1

25
Explanation

Here are two possible solutions for Sample 1 (left) and Sample 2 (right): plusss.png

Explanation Key:

Green:  cell
Red:  cell
Blue: possible .
For the explanation below, we will refer to a plus of length  as .

Sample 0 
There is enough good space to color one  plus and one  plus. , and . The product of their areas is , so we print .

Sample 1 
There is enough good space to color two  pluses. . The product of the areas of our two pluses is , so we print .
             *  
             */
    
     static class Plus{
        int x;
        int y;
        int len;
            
            public Plus(int x,int y,int length){
                this.x = x;
                this.y = y;
                this.len = length;
            }
        
        public void increaseLength(){
            len++;
        }
        
        public int getArea(){
            return (len * 4) + 1;
        }
        
        public boolean isNotOverLappingPlus(Plus otherPlus){
             if(this.x == otherPlus.x && this.y == otherPlus.y){
                 return false;
             }  
            //on the same row but otherplus is on leftside
            if(this.x == otherPlus.x && this.y < otherPlus.y){
               if((this.y + this.len) >= (otherPlus.y-otherPlus.len)){
                   return false;
               }
             //on the same row but otherplus is on rightside
           }else if(this.x == otherPlus.x && this.y > otherPlus.y){
                if((otherPlus.y+otherPlus.len) >= (this.y - this.len)){
                   return false;
               }
                //on the same column but otherplus is on downside
            }else if(this.y == otherPlus.y && this.x < otherPlus.x){
                 if((this.x+this.len) >= (otherPlus.x - otherPlus.len)){
                   return false;
               }
            }else if(this.y == otherPlus.y && this.x > otherPlus.x){
                 if((otherPlus.x + otherPlus.len) >= (this.x + this.len)){
                   return false;
               }
                //otherplus is in bottom right position to this plus
            }else if(this.y < otherPlus.y && this.x < otherPlus.x){
                //bottom of first plus and left of otherplus intersection rule
                if(this.x + len >= otherPlus.x &&  this.y >= otherPlus.y-otherPlus.len){
                    return false;
                //top of other plus and right of first plus intersection rule    
                }else if(this.y + len >= otherPlus.y && this.x >= otherPlus.x - otherPlus.len){
                    return false;
                }
                //otherplus is in top right position to this plus
            }else if(this.y < otherPlus.y && this.x > otherPlus.x){
                 //bottom of other plus and right of this plus intersection rule
                if(this.y + len >= otherPlus.y &&  otherPlus.x+otherPlus.len >= this.x){
                    return false;
                //top of this plus and left of otherplus plus intersection rule    
                }else if(this.x - len <= otherPlus.x && otherPlus.y - otherPlus.len <= this.y){
                    return false;
                }
                //otherplus is in bottom left position to this plus
            }else if(this.y > otherPlus.y && this.x < otherPlus.x){
                 //bottom of this plus and right of other plus intersection rule
                if(otherPlus.y + otherPlus.len >= this.y &&  this.x+len >= otherPlus.x){
                    return false;
                //top of other plus and left of this plus intersection rule    
                }else if(otherPlus.x - otherPlus.len <= this.x && this.y - len <= otherPlus.y){
                    return false;
                }
                //otherplus is in top left position to this plus
            }else if(this.y > otherPlus.y && this.x > otherPlus.x){
                 //right of other plus and top of this plus intersection rule
                if(otherPlus.y + otherPlus.len >= this.y && otherPlus.x >= this.x - len){
                    return false;
                   //bottom of otherplus and left of this plus intersection rule 
                }else if(otherPlus.x + otherPlus.len >= this.x &&  otherPlus.y >= this.y-this.len){
                    return false;
                }
            }
            return true;
        }
        
    }
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    char grid[][] = new char[r][c];
    String gridStr[] = new String[r]; 
        
        for(int i=0;i<r;i++){
            gridStr[i] = sc.next();
        }
        
        for(int i=0;i<r;i++){
            String currGrid = gridStr[i];
            for(int j=0;j<c;j++){
                grid[i][j] = currGrid.charAt(j);
            }
        }
        
        //find pluses in the grid and store it in a separate list
        ArrayList<Plus> pluses = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] != 'B'){
                    storeInPlus(i,j,r,c,grid,pluses);
                }
            }
        }
        
        //find the max sum of two non overlapping pluses
        int max =0;
        int plusOnex = 0;
        int plusOney =0;
        int PlusTwox =0;
        int PlusTwoy =0;
        Plus plus1 = null;
        Plus plus2 = null;
        for(int i=0;i<pluses.size();i++){
            Plus plusI = pluses.get(i);
            for(int j=i+1;j<pluses.size();j++){
                Plus plusJ = pluses.get(j);
                
                if(plusI.isNotOverLappingPlus(plusJ)){
                    int currArea = plusI.getArea() * plusJ.getArea();
                    if(currArea > max){
                        plusOnex = plusI.x;
                        plusOney = plusI.y;
                        PlusTwox = plusJ.x;
                        PlusTwoy = plusJ.y;
                        plus1 = plusI;
                        plus2 = plusJ;
                        max = currArea;
                    }
                }
            }
        }
        //System.out.println("plusOnex: " + plusOnex + " plusOney: " + plusOney+ " PlusTwox: " +  PlusTwox + "PlusTwoy: " + PlusTwoy);
       // System.out.println("Plus 1 area: " + plus1.getArea() + " Plus2 area: " + plus2.getArea());
        //System.out.println("Plus 1 length: " + plus1.len + "Plus2 length: " + plus2.len);
        System.out.println(max);
    }
    
    private static void storeInPlus(int i,int j,int r,int c,char[][] grid,ArrayList<Plus> pluses){
        Plus plus = new Plus(i,j,0);
        pluses.add(plus);
        int iter =1;
        while(true){
            //topcheck
            if(!(i-iter >=0 && grid[i-iter][j] == 'G')){
                 break;
            }
            //bottomcheck
            if(!(i+iter < r && grid[i+iter][j] == 'G')){
                 break;
            }
            //leftcheck
            if(!(j-iter >= 0 && grid[i][j-iter] == 'G')){
                 break;
            }
            //rightcheck
            if(!(j+iter < c && grid[i][j+iter] == 'G')){
                 break;
            }
            //This is done so as to get all the pluses of varying sizes on the same center i,j in the list
            Plus plus1 = new Plus(i,j,iter);
            pluses.add(plus1);
            //increment length 
            iter++;
        }
        //pluses.add(plus);
    }
    /*
    Larry has a permutation of  numbers, , whose unique elements range from  to  (i.e.: ). He wants  to be sorted, so he delegates the task of doing so to his robot. The robot can perform the following operation as many times as it wants:

Choose any  consecutive indices and rotate their elements in such a way that  rotates to , which rotates to , which rotates back to .
For example: if  and the robot rotates ,  becomes .

On a new line for each test case, print  if the robot can fully sort ; otherwise, print .

Input Format

The first line contains an integer, , the number of test cases. 
The  subsequent lines each describe a test case over  lines:

An integer, , denoting the size of .
 space-separated integers describing , where the  value describes element .
Constraints

Output Format

On a new line for each test case, print  if the robot can fully sort ; otherwise, print .

Sample Input

3
3
3 1 2
4
1 3 4 2
5
1 2 3 5 4
Sample Output

YES
YES
NO
Explanation

In the explanation below, the subscript of  denotes the number of operations performed.

Test Case 0: 
 
 is now sorted, so we print  on a new line.

Test Case 1: 
. 
. 
 is now sorted, so we print  on a new line.

Test Case 2:
No sequence of rotations will result in a sorted . Thus, we print  on a new line.
    */
        public static void larrysArray(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            int inversion = findNumOfinversion(a,n);
            if(inversion % 2 == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        
    }
    private static int findNumOfinversion(int[] a ,int n){
        int inversion = 0;
        for(int i =0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(a[j]<a[i]){
                    inversion++;
                }
            }
        }
        return inversion;
    }
    //Finding 
     /*
    Given an array with  elements, can you sort this array in ascending order using only one of the following operations?

Swap two elements.
Reverse one sub-segment.
Input Format 
The first line contains a single integer, , which indicates the size of the array. 
The next line contains  integers separated by spaces.

n  
d1 d2 ... dn  
Constraints 
 
  
All  are distinct.

Output Format 
1. If the array is already sorted, output yes on the first line. You do not need to output anything else.

If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:

a. If you can sort the array by swapping  and , output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the array is indexed from  to .

b. Else if it is possible to sort the array by reversing the segment , output reverse l r in the second line. and  are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from  to .

 represents the sub-sequence of the array, beginning at index  and ending at index , both inclusive.

If an array can be sorted by either swapping or reversing, stick to the swap-based method.

If you cannot sort the array in either of the above ways, output no in the first line.

Sample Input #1

2  
4 2  
Sample Output #1

yes  
swap 1 2
Sample Input #2

3
3 1 2
Sample Output #2

no
Sample Input #3

6
1 5 4 3 2 6
Sample Output #3

yes
reverse 2 5
Explanation 
For #1, you can both swap(1, 2) and reverse(1, 2), but if you can sort the array using swap, output swap only. 
For #2, it is impossible to sort by one single operation (among those permitted). 
For #3, you can reverse the sub-array d[2...5] = "5 4 3 2", then the array becomes sorted.
    */
    public static void isSwapOrReverse() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        if(!isSwapPossible(a,n)){
            if(!isReversePossible(a,n)){
                System.out.println("no");
            }
        }
    }
    
    private static boolean isReversePossible(int[] a ,int n){
        int reversePoint1 =-1;
        int reversePoint2 =-1;
        for(int i=0;i<n-1;i++){
            //System.out.println("a[i]: " + a[i] +  " a[i+1]: " + a[i+1]);
            if(a[i] > a[i+1] && reversePoint1 == -1){
                reversePoint1 = i;
                //System.out.println("reversePoint1: " + reversePoint1 );
            }else if(reversePoint1!= -1 && a[i]<a[i+1]){
                reversePoint2 = i;
                break;
                //System.out.println("reversePoint2: " + reversePoint2 );
            }
            
               }
        if(reversePoint1!=-1 && reversePoint2 == -1){
            reversePoint2 = n-1;
        }
           //System.out.println("Reverse" + " " + a[reversePoint1] + " " + a[reversePoint2]);
        if(reversePoint1!=-1 && reversePoint2 != -1){
            int[] reversedArray = reverseArray(reversePoint1,reversePoint2,a);
            if(checkIfSorted(reversedArray,n)){
                System.out.println("yes");
                if(reversePoint1 + 1 == reversePoint2){
                    System.out.println("swap" + " " + (reversePoint1+1) + " " + (reversePoint2+1));
                }else{
                System.out.println("reverse" + " " + (reversePoint1+1) + " " + (reversePoint2+1));
                }
                    return true;
            }else{
                return false;
            }
        }else{
            return false;
        } 
}
    
    private static int[] reverseArray(int reversePoint1,int reversePoint2,int []a){
        int j = reversePoint2;
        int i=reversePoint1;
        int mid = (j+i+1)/2;
        //int iter=0;
        while(i < mid){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        /*for(int i_=0;i_<a.length;i_++){
            System.out.println(a[i_] + " ");
        }*/
        return a;
    } 
    
    private static boolean isSwapPossible(int[] a ,int n){
        int swapPoint1 =-1;
        int swapPoint2 =-1;
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]){
                if(swapPoint1 == -1){
                    swapPoint1 = i;
                }else{
                    swapPoint2 = i+1;
                }
            }
        }
        if(swapPoint1 != -1 && swapPoint2 == -1 ){
            swapPoint2 = n-1;
        }
        //System.out.println("swap" + " " + a[swapPoint1] + " " + a[swapPoint2]);
        if(swapPoint1 != -1 && swapPoint2 != -1){
            int[] b = a.clone();
            int temp = b[swapPoint1];
            b[swapPoint1] = b[swapPoint2];
            b[swapPoint2] = temp;
            if(checkIfSorted(b,n)){
                System.out.println("yes");  
                System.out.println("swap" + " " + (swapPoint1+1) + " " + (swapPoint2+1));
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    private static boolean checkIfSorted(int[] a,int n){
        boolean isSorted = true;
        for(int i=0;i<n-1;i++){
            if(a[i] > a[i+1]){
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
    /*
    You are given a 2D matrix, a, of dimension MxN and a positive integer R. You have to rotate the matrix R times and print the resultant matrix. Rotation should be in anti-clockwise direction.

Rotation of a 4x5 matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only (refer sample tests for more clarity).

matrix-rotation

It is guaranteed that the minimum of M and N will be even.

Input Format 
First line contains three space separated integers, M, N and R, where M is the number of rows, N is number of columns in matrix, and R is the number of times the matrix has to be rotated. 
Then M lines follow, where each line contains N space separated positive integers. These M lines represent the matrix.

Constraints 
2 <= M, N <= 300 
1 <= R <= 109 
min(M, N) % 2 == 0 
1 <= aij <= 108, where i ∈ [1..M] & j ∈ [1..N]

Output Format 
Print the rotated matrix.

Sample Input #00

4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output #00

2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
Sample Input #01

4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output #01

3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
Sample Input #02

5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28
Sample Output #02

28 27 26 25
22 9 15 19
16 8 21 13
10 14 20 7
4 3 2 1
Sample Input #03

2 2 3
1 1
1 1
Sample Output #03

1 1
1 1
Explanation 
Sample Case #00: Here is an illustration of what happens when the matrix is rotated once.

 1  2  3  4      2  3  4  8
 5  6  7  8      1  7 11 12
 9 10 11 12  ->  5  6 10 16
13 14 15 16      9 13 14 15
Sample Case #01: Here is what happens when to the matrix after two rotations.

 1  2  3  4      2  3  4  8      3  4  8 12
 5  6  7  8      1  7 11 12      2 11 10 16
 9 10 11 12  ->  5  6 10 16  ->  1  7  6 15
13 14 15 16      9 13 14 15      5  9 13 14
Sample Case #02: Following are the intermediate states.

1  2  3  4      2  3  4 10    3  4 10 16    4 10 16 22
7  8  9 10      1  9 15 16    2 15 21 22    3 21 20 28
13 14 15 16 ->  7  8 21 22 -> 1  9 20 28 -> 2 15 14 27 ->
19 20 21 22    13 14 20 28    7  8 14 27    1  9  8 26
25 26 27 28    19 25 26 27    13 19 25 26   7 13 19 25



10 16 22 28    16 22 28 27    22 28 27 26    28 27 26 25
 4 20 14 27    10 14  8 26    16  8  9 25    22  9 15 19
 3 21  8 26 ->  4 20  9 25 -> 10 14 15 19 -> 16  8 21 13
 2 15  9 25     3 21 15 19     4 20 21 13    10 14 20  7
 1  7 13 19     2  1  7 13     3  2  1  7     4  3  2  1
Sample Case #03: As all elements are same, any rotation will reflect the same matrix.
    */
        public static void matLayer(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int rot = sc.nextInt();
        int[][] mat = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int rowIter = r;
        int columnIter = c;
        for(int i=0,j=0;i<r && j<c && rowIter>0 && columnIter > 0;i+=1,j+=1){
            
                //System.out.println("i: " + i + " j: " + j);
                int totElements = ((r-(i*2))*2+(c-(j*2))*2) - 4;
                int[] currLevelArray = new int[totElements];
                //System.out.println("totElements: " + totElements);
                int currLevel_i =0;
                //putting top row elements
                //System.out.println("Top Row Elements");
                for(int k=j;k<c-j;k++){
                   // System.out.println("currLevel_i: " + currLevel_i + "mat[" + i + "]" + "[" + k + "]: "  +  mat[i][k]);
                    currLevelArray[currLevel_i] = mat[i][k];
                    currLevel_i++;
                }
                
                //putting right column elements
                //System.out.println("Right column Elements");
                for(int k=i+1, l=c-j-1;k<r-i;k++){
                    //System.out.println("currLevel_i: " + currLevel_i + "mat[" + k + "]" + "[" + l + "]: "  +  mat[k][l]);
                    currLevelArray[currLevel_i] = mat[k][l];
                    currLevel_i++;
                }
                
                //putting Bottom row elements
                //System.out.println("Bottom Row Elements");
                for(int l=r-i-1, k=c-j-2;k>=j;k--){
                    //System.out.println("currLevel_i: " + currLevel_i + "mat[" + l + "]" + "[" + k + "]: "  +  mat[l][k]);
                    currLevelArray[currLevel_i] = mat[l][k];
                    currLevel_i++;
                }
                
                //putting left column elements
                //System.out.println("Left Column Elements");
                for(int k=r-i-2, l=j;k>=i+1;k--){
                    //System.out.println("currLevel_i: " + currLevel_i + "mat[" + k + "]" + "[" + l + "]: "  +  mat[k][l]);
                    currLevelArray[currLevel_i] = mat[k][l];
                    currLevel_i++;
                }
                
               int[] rotatedArray = leftRotateCurrArray(currLevelArray,rot);
                int rotIndex = 0;
            
                //System.out.println("Inserting into Top Row Elements");
                for(int k=j;k<c-j;k++){
                    //System.out.println("rotatedArray[" + rotIndex + "]: " + rotatedArray[rotIndex]);
                    //System.out.println("mat[" + i + "]" + "[" + k + "]: "  +  mat[i][k]);
                    mat[i][k] = rotatedArray[rotIndex];
                    rotIndex++;
                }
            
                 //Inserting into right column elements
                //System.out.println("Inserting into Right column Elements");
                for(int k=i+1, l=c-j-1;k<r-i;k++){
                    //System.out.println("rotatedArray[" + rotIndex + "]: " + rotatedArray[rotIndex]);
                   //System.out.println("mat[" + k + "]" + "[" + l + "]: "  +  mat[k][l]);
                    mat[k][l] = rotatedArray[rotIndex];;
                    rotIndex++;
                }
            
                //putting Bottom row elements
                //System.out.println("Inserting into Bottom Row Elements");
                for(int l=r-i-1, k=c-j-2;k>=j;k--){
                    //System.out.println("rotatedArray[" + rotIndex + "]: " + rotatedArray[rotIndex]);
                    //System.out.println("mat[" + l + "]" + "[" + k + "]: "  +  mat[l][k]);
                    mat[l][k] = rotatedArray[rotIndex] ;
                    rotIndex++;
                }
                
                //putting left column elements
                //System.out.println("Left Column Elements");
                for(int k=r-i-2, l=j;k>=i+1;k--){
                    //System.out.println("rotatedArray[" + rotIndex + "]: " + rotatedArray[rotIndex]);
                    //System.out.println("mat[" + k + "]" + "[" + l + "]: "  +  mat[k][l]);
                    mat[k][l] = rotatedArray[rotIndex] ;
                    rotIndex++;
                }
            
            
                rowIter-=2;
                columnIter-=2;
            }
        
        //printing final answer:
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(mat[i][j] + " ");
            }
             System.out.println();
        }
    }
    
    private static int[] leftRotateCurrArray(int[] arr,int r){
        //System.out.println("Before rotation");
        for(int i=0;i<arr.length;i++){
            //System.out.print(arr[i] + " ");
        }
        //System.out.println();
        int length = arr.length;
        int modr = r%length;
        
        if(modr==0){
            return arr;
        }else{
            int temp[] = new int[modr];
            for(int i=0;i<modr;i++){
                temp[i] = arr[i];
            }
            
            for(int i=0;i<length-modr;i++){
                arr[i] = arr[i+modr];
            }
            for(int i=length-modr,j=0;i<length && j< temp.length;i++){
                arr[i] = temp[j];
                j++;
            }
        }
        //System.out.println("After rotation");
        for(int i=0;i<arr.length;i++){
            //System.out.print(arr[i] + " ");
        }
        //System.out.println();
        return arr;
    }
 
    /**
     * Given a word , rearrange the letters of  to construct another word  in such a way that  is lexicographically greater than . In case of multiple possible answers, find the lexicographically smallest one among them.

Input Format

The first line of input contains , the number of test cases. Each of the next  lines contains .

Constraints

 will contain only lower-case English letters and its length will not exceed .
Output Format

For each testcase, output a string lexicographically bigger than  in a separate line. In case of multiple possible answers, print the lexicographically smallest one, and if no answer exists, print no answer.

Sample Input 0

5
ab
bb
hefg
dhck
dkhc
Sample Output 0

ba
no answer
hegf
dhkc
hcdk
Explanation 0

Test case 1: 
There exists only one string greater than ab which can be built by rearranging ab. That is ba.
Test case 2: 
Not possible to rearrange bb and get a lexicographically greater string.
Test case 3: 
hegf is the next string lexicographically greater than hefg.
Test case 4: 
dhkc is the next string lexicographically greater than dhck.
Test case 5: 
hcdk is the next string lexicographically greater than dkhc.
     */
    public static void lexographicallyGreater(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String currString = sc.next();
            String lexograpGreaterString = nextBiggerSting(currString);
            if(lexograpGreaterString!= null){
                System.out.println(lexograpGreaterString);
            }else{
                System.out.println("no answer");
            }
        }
    }
    private static String nextBiggerSting(String currString){
        int length = currString.length();
        StringBuilder currStringBuilder = new StringBuilder(currString);
        for(int i=length-2;i>=0;i--){
            char char_i = currString.charAt(i);
            for(int j=length-1;j>i;j--){
                if(currString.charAt(j) > char_i){
                    currStringBuilder.setCharAt(i, currString.charAt(j));
                    currStringBuilder.setCharAt(j, char_i); 
                    return sortFromJtoI(currStringBuilder,i,j);
                    //return currStringBuilder.toString();
                }
            }
        }
        return null;
    }
    private static String sortFromJtoI(StringBuilder stringBuilder,int i,int j){
        //System.out.println(stringBuilder.toString() + "i: "+  i + " j: " + j);
        String sortSubString = stringBuilder.substring(i+1);
        char[] sortArray = sortSubString.toCharArray();
        Arrays.sort(sortArray);
        return stringBuilder.substring(0,i+1) + new String(sortArray);
    }
}
