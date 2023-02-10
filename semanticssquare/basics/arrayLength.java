package com.semanticssquare.basics;

class arrayLength{
	
	static void findarrayLength(int [][]d){
		
		int x= d.length;
		int y=d[1].length;
		System.out.println("x: "+x+ "  y:"+y);
		}
		public static void main(String[] args){
		
		int[][] k={{1,2},{1,2,3}};
		findarrayLength(k);
		}
		}
	