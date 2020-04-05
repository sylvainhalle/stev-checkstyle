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

import stev.calculator.*;

public class SimpleExample
{
	public static void main(String[] args)
	{
		Addition a = new Addition();
		Multiplication m = new Multiplication();
		m.setLeft(Constant.get(3));
		m.setRight(Constant.get(2));
		a.setLeft(m);
		a.setRight(Constant.get(6));
		float value = a.getValue();
		System.out.println("The value of " + a + " is " + value);
	}
}
