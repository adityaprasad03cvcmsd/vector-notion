package com.vector.notion.notion.service.permission;

import com.vector.notion.notion.entity.Permission;

public interface PermissionService {

    Permission addPermission( Long userId, Long documentId, String type);

    Permission getPermissionByDocumentId(Long documentId);
}
