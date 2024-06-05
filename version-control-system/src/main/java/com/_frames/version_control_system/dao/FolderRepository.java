package com._frames.version_control_system.dao;

import com._frames.version_control_system.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
