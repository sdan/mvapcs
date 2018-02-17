public interface Stack<E>
{
	public abstract boolean isEmpty();
	public abstract E peek();
	public abstract void push(E obj);
	public abstract E pop();
}