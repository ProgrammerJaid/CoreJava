package com.semanticsquare.jvm;

/*In VM arguments:-Xms13m -Xmx13m -XX:+PrintGCDetails -XX:+UseSerialGC
 * 1. Xms13m=13 Mb min data created Xmx13m=13Mb max data.
 * 2. Change min to 2 mb
 * 3. Change min and max to 12 Mb
 * 
 * [Imp]-It checks each individual memory location to have the min. memory in this case 8.5.
 */


public class GCDemo {
	static int[] iArray = new int[2*1024*1024];  //Approx 8.4Mb (2M * 4byte)
	public static void main(String[] args) {
		
	}
}
