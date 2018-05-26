package com.ds.algo.cache;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author badsharma
 *
 */

public class LRUCache {

	private Deque<LRUNode> nodes;
	private Map<Integer,LRUNode> cache;
	private int capacity;
	
	public LRUCache(int capacity){
		this.capacity=capacity;
		cache = new HashMap<Integer,LRUNode>();
		nodes = new ArrayDeque<LRUNode>(capacity);
		
	}
	
	public int get(int key){
		int res =-1;
		LRUNode node = cache.get(key);
		if(node ==null){
			return res;
		}
		nodes.remove(node);
		nodes.addFirst(node);
		return node.value;
	}
	
	
	public void put(int key, int value){
		LRUNode node = cache.get(key);
		if(node !=null){
			nodes.remove(node);
			if(node.key==key){
				cache.remove(node.key, node);
				LRUNode newNode = new LRUNode(key, value);
				cache.put(key, newNode);
				nodes.addFirst(newNode);
			}else{
				nodes.addFirst(node);;
			}
		}else{
			LRUNode newNode = new LRUNode(key, value);
			if(cache.size()>=capacity){
			LRUNode lastNode=nodes.pollLast();
			cache.remove(lastNode.key, lastNode);
			cache.put(key, newNode);
			nodes.addFirst(newNode);
			}else{
				nodes.addFirst(newNode);
				cache.put(key, newNode);
				
			}
			
		}
		
		
	}
	
	
	public class LRUNode{
		
		private int key;
		private int value;
		
		public LRUNode(int k , int v){
			this.key=k;
			this.value=v;
		}

		@Override
		public String toString() {
			return "LRUNode [key=" + key + ", value=" + value + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		//["LRUCache","put","put","get","put","put","get"]
	//	[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
		LRUCache cache = new LRUCache(2);
		
		cache.put(2, 1);

		cache.put(2, 2);
		
		System.out.println(cache.get(2));
		cache.put(1, 1);
		cache.put(4, 1);
		System.out.println(cache.get(2));
		

	//	System.out.println(cache.get(2));
	}
}
