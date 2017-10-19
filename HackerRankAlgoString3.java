/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author harsha-1916
 */



public class HackerRankAlgoString3 {
/**
 Given two strings  and  of equal length, what's the longest string () that can be constructed such that it is a child of both? 

A string  is said to be a child of a string  if  can be formed by deleting 0 or more characters from . 

For example, ABCD and ABDC has two children with maximum length 3, ABC and ABD. Note that we will not consider ABCD as a common child because C doesn't occur before D in the second string.

Input format

Two strings,  and , with a newline separating them.

Constraints

All characters are upper cased and lie between ASCII values 65-90.
Output format

Print the length of the longest string , such that  is a child of both  and .

Sample Input 0

HARRY
SALLY
Sample Output 0

2
The longest possible string that is possible by deleting zero or more characters from  and  is , whose length is 2.

Sample Input 1

AA
BB
Sample Output 1

0
 and  has no characters in common and hence the output is 0.

Sample Input 2

SHINCHAN
NOHARAAA
Sample Output 2

3
The longest string that can be formed between  and  while maintaining the order is .

Sample Input 3

ABCDEF
FBDAMN
Sample Output 3

2
 is the longest child of the given strings.
 */
    
    
    static int commonChild(String s1, String s2){
        // Complete this function
        int s1len = s1.length();
        int s2len = s2.length();
        int[][] commonChildMat = new int[s1len][s2len];
        int max =0;
        for(int i=0;i<s1len;i++){
            char char_i = s1.charAt(i); 
            for(int j=0;j<s2len;j++){
                int curr =0;
                if(char_i == s2.charAt(j)){
                   //System.out.println("char_i: " + char_i + " char_j: " + s2.charAt(j)  + "diaog" + ": " + getDiagValue(i,j,commonChildMat));
                   curr = 1 + getDiagValue(i,j,commonChildMat); 
                }else{
                    curr = maxOfleftOrTop(i,j,commonChildMat);
                }
                commonChildMat[i][j] = curr;
                if(curr > max){
                    max = curr;
                }
            }
        }
        
        /*for(int i=0;i<s1len;i++){
            for(int j=0;j<s2len;j++){
                System.out.print(commonChildMat[i][i] + " ") ;
            }
             System.out.println();
        }*/
        return max;
    }

    private static int maxOfleftOrTop(int i,int j,int[][] commonChildMat){
        int topValue =0;
        int leftValue =0;
        
        if(j-1 >=0){
            leftValue = commonChildMat[i][j-1];
        }
        
        if(i-1 >= 0){
            topValue = commonChildMat[i-1][j];
        }
        
        if(topValue > leftValue){
            return topValue;
        }else{
            return leftValue;
        }
    }
    
    private static int getDiagValue(int i,int j,int[][] commonChildMat){
        if(i-1 < 0 || j-1 < 0){
            return 0;
        }else{
            return commonChildMat[i-1][j-1];
        }
    }
    /*private static int findChildLengthAtI(int[] childArr,String s2,String s1,int i){
       if(i == s1.length()){
            return 0;
        }
        else{
            childArr[i] = 0;
            char s1CharAtI = s1.charAt(i);
            for(int j=0;j<s2.length();j++){
                char s2CharAtJ = s2.charAt(j);
                if(s2CharAtJ == s1CharAtI){
                   childArr[i] = 1 + findsubsequentChildLengthForI(i+1,j+1,s1,s2);            
               }
            }
            return childArr[i];
        }
    }*/
    
    /*private static int findsubsequentChildLengthForI(int i,int j,String s1,String s2){
            int count =0;
            for(int k = i;k<s1.length();k++){
                  for(int l=j;l<s2.length();l++){
                      if(s1.charAt(k) == s2.charAt(l)){
                         count++;
                         j=l+1;
                         break;
                      }
                  }
            }
        return count;
        
    }*/
    public static void commonChildMain(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
    
    /*
    A gene is represented as a string of length  (where  is divisible by ), composed of the letters , , , and . It is considered to be steady if each of the four letters occurs exactly  times. For example,  and  are both steady genes.

Bear Limak is a famous biotechnology scientist who specializes in modifying bear DNA to make it steady. Right now, he is examining a gene represented as a string . It is not necessarily steady. Fortunately, Limak can choose one (maybe empty) substring of  and replace it with any string of the same length.

Modifying a large substring of bear genes can be dangerous. Given a string , can you help Limak find the length of the smallest possible substring that he can replace to make  a steady gene?

Note: A substring of a string  is a subsequence made up of zero or more consecutive characters of .

Input Format

The first line contains an interger  divisible by , denoting the length of a string . 
The second line contains a string  of length . Each character is one of the four: , , , .

Constraints

 is divisible by 
Subtask

 in tests worth  points.
Output Format

On a new line, print the minimum length of the substring replaced to make  stable.

Sample Input

8  
GAAATAAA
Sample Output

5
Explanation

One optimal solution is to replace a substring  with , resulting in . The replaced substring has length , so we print  on a new line.
    */
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
        for (Character c : s.toCharArray())
            map.put(c, map.get(c) + 1);

        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while(right < n - 1){
            char rc = s.charAt(right++);
            map.put(rc, map.get(rc) - 1);
            while(isSteady(map,n)){
                min = Math.min(min, right - left);
                char lc = s.charAt(left++);
                map.put(lc, map.get(lc) + 1);
            }
        }
        System.out.println(min);
    }

