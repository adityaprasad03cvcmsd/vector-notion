package com.vector.notion.notion.service.folder;

import com.vector.notion.notion.dto.folder.FolderRequest;
import com.vector.notion.notion.entity.FolderMetaData;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FolderServiceImpl implements FolderService{

    private List<FolderMetaData> folderList;

    @PostConstruct
    private void init(){
        folderList = new ArrayList<>();
    }

    @Override
    public FolderMetaData createFolder(FolderRequest request) {
        FolderMetaData folderMetaData = FolderMetaData.builder().createdAt(new Date()).id(Long.valueOf(folderList.size()))
                .userId(request.getUserId()).name(request.getName()).build();
        folderList.add(folderMetaData);

        return folderMetaData;
    }

    @Override
    public FolderMetaData getFolder(Long folderId) {

        for(FolderMetaData folder: folderList){
            if(folder.getId().equals(folderId)){
                return folder;
            }
        }
        return null;
    }

    @Override
    public List<FolderMetaData> getAllFolderByUserId(Long userId) {
        return folderList.stream().filter(e->e.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
