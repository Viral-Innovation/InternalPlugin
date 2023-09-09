package com.viralinnovation.internalapplicationsplugin.thalia;

import com.viralinnovation.internalapplicationsplugin.SourceManager;
import com.viralinnovation.viralmanager.api.annotations.form.Data;
import com.viralinnovation.viralmanager.api.annotations.form.Help;
import com.viralinnovation.viralmanager.api.architecture.ArchitectureEntity;
import com.viralinnovation.viralmanager.api.architecture.JVMEntity;
import com.viralinnovation.viralmanager.api.executables.ExecutableType;
import com.viralinnovation.viralmanager.api.executables.data.ExecutableEntity;
import com.viralinnovation.viralmanager.api.executables.data.ExecutableFormEntity;
import com.viralinnovation.viralmanager.api.utils.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ThaliaFormEntity extends ExecutableFormEntity {

    @Data(name = "Max. RAM (GB)")
    @Help(helpText = "Maximum RAM used by the Paper Server")
    private int xmx;

    public ThaliaFormEntity() {
        super();
    }

    public ThaliaFormEntity(int xmx) {
        this.xmx = xmx;
    }

    public int getXmx() {
        return xmx;
    }

    public void setXmx(int xmx) {
        this.xmx = xmx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThaliaFormEntity that = (ThaliaFormEntity) o;
        return xmx == that.xmx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xmx);
    }

    @Override
    public <T extends ArchitectureEntity> T getArchitectureEntity(@NotNull ExecutableType<T, ? extends ExecutableEntity> executableType) {
        SourceManager sourceManager = SourceManager.getInstance();
        String fileLocation = sourceManager.downloadFromNexus("Thalia", FileUtils.generateUploadedFilePath(endpoint));
        List<String> flags = new ArrayList<>();
        return executableType.getArchitectureEntity().cast(
                new JVMEntity(id, crashRestart, fileLocation, flags, xmx, xmx, 17)
        );
    }

    @Override
    public <S extends ExecutableEntity> S getExecutableEntity(ExecutableType<? extends ArchitectureEntity, S> executableType, ArchitectureEntity architectureEntity, boolean isTask) {
        SourceManager sourceManager = SourceManager.getInstance();
        return (S) new ThaliaServiceEntity(architectureEntity, name, endpoint, executableType, isTask, sourceManager.getDetails("Thalia").getVersion());
    }

    @Override
    public String toString() {
        return "ThaliaFormEntity{" +
                "xmx=" + xmx +
                ", name='" + name + '\'' +
                ", endpoint=" + endpoint +
                ", crashRestart=" + crashRestart +
                ", id=" + id +
                '}';
    }
}
