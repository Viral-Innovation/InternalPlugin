/*
 * Copyright (c) Viral Innovation 2021-2022 - All Rights Reserved
 */

package com.viralinnovation.internalapplicationsplugin.nexus.api;

public class NexusMavenRepositoryEntry {

    private String downloadUrl;
    private String path;
    private String id;
    private String repository;
    private String format;
    private NexusChecksum checksum;
    private String contentType;
    private String lastModified;
    private String lastDownloaded;
    private String uploader;
    private String uploaderIp;
    private String fileSize;
    private String blobCreated;
    private NexusMavenDetails maven2;

    public NexusMavenRepositoryEntry() {}

    public NexusMavenRepositoryEntry(String downloadUrl, String path, String id, String repository, String format,
                                     NexusChecksum checksum, String contentType, String lastModified, String lastDownloaded,
                                     String uploader, String uploaderIp, String fileSize, String blobCreated, NexusMavenDetails maven2) {
        this.downloadUrl = downloadUrl;
        this.path = path;
        this.id = id;
        this.repository = repository;
        this.format = format;
        this.checksum = checksum;
        this.contentType = contentType;
        this.lastModified = lastModified;
        this.lastDownloaded = lastDownloaded;
        this.uploader = uploader;
        this.uploaderIp = uploaderIp;
        this.fileSize = fileSize;
        this.blobCreated = blobCreated;
        this.maven2 = maven2;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public NexusChecksum getChecksum() {
        return checksum;
    }

    public void setChecksum(NexusChecksum checksum) {
        this.checksum = checksum;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastDownloaded() {
        return lastDownloaded;
    }

    public void setLastDownloaded(String lastDownloaded) {
        this.lastDownloaded = lastDownloaded;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getUploaderIp() {
        return uploaderIp;
    }

    public void setUploaderIp(String uploaderIp) {
        this.uploaderIp = uploaderIp;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getBlobCreated() {
        return blobCreated;
    }

    public void setBlobCreated(String blobCreated) {
        this.blobCreated = blobCreated;
    }

    public NexusMavenDetails getMaven2() {
        return maven2;
    }

    public void setMaven2(NexusMavenDetails maven2) {
        this.maven2 = maven2;
    }

    @Override
    public String toString() {
        return "NexusMavenRepositoryEntry{" +
                "downloadUrl='" + downloadUrl + '\'' +
                ", path='" + path + '\'' +
                ", id='" + id + '\'' +
                ", repository='" + repository + '\'' +
                ", format='" + format + '\'' +
                ", checksum=" + checksum +
                ", contentType='" + contentType + '\'' +
                ", lastModified='" + lastModified + '\'' +
                ", lastDownloaded='" + lastDownloaded + '\'' +
                ", uploader='" + uploader + '\'' +
                ", uploaderIp='" + uploaderIp + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", blobCreated='" + blobCreated + '\'' +
                ", maven2=" + maven2 +
                '}';
    }
}
