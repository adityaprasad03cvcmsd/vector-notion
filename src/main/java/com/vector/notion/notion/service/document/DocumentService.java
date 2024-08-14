package com.vector.notion.notion.service.document;

import com.vector.notion.notion.dto.document.DocumentRequest;
import com.vector.notion.notion.entity.Document;

import java.util.List;

public interface DocumentService {

    Document createDocument(DocumentRequest request);

    Document getDocument(Long documentId);

    List<String> searchDocumentsByTitlePrefix(String prefix);
}
