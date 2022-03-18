import javafx.scene.text.HitInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class SudokuSolver {
    public static void main(String[] args){
        char[][] input = new char[][]{
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };
        char[][] rule = new char[][]{
                {'a','a','e','j','j','p','p','t','v'},
                {'a','e','e','e','k','k','p','t','v'},
                {'b','e','e','k','k','q','p','p','v'},
                {'b','c','h','h','h','q','q','s','s'},
                {'c','c','c','l','l','l','s','s','s'},
                {'c','c','i','i','n','n','n','s','w'},
                {'d','f','f','i','m','m','r','r','w'},
                {'d','g','f','m','m','r','r','r','u'},
                {'d','g','f','f','o','o','r','u','u'}
        };
        HashMap<Character, Integer> ruleMap = new HashMap<>();
        ruleMap.put('a',13);ruleMap.put('b',17);ruleMap.put('c',24);
        ruleMap.put('d',12);ruleMap.put('e',29);ruleMap.put('f',32);
        ruleMap.put('g',8);ruleMap.put('h',13);ruleMap.put('i',11);
        ruleMap.put('j',12);ruleMap.put('k',18);ruleMap.put('l',24);
        ruleMap.put('m',13);ruleMap.put('n',16);ruleMap.put('o',14);
        ruleMap.put('p',29);ruleMap.put('q',12);ruleMap.put('r',31);
        ruleMap.put('s',29);ruleMap.put('t',12);ruleMap.put('u',15);
        ruleMap.put('v',12);ruleMap.put('w',9);
        solveSudoku(input, rule, ruleMap);
    }

    public static void solveSudoku(char[][] board, char[][] rule, HashMap<Character, Integer> ruleMap) {
        if(board == null) return;
        dfs(board, 0, rule, ruleMap);
    }

    private static boolean dfs(char[][] board, int d, char[][] rule, HashMap<Character, Integer> ruleMap) {
        if (d==81) return true; //found solution
        int i=d/9, j=d%9;
        if (board[i][j]!='.') return dfs(board,d+1, rule, ruleMap);//prefill number skip

        boolean[] flag=new boolean[10];
        validate(board,i,j,flag, rule, ruleMap);
        for (int k=1; k<=9; k++) {
            if (flag[k]) {
                board[i][j]=(char)('0'+k);
                if(ruleMap.get(rule[i][j])<k)
                    break;
                ruleMap.put(rule[i][j], ruleMap.get(rule[i][j])-k);
                if (dfs(board,d+1, rule, ruleMap)) return true;
                ruleMap.put(rule[i][j], ruleMap.get(rule[i][j])+k);
            }
        }
        board[i][j]='.'; //if can not solve, in the wrong path, change back to '.' and out
        return false;
    }
    private static void validate(char[][] board, int i, int j, boolean[] flag, char[][] rule, HashMap<Character, Integer> ruleMap) {
        Arrays.fill(flag,true);
        for (int k=0; k<9; k++) {
            if (board[i][k]!='.') flag[board[i][k]-'0']=false;
            if (board[k][j]!='.') flag[board[k][j]-'0']=false;
            int r=i/3*3+k/3;
            int c=j/3*3+k%3;
            if (board[r][c]!='.') flag[board[r][c]-'0']=false;
        }
    }
}
