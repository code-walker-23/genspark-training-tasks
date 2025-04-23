# Problem: Number of 1 Bits

[View Problem on InterviewBit](https://www.interviewbit.com/problems/number-of-1-bits/)

## Solution

This Java method counts the number of set bits (1s) in the binary representation of a given long integer. It iteratively checks the least significant bit and right shifts the number until all bits are processed.

### Code
```java
public class Solution {
    public int numSetBits(long a) {
        int setBits = 0;
        while(a > 0){
            if(a % 2 != 0) setBits++;
            a = a >> 1;
        }
        return setBits;
    }
}
