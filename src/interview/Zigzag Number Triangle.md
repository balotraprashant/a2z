### Solution

```
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        // 1
        // 3	2
        // 4	5	6
        // 10	9	8	7
        
        int num = 10;
        int curr = 1;
        int count = 1;
        boolean clockwise = true;
        
        while(curr<=10) {
            if(clockwise) {
                for(int i=0; i<count; i++) {
                    System.out.print(curr + " ");
                    curr++;
                }
            } else {
                int end = curr + count - 1;
                if (end > num) end = num;
                
                for(int i=end; i>=curr; i--) {
                    System.out.print(i + " ");
                }
                curr = end+1;
            }
            count++;
            clockwise = !clockwise;
            System.out.println();
        }
    }
}
```
