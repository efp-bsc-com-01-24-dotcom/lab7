
public class ValNode implements ExpressionBase {

    private Integer value;

    public ValNode(Integer v){
        this.value = v;
    }

    public Integer val() {
        return value;
    }

    public void setValue(Integer val) {
        value = val;
    }

    public ExpressionBase left() {
        return null;
    }

    public ExpressionBase right() {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

}
