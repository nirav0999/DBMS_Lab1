
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class main {
	public static void read_data_file(ArrayList<Integer> sizes) {
		File file = new File("/home/nirav/Desktop/sample");
		FileInputStream fins = null;
		//FileInputStream fins = null;
	    byte[] bFile = new byte[(int) file.length()];
	    try
	    {
	        //convert file into array of bytes
	         fins = new FileInputStream(file);
	         fins.read(bFile);
	         fins.close();//System.out.println((char) bFile[0]);
	         int l1=0;
	         int l2=0;
	         for (int i = 0; i < bFile.length; i++)
	         {
	            for(int j=0;j<sizes.size();j++) {
	            	for(int k=0;k<sizes.get(j);k++){
	            		System.out.print((char) bFile[l1+k]);
	            		l2=k+1;
	         }
	            l1=l1+l2;
	            System.out.print(" ");
	         }
	            System.out.println("");
	      }}
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      //return bFile;
	   }
		
		
	
	public void calculate_field() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> sizes=new ArrayList<Integer>();
		sizes.add(7);
		sizes.add(3);
		read_data_file(sizes);
	}

}
