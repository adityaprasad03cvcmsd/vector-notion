package com.vector.notion.notion.service.folderDocument;

import com.vector.notion.notion.entity.FolderDocument;
import com.vector.notion.notion.service.folder.FolderService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FolderDocumentServiceImpl implements FolderDocumentService {

    private List<FolderDocument> folderDocumentList;

    @PostConstruct
    void init(){
        folderDocumentList = new ArrayList<>();
    }

    @Override
    public FolderDocument putDocumentInFolder(Long folderId, Long documentId) {
        FolderDocument folderDocument = FolderDocument.builder().id(Long.valueOf(folderDocumentList.size())).documentId(documentId)
                .folderId(folderId).build();
        folderDocumentList.add(folderDocument);
        return folderDocument;
    }

    @Override
    public List<FolderDocument> getDocumentByFolderId(Long folderId) {
        return folderDocumentList.stream().filter(e->e.getFolderId().equals(folderId)).collect(Collectors.toList());
    }
}
