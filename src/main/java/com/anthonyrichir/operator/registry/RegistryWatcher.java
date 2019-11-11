package com.anthonyrichir.operator.registry;

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;

public class RegistryWatcher {

	@Inject
	KubernetesClient client;

	@Inject
	CustomResourceDefinition registryCustomResourceDefinition;

	@Inject
	CustomResourceDefinitionContext registryCustomResourceDefinitionContext;

	void onStartup(@Observes StartupEvent event) throws IOException {
		client.customResources(registryCustomResourceDefinition, Registry.class, RegistryList.class, DoneableRegistry.class)
				.watch(new Watcher<Registry>() {
					@Override
					public void eventReceived(Action action, Registry resource) {
						System.out.println("Action: " + action +
								" registry: " + resource);
					}

					@Override
					public void onClose(KubernetesClientException cause) {
						cause.printStackTrace();
						System.exit(-1);
					}
				});
	}
}
