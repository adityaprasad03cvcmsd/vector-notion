package com.vector.notion.notion.service.permission;

import com.vector.notion.notion.entity.Permission;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    List<Permission> permissionList;

    @PostConstruct
    void init(){
        permissionList = new ArrayList<>();
    }

    @Override
    public Permission addPermission(Long userId, Long documentId, String type) {
        Permission permission = Permission.builder().id(Long.valueOf(permissionList.size())).createdAt(new Date())
                .documentId(documentId).userId(userId).type(type).build();
        permissionList.add(permission);
        return permission;
    }

    @Override
    public Permission getPermissionByDocumentId(Long documentId) {
        for(Permission permission: permissionList){
            if(permission.getDocumentId().equals(documentId)){
                return permission;
            }
        }
        return null;
    }
}
