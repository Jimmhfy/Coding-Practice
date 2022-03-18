import javafx.scene.text.HitInfo;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null) return;
        solver(board);
    }

    public static boolean solver(char[][] nums){
        for(int i = 0; i < nums.length; i++){
            for (int j = 0; j <  nums.length; j++) {
                if(nums[i][j] == '.'){
                    for (char k = '1'; k <= '9' ; k++) {
                        if(validate(nums, i, j, k)){
                            nums[i][j] = k;
                            if(solver(nums))
                                return true;
                            else
                                nums[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validate(char[][] nums, int x, int y, char value){
        for(int i = 0; i < 9; i++){
            if(nums[i][y] == value) return false;
            if(nums[x][i] == value) return false;
            if(nums[x/3*3+i/3][y/3*3+i%3] == value) return false;
        }
        return true;
    }
}
