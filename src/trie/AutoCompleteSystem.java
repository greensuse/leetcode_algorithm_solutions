package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoCompleteSystem {
    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutoCompleteSystem as = new AutoCompleteSystem(sentences, times);
        List<String> res=as.input('i');
        System.out.println(res);
        res=as.input(' ');
        System.out.println(res);
        res=as.input('a');
        System.out.println(res);
        res=as.input('#');
        System.out.println(res);
    }
    TrieNode root;
    TrieNode cur;
    StringBuilder sb;

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur=root;
        sb=new StringBuilder();
        for(int i=0; i<times.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res=new ArrayList<>();
        if(c=='#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }

        sb.append(c);
        if(cur!=null) {
            cur=cur.children[c];
        }
        if(cur==null) return res;
        for(TrieNode node : cur.hotList) {
            res.add(node.sentence);
        }
        return res;
    }

    private void add(String sentence, int times) {
        TrieNode tmp=root;
        List<TrieNode> visited = new ArrayList<>();
        for(char c : sentence.toCharArray()) {
            if(tmp.children[c]==null) {
                tmp.children[c]=new TrieNode();
            }
            tmp=tmp.children[c];
            visited.add(tmp);
        }
        tmp.sentence=sentence;
        tmp.times +=times;

        for(TrieNode node: visited) {
            node.update(tmp);
        }
    }



    class TrieNode implements Comparable<TrieNode> {
        String sentence;
        int times;
        TrieNode[] children;
        List<TrieNode> hotList;

        public TrieNode() {
            children = new TrieNode[128];
            hotList=new ArrayList<>();
            times=0;
            sentence=null;
        }

        @Override
        public int compareTo(TrieNode node) {
            if(this.times==node.times) {
                return this.sentence.compareTo(node.sentence);
            }
            return node.times-this.times;
        }

        public void update(TrieNode node) {
            if(!hotList.contains(node)) {
                hotList.add(node);
            }
            Collections.sort(hotList);
            if(hotList.size() >3) {
                hotList.remove(hotList.size() - 1);
            }
        }
    }
}
