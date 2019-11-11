package com.anthonyrichir.operator.registry;

import io.fabric8.kubernetes.client.informers.ResourceEventHandler;

public class RegistryResourceEventHandler implements ResourceEventHandler<Registry> {

    @Override
    public void onAdd(Registry registry) {

    }

    @Override
    public void onUpdate(Registry oldRegistry, Registry newRegistry) {

    }

    @Override
    public void onDelete(Registry registry, boolean deletedFinalStateUnknown) {

    }
}
