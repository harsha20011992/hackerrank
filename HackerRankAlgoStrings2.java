/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author harsha-1916
 */


public class HackerRankAlgoStrings2 {
 
    /*
    Alice has a binary string, , of length . She thinks a binary string is beautiful if and only if it doesn't contain the substring .

In one step, Alice can change a  to a  (or vice-versa). Count and print the minimum number of steps needed to make Alice see the string as beautiful.

Input Format

The first line contains an integer,  (the length of binary string ). 
The second line contains a single binary string, , of length .

Constraints

Each character in .
Output Format

Print the minimum number of steps needed to make the string beautiful.

Sample Input 0

7
0101010
Sample Output 0

2
Sample Input 1

5
01100
Sample Output 1

0
Sample Input 2

10
0100101010
Sample Output 2

3
Explanation

Sample Case 0:

In this sample, 

The figure below shows a way to get rid of each instance of :

binary.png

Because we were able to make the string beautiful by changing  characters ( and ), we print .

Sample Case 1:

In this sample 

The substring  does not occur in , so the string is already beautiful and we print .
    
    */
    
    static int minSteps(int n, String B){
        // Complete this function
        int count=0;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=j+1;
            if(B.charAt(i) == '0' && B.charAt(j) == '1' && B.charAt(k) == '0'){
                count++;
                i=i+2;
            }
        }
        return count;
    }

    public static void str010(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();
        int result = minSteps(n, B);
        System.out.println(result);
    }
    
    /*
    James found a love letter his friend Harry has written for his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.

To do this, he follows two rules:

He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
In order to form a palindrome, if he has to repeatedly reduce the value of a letter, he can do it until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.
Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.

Input Format

The first line contains an integer , i.e., the number of test cases. 
The next  lines will contain a string each. The strings do not contain any spaces.

Constraints 
 
 length of string  
All characters are lower case English letters.

Output Format

A single line containing the number of minimum operations corresponding to each test case.

Sample Input

4
abc
abcba
abcd
cba
Sample Output

2
0
4
2
Explanation

For the first test case, abc -> abb -> aba.
For the second test case, abcba is already a palindromic string.
For the third test case, abcd -> abcc -> abcb -> abca = abca -> abba.
For the fourth test case, cba -> bba -> aba.
    */
        static int theLoveLetterMystery(String s){
        // Complete this function
        int i= 0;
        int j = s.length()-1;
        int operations = 0;
        while(j>i){
            int char_i = s.charAt(i);
            int char_j = s.charAt(j);
            operations = operations + Math.abs(char_i - char_j);
            i++;
            j--;
        }
        return operations;
    }

    public static void theLoveLetterMysteryMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }
    /**
     * Given a string, , of lowercase letters, determine the index of the character whose removal will make  a palindrome. If  is already a palindrome or no such character exists, then print . There will always be a valid solution, and any correct answer is acceptable. For example, if  "bcbc", we can either remove 'b' at index  or 'c' at index .

Input Format

The first line contains an integer, , denoting the number of test cases. 
Each line  of the  subsequent lines (where ) describes a test case in the form of a single string, .

Constraints

All characters are lowercase English letters.
Output Format

Print an integer denoting the zero-indexed position of the character that makes  not a palindrome; if  is already a palindrome or no such character exists, print .

Sample Input

3
aaab
baa
aaa
Sample Output

3
0
-1
Explanation

Test Case 1: "aaab" 
Removing 'b' at index  results in a palindrome, so we print  on a new line.

Test Case 2: "baa" 
Removing 'b' at index  results in a palindrome, so we print  on a new line.

Test Case 3: "aaa" 
This string is already a palindrome, so we print ; however, , , and  are also all acceptable answers, as the string will still be a palindrome if any one of the characters at those indices are removed.

Note: The custom checker logic for this challenge is available here. 
     */
    
        static int palindromeIndex(String s){
        // Complete this function
        int len = s.length();
        int pos = -1;
        for(int i=0;i<len/2;i++){
            if(s.charAt(i) != s.charAt(len-1-i)){
                if(s.charAt(i+1) == s.charAt(len-1-i) && s.charAt(i+2) == s.charAt(len-1-i-1)){
                    pos = i;
                    break;
                }else if(s.charAt(i) == s.charAt(len-1-i-1) && s.charAt(i+1) == s.charAt(len-1-i-2)){
                    pos = len-1-i;
                    break;
                }
            }
        }
        return pos;
    }

    public static void palindromeIndexMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
    }
    /**
     Sid is obsessed with reading short stories. Being a CS student, he is doing some interesting frequency analysis with the books. He chooses strings  and  in such a way that .

Your task is to help him find the minimum number of characters of the first string he needs to change to enable him to make it an anagram of the second string.

Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.

Input Format

The first line will contain an integer, , representing the number of test cases. Each test case will contain a string having length , which will be concatenation of both the strings described above in the problem.The given string will contain only characters from  to .

Constraints

 
Output Format

An integer corresponding to each test case is printed in a different line, i.e. the number of changes required for each test case. Print  if it is not possible.

Sample Input

6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx
Sample Output

3
1
-1
2
0
1
Explanation

Test Case #01: We have to replace all three characters from the first string to make both of strings anagram. Here,  = "aaa" and  = "bbb". So the solution is to replace all character 'a' in string a with character 'b'. 

Test Case #02: You have to replace 'a' with 'b', which will generate "bb". 

Test Case #03: It is not possible for two strings of unequal length to be anagram for each other. 

Test Case #04: We have to replace both the characters of first string ("mn") to make it anagram of other one. 

Test Case #05:  and  are already anagram to each other. 

Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". He had to replace 'a' from S1 with 'b' so that S1 = "xbxb" and we can rearrange its letter to "bbxx" in order to get S2. 
     */
    
    static int anagram(String s){
        // Complete this function
        int len = s.length();
        if(len%2 != 0){
            return -1;
        }
        String a=s.substring(0,(len/2));
        StringBuilder b = new StringBuilder(s.substring((len/2),len)); 
        //System.out.println("a: " + a);
        //System.out.println("b: " + b);
        //char[] aChar = a.toCharArray();
        //char[] bChar = b.toCharArray();
        //Arrays.sort(aChar);
        //Arrays.sort(bChar);
        int count =0;
        for(int i=0;i<len/2;i++){
            int j = b.indexOf(String.valueOf(a.charAt(i)));
                if(j > -1){
                b.deleteCharAt(j);              
            }else{
                count++;
            }
        }
        return count;
    }

    public static void anagramHelper(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }
    /**
   Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

This challenge is also available in the following translations:

Chinese
Russian
Input Format

The first line contains a single string, . 
The second line contains a single string, .

Constraints

It is guaranteed that  and  consist of lowercase English letters.
Output Format

Print a single integer denoting the number of characters which must be deleted to make the two strings anagrams of each other.

Sample Input

cde
abc
Sample Output

4
Explanation

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We had to delete  characters to make both strings anagrams, so we print  on a new line.2
     * @return 
     */
    
       static int makingAnagrams(String s1, String s2){
        // Complete this function
        StringBuilder b = new StringBuilder(s2);
        int delCount =0;
        for(int i=0;i<s1.length();i++){
            int index = b.indexOf(String.valueOf(s1.charAt(i)));
            if(index == -1){
                delCount++;
            }else{
                b.deleteCharAt(index);
            }                      
        }
        return delCount + b.length();
    }

    public static void makingAnagramsMain(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
    
    /**
   Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

door

But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.

Input Format

A single line which contains the input string.

Constraints

 length of string 
Each character of the string is a lowercase English letter.
Output Format

A single line which contains YES or NO in uppercase.

Sample Input 0

aaabbbb
Sample Output 0

YES
Explanation 0

A palindrome permutation of the given string is bbaaabb. 

Sample Input 1

cdefghmnopqrstuvw
Sample Output 1

NO
Explanation 1

You can verify that the given string has no palindrome permutation. 

Sample Input 2

cdcdcdcdeeeef
Sample Output 2

YES
Explanation 2

A palindrome permutation of the given string is ddcceefeeccdd.
     */
        static String gameOfThrones(String s){
        // Complete this function
        int charArray[] = new int[26];
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i) - 'a';
            charArray[index]++;
        }
        boolean isPalindrome = true;
        if(s.length()%2 == 0){
            for(int i=0;i<26;i++){
            if(charArray[i]%2 != 0){
                isPalindrome = false; 
                break;
            }
        }    
        }else{
            boolean oneOdd = false;
            for(int i=0;i<26;i++){
            if(charArray[i]%2 != 0){
                if(!oneOdd){
                oneOdd = true;
                }else{
                  isPalindrome = false; 
                    break;
                }
            }
        }   
        }
        if(isPalindrome){
            return "YES";
        }else{
            return "NO";
        }
    }

    public static void gameOfThronesMain(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
    
    /**
     *Given two strings,  and , determine if they share a common substring.

Input Format

The first line contains a single integer, , denoting the number of  pairs you must check. 
Each pair is defined over two lines:

The first line contains string .
The second line contains string .
Constraints

 and  consist of lowercase English letters only.
Output Format

For each  pair of strings, print YES on a new line if the two strings share a common substring; if no such common substring exists, print NO on a new line.

Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

We have  pairs to check:

, . The substrings  and  are common to both  and , so we print YES on a new line.
, . Because  and  have no common substrings, we print NO on a new line
     */
    
        static String twoStrings(String s1, String s2){
        // Complete this function
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<letters.length();i++){
            char lettersChar = letters.charAt(i); 
            if(s1.indexOf(lettersChar) > -1 && s2.indexOf(lettersChar) > -1){
                return "YES";
            }
        }
        
        return "NO";
    }

    public static void twoStringsMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
    
    
        static int stringConstruction(String s) {
        // Complete this function
        
        boolean charArray[] = new boolean[26]; 
        for(int i=0;i<26;i++){
            charArray[i] = false;
        }
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i) - 'a';
            charArray[index] = true;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(charArray[i]){
                count++;
            }
        }
        return count;
    }
