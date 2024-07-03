// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
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
package tribefire.extension.scripting.imp;

import com.braintribe.model.extensiondeployment.StateChangeProcessor;
import com.braintribe.model.processing.session.api.persistence.PersistenceGmSession;
import com.braintribe.product.rat.imp.AbstractImpCave;
import com.braintribe.product.rat.imp.impl.deployable.BasicDeployableImp;

import tribefire.extension.scripting.statechange.model.deployment.ScriptedStateChangeProcessor;

/**
 * An {@link AbstractImpCave} specialized in {@link StateChangeProcessor}
 */
public class StateChangeProcessorImpCave extends AbstractImpCave<StateChangeProcessor, BasicDeployableImp<StateChangeProcessor>> {

	public StateChangeProcessorImpCave(PersistenceGmSession session) {
		super(session, "externalId", StateChangeProcessor.T);
	}

	@Override
	protected BasicDeployableImp<StateChangeProcessor> buildImp(StateChangeProcessor instance) {
		return new BasicDeployableImp<StateChangeProcessor>(session(), instance);
	}

	public ScriptedStateChangeProcessorImp<ScriptedStateChangeProcessor> createScriptedStateChangeProcessor(String name, String externalId) {
		ScriptedStateChangeProcessor scriptedStateChangeProcessor = session().create(ScriptedStateChangeProcessor.T);
		scriptedStateChangeProcessor.setExternalId(externalId);
		scriptedStateChangeProcessor.setName(name);
		return new ScriptedStateChangeProcessorImp<ScriptedStateChangeProcessor>(session(), scriptedStateChangeProcessor);
	}
}
