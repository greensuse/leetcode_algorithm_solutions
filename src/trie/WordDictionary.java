package trie;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean res = wordDictionary.search("aa"); // return False
        System.out.println(res);
        res = wordDictionary.search("bad"); // return True
        System.out.println(res);
        res = wordDictionary.search(".ad"); // return True
        System.out.println(res);
        res = wordDictionary.search("b.."); // return True
        System.out.println(res);
    }

    TrieNode root=null;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;
        for(char c : word.toCharArray()) {
            if(cur.children[c-'a']==null) {
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        cur.word=word;
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode cur, String word) {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c=='.') {
                String new_word=word.substring(i+1);
                if(search(cur.children, new_word)) {
                    return true;
                }
                return false;
            }

            if(cur.children[c-'a']==null) {
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return cur.word!=null;
    }

    private boolean search(TrieNode[] children, String word) {
        for(TrieNode node : children) {
            if(node==null) continue;
            if(search(node, word)) {
                return true;
            }
        }
        return false;
    }

    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children=new TrieNode[26];
            word=null;
        }
    }
}


