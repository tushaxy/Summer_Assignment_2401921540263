class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int originalRows = mat.length;
        int originalCols = mat[0].length;
        
        if (originalRows * originalCols != r * c) {
            return mat;
        }
        
        int[][] reshaped = new int[r][c];
        int newRow = 0;
        int newCol = 0;
        
        for (int i = 0; i < originalRows; i++) {
            for (int j = 0; j < originalCols; j++) {
                reshaped[newRow][newCol] = mat[i][j];
                newCol++;
                
                if (newCol == c) {
                    newCol = 0;
                    newRow++;
                }
            }
        }
        
        return reshaped;
    }
}