    private static boolean isSteady(Map<Character, Integer> map,int n) {
        for (Integer i : map.values())
            if (i > n / 4) return false;
        return true;
    }
    /**
     Jack and Daniel are friends. Both of them like letters, especially upper-case ones. 
They are cutting upper-case letters from newspapers, and each one of them has their collection of letters stored in separate stacks. 
One beautiful day, Morgan visited Jack and Daniel. He saw their collections. Morgan wondered what is the lexicographically minimal string, made of that two collections. He can take a letter from a collection when it is on the top of the stack. 
Also, Morgan wants to use all the letters in the boys' collections.

Input Format

The first line contains the number of test cases, . 
Every next two lines have such format: the first line contains string , and the second line contains string .

Constraints

 
 
 
 and  contain upper-case letters only.

Output Format

Output the lexicographically minimal string  for each test case in new line.

Sample Input

2
JACK
DANIEL
ABACABA
ABACABA
Sample Output

DAJACKNIEL
AABABACABACABA
Explanation

The first letters to choose from were J and D since they were at the top of the stack. D was chosen, the options then were J and A. A chosen. Then the two stacks have J and N, so J is chosen. (Current string is DAJ) Continuing this way till the end gives us the resulting string.
     */
    
public static void morganMain() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            String s1 = sc.next();
            String s2 = sc.next();
            //System.out.println("s1: " + s1 + " s2: " + s2);
            int k=0,j=0;
            while(k<s1.length()&&j<s2.length()){
                if(s1.charAt(k) < s2.charAt(j)){
                    System.out.print(s1.charAt(k));
                    k++;
                }else if(s2.charAt(j)  < s1.charAt(k)){
                    System.out.print(s2.charAt(j));
                    j++;
                }else{
                    int tempk = k+1;
                    int tempj = j+1;
                    int[] compareArray = doesS1HasNextSmaller(s1,s2,tempk,tempj);
                    //System.out.println("compareArray[0]: "+ compareArray[0] + " compareArray[1]: " + compareArray[1] + " for : s1[k]: " + k + " s2[j]: " +j);
                    if(compareArray[0] == 1){
                        for(int i_i=0;i_i<=compareArray[1];i_i++){
                            System.out.print(s1.charAt(k));
                            k++;    
                        }
                        
                    }
                
                else if(compareArray[0] == -1){
                        
                    for(int i_i=0;i_i<=compareArray[1];i_i++){
                            System.out.print(s2.charAt(j));
                            j++;    
                        }
                    }else{
                    System.out.print(s1.charAt(k));
                   k++;
                }
                }
            }
            while(k<s1.length()){
                System.out.print(s1.charAt(k));
                    k++;
            }
            while(j<s2.length()){
                System.out.print(s2.charAt(j));
                    j++;
            }
            System.out.println();
        }
    }
    
    private static int[] doesS1HasNextSmaller(String s1,String s2,int i,int j){
        /*int lenDiff = Math.abs(s1.length()-s2.length());
        if(s1.length() > s2.length()){
          int k=0;
          while(k<lenDiff){
              s2+='z';
          }   
        }else{
            
        }*/
        
        /*while(i<s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)){
            i++;
            j++;
        }*/
        
        /*if(i < s1.length() && j<s2.length() && s1.charAt(i) < s1.charAt(j)){
            return true;
        }else{
            return false;
        }*/
        int s1remLength = s1.length()-i;
        int s2remLength = s2.length()-j;
        int k = 0;
        int l=0;
        while(k<s1remLength || l<s2remLength){
            char s1char = 'z';
            char s2char = 'z';
            if(k+i<s1.length()){
                s1char = s1.charAt(k+i);
                
            }
            if(l+j<s2.length()){
                s2char = s2.charAt(l+j);
            }
            if(s1char < s2char){
                return new int[]{1,k};
            }
            
            if(s2char < s1char){
               return new int[]{-1,l};
            }
            k++;
            l++;
        }
        return new int[]{0,0};
    }
}
