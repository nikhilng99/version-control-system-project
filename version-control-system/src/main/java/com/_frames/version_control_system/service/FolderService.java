package com._frames.version_control_system.service;


import com._frames.version_control_system.model.Folder;
import com._frames.version_control_system.dao.FolderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Transactional
    public Folder createFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Folder getFolderById(Long id) {
        return folderRepository.findById(id).orElse(null);
    }
}

