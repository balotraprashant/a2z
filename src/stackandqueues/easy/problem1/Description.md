Problem Link: https://leetcode.com/problems/valid-parentheses/

```
class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.peek();

                if (ch == ')' && top != '(')
                    return false;

                else if (ch == '}' && top != '{')
                    return false;

                else if (ch == ']' && top != '[')
                    return false;

                else
                    stack.pop();
            }
        }

        return stack.size() == 0;

        // Stack<Character> stack = new Stack<>();

        // char[] chArr = s.toCharArray();

        // if(chArr[0]==')' || chArr[0]==']' || chArr[0]=='}') {
        //     return false;
        // }

        // for(int i=0; i<chArr.length; i++) {
        //     if(chArr[i]=='(' || chArr[i]=='{' || chArr[i]=='[') {
        //         stack.push(chArr[i]);
        //     } else if (chArr[i]==')' && !stack.isEmpty() && stack.peek() == '(') {
        //         stack.pop();
        //     } else if (chArr[i]==']' && !stack.isEmpty() && stack.peek() == '[') {
        //         stack.pop();
        //     } else if (chArr[i]=='}' && !stack.isEmpty() && stack.peek() == '{') {
        //         stack.pop();
        //     } else {
        //         return false;
        //     }
        // }

        // return stack.size()==0;
    }
}
```
