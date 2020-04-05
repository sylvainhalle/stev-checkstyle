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
 * Division of two numbers.
 */
public class Division extends BinaryOperator
{
	@Override
	protected String getSymbol() 
	{
		return "\u00D7";
	}

	@Override
	public float getValue() 
	{
		return m_left.getValue() / m_right.getValue();
	}
}
