package com.vector.notion.notion.dto.document;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class DocumentVersionRequest {

    private String documentUqKey;

    private Long documentId;

    private String description;
}
