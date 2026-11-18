
public interface BeanNode<E> {

    public E Element();

    public void setElement(E v);

    public BeanNode<E> left();

    public BeanNode<E> right();

    public boolean isleaf();

}
