package com._frames.version_control_system.dao;

import com._frames.version_control_system.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}

