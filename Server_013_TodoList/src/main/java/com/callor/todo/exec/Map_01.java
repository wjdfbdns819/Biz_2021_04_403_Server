package com.callor.todo.exec;

import java.util.HashMap;
import java.util.Map;

public class Map_01 {

	/*
	 * Map<K,V>
	 * List 데이터와 함께 Java에서 매우 많이
	 *  사용되는 자료구조임
	 *  
	 * Key, Value 형식으로 데이터를 저장하고,
	 * 	읽을수 있는 자료구조이다
	 * 
	 * List Type
	 * list.add(값) : List에 저장
	 * list.get(index) : List에서 값 읽기
	 * 
	 * Map type
	 * map.put(key,값) : Map에서 데이터 저장
	 * map.get(key) : Map에서 값을 읽을 때
	 */
	public static void main(String[] args) {
		
		// Map interface로 선언하고, HashMap으로 생성하기
		Map<String, String> maps
			= new HashMap<String, String>();
		
		
		// map.put --> 저장
		maps.put("이름", "홍길동");
		maps.put("나이", "30");
		maps.put("직업", "IT 개발자");
		
		// map.get --> 값을 읽기
		System.out.println(maps.get("이름"));
		System.out.println(maps.get("나이"));
		System.out.println(maps.get("직업"));
		
	}
}
