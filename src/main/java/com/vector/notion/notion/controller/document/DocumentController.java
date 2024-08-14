package com.vector.notion.notion.controller.document;

import com.vector.notion.notion.dto.document.DocumentPermissionRequest;
import com.vector.notion.notion.dto.document.DocumentRequest;
import com.vector.notion.notion.entity.Document;
import com.vector.notion.notion.entity.FolderDocument;
import com.vector.notion.notion.service.document.DocumentService;
import com.vector.notion.notion.service.documentManagement.DocumentManagementService;
import com.vector.notion.notion.service.folderDocument.FolderDocumentService;
import com.vector.notion.notion.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("documents/v1")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    FolderDocumentService folderDocumentService;

    @Autowired
    DocumentManagementService documentManagementService;

    @Autowired
    PermissionService permissionService;

    @PostMapping
    public ResponseEntity<?> createDocument(@RequestBody DocumentRequest req){
        try{
            Document document = documentManagementService.createDocument(req);
            return ResponseEntity.status(HttpStatus.CREATED).body(document);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<?>getAllDocumentsInFolder(@RequestParam("folderId")Long folderId){
        try{
            List<FolderDocument> folderDocumentList = folderDocumentService.getDocumentByFolderId(folderId);
            return ResponseEntity.ok(folderDocumentList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{documentUqKey}")
    public ResponseEntity<?> getDocument(@PathVariable("documentUqKey") String uqKey, @RequestHeader("userId") Long userId){
        try{
            Document document = documentManagementService.findDocumentByUqKey(uqKey, userId);
            return ResponseEntity.ok(document);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/folder")
    public ResponseEntity<?>putFolderInDocument(@RequestBody FolderDocument req){
        try{
            FolderDocument folderDocument = folderDocumentService.putDocumentInFolder(req.getFolderId(), req.getDocumentId());
            return ResponseEntity.ok().build();
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/permission")
    public ResponseEntity<?>addPermissionToDocument(@RequestBody DocumentPermissionRequest req){
        try{
            permissionService.addPermission(req.getPermissionFor(), req.getDocumentId(), req.getType());
            return ResponseEntity.ok().build();
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/title")
    public ResponseEntity<?>getDocumentsByTitle(@PathVariable("search")String searchText){
        try{
            List<String> documentTitleList = documentService.searchDocumentsByTitlePrefix(searchText);
            return ResponseEntity.ok(documentTitleList);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
