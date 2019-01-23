

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
		File file = new File("data.txt");
		FileInputStream fins = null;
		
	    
	    int[] sizes_of_fields=new int[no_of_fields];
	    String[] name_of_fields=new String[no_of_fields];
	    String[] type_of_fields=new String[no_of_fields];
	    
	    
	    //int record_size=0;
	    byte[] bFile = new byte[(int) file.length()];
	    for(int i=0;i<no_of_fields;i++) {
	    	//System.out.println(metadata_array[i][2]);
	    	int x=Integer.parseInt(metadata_array.get(2).get(i));
	    	sizes_of_fields[i]=x;
	    	
	    	//record_size=record_size+x;
	    }
	    
	    
	    try
	    {
	        //convert file into array of bytes
	         fins = new FileInputStream(file);
	         fins.read(bFile);
	         ArrayList<Character> bFile1=new ArrayList<Character>();
	         for(int i=0;i<bFile.length;i++) {
	        	 char x=(char)bFile[i];
	        	 //System.out.println(x);
	        	 if(x!='\n') {
	        		 bFile1.add(x);
	        		 //System.out.println(x);
	        	 }
	         }
	         fins.close();
	         ArrayList<ArrayList<String>> mm=new ArrayList<ArrayList<String>>();
	         for (int y=0;y<no_of_fields;y++) {
	        	 mm.add(new ArrayList<String>());
	         }
	         int l1=0;
	         int l2=0;
	         System.out.println();
	         System.out.println();
	         for (int i = 0; i < bFile1.size(); i++)
	         {
	            for(int j=0;j<sizes_of_fields.length;j++) {
	            	String x="";
	            	for(int k=0;k<sizes_of_fields[j];k++){
	            		if(l1+k<bFile1.size()) {
	            		char d=(char) bFile1.get(l1+k);
	            		x=x+d;
	            		System.out.print(d);
	            		l2=k+1;
	            		}
	       
	         }
	            l1=l1+l2;
	            if (x!="") {
	            	mm.get(j).add(x);
	            	
	            }
	            
	            
	            System.out.print(" ");
	            }
	            
	            if(l1+l2-1<bFile.length) {
	            System.out.println("");}
	      }
	         return mm;
	         
	    }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	         return null;
	      }
	     
	    
	    /*
	    int f_index=find_field_index(metadata_array,no_of_fields,field);
	    int size_of_field=-1;
	    if(f_index==-1) {
	    	System.out.println("Error :field name not found.");
	    }
	    else {
	    	size_of_field=Integer.parseInt(metadata_array[f_index][2]);
	    	int size_previous=0;
	    	for(int i=0;i<f_index;i++) {
	    		int m=Integer.parseInt(metadata_array[i][2]);
	    		size_previous=size_previous+m;
	    	}
	    	int parse=0;
	    	while()
	    	
	    }
	    */
	    
	   }
	
	
	
	
	
	public static void main(String[] args) throws IOException,FileNotFoundException {
		// TODO Auto-generated method stub
		/*ArrayList<Integer> sizes=new ArrayList<Integer>();
		sizes.add(7);
		sizes.add(3);
		sizes.add(4);
		
		int no_of_fields=3;
		String[][] array=new String[no_of_fields][3];
		array[0][2]="7";
		array[1][2]="3";
		array[2][2]="4";
		array[0][1]="I";
		array[1][1]="C";
		array[2][1]="F";
		array[0][0]="Fieldname1";
		array[1][0]="Fieldname2";
		array[2][0]="Fieldname2";*/
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