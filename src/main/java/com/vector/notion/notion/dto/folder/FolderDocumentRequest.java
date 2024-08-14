package com.vector.notion.notion.dto.folder;

import lombok.Data;
import lombok.NonNull;

@Data
public class FolderDocumentRequest {

    @NonNull
    private Long folderId;

    @NonNull
    private Long DocumentId;
}
