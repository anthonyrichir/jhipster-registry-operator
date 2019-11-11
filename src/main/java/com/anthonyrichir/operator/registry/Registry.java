package com.anthonyrichir.operator.registry;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.CustomResource;

public class Registry extends CustomResource {

	public RegistrySpec getSpec() {
		return spec;
	}

	public void setSpec(RegistrySpec spec) {
		this.spec = spec;
	}

	public RegistryStatus getStatus() {
		return status;
	}

	public void setStatus(RegistryStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Registry{" +
				"apiVersion='" + getApiVersion() + "'" +
				", metadata=" + getMetadata() +
				", spec=" + spec +
				", status=" + status +
				"}";
	}

	private RegistrySpec spec;
	private RegistryStatus status;

	@Override
	public ObjectMeta getMetadata() {
		return super.getMetadata();
	}
}