/**
Amanda has a string, , of  lowercase letters that she wants to copy into a new string, . She can perform the following operations any number of times to construct string :

Append a character to the end of string  at a cost of  dollar.
Choose any substring of  and append it to the end of  at no charge.
Given  strings (i.e., ), find and print the minimum cost of copying each  to  on a new line.

Input Format

The first line contains a single integer, , denoting the number of strings. 
Each line  of the  subsequent lines contains a single string, .

Constraints

Subtasks

 for  of the maximum score.
Output Format

For each string  (where ), print the minimum cost of constructing string  on a new line.

Sample Input

2
abcd
abab
Sample Output

4
2
Explanation

Query 0: We start with  and .

Append character '' to  at a cost of  dollar, .
Append character '' to  at a cost of  dollar, .
Append character '' to  at a cost of  dollar, .
Append character '' to  at a cost of  dollar, .
Because the total cost of all operations is  dollars, we print  on a new line.

Query 1: We start with  and .

Append character '' to  at a cost of  dollar, .
Append character '' to  at a cost of  dollar, .
Append substring  to  at no cost, .
Because the total cost of all operations is  dollars, we print  on a new line.

Note

A substring of a string  is another string  that occurs "in"  (Wikipedia). For example, the substrings of the string "" are "", "" ,"", "", "", and ""
 */
    public static void stringConstructionMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
    
    
    
    /**
    Sherlock considers a string, , to be valid if either of the following conditions are satisfied:

All characters in  have the same exact frequency (i.e., occur the same number of times). For example,  is valid, but  is not valid.
Deleting exactly  character from  will result in all its characters having the same frequency. For example,  and  are valid because all their letters will have the same frequency if we remove  occurrence of c, but  is not valid because we'd need to remove  characters.
Given , can you determine if it's valid or not? If it's valid, print YES on a new line; otherwise, print NO instead.

Input Format

A single string denoting .

Constraints

String  consists of lowercase letters only (i.e., [a-z]).
Output Format

Print YES if string  is valid; otherwise, print NO instead.

Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

We would need to remove two characters from  to make it valid, because a and b both have a frequency of  and c and d both have a frequency of . This means  is invalid because we'd need to remove more than  character to make all its letters have the same frequency, so we print NO as our answer.
     */
    static String isValid(String s){
        // Complete this function
        int[] charArray = new int[26];
        for(int i=0;i<26;i++){
            charArray[i] = 0;
        }
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i) - 'a';
            charArray[index]++;
        }
        boolean oneDelete = false;
        //int prevValue = charArray[0];
        //System.out.println("a" + ": " + charArray[0]);
        /*for(int i=1;i<26;i++){
            System.out.println((char) (i+'a') + ": " + charArray[i] + " " + "prevValue" + ": " + prevValue);
            
            if(charArray[i] !=0 && prevValue!= 0 && charArray[i] != prevValue){
                if(oneDelete){
                    return "NO";
                }else{
                    if(Math.abs(charArray[i] - prevValue) != 1){
                        return "NO";
                    }else{
                        oneDelete = true;
                    }
                }
            }
            if(charArray[i] !=0){
             prevValue = charArray[i];   
            }
        }*/
        HashMap<Integer,Integer> frequencyCount = new HashMap<>();
        for(int i=0;i<26;i++){
            if(charArray[i] !=0){
                if(!frequencyCount.containsKey(charArray[i])){
                    frequencyCount.put(charArray[i],1);
                }else{
                    int count =frequencyCount.get(charArray[i]);
                    frequencyCount.put(charArray[i],count+1);
                }
            }
        }
        
        if(frequencyCount.size() > 2){
            return "NO";
        }else if(frequencyCount.size() == 2){
            if(frequencyCount.containsKey(1) && frequencyCount.get(1) == 1){
                return "YES";
            }
            if(isConsecutiveFrequencies(frequencyCount)){
                return "YES";
            }else{
                return "NO";
            }
        }else{
            return "YES";    
        }
        
        
    }

    private static boolean isConsecutiveFrequencies(HashMap<Integer,Integer> frequenciesCount){
        Set<Integer> keySet = frequenciesCount.keySet();
        int[] a = new int[2];
        int j=0;
        for(int i: keySet){
            a[j] = i;
            j++;
        }
        Arrays.sort(a);
        
        if(a[0] +1 != a[1]){
            return false;
        }else{
            int highCount = frequenciesCount.get(a[1]);
            if(highCount == 1){
                return true;
            }
            return false;
        }
    }                 
    public static void isValidMain(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
    
    /**
     Problem
Submissions
Leaderboard
Discussions
Editorial
Tutorial
Given a string , find the number of "unordered anagrammatic pairs" of substrings. In other words, find the number of unordered pairs of substrings of  that are anagrams of each other.

Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.

Input Format 
First line contains , the number of testcases. Each testcase consists of string  in one line.

Constraints 
 
 
String  contains only the lowercase letters of the English alphabet.

Output Format 
For each testcase, print the required answer in one line.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Sample Input 1

5
ifailuhkqq
hucpoltgty
ovarjsnrbf
pvmupwjjjf
iwwhrlkpek
Sample Output 1

3
2
2
6
3
Explanation

Sample 0 
Let's say  denotes the substring .

testcase 1: 
For S=abba, anagrammatic pairs are:  (a and a),  (ab and ba),  (b and b) and  (abb and bba).

testcase 2: 
No anagrammatic pairs.

Sample 1 
Left as an exercise to you. 
     */
    static int sherlockAndAnagrams(String s){
        // Complete this function
        ArrayList<String> substringArray = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                substringArray.add(s.substring(i,j));
            }
        }
        int count = countAnagrams(substringArray);
        return count;
    }

    private static int countAnagrams(ArrayList<String> substringArray){
        int count =0;
        for(int i=0;i<substringArray.size()-1;i++){
            String string_i = substringArray.get(i);
            for(int j=i+1;j < substringArray.size();j++){
                String string_j = substringArray.get(j);
                if(checkAnagram(string_i,string_j)){
                    count++;
                }
            }
        }
        return count;
    }
        
    private static boolean checkAnagram(String aStr,String bStr){
        if(aStr.length() != bStr.length()){
            return false;
        }else{
            char[] aArray = aStr.toCharArray();
            char[] bArray = bStr.toCharArray();
            Arrays.sort(aArray);
            Arrays.sort(bArray);
            for(int i=0;i<aArray.length;i++){
                if(aArray[i] != bArray[i]){
                    return false;
                }
            }
            return true;
        }
    }
    
    public static void sherlockAndAnagramMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
    
    /**
     Sandy likes palindromes. A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward as it does forward. For example, madam is a palindrome.

On her  birthday, Sandy's uncle, Richie Rich, offered her an -digit check which she refused because the number was not a palindrome. Richie then challenged Sandy to make the number palindromic by changing no more than digits. Sandy can only change  digit at a time, and cannot add digits to (or remove digits from) the number.

Given  and an -digit number, help Sandy determine the largest possible number she can make by changing digits.

Note: Treat the integers as numeric strings. Leading zeros are permitted and can't be ignored (So 0011 is not a palindrome, 0110 is a valid palindrome). A digit can be modified more than once.

Input Format

The first line contains two space-separated integers,  (the number of digits in the number) and  (the maximum number of digits that can be altered), respectively. 
The second line contains an -digit string of numbers that Sandy must attempt to make palindromic.

Constraints

Each character  in the number is an integer where .
Output Format

Print a single line with the largest number that can be made by changing no more than  digits; if this is not possible, print -1.

Sample Input 0

4 1
3943
Sample Output 0

3993
Sample Input 1

6 3
092282
Sample Output 1

992299
Sample Input 2

4 1
0011
Sample Output 2

-1
Explanation

Sample 0

There are two ways to make  a palindrome by changing exactly  digits:

, so we print .
     */
    static String richieRich(String s, int n, int k){
        // Complete this function
        StringBuilder left;
        StringBuilder right;
        left = new StringBuilder(s.substring(0,s.length()/2));
        if(s.length()%2 == 0){
            right = new StringBuilder(s.substring(s.length()/2));
        }else{
            right = new StringBuilder(s.substring(s.length()/2+1));
        }
        
        StringBuilder reverseRight = new StringBuilder();
        int j=0;
        for(int i=right.length()-1;i>=0;i--){
            reverseRight.append(right.charAt(i));
            j++;
        }
        
        right = reverseRight;
        int diff = 0;
        for(int i=0;i<left.length();i++){
            if(left.charAt(i) != right.charAt(i)){
                diff++;
            }
        }
        int availableChanges = k;
        //int changesMade = 0;
        if(diff > k){
            return "-1";
        }
        for(int i=0;i<left.length();i++){
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            if(leftChar != rightChar){
                if(leftChar == '9'){
                    k--;
                    diff--;
                    right.setCharAt(i,'9');
                }else if(rightChar == '9'){
                    k--;
                    diff--;
                    left.setCharAt(i,'9');
                }else{
                    if(k-2 < diff-1){
                        k--;
                        diff--;
                        if(leftChar > rightChar){
                            right.setCharAt(i,leftChar);
                        }else{
                            left.setCharAt(i,rightChar);
                        }
                    }else{
                        k -=2;
                        diff--;
                        left.setCharAt(i,'9');
                        right.setCharAt(i,'9');
                    }
                }
                
                
            }else{
                if(k > diff){
                    if(leftChar!= '9'){
                        if(k-2 >= diff){
                            k -=2;
                            left.setCharAt(i,'9');
                            right.setCharAt(i,'9');
                           
                        } 
                    }
                }
            }
        }
        
        reverseRight = new StringBuilder("");
        int j_i=0;
        for(int i=right.length()-1;i>=0;i--){
           reverseRight.append(right.charAt(i));
            j_i++;
        }
        
        
        right = reverseRight;
        if(s.length()%2 == 0){
            return left.toString()+right.toString();    
        }else{
            if(k > 0){
            return left.toString()+ '9' +right.toString();
            }else{
            return left.toString()+ s.charAt(s.length()/2) +right.toString();
            }
        }
        
    }

    public static void richieRichMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
    
}
