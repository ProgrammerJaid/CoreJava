package com.semanticsqaure.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;	//Avoid Using FileInputStream use InputStreamReader instead...it applies encoding schemes
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

	public class ytIO { // Kody Simpson
		
		private static void outputStream() {
			System.out.write(74); // Stores in Buffer gives error if int >255 ASCII standards
			System.out.flush(); // Prints it out by flushing the buffer.
		
			System.out.write(10); // 10 is for new line       We do not need catch for this because its an abstract void
															// over written method.
			System.out.flush();
			String name = "My name is Sk Jaid";
			byte[] data = name.getBytes();
			try {
				System.out.write(data);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.close();
			}
			System.out.flush();
		}
		
		private static void inputStream() {
			System.out.println("In Input Stream...\n");
			/*int[] data = new int[10];
			try {
				for(int i=0;i<data.length;i++) {
					data[i]=System.in.read();			//It takes 10 byte as input
				}
				
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.print("Printing Input...-> ");
				for(int i=0;i<data.length;i++) {
					System.out.write(data[i]);			
				}
				System.out.flush();*/
				
				//-1 means end of stream...This is for Single Data...
				try(FileInputStream in = new FileInputStream("temp.txt")){		//This is tryWithResources
					while(true) {
						int value = in.read();
						if(value==-1) {
							System.out.println("....End Of Stream.\n");
							break;
						}else {
							System.out.write(value);
						}
						System.out.flush();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//This is for Chunks of data...
				FileInputStream in=null;
				try{
				/*For Storing data given by console
					byte[] value = new byte[20];
					System.in.read(value);
					System.out.write(value);
					System.out.flush();*/
					
					//Reading from File With available method
					in= new FileInputStream("temp.txt");
					byte[] d = new byte[in.available()];//It guesses the length required and automatically sets it. 
					in.read(d);
					System.out.write(d);
					System.out.flush();
					
				}catch(IOException e) {
					e.printStackTrace();
				}finally {
					try {
						if(in!=null) {		//That means some file was opened
							in.close();
							System.out.println("\nFile is Closed...");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("\nEnd of inputStream...");
			}
		
		private static void filterInputStreams() {
			System.out.println("\nInside Filter Output Stream.\n");
			try(CustomOutputFilter output = new CustomOutputFilter(new FileOutputStream("output.txt"));){
				int i;
				while ((i = System.in.read()) != 'x' ){
					output.write(i);
				}
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		private static void bufferInputStream() {
			System.out.println("\nInside bufferedInputStream...");
			try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("data.txt"));
					BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("newData.txt"));){
				
				int i;
				for(i=input.read();i!=-1;i=input.read()){
					output.write(i);
				}
				output.flush();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			//outputStream();
			inputStream();
			//filterInputStreams();		//Check DIRFilter by dheeru sir.
			//bufferInputStream();
		}
}
	
	class CustomOutputFilter extends FilterOutputStream{

		public CustomOutputFilter(OutputStream out) {
			super(out);
			
		}
		
		@Override
		public void write(int b) throws IOException{
			
			if(b>=48 && b<=57) {
				super.write(b);
			} else {
				super.write(63);
			}
		}
		
		@Override
		public void write(byte[] b,int off,int len) throws IOException{
			
			for(int i=off;i<=off+len;i++) {
				this.write(b[i]);			//this is for class write method
			}
		}
	}
