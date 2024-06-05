package com._frames.version_control_system.controller;

import com._frames.version_control_system.model.Folder;
import com._frames.version_control_system.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @PostMapping
    public Folder createFolder(@RequestBody Folder folder) {
        return folderService.createFolder(folder);
    }

    @GetMapping
    public List<Folder> getAllFolders() {
        return folderService.getAllFolders();
    }

    @GetMapping("/{id}")
    public Folder getFolderById(@PathVariable Long id) {
        return folderService.getFolderById(id);
    }
}
