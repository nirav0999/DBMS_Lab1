

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class main {
	/*
	public static int find_field_index(String[][] metadata_array,int no_of_fields,String field) {
		for(int k=0;k<no_of_fields;k++) {
			if(metadata_array[k][0].equals(field)) {
				return k;
			}
			
		}
		return -1;
	}
	*/
	public static void findmax(String a,ArrayList<ArrayList<String>> met,ArrayList<ArrayList<String>> data){
		int z=-1;
		for (int k=0;k<met.get(0).size();k++) {
			String e=met.get(0).get(k);
			if (e.contentEquals(a)) {
				
				z=k;
				//System.err.println("sssssssssssssss");
				break;
			}
			
		}
		if (z==-1) {
			System.out.println("");
			System.out.println("Error: Field Name Not Found");
			
		}
		
		else {
			if (met.get(1).get(z).equals("C")) {
				String[] arr=new String[data.get(z).size()];
				for (int l=0;l<data.get(z).size();l++) {
					arr[l]=data.get(z).get(l).trim();
				}
				Arrays.sort(arr);
				System.out.println("");
				System.out.println("Max Value:");
				System.out.println(arr[arr.length-1]);
			}
			
			else if(met.get(1).get(z).equals("I")) {
				int[] arr=new int[data.get(z).size()];
				for (int l=0;l<data.get(z).size();l++) {
					String p=data.get(z).get(l).trim();
					arr[l]=Integer.parseInt(p);
				}
				Arrays.sort(arr);
				System.out.println("");
				System.out.println("Max Value:");
				System.out.println(arr[arr.length-1]);
				
			}
			
			else if(met.get(1).get(z).equals("F")) {
				double[] arr=new double[data.get(z).size()];
				for (int l=0;l<data.get(z).size();l++) {
					String p=data.get(z).get(l).trim();
					arr[l]=Double.parseDouble(p);
				}
				Arrays.sort(arr);
				System.out.println("");
				System.out.println("Max Value:");
				System.out.println(arr[arr.length-1]);
				
			}
			
		}
	
		
		
	}
	public static ArrayList<ArrayList<String>> getmetadata () throws IOException,FileNotFoundException{
		//ENTER METADATA FILE NAME BELOW
		BufferedReader m=new BufferedReader(new FileReader("metadata.txt"));
		ArrayList<ArrayList<String>> s=new ArrayList<ArrayList<String>>();
		for (int j=0;j<3;j++) {
			s.add(new ArrayList<String>());
			
		}
		String x;
		while ((x=m.readLine())!=null) {
			String[] r=x.split(",");
			s.get(0).add(r[0]);
			s.get(1).add(r[1]);
			s.get(2).add(r[2]);
			System.out.println("Name:"+r[0]+",Type:"+r[1]+",Size:"+r[2]);
		}
		
		return s;
		}
	
	public static ArrayList<ArrayList<String>> read_data_file(ArrayList<ArrayList<String>> metadata_array,int no_of_fields) {
		//ENTER DATA FILE NAME BELOW
		File file = new File("datafile.txt");
		FileInputStream fins = null;
		int[] sizes_of_fields=new int[no_of_fields];
	    try
	    {
	        
	         ArrayList<ArrayList<String>> mm=new ArrayList<ArrayList<String>>();
	         for (int y=0;y<no_of_fields;y++) {
	        	 mm.add(new ArrayList<String>());
	         }
	         
	         //System.out.println();
	         //System.out.println();
	         BufferedReader m=new BufferedReader(new FileReader("datafile.txt"));
	         String x;
	         
	         while ((x=m.readLine())!=null) {
	        	 int current_index=0;
	        	 for(int i=0;i<no_of_fields;i++) {
	        		 int size1=Integer.parseInt(metadata_array.get(2).get(i));
	        		 //System.out.println("Sizes of fields="+size1);
	        		 //System.out.println("ci="+current_index);
	        		 String f="";
	        		 for(int h=current_index;h<size1+current_index;h++) {
	        			 f=f+x.charAt(h);
	        		 }
	        		 System.out.print(f);
	        		 System.out.print(" ");
	        		 current_index+=size1;
	        		 //System.out.println("ci2="+current_index);
	        		 mm.get(i).add(f);
	        	 }
	        	System.out.println("");
	        	 
	 			
	 		}
	         return mm;
	         }
	         catch(Exception e) {
	        	 e.printStackTrace();
	        	 System.out.println("Error");
	        	 return null;}
	       }
	
	
	
	
	
	public static void main(String[] args) throws IOException,FileNotFoundException {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> m=getmetadata();
		int r=args.length;
		//System.out.println(args.length);
		
		String s=args[0];
		
		if(r>1) {
		for(int i=1;i<r;i++) {
			s=s+" "+args[i];
			
		}}
		
		System.out.println(s);
		
		ArrayList<ArrayList<String>>y=read_data_file(m,m.get(0).size());
		findmax(s,m,y);
	}

}