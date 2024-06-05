package com._frames.version_control_system.dao;

import com._frames.version_control_system.model.Change;
import com._frames.version_control_system.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChangeRepository extends JpaRepository<Change, Long> {
    List<Change> findByFileAndOldVersionAndNewVersion(File file, Integer oldVersion, Integer newVersion);
}

