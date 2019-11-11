package com.anthonyrichir.operator.registry;

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

public class OperatorConfiguration {

	@Produces
	@Singleton
	CustomResourceDefinition registryCustomResourceDefinition() {
		return new CustomResourceDefinitionBuilder()
				.withNewMetadata().withName("registries.operator.anthonyrichir.com").endMetadata()
				.withNewSpec()
				.withGroup("operator.anthonyrichir.com")
				.withVersion("v1alpha1")
				.withNewNames().withKind("Registry").withPlural("Registrys").endNames()
				.withScope("Namespaced")
				.endSpec()
				.build();
	}

	@Produces
	@Singleton
	CustomResourceDefinitionContext registryCustomResourceDefinitionContext() {
		return new CustomResourceDefinitionContext.Builder()
				.withVersion("v1alpha1")
				.withScope("Namespaced")
				.withGroup("operator.anthonyrichir.com")
				.withPlural("registries")
				.build();
	}
}
