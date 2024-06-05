package com._frames.version_control_system.controller;

import com._frames.version_control_system.model.Change;
import com._frames.version_control_system.model.File;
import com._frames.version_control_system.model.MergeRequest;
import com._frames.version_control_system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public File createFile(@RequestBody File file) {
        return fileService.createFile(file);
    }

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/{id}")
    public File getFileById(@PathVariable Long id) {
        return fileService.getFileById(id);
    }

    @GetMapping("/folder/{folderId}")
    public List<File> getFilesByFolderId(@PathVariable Long folderId) {
        return fileService.getFilesByFolderId(folderId);
    }

    @PutMapping("/{fileId}")
    public File updateFile(@PathVariable Long fileId, @RequestBody String newContent) {
        return fileService.updateFile(fileId, newContent);
    }

    @GetMapping("/{fileId}/diff/{version1}/{version2}")
    public List<Change> getDiff(@PathVariable Long fileId, @PathVariable Integer version1, @PathVariable Integer version2) {
        return fileService.getDiff(fileId, version1, version2);
    }

    @PostMapping("/merge")
    public File mergeFiles(@RequestBody MergeRequest mergeRequest) {
        return fileService.mergeFiles(mergeRequest.getFileId(), mergeRequest.getBaseVersion(), mergeRequest.getNewContent());
    }
}

