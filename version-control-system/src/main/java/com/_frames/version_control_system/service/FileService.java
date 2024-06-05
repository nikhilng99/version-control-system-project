package com._frames.version_control_system.service;

import com._frames.version_control_system.Change;
import com._frames.version_control_system.dao.ChangeRepository;
import com._frames.version_control_system.dao.FolderRepository;
import com._frames.version_control_system.model.File;
import com._frames.version_control_system.dao.FileRepository;
import com._frames.version_control_system.model.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private ChangeRepository changeRepository;

    public File createFile(String filename, Long folderPath, Long userId, String content) {
        File file = new File();
        file.setFileName(filename);
        file.setFileContent(content);
        file.setFileVersion(1);
        file.setFolder(new Folder(folderPath));
        file.setTimestamp(LocalDateTime.now());
        // set folder and user based on folderId and userId
        return fileRepository.save(file);
    }

    public File getFile(Long fileId) {
        System.out.println("fileId is "+fileId);
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("Could not find file"));
    }
    public List<File> getFiles() {
        return fileRepository.findAll();
    }

    public File updateFile(Long fileId, String newContent) {
        File file = fileRepository.findById(fileId).orElse(null);
        if (file != null) {
            String oldContent = file.getFileContent();
            Integer oldVersion = file.getFileVersion();
            Integer newVersion = oldVersion + 1;

            // Calculate diff
            String diff = getDiff(oldContent, newContent);

            // Save change
            Change change = new Change();
            change.setFile(file);
            change.setOldVersion(oldVersion);
            change.setNewVersion(newVersion);
            change.setDiff(diff);
            change.setTimestamp(LocalDateTime.now());
            changeRepository.save(change);

            // Update file
            file.setFileContent(newContent);
            file.setFileVersion(newVersion);
            file.setTimestamp(LocalDateTime.now());
            return fileRepository.save(file);
        }
        return null;
    }

    public List<Change> getDiff(Long fileId, Integer version1, Integer version2) {
        File file = fileRepository.findById(fileId).orElse(null);
        return changeRepository.findByFileAndOldVersionAndNewVersion(file, version1, version2);
    }

    public File mergeFiles(Long fileId, Integer baseVersion, String newContent) {
        File file = fileRepository.findById(fileId).orElse(null);
        if (file != null) {
            // Fetch base content and latest content
            List<Change> changes = changeRepository.findByFileAndOldVersionAndNewVersion(file, baseVersion, file.getFileVersion());
            String baseContent = changes.get(0).getDiff();
            String latestContent = file.getFileContent();
            String mergedContent = merge(baseContent, latestContent, newContent);

            // Update file with merged content
            return updateFile(fileId, mergedContent);
        }
        return null;
    }

    private String getDiff(String oldContent, String newContent) {
        // Implement diff logic here
        return "diff result";
    }

    private String merge(String baseContent, String latestContent, String newContent) {
        // Implement merge logic here
        return "merged result";
    }
}

