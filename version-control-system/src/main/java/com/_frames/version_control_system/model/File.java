package com._frames.version_control_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    private String fileContent;
    private Integer fileVersion;
    private LocalDateTime timestamp;

    @ManyToOne
    private Folder folder;

    public Folder getFolder() {
        return folder;
    }

    @ManyToOne
    private User user;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public Integer getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(Integer fileVersion) {
        this.fileVersion = fileVersion;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setFolder(Folder folder) {
        this.folder=folder;
    }
}

