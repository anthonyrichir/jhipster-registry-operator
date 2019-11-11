package com.anthonyrichir.operator.registry;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pod")
public class Pods {

    private final KubernetesClient kubernetesClient;

    @Inject
    public Pods(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{namespace}")
    public List<Pod> pods(@PathParam("namespace") String namespace) {
        return kubernetesClient.pods().inNamespace(namespace).list().getItems();
    }
}
