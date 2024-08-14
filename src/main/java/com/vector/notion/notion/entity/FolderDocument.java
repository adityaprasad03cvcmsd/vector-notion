package com.vector.notion.notion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class FolderDocument {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long folderId;

    private Long documentId;
}
