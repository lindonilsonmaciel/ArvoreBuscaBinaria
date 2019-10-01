import javax.swing.*;
import java.awt.*;

public class ArvoreBinariaBuscaView extends JComponent {
    private ArvoreBuscaBinaria tree = null;
    private int nodeSize = 30;
    private int offset = 60;

    public ArvoreBinariaBuscaView(ArvoreBuscaBinaria tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (this.tree == null){
            return;
        }
        drawNode(g, this.tree.getRoot(), getWidth()/2, 0, 0);
    }

    private void drawNode(Graphics g, ArvoreBuscaBinaria.Node node, int x, int y, int level){
        g.drawOval(x, y, nodeSize, nodeSize);
        g.drawString(String.valueOf(node.getValue()), x + 8, y + 20);
        if (node.getLeft() != null){
            int childX = x - offset;
            int childY = y + offset;
            g.drawLine(
                    x + nodeSize / 2,
                    y + nodeSize,
                    childX + nodeSize/2,
                    childY);
            drawNode(g, node.getLeft(), childX, childY, level+1);
        }
        if (node.getRight() != null){
            int childX = x + offset;
            int childY = y + offset;
            g.drawLine(
                    x + nodeSize / 2,
                    y + nodeSize,
                    childX + nodeSize/2,
                    childY);
            drawNode(g, node.getRight(), childX, childY, level+1);
        }
    }
}