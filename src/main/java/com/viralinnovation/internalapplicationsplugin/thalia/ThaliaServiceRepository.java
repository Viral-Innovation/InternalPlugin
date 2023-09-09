package com.viralinnovation.internalapplicationsplugin.thalia;

import com.viralinnovation.viralmanager.api.jpa.executables.ExecutableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThaliaServiceRepository extends ExecutableRepository<ThaliaServiceEntity> {
    @Override
    default String repoName() {
        return "Thalia Repo";
    }
}
