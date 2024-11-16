public class StringPalindrome {
    public static boolean isPalindrome(String word){
        char[] charArray = word.toCharArray(); //converts the string into a character array
        int start=0;
        int end = word.length()-1;
        while(start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        if(isPalindrome("madam")){
            System.out.println("The given string is a palindrome");
        }else{
            System.out.println("The given string is not a palindrome");
        }

    }
}
