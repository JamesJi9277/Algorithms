就是一个dart game，然后有一群possible scores,然后给你一个candidate score，
问这个candidate score是不是可能的得分。
For example:possible scores: [3,5,3,3,5] 
(有duplicates，unsorted，可能有很多很多possible score，不一定只有3和5)

candidate score: 6, yes
candidate score: 11, yes
candidate score: 7, no
candidate score: 0, yes

import java.util.*;
public class can {
	public boolean isValid(int score, int[] scores) {
		if(scores == null || scores.length == 0) {
			return false;
		}
		Arrays.sort(scores);
		return helper(score, scores, 0);
	}
	private boolean helper(int score, int[] scores, int index) {
		if(score == 0) {
			return true;
		}
		for(int i = index; i < scores.length; i++) {
			if(i != index && scores[i] == scores[i - 1]) {
				continue;
			}
			if(helper(score - scores[i], scores, i + 1)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int score = 12;
		int[] scores = {3,3,5,5};
		can c = new can();
		System.out.print(c.isValid(score, scores));
	}
}

