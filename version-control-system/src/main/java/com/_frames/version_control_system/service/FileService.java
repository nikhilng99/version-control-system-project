package com._frames.version_control_system.service;

import com._frames.version_control_system.dao.ChangeRepository;
import com._frames.version_control_system.dao.FileRepository;
import com._frames.version_control_system.model.Change;
import com._frames.version_control_system.model.File;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;
    private ChangeRepository changeRepository;

    @Transactional
    public File createFile(File file) {
        file.setVersion(1);
        file.setTimestamp(LocalDateTime.now());
        return fileRepository.save(file);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public List<File> getFilesByFolderId(Long folderId) {
        return fileRepository.findAllById(Collections.singleton(folderId));
    }

    public File updateFile(Long fileId, String newContent) {
        File file = fileRepository.findById(fileId).orElse(null);
        if (file != null) {
            String oldContent = file.getContent();
            Integer oldVersion = file.getVersion();
            //increment the version
            Integer newVersion = oldVersion + 1;

            //calculate the difference between old and new contents
            String diff = getDiff(oldContent, newContent);

            //saving the change
            Change change = new Change();
            change.setFile(file);
            change.setOldVersion(oldVersion);
            change.setNewVersion(newVersion);
            change.setDiff(diff);
            change.setTimestamp(LocalDateTime.now());
            changeRepository.save(change);

            //updating the file
            file.setContent(newContent);
            file.setVersion(newVersion);
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
            //get the old content and latest content
            List<Change> changes = changeRepository.findByFileAndOldVersionAndNewVersion(file, baseVersion, file.getVersion());
            String baseContent = changes.get(0).getDiff();
            String latestContent = file.getContent();
            String mergedContent = merge(baseContent, latestContent, newContent);

            //updating the file with merged content
            return updateFile(fileId, mergedContent);
        }
        return null;
    }

    private String getDiff(String oldContent, String newContent) {
        //logic to be implemented to show difference in the files.
        // We can show ++ as the additions and -- for removals.
        // Similar to Github which shows difference
        return "diff result";
    }

    private String merge(String baseContent, String latestContent, String newContent) {
        //logic to merge the content in files.
        // Need to consider Head and the modified content
        return "merged result";
    }
}

