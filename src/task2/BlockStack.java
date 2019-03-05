package task2;

import common.StackException;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;
	
	//access counter TASK 1
	private int stackAccessCounter =0;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	public char acStack[] = new char[] {'a', 'b', 'c', 'd', '*', '*'};

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '*';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	//task 2
	public char pick() throws StackException
	{
		
		stackAccessCounter++;
		if(!isEmpty()) {
		return this.acStack[this.iTop];
		}
		else
			throw new StackException("Empty Stack !!!");
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition) throws StackException
	{
		//task 1
		stackAccessCounter++;
		if(piPosition <= iSize-1)
		return this.acStack[piPosition];
		else
			throw new StackException ("Array out of bounds, can't access stack position");
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws StackException
	{
		//task 2 if empty put 'a' on top
		stackAccessCounter++;
		
		if(isEmpty()) {
			this.acStack[++this.iTop] = acStack[0];
			
		} else if(iTop < iSize) {
			this.acStack[++this.iTop] = pcBlock;
		} 
		else
			throw new StackException ("Full Stack !!!");
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws StackException
	{
		//task 1
		stackAccessCounter++;
		if(!isEmpty()) {
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '*'; // Leave prev. value undefined
		return cBlock;
		}
		else
			throw new StackException("Empty Stack !!!");
	}
	
	public int getITop() {
		return iTop;
		
	}
	
	public int getISize() {
		return iSize;
		
	}
	
	public int getAccessCounter() {
		return stackAccessCounter;
		
	}
	
	public boolean isEmpty() {
		return (this.iTop == -1);
		
	}
	
	
}

// EOF
