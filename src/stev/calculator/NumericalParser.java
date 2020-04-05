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

import ca.uqac.lif.bullwinkle.BnfParser;
import ca.uqac.lif.bullwinkle.BnfParser.InvalidGrammarException;
import ca.uqac.lif.bullwinkle.BnfParser.ParseException;
import ca.uqac.lif.bullwinkle.ParseNode;
import ca.uqac.lif.bullwinkle.ParseTreeObjectBuilder.BuildException;

/**
 * Turns a character string into a {@link NumericalOperator}.
 */
public class NumericalParser 
{
	/**
	 * A parser to read strings and create parse trees from them.
	 */
	protected static final BnfParser s_parser = getParser();

	/**
	 * Turns a character string into a {@link NumericalOperator}.
	 * @param s The character string
	 * @return The numerical operator
	 * @throws ParseException If the string is malformed
	 * @throws BuildException If the operator cannot be built
	 */
	public static NumericalOperator parse(String s) throws ParseException, BuildException
	{
		ParseNode root = s_parser.parse(s);
		NumericalBuilder builder = new NumericalBuilder();
		return builder.build(root);
	}

	/**
	 * Creates a new numerical parser. This constructor is private, as we are
	 * not supposed to access it directly.
	 */
	private NumericalParser()
	{
		super();
	}

	/**
	 * Gets an instance of the parser for numerical expressions.
	 * @return The parser, or <tt>null</tt> if the parser could not be created
	 */
	protected static BnfParser getParser()
	{
		try 
		{
			return new BnfParser(NumericalParser.class.getResourceAsStream("grammar.bnf"));
		}
		catch (InvalidGrammarException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
