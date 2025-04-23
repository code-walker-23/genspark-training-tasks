public class Solution {
	public int numSetBits(long a) {
        int setBits = 0;
        while(a > 0){
            if(a%2 != 0)setBits++;
            a = a >> 1;
        }
        return setBits;
	}
}
