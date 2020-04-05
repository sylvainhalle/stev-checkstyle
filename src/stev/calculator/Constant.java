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

import java.util.HashMap;
import java.util.Map;


/**
 * A scalar numerical value. Constants cannot be instantiated directly;
 * they are obtained by calling the static method {@link #get(float)}.
 */
public class Constant extends NumericalOperator 
{
	/**
	 * The value of the number.
	 */
	protected float m_value;
	
	/**
	 * A map storing instances of constants, to favor object reuse.
	 */
	protected static Map<Float,Constant> s_cache = new HashMap<Float, Constant>();
	
	/**
	 * Gets an instance of a constant for a given numerical value
	 * @param value The value
	 * @return The instance of the constant
	 */
	public static Constant get(float value)
	{
		if (s_cache.containsKey(value))
		{
			return s_cache.get(value);
		}
		Constant c = new Constant(value);
		s_cache.put(value, c);
		return c;
	}
	
	/**
	 * Creates a new constant with value 0.
	 */
	private Constant()
	{
		this(0);
	}
	
	/**
	 * Creates a new constant.
	 * @param value The value of the constant
	 */
	private Constant(float value)
	{
		super();
		m_value = value;
	}
	
	@Override
	public float getValue() 
	{
		return m_value;
	}
	
	@Override
	public String toString()
	{
		if (m_value % 1 == 0)
		{
			return Integer.toString((int) m_value);
		}
		return Float.toString(m_value);
	}
}
