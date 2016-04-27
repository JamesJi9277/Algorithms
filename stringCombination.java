import java.util.ArrayList;

public class Solution {
    public void stringCombination(String[][] arrays) {
        ArrayList<String> temp = new ArrayList<String>();
        doDFS(0, arrays, temp);
    }
    private void doDFS(int start, String[][] arrays, ArrayList<String> temp) {
        if(start == arrays.length && temp.size() == arrays.length) {
            System.out.println(temp);
        }
        for(int i = start; i < arrays.length; i++) {
            String[] cur = arrays[i];
            for(int j = 0; j < cur.length; j++) {
                temp.add(cur[j]);
                doDFS(i + 1, arrays, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        String[] array1 = {"Red", "Green", "Blue"};
        String[] array2 = {"Large", "Medium", "Small"};
        String[] array3 = {"giant", "monster", "pig"};
        String[][] input = {array1, array2, array3};
        a9 m = new a9();
        m.mergeThreeArray(input);
    }
}