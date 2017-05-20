

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class encoder {
	
	public static void main(String[] args) {
		String FILENAME=args[0];
		HuffmanTree.make_huffman_tree(FILENAME);
		get_binary_codes(FILENAME);
		generate_code_table();
	}
	
public static void get_binary_codes(String input_file){
		
		StringBuffer buffer = new StringBuffer();
		String output_file = "encoded.bin";
		File output = new File(output_file);
		
		try (BufferedReader br = new BufferedReader(new FileReader(input_file));FileOutputStream b2 = new FileOutputStream(output, true)){
			String line;
			if(!output.exists())
				output.createNewFile();
			while((line=br.readLine())!=null && !line.isEmpty()){
				
				buffer.append(HuffmanTree.path_values.get(line));
				
				
				
				while(buffer.length()>=8){
					String subset = buffer.substring(0, 8);
					int chunk = Integer.parseInt(subset,2);
					
					b2.write(chunk);
					buffer.delete(0, 8);
				}
				
				
			}
			
			
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void generate_code_table(){
		
		//String output_file = "code_table.txt";
		//File output = new File(output_file);
		//FileOutputStream b2 = new FileOutputStream(output, true)
	
	
		try{
			File file = new File("code_table.txt");
			FileOutputStream f = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(f);
			for(String path: HuffmanTree.path_values.keySet()){
				pw.write(path + " ");
				pw.write(HuffmanTree.path_values.get(path)+"\n");
			}
			pw.flush();
			pw.close();
			f.close();
		}
		catch(Exception e){
			System.out.println("exception in code_table writing");
		}
	}
	

}
