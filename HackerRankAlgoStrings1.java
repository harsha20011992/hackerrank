/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author harsha-1916
 */
public class HackerRankAlgoStrings1 {
    /*
    Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc" after operation.

Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Steve out by finding and printing 's non-reducible form!

Note: If the final string is empty, print Empty String .

Input Format

A single string, .

Constraints

Output Format

If the final string is empty, print Empty String; otherwise, print the final non-reducible string.

Sample Input 0

aaabccddd
Sample Output 0

abd
Sample Case 0

Steve can perform the following sequence of operations to get the final string:

aaabccddd → abccddd
abccddd → abddd
abddd → abd
Thus, we print abd.

Sample Input 1

baab
Sample Output 1

Empty String
Explanation 1

Steve can perform the following sequence of operations to get the final string:

baab → bb
bb → Empty String
Thus, we print Empty String.

Sample Input 2

aa
Sample Output 2

Empty String
Explanation 2

Steve can perform the following sequence of operations to get the final string:

aa → Empty String
Thus, we print Empty String.
    */
    static String super_reduced_string(String s){
        // Complete this function
        char[] charArray = s.toCharArray();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                //System.out.println( "s.charAt(" + i+ "): " + s.charAt(i));
                //System.out.println( "s.charAt(" + (i-1)+ "): " + s.charAt(i-1));    
                //System.out.println( "s.substring(" + 0 + "," + (i-1)+ "): " + s.substring(0, i-1));
                //System.out.println( "s.substring(" + (i+1) + "," + s.length()+ "): " + s.substring(0, i-1));
                s = s.substring(0, i-1) + s.substring(i+1,s.length());
                i-=2;
                if(i==-1){
                    i=0;
                }
            }
        }
        if(s== null || s.equals("")){
            return "Empty String";
        }else{
        return s;
        }
    }

    public static void reduced_string_Helper(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
    
    /*
    Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:

It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
Given , print the number of words in  on a new line.

Input Format

A single line containing string .

Constraints

Output Format

Print the number of words in string .

Sample Input

saveChangesInTheEditor
Sample Output

5
Explanation

String  contains five words:

save
Changes
In
The
Editor
Thus, we print  on a new line.

Need help? Try this problem first to get familiar with HackerRank environ
    */
    public static void camelCase(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int wordCount =1;
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr >= 'A' && curr <= 'Z'){
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
    /**
     * String  always consists of two distinct alternating characters. For example, if string 's two distinct characters are x and y, then t could be xyxyx or yxyxy but not xxyy or xyyx.

You can convert some string  to string  by deleting characters from . When you delete a character from , you must delete all occurrences of it in . For example, if  abaacdabd and you delete the character a, then the string becomes bcdbd.

Given , convert it to the longest possible string . Then print the length of string  on a new line; if no string  can be formed from , print  instead.

Input Format

The first line contains a single integer denoting the length of . 
The second line contains string .

Constraints

 only contains lowercase English alphabetic letters (i.e., a to z).
Output Format

Print a single integer denoting the maximum length of  for the given ; if it is not possible to form string , print instead.

Sample Input

10
beabeefeab
Sample Output

5
Explanation

The characters present in  are a, b, e, and f. This means that  must consist of two of those characters.

If we delete e and f, the resulting string is babab. This is a valid  as there are only two distinct characters (a and b), and they are alternating within the string.

If we delete a and f, the resulting string is bebeeeb. This is not a valid string  because there are three consecutive e's present.

If we delete only e, the resulting string is babfab. This is not a valid string  because it contains three distinct characters.

Thus, we print the length of babab, which is , as our answer.
     *  
     */
    
        public static void twoCharacters(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
            ArrayList<Character> chars = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char char_i = s.charAt(i);
            if(!chars.contains(char_i)){
                chars.add(char_i);
            }
        }
        int max =0;
        
        for(int i=0;i<chars.size()-1;i++){
            char char_i = chars.get(i);
            for(int j=i+1;j<chars.size();j++){
                char char_j = chars.get(j);
                StringBuilder temp = new StringBuilder(s);
                //System.out.println("Keeping char_i: " + char_i + " char_j: " + char_j);
                for(int k=0;k<temp.length();k++){
                        char char_k = temp.charAt(k);
                        if(char_k != char_i && char_k != char_j){
                            temp.deleteCharAt(k);
                            k--;
                        }
                }
                //System.out.println(temp);
                int temp_max =  validStringCount(temp);
                if(temp_max > max){
                    max = temp_max;
                }
            }
            
        }
        System.out.println(max);
    }
    private static int validStringCount(StringBuilder s){
        char charAt0 = s.charAt(0);
        char charAt1 = s.charAt(1);
        if(charAt0 == charAt1){
            return 0;
        }else{
            boolean isValidString = true;
            for(int i=2;i<s.length();i++){
                char char_i = s.charAt(i);
                if(i%2==0){
                    if(char_i != charAt0){
                        isValidString = false;
                        break;
                    }
                }else{
                    if(char_i != charAt1){
                        isValidString = false;
                        break;
                    }
                }
            }
            if(isValidString){
                return s.length();
            }else{
                return 0;
            }
        }
    }
    /**
   Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every letter in a string by a fixed number, , making it unreadable by his enemies. Given a string, , and a number, , encrypt  and print the resulting string.

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

Input Format

The first line contains an integer, , which is the length of the unencrypted string. 
The second line contains the unencrypted string, . 
The third line contains the integer encryption key, , which is the number of letters to rotate.

Constraints 
 
 
 is a valid ASCII string and doesn't contain any spaces.

Output Format

For each test case, print the encoded string.

Sample Input

11
middle-Outz
2
Sample Output

okffng-Qwvb
Explanation

Each unencrypted letter is replaced with the letter occurring  spaces after it when listed alphabetically. Think of the alphabet as being both case-sensitive and circular; if  rotates past the end of the alphabet, it loops back to the beginning (i.e.: the letter after  is , and the letter after  is ).

Selected Examples: 
 (ASCII 109) becomes  (ASCII 111). 
 (ASCII 105) becomes  (ASCII 107). 
 remains the same, as symbols are not encoded. 
 (ASCII 79) becomes  (ASCII 81). 
 (ASCII 122) becomes  (ASCII 98); because  is the last letter of the alphabet,  (ASCII 97) is the next letter after it in lower-case rotation.
     */
    
    
        public static void ceaserCipher(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String unencryptedString = sc.next();
        int k = sc.nextInt();
        char[] encryptedString = encryptString(unencryptedString,k); 
        for(int i=0;i<encryptedString.length;i++){
            System.out.print(encryptedString[i]);
        }
    }
    
    private static char[] encryptString(String unEncryptedString,int k){
        k = k%26;
        char[] encryptedString = new char[unEncryptedString.length()];
        for(int i=0;i<unEncryptedString.length();i++){
            char char_i = unEncryptedString.charAt(i);
            if(isSmallCase(char_i)){
                   int char_int = (int)char_i;
                   //System.out.println("char_int: " + char_int);
                   int startIndex  =  (int) 'a';        
                    //System.out.println("startIndex: " + startIndex);
                    int moduloIndex = (int)'z';
                   //System.out.println("moduloIndex: " + moduloIndex);
                int addIndex = k+char_int;
                if(addIndex > moduloIndex){
                    int newValue = startIndex + ((addIndex)%moduloIndex) -1;
                    addIndex = newValue;
                }
                //System.out.println("addIndex: " + addIndex);
                    
                  // System.out.println("newValue: " + addIndex);
                   encryptedString[i] = (char) addIndex;
            }else if(isUpperCase(char_i)){
               int char_int = (int)char_i;
                   //System.out.println("char_int: " + char_int);
                   int startIndex  =  (int) 'A';        
                    //System.out.println("startIndex: " + startIndex);
                    int moduloIndex = (int)'Z';
                   //System.out.println("moduloIndex: " + moduloIndex);
                int addIndex = k+char_int;
                if(addIndex > moduloIndex){
                    int newValue = startIndex + ((addIndex)%moduloIndex) -1;
                    addIndex = newValue;
                }
                //System.out.println("addIndex: " + addIndex);
                    
                   //System.out.println("newValue: " + newValue);
                   encryptedString[i] = (char) addIndex;
            }else{
                 encryptedString[i] = char_i;
            }
        }
        return encryptedString;
    }
    
    private static boolean isSmallCase(char char_i){
        if(char_i >= 'a' && char_i <= 'z'){
            return true;
        }
        return false;
    }
    
    private static boolean isUpperCase(char char_i){
           if(char_i >= 'A' && char_i <= 'Z'){
            return true;
        }
        return false;
    }
    /**
     Problem
Submissions
Leaderboard
Discussions
Editorial
Sami's spaceship crashed on Mars! She sends  sequential SOS messages to Earth for help.

NASA_Mars_Rover.jpg

Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, , determine how many letters of Sami's SOS have been changed by radiation.

Input Format

There is one line of input: a single string, .

Note: As the original message is just SOS repeated  times, 's length will be a multiple of .

Constraints

 will contain only uppercase English letters.
Output Format

Print the number of letters in Sami's message that were altered by cosmic radiation.

Sample Input 0

SOSSPSSQSSOR
Sample Output 0

3
Sample Input 1

SOSSOT
Sample Output 1

1
Explanation

Sample 0

 = SOSSPSSQSSOR, and signal length . Sami sent  SOS messages (i.e.: ).

Expected signal: SOSSOSSOSSOS
Recieved signal: SOSSPSSQSSOR

We print the number of changed letters, which is .

Sample 1

 = SOSSOT, and signal length . Sami sent  SOS messages (i.e.: ).

Expected Signal: SOSSOS 
Received Signal: SOSSOT

We print the number of changed letters, which is . 
     */
    
    
    public static void marsRover(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int count =0;
        for(int i=0;i<S.length()-2;i=i+3){
            if(S.charAt(i) != 'S'){
                count++;
            }
            
            if(S.charAt(i+1) != 'O'){
                count++;
            }
            if(S.charAt(i+2) != 'S'){
                count++;
            }
        }
        System.out.println(count);
    }
    
    /**
     We say that a string, , contains the word hackerrank if a subsequence of the characters in  spell the word hackerrank. For example, haacckkerrannkk does contain hackerrank, but haacckkerannk does not (the characters all appear in the same order, but it's missing a second r).

More formally, let  be the respective indices of h, a, c, k, e, r, r, a, n, k in string . If  is true, then  contains hackerrank.

You must answer  queries, where each query consists of a string, . For each query, print YES on a new line if contains hackerrank; otherwise, print NO instead.

Input Format

The first line contains an integer denoting  (the number of queries). 
Each line of the  subsequent lines contains a single string denoting .

Constraints

Output Format

For each query, print YES on a new line if  contains hackerrank; otherwise, print NO instead.

Sample Input 0

2
hereiamstackerrank
hackerworld
Sample Output 0

YES
NO
Explanation 0

We perform the following  queries:

 
The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we print YES on a new line.
 does not contain the last three characters of hackerrank, so we print NO on a new line. 
     */
    
        public static void hackerRankString(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String needed = "hackerrank";
            int j=0;
       
            for(int i=0;i<s.length() && j< needed.length();i++){
                if(s.charAt(i) == needed.charAt(j)){
                    j++;
                }
            }
            //System.out.println("j:" + j);
            if(j==needed.length()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
        /*
        
        Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence , tell Roy if it is a pangram or not.

Input Format

Input consists of a string .

Constraints 
Length of  can be at most   and it may contain spaces, lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.

Output Format

Output a line containing pangram if  is a pangram, otherwise output not pangram.

Sample Input

Input #1

We promptly judged antique ivory buckles for the next prize    
Input #2

We promptly judged antique ivory buckles for the prize    
Sample Output

Output #1

pangram
Output #2

not pangram
Explanation

In the first test case, the answer is pangram because the sentence contains all the letters of the English alphabet.
        */
        
            public static void isPanagram(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        boolean[] charArray = new boolean[26];
        for(int i=0;i<25;i++){
            charArray[i] = false;
        }
        //System.out.println("s: " + s);
        for(int i=0;i<s.length();i++){
            int char_i = s.charAt(i);
            if(isValidChar(s.charAt(i))){
            int arrayIndex = char_i - (int)'a';
            //System.out.println("arrayIndex: " + arrayIndex);    
            charArray[arrayIndex] = true;
            }
        }
        boolean isPanagram = true;
        for(int i=0;i<25;i++){
            if(!charArray[i]){
                isPanagram = false;
            }
        }
        if(isPanagram){
            System.out.println("pangram");
        }else{
             System.out.println("not pangram");
        }
    }
    
    private static boolean isValidChar(char char_i){
        if(char_i >= 'a' && char_i <= 'z'){
            return true;
        }
        return false;
    }
    
    /**
     * A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:

 for any  (i.e., each element in the sequence is  more than the previous element).
No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
The diagram below depicts some beautiful strings:

image

You must perform  queries, where each query consists of some string . For each query, print whether or not the string is beautiful on a new line. If it's beautiful, print YES x, where  is the first number of the increasing sequence (if there are multiple such values of , choose the smallest); otherwise, print NO instead.

Input Format

The first line contains an integer denoting  (the number of strings to evaluate). 
Each of the  subsequent lines contains some string  for a query.

Constraints

Each character in  is a decimal digit from  to  (inclusive).
Output Format

For each query, print its answer on a new line (i.e., either YES x where  is the smallest first number of the increasing sequence, or NO).

Sample Input 0

7
1234
91011
99100
101103
010203
13
1
Sample Output 0

YES 1
YES 9
YES 99
NO
NO
NO
NO
Explanation 0

The first three numbers are beautiful (see the diagram above). The remaining numbers are not beautiful:

For , all possible splits violate the first and/or second conditions.
For , it starts with a zero so all possible splits violate the second condition.
For , the only possible split is , which violates the first condition.
For , there are no possible splits because  only has one digit.
     *  
     */
    
    public static void BeautifulStringMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // your code goes here
           long index= findBeautifulIndex(s);
            if(index != 0){
                System.out.println("YES" + " " + index);
            }else{
                System.out.println("NO");
            }
        }
    }
    
    private static long findBeautifulIndex(String s){
        if(s.length() == 1){
            return 0;
        }else if(s.charAt(0) == '0'){
            return 0;
        }else{
            boolean isPossible = true;
            long startNumber = 0;
            for(int i=0;i<s.length()/2;i++){
                long currLong = Long.parseLong(s.substring(0,i+1));
                startNumber = currLong;
                int lengthString = i+1;
                //System.out.println("startNumber: " + startNumber);
                for(int j=i+1;j<s.length();j = j+lengthString){
                    isPossible = true;
                    int currLengthIndex = j+lengthString;
                    if(currLengthIndex >= s.length()){
                        currLengthIndex =  s.length();
                    }
                    //System.out.println("j:" + j);
                    //System.out.println("currLengthIndex:" + currLengthIndex);
                    long nextLong = Long.parseLong(s.substring(j,currLengthIndex));
                    //System.out.println("nextLong:" + nextLong);
                    if(nextLong -1 == currLong){
                        currLong = nextLong;
                        continue;
                    }else{
                        currLengthIndex++;
                        if(currLengthIndex >= s.length()){
                        currLengthIndex =  s.length();
                    }   
                          //System.out.println("currLengthIndex:" + currLengthIndex);
                        nextLong = Long.parseLong(s.substring(j,currLengthIndex));
                        //System.out.println("currLong:" + currLong); 
                        //System.out.println("nextLong:" + nextLong);
                        if(nextLong -1 == currLong){
                            
                            currLong = nextLong;
                            lengthString++;
                            //System.out.println("lengthString:" + lengthString);
                        continue;
                    }else{
                            isPossible = false;
                            //System.out.println("isPossible:" + isPossible);
                            break;
                        }
                        
                    }           
                }
                //System.out.println("isPossible: " + isPossible);
                if(isPossible){
                    return startNumber;
                }
            }
            return 0;
        }
    }
    
    /**
    Suppose you have a String, , of length  that is indexed from  to . You also have some String, , that is the reverse of String .  is funny if the condition  is true for every character from  to .

Note: For some String ,  denotes the ASCII value of the  -indexed character in . The absolute value of an integer, , is written as .

Input Format

The first line contains an integer,  (the number of test cases). 
Each line  of the  subsequent lines contain a string, .

Constraints

Output Format

For each String  (where ), print whether it is  or  on a new line.

Sample Input

2
acxz
bcxz
Sample Output

Funny
Not Funny
Explanation

Test Case 0:  
 
 
 
As each comparison is equal, we print .

Test Case 1:  
, but  
At this point, we stop evaluating  (as ) and print .
     */
    
    static String funnyString(String s){
        // Complete this function
        String r = reverseString(s);
        boolean isFunny = true;
        for(int i=1;i<s.length();i++){
            if(Math.abs(s.charAt(i-1) - s.charAt(i)) != Math.abs(r.charAt(i-1) - r.charAt(i))){
                isFunny = false;
                break;
            } 
        }
        if(isFunny){
           return "Funny";
        }else{
            return "Not Funny";
        }
    }

    private static String reverseString(String s){
        String r = "";
        for(int i=s.length()-1;i>=0;i--){
           r+= s.charAt(i);
       }
        return r;
    }
    public static void isFunnyMain(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
    /**
     * A weighted string is a string of lowercase English letters where each letter has a weight in the inclusive range from to , defined below:

image

We define the following terms:

The weight of a string is the sum of the weights of all the string's characters. For example:

image

A uniform string is a string consisting of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not (i.e., they consist of more than one distinct character).
Given a string, , let  be the set of weights for all possible uniform substrings (contiguous) of string . You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.

Note: The  symbol denotes that  is an element of set .

Input Format

The first line contains a string denoting  (the original string). 
The second line contains an integer denoting  (the number of queries). 
Each line  of the  subsequent lines contains an integer denoting  (the weight of a uniform subtring of  that may or may not exist).

Constraints

 will only contain lowercase English letters.
Output Format

Print  lines. For each query, print Yes on a new line if ; otherwise, print No instead.

Sample Input 0

abccddde
6
1
3
12
5
9
10
Sample Output 0

Yes
Yes
Yes
Yes
No
No
Explanation 0

The weights of every possible uniform substring in the string abccddde are shown below:

image

We print Yes on the first four lines because the first four queries match weights of uniform substrings of . We print No for the last two queries because there are no uniform substrings in  that have those weights.

Note that while de is a substring of  that would have a weight of , it is not a uniform substring.

Note that we are only dealing with contiguous substrings. So ccc is not a substring of the string ccxxc. 
     */
    public static void weightedSum(String[] args) {
            Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        int[] charInt = new int[27];
        for(int i=1;i<27;i++){
            charInt[i] = 0;
        }
        Set<Integer> U = new HashSet<>();
        //boolean[] Uarray = new boolean[]
        int prevString = s.charAt(0) - 97 + 1;;
        U.add((prevString * 1));
        int counter = 1;
        for(int i=1;i<s.length();i++){
            int char_i = s.charAt(i) - 97 + 1;
            if(char_i == prevString ){
                counter++;
                U.add((char_i * counter));    
            }else{
                prevString = s.charAt(i) - 97 + 1;;
                U.add((prevString * 1));
                counter =1;
            }
            //charInt[char_i] = charInt[char_i] + 1; 
            //System.out.println("charInt[char_i]: " + charInt[char_i]);
            //U.add((char_i * charInt[char_i]));
        }
        /*ArrayList<Integer> U = new ArrayList<>();
        for(int i=1;i<27;i++){
            int num = charInt[i];
            if(num != 0){
                for(int j=1;j<=num;j++){
                    //System.out.println("Index: " + (i*j));
                    U.add(i*j);
                }
            }
        }*/
        
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            // your code goes here
            if(U.contains(x)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }

    /*
        John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.

Given the list of  rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format

The first line consists of an integer, , the number of rocks. 
Each of the next  lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.

Constraints 
 
Each composition consists of only lower-case Latin letters ('a'-'z'). 
 length of each composition 

Output Format

Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Sample Input

3
abcdde
baccd
eeabg
Sample Output

2
Explanation

Only "a" and "b" are the two kinds of gem-elements, since these are the only characters that occur in every rock's composition.
        */
        static int gemstones(String[] arr){
        // Complete this function
        int[] charArray = new int[26];
        for(int i=0;i<charArray.length;i++){
            charArray[i] = -1;
        }
        for(int i=0;i<arr.length;i++){
            String currString = arr[i];
             //System.out.println(currString);
            for(int j=0;j<currString.length();j++){
                int char_j = currString.charAt(j) - 97;
                //System.out.println("char_i: " + char_i);
                if(charArray[char_j] == i-1){
                    //System.out.print("charAtJ: " + currString.charAt(j));
                    charArray[char_j] = i;
                }
            }
            //System.out.println();
        }
        int count =0;
            for(int k=0;k<26;k++){
                if(charArray[k] == arr.length-1){
                    count++;
                }
            }
            return count;
    }

    public static void gemStones(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
/*
     
     You are given a string containing characters  and  only, your task is to change it into a string such that every two consecutive characters are different. To do this, you are allowed to delete one or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, string  should be changed to  by deleting one character .

Input Format

The first line contains an integer , i.e. the number of test cases. 
The next  lines contain a string .

Constraints

Output Format

For each test case, print the minimum number of deletions required in a new line.

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

The characters marked red are the ones that need to be deleted so that the string doesn't have two same consecutive characters.

image
     */    
    
     static int alternatingCharacters(String s){
        // Complete this function
        char prevChar = s.charAt(0);
        int count=0;
        for(int i=1;i<s.length();i++){
            char currChar = s.charAt(i);
            if(currChar  == prevChar){
                count++;
            }else{
                prevChar = currChar;
            }
        }
        return count;
    }

    public static void alternatingCharactersHelper(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }
}

