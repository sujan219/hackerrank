package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T9 {
	
	static HashMap<Character, List<Character>> map;
	
	public static void main(String[] args){
		initMap();
		Trie[] dictionary = getDictionary();
		
		String input = "867";
		Queue<Trie> queue = solve(dictionary, input);
		
		
		while(!queue.isEmpty()){
			StringBuilder str = new StringBuilder();
			Trie t = queue.remove();
			while(t != null){
				str.insert(0, t.ch);
				t = t.parent;
			}
			System.out.println(str.toString());
		}
	}
	
	private static Queue<Trie> solve(Trie[] dictionary, String input){
		Queue<Trie> queue = new LinkedList<Trie>();
		
		for(int i=0; i<input.length(); ++i){
			List<Trie> tempList = new ArrayList<Trie>();
			
			char ch = input.charAt(i);
			List<Character> chars = map.get(ch);
			
			if(i==0){
				for(char c:chars){
					tempList.add(dictionary[c]);
				}
			}else{
				while(!queue.isEmpty()){
					Trie t = queue.remove();
					for(char c:chars){
						Trie childTrie = t.find(c);
						if(childTrie != null){
							tempList.add(childTrie);
						}
					}
				}
			}
			
			queue.addAll(tempList);
		}
		
		return queue;
	}
	
	private static Trie[] getDictionary() {
		Trie[] dic = new Trie[128];
		String[] words = {"tree", "top", "try", "used", "user", "van", "var"};
		for(String word:words){
			Trie cur = null;
			if(dic[word.charAt(0)] == null){
				dic[word.charAt(0)] = new Trie(word.charAt(0));
			}
			cur = dic[word.charAt(0)];
			
			for(int i=1; i<word.length(); ++i){
				char ch = word.charAt(i);
				cur = cur.add(ch);
			}
		}
		return dic;
	}

	private static void initMap() {
		map = new HashMap<Character, List<Character>>();
		map.put('2', Arrays.asList('a', 'b', 'c'));
		map.put('3', Arrays.asList('d', 'e', 'f'));
		map.put('4', Arrays.asList('g', 'h', 'i'));
		map.put('5', Arrays.asList('j', 'k', 'l'));
		map.put('6', Arrays.asList('m', 'n', 'o'));
		map.put('7', Arrays.asList('p', 'q', 'r', 's'));
		map.put('8', Arrays.asList('t', 'u', 'v'));
		map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
	}

	public static class Trie{
		List<Trie> children;
		Trie parent;
		char ch;
		
		Trie(char c){
			ch = c;
			children = new ArrayList<>();
		}
		
		public Trie add(char c){
			Trie t = find(c);
			if(t == null){
				t = new Trie(c);
				t.parent = this;
				children.add(t);
			}
			return t;
		}
		
		public Trie find(char c){
			for(Trie trie:children){
				if(trie.ch == c){
					return trie;
				}
			}
			return null;
		}
	}
}
