package com.viralinnovation.internalapplicationsplugin.thalia;

import com.viralinnovation.internalapplicationsplugin.SourceManager;
import com.viralinnovation.viralmanager.api.architecture.JVMEntity;
import com.viralinnovation.viralmanager.api.executables.modifiers.ExecutableInteractor;
import com.viralinnovation.viralmanager.api.executables.threads.modify.ModifyFunction;
import com.viralinnovation.viralmanager.api.executables.threads.stats.StatFunction;
import com.viralinnovation.viralmanager.api.statistics.AbstractStatisticsEntity;
import com.viralinnovation.viralmanager.api.utils.FileUtils;
import org.jetbrains.annotations.Nullable;

public class ThaliaServiceInteractor implements ExecutableInteractor<JVMEntity, ThaliaServiceEntity> {

    @Override
    public @Nullable ModifyFunction<JVMEntity, ThaliaServiceEntity> getModifyFunction() {
        return new ModifyFunction<>() {

            private final SourceManager sourceManager = SourceManager.getInstance();

            @Override
            public boolean modifyCondition(ThaliaServiceEntity executableEntity, JVMEntity architectureEntity) {
                return sourceManager.getDetails("Thalia").getVersion().equals(executableEntity.getVersion());
            }

            @Override
            public ThaliaServiceEntity modifiedExecutableEntity(ThaliaServiceEntity executableEntity, JVMEntity architectureEntity) {
                SourceManager sourceManager = SourceManager.getInstance();
                executableEntity.setVersion(sourceManager.getDetails("Thalia").getVersion());
                return executableEntity;
            }

            @Override
            public JVMEntity modifiedArchitectureEntity(ThaliaServiceEntity executableEntity, JVMEntity architectureEntity) {
                SourceManager sourceManager = SourceManager.getInstance();
                String fileLocation = sourceManager.downloadFromNexus("Thalia", FileUtils.generateUploadedFilePath(executableEntity.getEndpoint()));
                architectureEntity.setJarFilePath(fileLocation);
                return architectureEntity;
            }
        };
    }

    @Override
    public @Nullable StatFunction<? extends AbstractStatisticsEntity, JVMEntity, ThaliaServiceEntity> getStatFunction() {
        return null;
    }
}
