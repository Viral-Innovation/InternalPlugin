/*
 * Copyright (c) Viral Innovation 2021-2022 - All Rights Reserved
 */

package com.viralinnovation.internalapplicationsplugin.nexus.api;

public class NexusChecksum {

    private String sha1;
    private String sha256;
    private String sha512;
    private String md5;

    public NexusChecksum() {}

    public NexusChecksum(String sha1, String sha256, String sha512, String md5) {
        this.sha1 = sha1;
        this.sha256 = sha256;
        this.sha512 = sha512;
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
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

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "NexusChecksum{" +
                "sha1='" + sha1 + '\'' +
                ", sha256='" + sha256 + '\'' +
                ", sha512='" + sha512 + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
