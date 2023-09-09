package com.viralinnovation.internalapplicationsplugin;

import com.viralinnovation.internalapplicationsplugin.thalia.*;
import com.viralinnovation.viralmanager.api.executables.ExecutableTypes;
import com.viralinnovation.viralmanager.api.plugins.Plugin;
import com.viralinnovation.viralmanager.api.plugins.Registry;
import org.jetbrains.annotations.NotNull;

import java.net.URISyntaxException;

public class InternalApplicationsPlugin extends Plugin {
    @Override
    public void register(@NotNull Registry registry) {
        new SourceManager();
        try {
            registry.addJavaMapping("Thalia Server",
                    ThaliaFormEntity.class, ThaliaResponseEntity.class, ThaliaServiceEntity.class,
                    ThaliaServiceRepository.class, ThaliaServiceListener.class,
                    new ThaliaServiceInteractor(), getPluginConfig(),
                    getClass().getResource("/images/thalia.png").toURI(),
                    ExecutableTypes.SERVICE);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void disable() {

    }
}
