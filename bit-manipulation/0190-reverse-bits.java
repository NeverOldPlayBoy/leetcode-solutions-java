class Solution {
    //位运算分治！M is MASK, 掩码。
    private static final int M1 = 0x55_55_55_55;
    private static final int M2 = 0x33_33_33_33;
    private static final int M4 = 0x0f_0f_0f_0f;
    private static final int M8 = 0x00_ff_00_ff;
    // 16进制 -> 2进制。 01010101_01010101_01010101_01010101;
    public int reverseBits(int n) {
        n = (n & M1) << 1 | (n >> 1) & M1;
        n = (n & M2) << 2 | (n >> 2) & M2;
        n = (n & M4) << 4 | (n >> 4) & M4;
        n = (n & M8) << 8 | (n >> 8) & M8;
        //最高16位最低16位互换. 前面4步，因为掩码的前几位都是0，所以 >> 算术右移不会出错。但是最后一步，没有掩码，必须逻辑右移 >>>         
        return (n << 16) | (n >>> 16);
    }
}
