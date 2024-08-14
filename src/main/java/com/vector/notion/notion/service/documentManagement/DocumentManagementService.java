package com.vector.notion.notion.service.documentManagement;

import com.vector.notion.notion.dto.document.DocumentRequest;
import com.vector.notion.notion.dto.document.DocumentVersionRequest;
import com.vector.notion.notion.entity.Document;
import com.vector.notion.notion.entity.DocumentVersion;
import com.vector.notion.notion.entity.Permission;
import com.vector.notion.notion.service.document.DocumentService;
import com.vector.notion.notion.service.documentVersion.DocumentVersionService;
import com.vector.notion.notion.service.folderDocument.FolderDocumentService;
import com.vector.notion.notion.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentManagementService {

    @Autowired
    DocumentService documentService;

    @Autowired
    DocumentVersionService documentVersionService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    FolderDocumentService folderDocumentService;

    public Document createDocument(DocumentRequest req){
        Document document = documentService.createDocument(req);
        DocumentVersion documentVersion = documentVersionService.createDocumentVersion(DocumentVersionRequest.builder().documentUqKey(document.getUqKey())
                .documentId(document.getId()).description(document.getTitle()).build());
        Permission permission = permissionService.addPermission(document.getUserId(), document.getId(), "admin");
        return document;
    }

    public Document findDocumentByUqKey(String documentUqKey, Long userId){
        DocumentVersion documentVersion = documentVersionService.getDocumentIdVersion(documentUqKey);
        Document doc = documentService.getDocument(documentVersion.getDocumentId());
        if(doc.getId().equals(userId)){
            return doc;
        }
        return null;
    }
}
