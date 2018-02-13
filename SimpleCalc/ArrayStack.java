import java.util.List;
import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E>
{
	private List<E> elements;
	
	public ArrayStack()
	{
		elements = new ArrayList<E>();
	}
	
	public boolean isEmpty()
	{
		return elements.isEmpty();
	}
	
	public E peek()
	{
		return elements.get(elements.size()-1);
	}
	
	public void push(E obj)
	{
		elements.add(obj);
	}
	
	public E pop()
	{
		return elements.remove(elements.size()-1);
	}
}
