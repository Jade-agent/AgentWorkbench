/**
 * @author Hanno - Felix Wagner, 24.05.2010
 * Copyright 2010 Hanno - Felix Wagner
 * 
 * This file is part of ContMAS.
 *
 * ContMAS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ContMAS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ContMAS.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package contmas.interfaces;

import jade.util.leap.ArrayList;
import jade.util.leap.List;
import contmas.ontology.Designator;

/**
 * @author Hanno - Felix Wagner
 *
 */
public interface TacticalMemorizer{

	/**
	 * @param target
	 */
	void memorizeTacticalTarget(Designator target);
	List getTacticalTargets();
}