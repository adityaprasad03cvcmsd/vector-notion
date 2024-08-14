package com.vector.notion.notion.utils.trie;

import java.util.HashMap;

public class TrieNode {

    public HashMap<Character, TrieNode> children = new HashMap<>();
    public boolean isEndOfWord = false;
}
