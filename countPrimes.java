public class Solution {
    //get prime numbers less than n
    public int countPrimes(int n) {
        if(n < 3) {
            return 0;
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
	public int countPrimes(int n) {
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
	}
	private boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		for(int i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

public class Solution {
    public int countPrimes(int n) {
        if(n < 3) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i + i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}