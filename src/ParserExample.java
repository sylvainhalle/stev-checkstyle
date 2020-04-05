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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ca.uqac.lif.bullwinkle.BnfParser.ParseException;
import ca.uqac.lif.bullwinkle.ParseTreeObjectBuilder.BuildException;
import stev.calculator.NumericalOperator;
import stev.calculator.NumericalParser;

public class ParserExample
{

	public static void main(String[] args) throws ParseException, BuildException, IOException
	{
		boolean quit = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!quit)
		{
			System.out.println("Enter an arithmetic expression or X to quit:");
			String exp = br.readLine();
			if (exp.compareTo("X") == 0)
			{
				quit = true;
				continue;
			}
			NumericalOperator nop = NumericalParser.parse(exp);
			System.out.println(nop.getValue());
		}
		System.out.println("Goodbye!");
	}
}
