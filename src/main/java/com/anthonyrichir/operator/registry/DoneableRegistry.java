package com.anthonyrichir.operator.registry;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.client.CustomResourceDoneable;


public class DoneableRegistry extends CustomResourceDoneable<Registry> {
	public DoneableRegistry(Registry resource, Function function) {
		super(resource, function);
	}
}
