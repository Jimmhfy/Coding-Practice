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
        for(int i = 0; i < nums.length; i++){
            for (int j = 0; j <  nums.length; j++) {
                if((x == i || y == j || squareGroup(x,y) == squareGroup(i,j)) && nums[i][j] == value)
                    return false;
            }
        }
        return true;
    }

    public static int squareGroup(int x, int y){
        return x/3+y/3*3;
    }
}
