import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*
        ArvoreBuscaBinaria tree = new ArvoreBuscaBinaria();
        Random random = new Random();
        for (int i = 0; i < 15; i++){
                tree.insert(random.nextInt(40));
        }
         */
        Random random = new Random();
        ArvoreBuscaBinaria tree = new ArvoreBuscaBinaria();

        for (int i = 0; i < 10; i++){
            tree.insert(random.nextInt(40));
        }
        if (tree.isBalanced()){
            System.out.println("Árvore Balanceada!!");
        }else{
            System.out.println("Árvore Não Balanceada!!");
        }

        //tree.remove(50);
        //ArvoreBuscaBinaria.Node value = tree.search(30);
        /*if (tree.search(50) != null){
            System.out.println("Encontrou o elemento");
        }else {
            System.out.println("Elemento não encontrado");
        }*/

        /*

        // IMPLEMENTAÇÃO VISUAL
        */
        JFrame frame = new JFrame("Visualizador de Árvore Binária de Busca");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        ArvoreBinariaBuscaView view = new ArvoreBinariaBuscaView(tree);
        frame.add(view);
        frame.setVisible(true);
         /**/
    }
}
