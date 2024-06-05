package com._frames.version_control_system.controller;

import com._frames.version_control_system.*;
import com._frames.version_control_system.model.File;
import com._frames.version_control_system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/files")
    public File createFile(@RequestBody FileRequest fileRequest) {
        return fileService.createFile(fileRequest.getFileName(), fileRequest.getFolderPath(), fileRequest.getUserName(), fileRequest.getContent());
    }

    @GetMapping("/files/{fileId}")
    public File getFile(@PathVariable Long fileId) {
        return fileService.getFile(fileId);
    }

    @GetMapping("files/allfiles")
    public List<File> getFiles() {
        return fileService.getFiles();
    }
    @PutMapping("/files/{fileId}")
    public File updateFile(@PathVariable Long fileId, @RequestBody String newContent) {
        return fileService.updateFile(fileId, newContent);
    }

    @GetMapping("files/{fileId}/diff/{version1}/{version2}")
    public List<Change> getDiff(@PathVariable Long fileId, @PathVariable Integer version1, @PathVariable Integer version2) {
        return fileService.getDiff(fileId, version1, version2);
    }

    @PostMapping("files/merge")
    public File mergeFiles(@RequestBody MergeRequest mergeRequest) {
        return fileService.mergeFiles(mergeRequest.getFileId(), mergeRequest.getBaseVersion(), mergeRequest.getNewContent());
    }
}

