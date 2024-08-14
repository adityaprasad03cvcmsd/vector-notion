package com.vector.notion.notion.service.document;

import com.vector.notion.notion.dto.document.DocumentRequest;
import com.vector.notion.notion.entity.Document;
import com.vector.notion.notion.utils.trie.Trie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService{

    private List<Document> documentList;

    private Trie documentTrie;

    @PostConstruct
    void init(){
        documentList = new ArrayList<>();
        documentTrie = new Trie();
    }

    @Override
    public Document createDocument(DocumentRequest request) {
        Document document = Document.builder().id(Long.valueOf(documentList.size())).createdAt(new Date())
                .title(request.getTitle()).userId(Long.valueOf(request.getUserId())).content(request.getContent())
                .uqKey(UUID.randomUUID().toString()).build();
        documentList.add(document);
        documentTrie.insert(document.getTitle());
        return document;
    }

    @Override
    public Document getDocument(Long documentId) {
        for(Document doc: documentList){
            if(doc.getId().equals(documentId)){
                return doc;
            }
        }
        return null;
    }

    @Override
    public List<String> searchDocumentsByTitlePrefix(String prefix) {
        return documentTrie.searchByPrefix(prefix);
    }
}
