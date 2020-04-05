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

import ca.uqac.lif.bullwinkle.Builds;
import ca.uqac.lif.bullwinkle.ParseTreeObjectBuilder;

/**
 * Builds a {@link NumericalOperator} based on the contents of a parse tree.
 */
public final class NumericalBuilder extends ParseTreeObjectBuilder<NumericalOperator>
{
	@Builds(rule = "<add>", pop = true, clean = true)
	public Addition buildAdd(Object...parts)
	{
		Addition op = new Addition();
		op.setLeft((NumericalOperator) parts[0]);
		op.setRight((NumericalOperator) parts[1]);
		return op;
	}
	
	@Builds(rule = "<sub>", pop = true, clean = true)
	public Subtraction buildSub(Object...parts)
	{
		Subtraction op = new Subtraction();
		op.setLeft((NumericalOperator) parts[0]);
		op.setRight((NumericalOperator) parts[1]);
		return op;
	}
	
	@Builds(rule = "<mul>", pop = true, clean = true)
	public Multiplication buildMul(Object...parts)
	{
		Multiplication op = new Multiplication();
		op.setLeft((NumericalOperator) parts[0]);
		op.setRight((NumericalOperator) parts[1]);
		return op;
	}
	
	@Builds(rule = "<div>", pop = true, clean = true)
	public Division buildDiv(Object...parts)
	{
		Division op = new Division();
		op.setLeft((NumericalOperator) parts[0]);
		op.setRight((NumericalOperator) parts[1]);
		return op;
	}
	
	@Builds(rule = "<num>", pop = true)
	public Constant buildNum(Object...parts)
	{
		float val = Float.parseFloat((String) parts[0]);
		return Constant.get(val);
	}
}
