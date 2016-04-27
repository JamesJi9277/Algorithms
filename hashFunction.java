// In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:
//
// hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE
//
//                               = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE
//
//                               = 3595978 % HASH_SIZE
//
// here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).
//
// Given a string as a key and the size of hash table, return the hash value of this key.f
//
//
//
// Have you met this question in a real interview? Yes
// Example
// For key="abcd" and size=100, return 78
//
// Clarification
// For this problem, you are not necessary to design your own hash algorithm or consider any collision issue, you just need to implement the algorithm as described.
//这一题看似简单，实际上要bug free并不容易，需要考虑到精度以及会不会溢出等一系列问题，这题考察的细节真是太好了
//首先要考虑到sum因为做了乘法所以说结果可能会overflow，所以要定义为long，其次就是不需要一次就乘以33的多少次方
//这样子很麻烦，并且需要注意的是Math.pow(double, double)，这里面应该是double，为了不必要的转型操作，
//我们可以将sum不断地累乘来达到效果，然后就是累乘之后就取余，这样子可以保证sum始终在long的范围之内，
//还需要注意的是我如果给的string是“1234”，我要得到integer的1234那么我可以用Integer.parseInt("1234")这个API
//但是我这里给出的是‘a’我要得到他的ASCII码，就不能够这样做，直接强制转换成(int)即可
//最后一步因为题目要求的是return int，所以也是同样的将long强制转换成int就好了
class Solution {
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if(key == null || key.length == 0) {
            return 0;
        }
        long res = 0;
        for(int i = 0; i < key.length; i++) {
            int digit = (int)key[i];
            res = (res * 33 + digit) % HASH_SIZE;
        }
        return (int)res;
    }
};