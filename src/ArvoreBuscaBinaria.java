public class ArvoreBuscaBinaria {

    private Node root = null;

    public boolean isBalanced(){
        if (root.balanced(root) >= -1 && root.balanced(root) <= 1){
            return true;
        }
        return false;
    }


    //Método para usar nos testes
    public int balanced(){
        if (root.balanced(root) >= -1 && root.balanced(root) <= 1){
            return 1;
        }
        return root.height(root);
    }

    public void remove(int value){
        if (root == null){
            System.out.println("Árvore Vazia");
            return;
        }
        root.remove(root, value);
    }

    public void insert(Node node){
        if (root == null){
            root = node;
            return;
        }

        root.insert(node);
    }

    public void insert(int value){
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int i) {
        if (root == null){
            return null;
        }

        return root.search(i);
    }

    public Node getRoot(){
        return root;
    }

    public static class Node {
        private Node left = null;
        private Node right = null;
        private int value = 0;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        private void insert(Node node) {
            if (node.value > this.value){
                if (right == null){
                    this.right = node;
                }else {
                    this.right.insert(node);
                }
            }else if(node.value < this.value){
                if (left == null){
                    this.left = node;
                }else{
                    this.left.insert(node);
                }
            }
        }

        public Node search(int i) {
            if (i == this.value){
                return this;
            }

            if (i < this.value){
                if (left==null){
                    return null;
                }

                return left.search(i);
            }

            if (i > this.value){
                if (right == null){
                    return null;
                }
                return right.search(i);
            }
            return null;
        }

        public void remove(Node root, int value) {
            Node before = null;
            Node current = root;
            while (current != null){
                //Achou o nó a ser removido. Tratar o lado da remoção.
                if (value == current.value){
                    if (current == root){
                        root = removeCurrent(current);
                    }else{
                        if (before.right == current){
                            before.right = removeCurrent(current);
                        }else{
                            before.left = removeCurrent(current);
                        }
                    }
                }
                //Continua andando na árvore a procura do nó a ser removido
                before = current;
                if (value > current.value){
                    current = current.right;
                }else{
                    current = current.left;
                }
            }
        }

        private int balanced(Node root){
            int right = height(root.right);
            int left = height(root.left);
            return left - right;
        }

        private int height(Node root){
            if (root == null){
                return -1;
            }
            int left = height(root.left);
            int right = height(root.right);

            if (left > right){
                return left+1;
            }else{
                return right+1;
            }
        }

        private Node removeCurrent(Node current) {
            Node node1, node2;
            //Sem filho da esquerda. Apontar para o filho da direita.
            //PS: Trato nós folhas e nós filhos
            if (current.left == null){
                node2  = current.right;
                return node2;
            }
            //Procurar filho mais a direita na sub-árvore da esquerda.
            node1 = current;
            node2 = current.left;
            while (node2.right != null){
                node1 = node2;
                node2 = node2.right;
            }
            //Copia o filho mais a direita na sub-árvore da esquerda para o lugar do nó removido.
            if (node1 != current){
                node1.right = current.right;
                node2.left = current.left;
            }
            node2.right = current.right;
            return node2;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

    }
}
