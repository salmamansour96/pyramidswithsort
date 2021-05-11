package Pyramidwithsort;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pyramid> pyra=new LinkedList<Pyramid>();
		PyramidDAO pr=new PyramidDAO();
		try {
			 pyra=pr.readcsv("E:\\linux course\\java\\pyramids.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  Collections.sort(pyra, new Pyramidsort().reversed());
		  
		  int i =1;
	        for(Pyramid p: pyra) {
	           System.out.println("#"+(i++)+","+p.getPharaoh()+"," + p.getModern_name()+","+p.getSite()+","+p.getHeight());}
	        Map < String, Integer > NumOfSites= new LinkedHashMap<>();
	         for(Pyramid p: pyra)
	         {
	             String site = p.getSite();
	             Integer count = NumOfSites.get(site);
	             if (count == null )
	             { 
	                 count =1;
	             }
	             else {
	                 count++;
	             } 
	             NumOfSites.put(site, count);
	         } 
	                
	           System.out.println("\n"+NumOfSites);    

	}

}
