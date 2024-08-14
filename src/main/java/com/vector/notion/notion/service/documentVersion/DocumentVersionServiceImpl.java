package com.vector.notion.notion.service.documentVersion;

import com.vector.notion.notion.dto.document.DocumentVersionRequest;
import com.vector.notion.notion.entity.DocumentVersion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DocumentVersionServiceImpl implements DocumentVersionService{

    List<DocumentVersion> documentVersionList;

    void init(){
        documentVersionList = new ArrayList<>();
    }


    @Override
    public DocumentVersion createDocumentVersion(DocumentVersionRequest request) {
        DocumentVersion docVersion = DocumentVersion.builder().id(Long.valueOf(documentVersionList.size())).documentId(request.getDocumentId())
                .documentUqKey(request.getDocumentUqKey()).createdAt(new Date()).description(request.getDescription()).build();
        documentVersionList.add(docVersion);
        return docVersion;
    }

    @Override
    public DocumentVersion getDocumentIdVersion(String documentUqKey) {
        for(DocumentVersion docVer: documentVersionList){
            if(docVer.getDocumentUqKey().equals(documentUqKey)){
                return docVer;
            }
        }
        return null;
    }
}
