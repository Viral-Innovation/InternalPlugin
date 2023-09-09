/*
 * Copyright (c) Viral Innovation 2021-2022 - All Rights Reserved
 */

package com.viralinnovation.internalapplicationsplugin.nexus.api;

import java.util.List;

public class NexusMavenRepositoryEntries {

    private List<NexusMavenRepositoryEntry> items;
    private String continuationToken;

    public NexusMavenRepositoryEntries() {}

    public NexusMavenRepositoryEntries(List<NexusMavenRepositoryEntry> items, String continuationToken) {
        this.items = items;
        this.continuationToken = continuationToken;
    }

    public List<NexusMavenRepositoryEntry> getItems() {
        return items;
    }

    public void setItems(List<NexusMavenRepositoryEntry> items) {
        this.items = items;
    }

    public String getContinuationToken() {
        return continuationToken;
    }

    public void setContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
    }

    @Override
    public String toString() {
        return "NexusMavenRepositoryEntries{" +
                "items=" + items +
                ", continuationToken='" + continuationToken + '\'' +
                '}';
    }
}
