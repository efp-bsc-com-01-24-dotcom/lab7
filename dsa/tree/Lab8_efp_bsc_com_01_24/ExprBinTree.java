
public class ExprBinTree {

    private int count = 0;

    public ExpressionBase root;

    public ExprBinTree() {
        this.root = null;
    }

    ExpressionBase generateRandom(ExpressionBase rt) {

        if (count >= 10) {
            return new ValNode((int) (Math.random() * 100) + 1);
        }

        int choice = (int) (Math.random() * 2);

        if (choice == 0) {
            return new ValNode((int) (Math.random() * 100) + 1);
        } else {

            char[] operators = {'+', '-', '*'};

            int randomIndex = (int) (Math.random() * 3);

            Character operator = operators[randomIndex];

            count++;

            ExpressionBase left = generateRandom(null);
            ExpressionBase right = generateRandom(null);

            return new OpNode(operator, left, right);
        }
    }

    public void print(ExpressionBase rt) {

        if (rt instanceof ValNode) {
            System.out.print(((ValNode) rt).val());

        } else if (rt instanceof OpNode) {

            OpNode node = (OpNode) rt;

            System.out.print("(");
            print(node.left());
            System.out.print(" " + node.operator() + " ");
            print(node.right());
            System.out.print(")");
        }
    }

    public int evaluate(ExpressionBase rt) {

        if (rt instanceof ValNode) {
            return ((ValNode) rt).val();
        }

        if (rt instanceof OpNode) {

            OpNode node = (OpNode) rt;

            int left = evaluate(node.left());
            int right = evaluate(node.right());

            switch (node.operator()) {

                case '+':
                    return left + right;

                case '-':
                    return left - right;

                case '*':
                    return left * right;

                default:
                    throw new IllegalArgumentException(
                            "Unsupported operator: " + node.operator()
                    );
            }
        }

        throw new IllegalArgumentException("Expression node cannot be null");
    }

    public static void main(String[] args) {

        ExprBinTree tree = new ExprBinTree();

        tree.count = 0;

        tree.root = tree.generateRandom(null);

        System.out.print("Expression: ");
        tree.print(tree.root);

        System.out.println();

        System.out.println("Result: " + tree.evaluate(tree.root));
    }
}
