import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CodecTest {
    @Rule
    public Timeout globalTimeout= new Timeout(10000);

    @Test()
    public void codecSolver() {
        var leetCode = new Codec();
        Codec.TreeNode root = new Codec.TreeNode(1);
        root.left = new Codec.TreeNode(2);
        root.right = new Codec.TreeNode(3);
        root.right.left = new Codec.TreeNode(4);
        root.right.right = new Codec.TreeNode(4);
        Codec.TreeNode result = leetCode.deserialize(leetCode.serialize(root));
        assertEquals(result.toString(), root.toString());
    }
}