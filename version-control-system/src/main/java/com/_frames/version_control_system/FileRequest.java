package com._frames.version_control_system;

public class FileRequest {
    private String fileName;
    private Long folderPath;
    private Long userName;
    private String content;

    public FileRequest(String fileName, Long folderPath, Long userName, String content) {
        this.fileName = fileName;
        this.folderPath = folderPath;
        this.userName = userName;
        this.content = content;
    }

    public FileRequest() {
    }
// Getters and Setters

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(Long folderPath) {
        this.folderPath = folderPath;
    }

    public Long getUserName() {
        return userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
