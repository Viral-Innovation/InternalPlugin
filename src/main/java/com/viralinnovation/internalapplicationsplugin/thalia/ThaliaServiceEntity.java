package com.viralinnovation.internalapplicationsplugin.thalia;

import com.viralinnovation.viralmanager.api.architecture.ArchitectureEntity;
import com.viralinnovation.viralmanager.api.executables.ExecutableType;
import com.viralinnovation.viralmanager.api.executables.data.ExecutableEntity;
import com.viralinnovation.viralmanager.api.executables.data.ExecutableResponse;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ThaliaServiceEntity extends ExecutableEntity {

    private String version;

    public ThaliaServiceEntity() {
    }

    public ThaliaServiceEntity(@NotNull ArchitectureEntity architectureEntity, String name, UUID endpoint, ExecutableType<? extends ArchitectureEntity, ? extends ExecutableEntity> type, boolean terminates,
                               String version) {
        super(architectureEntity, name, endpoint, type, terminates);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThaliaServiceEntity that = (ThaliaServiceEntity) o;
        return Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public String toString() {
        return "ThaliaServiceEntity{" +
                "version='" + version + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", executableType='" + executableType + '\'' +
                ", isSystem=" + isSystem +
                ", endpoint=" + endpoint +
                ", terminates=" + terminates +
                '}';
    }

    @Override
    public ExecutableResponse getResponse(ArchitectureEntity architectureEntity) {
        return new ThaliaResponseEntity(this, architectureEntity);
    }
}
