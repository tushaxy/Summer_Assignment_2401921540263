import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder streamBuilder = new StringBuilder();
        buildStringStream(root, streamBuilder);
        return streamBuilder.toString();
    }
    
    private void buildStringStream(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        buildStringStream(node.left, sb);
        buildStringStream(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        Queue<String> nodeQueue = new LinkedList<>(Arrays.asList(tokens));
        return constructFromStream(nodeQueue);
    }
    
    private TreeNode constructFromStream(Queue<String> queue) {
        String currentToken = queue.poll();
        if (currentToken == null || currentToken.equals("#")) {
            return null;
        }
        
        TreeNode reconstructedNode = new TreeNode(Integer.parseInt(currentToken));
        reconstructedNode.left = constructFromStream(queue);
        reconstructedNode.right = constructFromStream(queue);
        
        return reconstructedNode;
    }
}
