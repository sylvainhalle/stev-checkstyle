/*
    A simple calculator   
    Copyright (C) 2020 Sylvain Hallé

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package stev.calculator;

/**
 * Abstract class for all operators taking two operands.
 */
public abstract class BinaryOperator extends NumericalOperator
{
	/**
	 * The left operand.
	 */
	protected NumericalOperator m_left;
	
	/**
	 * The left operand.
	 */
	protected NumericalOperator m_right;
	
	/**
	 * Determines if the operator is to be displayed using prefix notation
	 * (default: no, which means infix notation).
	 */
	protected boolean m_prefix = false;
	
	/**
	 * Creates a new empty binary operator.
	 */
	public BinaryOperator()
	{
		super();
	}
	
	/**
	 * Sets the left operand.
	 * @param nop The operand
	 * @return This operator
	 */
	public BinaryOperator setLeft(NumericalOperator nop)
	{
		m_left = nop;
		return this;
	}
	
	/**
	 * Sets the right operand.
	 * @param nop The operand
	 * @return This operator
	 */
	public BinaryOperator setRight(NumericalOperator nop)
	{
		m_right = nop;
		return this;
	}
	
	/**
	 * Gets the symbol used for this operator
	 * @return The symbol
	 */
	protected abstract String getSymbol();
	
	@Override
	public String toString()
	{
		StringBuilder out = new StringBuilder();
		if (m_prefix)
		{
			out.append(getSymbol()).append("(").append(m_left.toString()).append(",").append(m_right.toString()).append(")");
		}
		else
		{
			if (m_left instanceof Constant)
			{
				out.append(m_left.toString());
			}
			else
			{
				out.append("(").append(m_left.toString()).append(")");
			}
			out.append(getSymbol());
			if (m_right instanceof Constant)
			{
				out.append(m_right.toString());
			}
			else
			{
				out.append("(").append(m_right.toString()).append(")");
			}
		}
		return out.toString();
	}
}
