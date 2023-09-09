package com.viralinnovation.internalapplicationsplugin.nexus.wrappers;

import org.jetbrains.annotations.NotNull;
import com.viralinnovation.internalapplicationsplugin.nexus.api.NexusMavenRepositoryEntry;

import java.util.Objects;

public class InfoDetails {

    private String artifactId;
    private String extension;
    private String version;
    private String downloadUrl;
    private String sha256;
    private String sha512;

    public InfoDetails(String artifactId, String extension, String version, String downloadUrl, String sha256, String sha512) {
        this.artifactId = artifactId;
        this.extension = extension;
        this.version = version;
        this.downloadUrl = downloadUrl;
        this.sha256 = sha256;
        this.sha512 = sha512;
    }

    public InfoDetails(@NotNull NexusMavenRepositoryEntry entry) {
        this.artifactId = entry.getMaven2().getArtifactId();
        this.extension = entry.getMaven2().getExtension();
        this.version = entry.getMaven2().getVersion();
        this.sha256 = entry.getChecksum().getSha256();
        this.sha512 = entry.getChecksum().getSha512();
        this.downloadUrl = entry.getDownloadUrl();
        // this.downloadUrl = "http://192.168.10.10:8085/nexus/" + url;
    }

    public InfoDetails(@NotNull NexusMavenRepositoryEntry entry, String url) {
        this.artifactId = entry.getMaven2().getArtifactId();
        this.extension = entry.getMaven2().getExtension();
        this.version = entry.getMaven2().getVersion();
        this.sha256 = entry.getChecksum().getSha256();
        this.sha512 = entry.getChecksum().getSha512();
        this.downloadUrl = "https://license.viral-innovation.com/nexus/" + url;
        // this.downloadUrl = "http://192.168.10.10:8085/nexus/" + url;
    }

    public InfoDetails() {
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getSha512() {
        return sha512;
    }

    public void setSha512(String sha512) {
        this.sha512 = sha512;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoDetails that = (InfoDetails) o;
        return Objects.equals(getArtifactId(), that.getArtifactId()) && Objects.equals(getExtension(), that.getExtension()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getDownloadUrl(), that.getDownloadUrl()) && Objects.equals(getSha256(), that.getSha256()) && Objects.equals(getSha512(), that.getSha512());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtifactId(), getExtension(), getVersion(), getDownloadUrl(), getSha256(), getSha512());
    }

    @Override
    public String toString() {
        return "InfoDetails{" +
                "artifactId='" + artifactId + '\'' +
                ", extension='" + extension + '\'' +
                ", version='" + version + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", sha256='" + sha256 + '\'' +
                ", sha512='" + sha512 + '\'' +
                '}';
    }
}
