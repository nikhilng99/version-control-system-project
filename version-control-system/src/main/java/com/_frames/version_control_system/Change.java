package com._frames.version_control_system;

import com._frames.version_control_system.model.File;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Change {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer oldVersion;
    private Integer newVersion;
    private String diff;
    private LocalDateTime timestamp;

    @ManyToOne
    private File file;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOldVersion() {
        return oldVersion;
    }

    public void setOldVersion(Integer oldVersion) {
        this.oldVersion = oldVersion;
    }

    public Integer getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(Integer newVersion) {
        this.newVersion = newVersion;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

