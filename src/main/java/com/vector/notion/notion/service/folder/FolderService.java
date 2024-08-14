package com.vector.notion.notion.service.folder;

import com.vector.notion.notion.dto.folder.FolderRequest;
import com.vector.notion.notion.entity.FolderMetaData;

import java.util.List;

public interface FolderService {

    FolderMetaData createFolder(FolderRequest request);

    FolderMetaData getFolder(Long folderId);

    List<FolderMetaData> getAllFolderByUserId(Long userId);

}
