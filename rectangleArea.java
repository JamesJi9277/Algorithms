// Find the total area covered by two rectilinear rectangles in a 2D plane.
public class Solution{
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
		if(C<E||G<A )
			return (G-E)*(H-F) + (C-A)*(D-B);
        if(D<F || H<B)
        	return (G-E)*(H-F) + (C-A)*(D-B);
		int sum = (C-A)*(D-B) + (G-E)*(H-F);
		int cover = sum - (Math.min(C,G)-Math.max(A,E))*(Math.min(H,D)-Math.max(F,B));
		return cover;
	}
}