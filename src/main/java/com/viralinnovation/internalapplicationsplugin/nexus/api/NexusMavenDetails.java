/*
 * Copyright (c) Viral Innovation 2021-2022 - All Rights Reserved
 */

package com.viralinnovation.internalapplicationsplugin.nexus.api;

public class NexusMavenDetails {

    private String extension;
    private String groupId;
    private String artifactId;
    private String version;

    public NexusMavenDetails() {}

    public NexusMavenDetails(String extension, String groupId, String artifactId, String version) {
        this.extension = extension;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "NexusMavenDetails{" +
                "extension='" + extension + '\'' +
                ", groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
