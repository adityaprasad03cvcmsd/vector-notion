package com.vector.notion.notion.service.folderDocument;

import com.vector.notion.notion.entity.FolderDocument;

import java.util.List;

public interface FolderDocumentService {

    FolderDocument putDocumentInFolder(Long folderId, Long documentId);

    List<FolderDocument> getDocumentByFolderId(Long folderId);
}
