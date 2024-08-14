package com.vector.notion.notion.dto.document;

import lombok.Data;

@Data
public class DocumentPermissionRequest {

    private Long documentId;

    private Long permissionFor;

    private String type;
}
