import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class SudokuSolverTest {

    @Test
    public void sukudoSolver() {
        var leetCode = new SudokuSolver();
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

        char[][] expected = new char[][]{
                {'5','6','7','9','3','8','1','4','2'},
                {'2','4','1','6','7','5','9','8','3'},
                {'9','8','3','4','2','1','5','6','7'},
                {'8','2','9','3','1','4','7','5','6'},
                {'6','1','5','8','9','7','2','3','4'},
                {'3','7','4','5','6','2','8','9','1'},
                {'1','9','6','2','5','3','4','7','8'},
                {'7','3','8','1','4','9','6','2','5'},
                {'4','5','2','7','8','6','3','1','9'}
        };
        leetCode.solveSudoku(input, rule, ruleMap);
        Assertions.assertArrayEquals(expected,input);
    }

    @Test
    public void sukudoSolver1() {
        var leetCode = new SudokuSolver();
        char[][] input = new char[][]{
                {'.','.'},
                {'.','.'}
        };
        char[][] rule = new char[][]{
                {'a','a'},
                {'b','b'}
        };
        HashMap<Character, Integer> ruleMap = new HashMap<>();
        ruleMap.put('a',3);
        ruleMap.put('b',7);

        char[][] expected = new char[][]{
                {'1','2'},
                {'3','4'}
        };
        leetCode.solveSudoku(input, rule, ruleMap);
        Assertions.assertArrayEquals(expected,input);
    }
}