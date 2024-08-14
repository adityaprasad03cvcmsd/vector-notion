package com.vector.notion.notion.service.documentVersion;

import com.vector.notion.notion.dto.document.DocumentVersionRequest;
import com.vector.notion.notion.entity.DocumentVersion;

public interface DocumentVersionService {

    DocumentVersion createDocumentVersion(DocumentVersionRequest request);

    DocumentVersion getDocumentIdVersion(String documentUqKey);
}
