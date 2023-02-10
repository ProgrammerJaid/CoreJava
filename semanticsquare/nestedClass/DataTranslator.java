package com.semanticsquare.nestedClass;

import java.io.StringWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;


public class DataTranslator {	
	
	public static String getBookAsXml(int id, String title, double rating, int fbLikesCount, int tweetCount) {
		
		class Book {										//Use this in VM arguments
			private int id;									//--add-opens java.base/java.util=ALL-UNNAMED
			private String title;							//--add-opens java.base/java.lang=ALL-UNNAMED
			private double rating;							//--add-opens java.base/java.lang.reflect=ALL-UNNAMED
			private int fbLikesCount;						//--add-opens java.base/java.text=ALL-UNNAMED
			private int tweetCount;							//--add-opens java.desktop/java.awt.font=ALL-UNNAMED
			
			public Book (int id, String title, double rating, int fbLikesCount, int tweetCount) {
				this.id = id;
				this.title = title;
				this.rating = rating;
				this.fbLikesCount = fbLikesCount;
				this.tweetCount = tweetCount;
			}		
		}
			
		Book book = new Book(id, title, rating, fbLikesCount, tweetCount);
		
		XStream xstream = new XStream(new StaxDriver());		//Takes book object and converts it into xml
		xstream.alias("book", Book.class);						//JaxP in java can be used however the class itself must be a static member class
		StringWriter writer = new StringWriter();
		xstream.marshal(book,  new PrettyPrintWriter(writer));
		
		return writer.toString();
		//return xstream.toXML(book);		
	}
	
	public static void main(String[] args) {
		System.out.println(DataTranslator.getBookAsXml(2002, "Interface vs Abstract Class", 3.0, 5, 6));
	}
}
