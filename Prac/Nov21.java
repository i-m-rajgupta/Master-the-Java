import java.util.*;
public class Nov21 {
    public static String reverse(String str){
        int start = 0,end = str.length()-1;
        char ch[] = str.toCharArray();
        while (start<end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        String res = "";
        for(char ele:ch){
          res += ele;
        }
        return res;
    }

    public static boolean isPalindrome(String str){
      str = str.toLowerCase();
      int start = 0,end = str.length()-1;
      while (start < end) {
        if(str.charAt(start) != str.charAt(end)){
            return false;
        }
        start++;
        end--;
      }
      return true;
    }

    public static void count(String str){
        int vowels = 0,constants =0;
        for(int i =0;i<str.length();i++){
          char ele = Character.toLowerCase(str.charAt(i));
          if(Character.isAlphabetic(ele)){
            if(ele == 'a' || ele == 'e' || ele == 'i' || ele == 'o' || ele == 'u'){
                vowels++;
            }else{
                constants++;
            }
          }
        }
        System.out.println("Total vowels and consonants present in the "+str+" is "+vowels+" and "+constants);

    }

    public static void frequency(String str){
      HashMap<Character,Integer> map = new HashMap<>();
      for(int i = 0 ; i < str.length();i++ ){
        char ch = str.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
      }

      System.out.println("Frequency of each character in "+str+" : ");
      for(HashMap.Entry<Character,Integer> entry : map.entrySet()){
         System.out.print(entry.getKey()+":"+entry.getValue()+",");
      }
      System.out.println();
    }

    public static int first_non_repeating(String str){
      HashMap<Character,Integer> map = new HashMap<>();
      for(int i = 0;i<str.length();i++){
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch,0)+1);
      }
      
      for(int i = 0;i<str.length();i++){
        if(map.get(str.charAt(i)) == 1){
             return str.charAt(i);
        }
      }

      return -1;
    }

    public static void remove_duplicate(String str){
      HashMap<Character,Integer> map = new HashMap<>();
      for(int i = 0;i<str.length();i++){
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch,0)+1);
      }

      String res = "";
      for(int i =0;i<str.length();i++){
        char ch = str.charAt(i);
        if(map.get(ch) != -1){
          res += ch;
          map.put(ch, -1);
      }
    }

    System.out.println("After removing the duplicate from "+str+" is : "+res);
    }

    public static boolean isAnagram(String str1,String str2){

       str1 = str1.toLowerCase();
       str2 = str2.toLowerCase();
       HashMap<Character,Integer> map1 = new HashMap<>();
       HashMap<Character,Integer> map2 = new HashMap<>();
       

       for(int i = 0;i<str1.length();i++){
        char ch = str1.charAt(i);
        
        if(ch == ' '){
         continue;
        }
        map1.put(ch, map1.getOrDefault(ch, 0)+1);
       }
       for(int i =0;i<str2.length();i++){
        char ch = str2.charAt(i);
       if(ch == ' '){
         continue;
        }
        map2.put(ch, map2.getOrDefault(ch, 0)+1);     
       }

       return map1.equals(map2);
    }

    public static void longest(String str){
       String[] arr = str.split(" ");
       String longest = "";
       for(String ele : arr){
         if(ele.length() > longest.length()){
          longest = ele;
         }
       }
       System.out.println(longest);
      
    }

    public static String shorten(String str) {
    if (str.isEmpty()) {
        return str;
    }

    StringBuilder res = new StringBuilder();
    int count = 1;

    for (int i = 1; i <= str.length(); i++) {

        if (i < str.length() &&
            str.charAt(i) == str.charAt(i - 1)) {

            count++;

        } else {

            res.append(str.charAt(i - 1));

            if (count > 1) {
                res.append(count);
            }

            count = 1;
        }
    }

    if (res.length() < str.length()) {
        return res.toString();
    }

    return str;
}

    public static  int longest_substring(String str){
      HashMap<Character,Integer> map = new HashMap<>();
      int start = 0,maxLength = 0;
      for(int i =0;i<str.length();i++){
        char ch = str.charAt(i);
        if(map.containsKey(ch) && map.get(ch) >= start){
          start = map.get(ch)+1;
        }
        map.put(ch,i);
        maxLength = Math.max(maxLength, i-start +1);
      }
      return maxLength;
    }
    public static void main(String[] args){
        String str = "Madam";
        // Write a Java program to reverse a given string without using StringBuilder.reverse().
        System.out.println("String after reverse : "+reverse("hello"));

        // Check whether a given string is a palindrome. Ignore uppercase/lowercase differences.
        System.out.println(str+" is palindrome : "+isPalindrome(str));
        System.out.println("Aa is palindrome : "+isPalindrome("Aa"));

        // Count the number of vowels and consonants in a string. Ignore spaces, digits, and special characters.
        count("1a & b : 2ce f ");
        count("Java Programming");

        // Find the frequency of every character in a string using HashMap.
        frequency("programming");
        frequency(str);

        // Find the first character that appears exactly once in a string. Return -1 if no such character exists.
        int res = first_non_repeating("swiss");
        if(res == -1){
            System.out.println("Non-Repeating character is not present");
        }else{
          System.out.println("Result "+(char)res);
        }
         res = first_non_repeating("maddam");
        if(res == -1){
            System.out.println("Non-Repeating character is not present");
        }else{
          System.out.println("Result "+(char)res);
        }
        

        // Remove duplicate characters while preserving the original order of their first occurrence.
         remove_duplicate("programming");
         remove_duplicate("laptop acer 7q");

        //Check whether two strings are anagrams of each other. Ignore case and spaces.
        System.out.println("These two are Anagram "+isAnagram("Listen", "silent"));
        System.out.println("These two are Anagram "+isAnagram("raj", "jak"));
        System.out.println("These two are Anagram "+isAnagram("a!", "a"));
        System.out.println("These two are Anagram "+isAnagram("raj ", "jar"));

        // Find the longest word in a sentence. If multiple words have the same maximum length, return the first one.
        String sentence = "Java is a programming language";
        longest(sentence);
        longest("I like and care you");

        // Compress consecutive repeated characters by replacing each group with the character followed by its count. Return the original string if compression does not make it shorter.
        System.out.println(shorten("aaabbccccd" ));
        System.out.println(shorten("aabbcdd" ));

        // Find the length of the longest substring containing no repeated characters. Solve using the sliding window technique.
        System.out.println(longest_substring("abcabcbb"));
        System.out.println(longest_substring("klompmp"));
    }
}