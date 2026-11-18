
public class OpNode implements ExpressionBase {

    private Character op;
    private ExpressionBase left;
    private ExpressionBase right;

    public OpNode() {
    }

    public OpNode(Character c, ExpressionBase l, ExpressionBase r) {
        this.op = c;
        this.left = l;
        this.right = r;
    }

    public Character operator() {
        return op;
    }

    public void setOperator(Character operator) {
        op = operator;
    }

    public ExpressionBase left() {
        return left;
    }

    public ExpressionBase right() {
        return right;
    }

    public void setLeft(ExpressionBase L) {
        left = L;
    }

    public void setRight(ExpressionBase R) {
        right = R;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
