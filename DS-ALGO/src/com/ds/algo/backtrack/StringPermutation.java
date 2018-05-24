package com.ds.algo.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * to generate all the possible combination of a string
 * ABC -> ABC,ACB,BAC,BCA,CAB,CBA
 * @author badsharma
 *
 */
public class StringPermutation {
	
	public static List<String> permuteString(String str){
			
		Map<Character,Integer> countMap = new HashMap<Character, Integer>();
		
		for(int i=0;i<str.length();i++){
			if(countMap.containsKey(str.charAt(i))){
				countMap.put(str.charAt(i), countMap.get(str.charAt(i))+1);
			}else{
				countMap.put(str.charAt(i), 1);
				
			}
			
		}
	
		
	char chararray [] = new char[countMap.size()];
	Integer count [] = new Integer[countMap.size()];
	int i=0;
	for(Map.Entry<Character, Integer> map : countMap.entrySet()){
		chararray[i] = map.getKey();
		count[i] = map.getValue();
		i++;
	}

	char [] result = new char[str.length()];
	
	List<String> resultList = new ArrayList<String>();
	
	permuteUtil(chararray , count , 0, result,resultList);
		
		
		return resultList;
	}
	
	
	
	

	private static void permuteUtil(char[] chararray, Integer[] count, int level, char[] result,
			List<String> resultList) {

		if(level==result.length){
			resultList.add(new String(result));
			return;
		}
		for(int i=0;i<chararray.length;i++){
			if(count[i]==0){
				continue;
			}
			result[level]=chararray[i];
			count[i]--;
			permuteUtil(chararray,count,level+1,result,resultList);
			count[i]++;
		}
	}





	public static void main(String[] args) {
		System.out.println(permuteString("abc"));

	}

}
