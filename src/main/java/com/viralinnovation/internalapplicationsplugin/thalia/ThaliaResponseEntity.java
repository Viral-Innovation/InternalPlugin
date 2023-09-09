package com.viralinnovation.internalapplicationsplugin.thalia;

import com.viralinnovation.viralmanager.api.architecture.ArchitectureEntity;
import com.viralinnovation.viralmanager.api.architecture.JVMEntity;
import com.viralinnovation.viralmanager.api.executables.data.ExecutableEntity;
import com.viralinnovation.viralmanager.api.executables.data.ExecutableResponse;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ThaliaResponseEntity extends ExecutableResponse {

    private int xmx;

    public ThaliaResponseEntity(@NotNull ExecutableEntity executable, @NotNull ArchitectureEntity entity) {
        super(executable, entity);
        this.xmx = ((JVMEntity) entity).getXmx();
    }

    public int getXmx() {
        return xmx;
    }

    @Override
    public String toString() {
        return "ThaliaResponseEntity{" +
                "xmx=" + xmx +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", executableType='" + executableType + '\'' +
                ", isSystem=" + isSystem +
                ", crashRestart=" + crashRestart +
                ", endpoint=" + endpoint +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThaliaResponseEntity that = (ThaliaResponseEntity) o;
        return xmx == that.xmx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xmx);
    }
}
