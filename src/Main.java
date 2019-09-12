public class Main {
    public static void main(String[] args) {
        ArvoreBuscaBinaria tree = new ArvoreBuscaBinaria();
        tree.insert(50);
        tree.insert(90);
        tree.insert(30);
        tree.insert(100);
        tree.insert(40);
        tree.insert(20);
        tree.remove(50);
        //ArvoreBuscaBinaria.Node value = tree.search(30);
        if (tree.search(50) != null){
            System.out.println("Encontrou o elemento");
        }else {
            System.out.println("Elemento não encontrado");
        }
    }
}
