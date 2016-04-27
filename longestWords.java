// Given a dictionary, find all of the longest words in the dictionary.

// Have you met this question in a real interview? Yes
// Example
// Given

// {
//   "dog",
//   "google",
//   "facebook",
//   "internationalization",
//   "blabla"
// }
// the longest words are(is) ["internationalization"].

// Given

// {
//   "like",
//   "love",
//   "hate",
//   "yes"
// }
// the longest words are ["like", "love", "hate"].

//bug free
class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> res = new ArrayList<String>();
        if(dictionary == null || dictionary.length == 0) {
            return res;
        }
        Stack<String> stack = new Stack<String>();
        stack.push(dictionary[0]);
        for(int i =1;i<dictionary.length;i++){
            if(dictionary[i].length() > stack.peek().length()) {
                while(!stack.isEmpty()){
                    if(stack.peek().length() < dictionary[i].length()) {
                        stack.pop();
                    }
                }
                stack.push(dictionary[i]);
            }
            else if(dictionary[i].length() == stack.peek().length()){
                 stack.push(dictionary[i]);
             }
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
};


