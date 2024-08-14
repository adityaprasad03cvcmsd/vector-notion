package com.vector.notion.notion.controller.folder;

import com.vector.notion.notion.dto.folder.FolderRequest;
import com.vector.notion.notion.entity.FolderMetaData;
import com.vector.notion.notion.service.folder.FolderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/folders/v1")
public class FolderController {

    @Autowired
    FolderService folderService;

    @PostMapping
    public ResponseEntity<?> createFolder(@RequestBody FolderRequest req){
        try{
            FolderMetaData folder = folderService.createFolder(req);
            return ResponseEntity.status(HttpStatus.CREATED).body(folder);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllFolder(@RequestHeader("userId") Long userId){
        try{
            List<FolderMetaData> res = folderService.getAllFolderByUserId(userId);
            return ResponseEntity.ok(res);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
