package com.viralinnovation.internalapplicationsplugin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viralinnovation.internalapplicationsplugin.nexus.api.NexusMavenRepositoryEntries;
import com.viralinnovation.internalapplicationsplugin.nexus.api.NexusMavenRepositoryEntry;
import com.viralinnovation.internalapplicationsplugin.nexus.wrappers.InfoDetails;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public final class SourceManager {

    private static SourceManager instance;

    public SourceManager() {
        if(instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("Singleton Class");
        }
    }

    @Contract("_ -> new")
    public @NotNull InfoDetails getDetails(String name) {
        try {
            NexusMavenRepositoryEntry entry = simpleHttpGetRequest(new URL(
                    "http://192.168.20.8:8081/service/rest/v1/search/assets?sort=version&repository=private&group=com.viralinnovation&name=" + name + "&maven.extension=jar"), NexusMavenRepositoryEntries.class).getItems().get(0);
            return new InfoDetails(entry);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String downloadFromNexus(String name, String saveLocation) throws RuntimeException {
        InfoDetails infoDetails = getDetails(name);
        saveLocation = saveLocation + File.separator + infoDetails.getArtifactId()
                + "-" + infoDetails.getVersion()
                + "." + infoDetails.getExtension();
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(infoDetails.getDownloadUrl()))
                    .header("Authorization", getBasicAuthenticationHeader())
                    .GET()
                    .build();
            httpClient.send(request, HttpResponse.BodyHandlers.ofFile(new File(saveLocation).toPath()));
            return saveLocation;
        } catch (IOException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T simpleHttpGetRequest(URL url, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(simpleHttpGetRequest(url), clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String simpleHttpGetRequest(@NotNull URL url) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url.toURI())
                    .header("Authorization", getBasicAuthenticationHeader())
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getBasicAuthenticationHeader() {
        String valueToEncode = "internal" + ":" + "4zgzWAtRigkDxhn";
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    public static SourceManager getInstance() {
        return instance;
    }

    public static void main(String... args) {
        SourceManager sourceManager = new SourceManager();
        System.out.println(sourceManager.getDetails("Thalia"));
        System.out.println(sourceManager.downloadFromNexus("Thalia",
                "test"));
    }
}
