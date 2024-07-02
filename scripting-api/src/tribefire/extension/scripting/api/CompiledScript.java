// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package tribefire.extension.scripting.api;

import java.util.Map;

import com.braintribe.gm.model.reason.Maybe;

/**
 * 
 * Interface for compiled scripts that can be evaluated. Scripting engines internally will pre-compile scripts and 
 * store the result as a CompiledScript. 
 * 
 * @author Dirk Scheffler
 *
 */

public interface CompiledScript {

	/**
	 * To evaluate a compiled script given parameter bindings. The script is already pre-compiled and the bindings are
	 * passed as parameter inputs to the script. 
	 * 
	 * @param <T>
	 *            Arbitrary return type, depending on the actual script. 
	 * @param bindings
	 *            Parameter bindings. The parameters are passed to the script as inputs. 
	 *            
	 * @return Reasoned return object. May contain ScriptRuntimeError.
	 */
	<T> Maybe<T> evaluate(Map<String, Object> bindings);
}
