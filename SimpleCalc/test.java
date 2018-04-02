import java.util.List;		// used by expression evaluator

/**
 *	This program is a simple calculator that utilizes the stack data
 *  structure to evaluate simple expressions consisting of doubles and
 *  basic operators such as +,-,/,*,% and the program can also handle
 *  parantheses. The ExprUtils class is used to tokenize an expression
 *  and check the precedence of operators. Two stacks are utilized, a 
 *  variable stack and an operator stack. The program continues to 
 *  simplify the stacks through continuous popping and pushing until
 *  the variable stack just has one value in it and the operator stack
 *  is empty. The program is unable to handle unkown operators.
 *	@author	Deepak Ramalingam
 *	@since	02/14/2018
 */
 
public class SimpleCalc 
{
	
	private ExprUtils utils;	// expression utilities
	
	private ArrayStack<Double> valueStack;		// value stack
	private ArrayStack<String> operatorStack;	// operator stack

	// constructor	
	public SimpleCalc() 
	{
		utils = new ExprUtils();
		valueStack = new ArrayStack<Double>();
		operatorStack = new ArrayStack<String>();
	}
	
	public static void main(String[] args) 
	{
		SimpleCalc sc = new SimpleCalc();
		sc.run();
	}
	
	public void run() 
	{
		System.out.println("\n\n\nWelcome to SimpleCalc!!!");
		runCalc();
		System.out.println("\nThanks for using SimpleCalc! Goodbye.\n\n\n");
	}
	
	/**
	 *	Prompt the user for expressions, run the expression evaluator,
	 *	and display the answer.
	 */
	public void runCalc() 
	{
		boolean done = false;
		
		do
		{
			String expr = Prompt.getString(" -> ");
			if(expr.equalsIgnoreCase("q"))
			{
				done = true;
			}
			else if(expr.equalsIgnoreCase("h"))
			{
				printHelp();
			}
			else if(!expr.equals(""))
			{
				List<String> tokens = utils.tokenizeExpression(expr);
				double value = evaluateExpression(tokens);
				System.out.println(value);
			}

		}
		while(!done);
		
	}
	
	/**	Print help */
	public void printHelp() 
	{
		System.out.println("Help:");
		System.out.println("  h - this message\n  q - quit\n");
		System.out.println("Expressions can contain:");
		System.out.println("  integers or decimal numbers");
		System.out.println("  arithmetic operators +, -, *, /, %, ^");
		System.out.println("  parentheses '(' and ')'");
	}
	
	/**
	 *	Evaluate expression and return the value
	 *	@param tokens	a List of String tokens making up an arithmetic expression
	 *	@return			a double value of the evaluated expression
	 *	Algorithm:
	 *	1. while there are tokens to be read in,
	 *	  1.1 Get the next token
	 *	  1.2 If the token is:
	 *		1.2.1 A number: push it onto the value stack
	 *		1.2.2 (extra credit) A variable: get its value, and push onto the value stack
	 *		1.2.3 A left parenthesis: push it onto the operator stack
	 *		1.2.4 A right parenthesis
	 *		  A. While the thing on top of the operator stack is not
	 *			a left parenthesis
	 *			A.1 Pop the operator from the operator stack
	 *			A.2 Pop the value stack twice, getting two operands.
	 *			A.3 Apply the operator to the operands, in the correct order.
	 *			A.4 Push the result onto the value stack.
	 *		  B. Pop the left parenthesis from the operator stack, and discard.
	 *		1.2.5 An operator
	 *		  A. While the operator stack is not empty, and the top thing
	 *			on the operator stack has the same or greater precedence
	 *			as the token's operator (hasPrecedence below)
	 *			A.1 Pop the operator from the operator stack
	 *			A.2 Pop the value stack twice, getting two operands
	 *			A.3 Apply the operator to the operands, in the correct order.
	 *			A.4 Push the result onto the value stack.
	 *		  B. Push token operator onto the operator stack.
	 *	2. While the operator stack is not empty,
	 *		2.1 Pop the operator from the operator stack.
	 *		2.2 Pop the value stack twice, getting two operands
	 *		2.3 Apply the operator to the operands, in the correct order
	 *		2.4 Push the result on the value stack.
	 *	3. At this point the operator stack should be empty, and value stack
	 *		should have only one value in it, which is the final result. 
	 */
	public double evaluateExpression(List<String> tokens) 
	{
		double value = 0;
		
		for(int i = 0; i < tokens.size(); i++)
		{
			String oldOperator = "";
			String curValue = tokens.get(i);
			if(!operatorStack.isEmpty())
				oldOperator = operatorStack.peek();
			
			if (utils.isOperator(curValue.charAt(0)))
			{
				if(curValue.equals(")"))
				{
					while(!operatorStack.peek().equals("("))
					{
						String operator = operatorStack.pop();
						double second = valueStack.pop();
						double first = valueStack.pop();
						
						evaluate(first, second, operator);					
					}

					operatorStack.pop();
				}
				else if(curValue.equals("("))
				{
					operatorStack.push(curValue);
				}
				else
				{
					if(!oldOperator.equals("") && hasPrecedence(curValue, oldOperator))
					{
						String operator = operatorStack.pop();
						double second = valueStack.pop();
						double first = valueStack.pop();
						
						evaluate(first, second, operator);
					}
					operatorStack.push(curValue);
				}
			}
			else if (Character.isDigit(curValue.charAt(0)))
			{
				valueStack.push(Double.parseDouble(curValue));
			}
		}
		
		while(!operatorStack.isEmpty())
		{
			String operator = operatorStack.pop();
			double second = valueStack.pop();
			double first = valueStack.pop();
			
			evaluate(first, second, operator);
		}
		
		value = valueStack.peek();

		valueStack.pop();
		
		return value;
	}
	
	/**
	 *	Evaluates a simple expression consisting of two variables and
	 *  one operator.
	 *	@param first	first number
	 *  @param second	second number
	 * 	@param operator	the operator that must be applied on the numbers
	 */
	public void evaluate(double first, double second, String operator)
	{
		if(operator.equals("+"))
			valueStack.push(first + second);
		else if(operator.equals("-"))
			valueStack.push(first - second);
		else if(operator.equals("*"))
			valueStack.push(first * second);
		else if(operator.equals("/"))
			valueStack.push(first / second);
		else if(operator.equals("^"))
			valueStack.push(Math.pow(first,second));
		else if(operator.equals("%"))
			valueStack.push(first % second);
		else
			System.out.println("UNKNOWN OPERATION");
	}
	
	/**
	 *	Precedence of operators
	 *	@param op1		operator 1
	 *	@param op2		operator 2
	 *	@return			true if op2 has higher or same precedence as op1; false otherwise
	 *	Algorithm:
	 *		if op1 is exponent, then false
	 *		if op2 is either left or right parenthesis, then false
	 *		if op1 is multiplication or division or modulus and 
	 *				op2 is addition or subtraction, then false
	 *		otherwise true
	 */
	private boolean hasPrecedence(String op1, String op2) 
	{
		if (op1.equals("^")) 
			return false;
		if (op2.equals("(") || op2.equals(")")) 
			return false;
		if ((op1.equals("*") || op1.equals("/") || op1.equals("%")) && (op2.equals("+") || op2.equals("-")))
			return false;
		return true;
	}
}
