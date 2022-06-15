package stack;

public class FloodFill_1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color) return image;

        fill(image, sr, sc, originalColor, color);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]==newColor) {
            return;
        }
        if(image[sr][sc]==originalColor) {
            image[sr][sc]=newColor;
        } else {
            return;
        }

        fill(image, sr-1, sc, originalColor, newColor);
        fill(image, sr+1, sc, originalColor, newColor);
        fill(image, sr, sc-1, originalColor, newColor);
        fill(image, sr, sc+1, originalColor, newColor);
    }
}
