package com.alex.shiro.md5;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Alex on 2017/5/26.
 */
public class Md5Test {
	
	public static void main(String[] args) {
		
		Md5Hash md5Hash = new Md5Hash("11111", "aaaaa", 2);
		
		System.out.println(md5Hash.toString());
		
	}
	
}
