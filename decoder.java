
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.PrintWriter;

public class decoder {

	static Decodetree decoder_root=null;
	public static void main(String[] args) {
		
		decoder_root = new Decodetree();
		//String codetablefile = "code_table.txt";
		//String encodedfile = "encoded.bin";
		String encodedfile = args[0];
		String codetablefile = args[1];
		
		make_decoder_tree(codetablefile);
		generate_the_decode_file(encodedfile);
	
	}

	
	
	//-------------GENERATE DECODED TREE-----------------
	
	public static void make_decoder_tree(String codetablefile) {
		// TODO Auto-generated method stub
		
		try(BufferedReader br = new BufferedReader(new FileReader(codetablefile));) {
			StringBuffer buffer = new StringBuffer();
			String line = br.readLine();
			Decodetree p_node = decoder_root;
			while(line!=null){
				//System.out.println("in line while"+ decoder_root.getLeftchild());
				buffer.append(line);
				String[] line_content = line.split(" ");	
				String cur_code=line_content[1];
				String value = line_content[0];
				//node.setValue(line_content[0]);
				for(int i=0;i<cur_code.length();i++){
					Decodetree node = new Decodetree();
					if(cur_code.charAt(i)=='0'){
						if(p_node.getLeftchild()==null){
							p_node.setLeftchild(node);
							p_node = p_node.getLeftchild();
						}
						else{
							p_node = p_node.getLeftchild();
						}
						p_node.setCode("0");
					}
					else if(line_content[1].charAt(i)=='1'){
						if(p_node.getRightchild()==null){
							p_node.setRightchild(node);
							p_node = p_node.getRightchild();
						}
						else{
							p_node = p_node.getRightchild();
						}
						p_node.setCode("1");
				}
			}
				p_node.setValue(value);
				line=br.readLine();	
				p_node = decoder_root;
		}
		}
		catch(Exception e){
		}	
	}
	
	
	//-------------GET DECODED.TXT ----------------------
	
	public static void generate_the_decode_file(String encodedfile) {
		// TODO Auto-generated method stub
		
		try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(encodedfile));){
			File file = new File("decoded.txt");
			FileOutputStream f = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(f);
			int byte_chunk;
			
			Decodetree cur_node = decoder_root;
			while((byte_chunk = inputStream.read())!=-1){
				
				byte input = (byte) byte_chunk;
				//String s1 = String.format("%1s", Integer.toBinaryString((byte_chunk+256)%256));
				//String str = String.format("%8s", s1).replace(" ", "0");
				//System.out.println(byte_chunk);
				for(int i=7;i>=0;i--){
					if((input & (1 << i)) ==1 << i){
						cur_node = cur_node.getRightchild();
						if(cur_node.getValue()!=null){
							//System.out.println(cur_node.getValue());
							pw.write(cur_node.getValue()+"\n");
							cur_node = decoder_root;			
						}
					}
					else{
						cur_node = cur_node.getLeftchild();
						if(cur_node.getValue()!=null){
							//System.out.println(cur_node.getValue());
							pw.write(cur_node.getValue()+"\n");
							cur_node = decoder_root;
						}
					}
				}
				//end of for
			}
			pw.flush();
			pw.close();
			f.close();
		}
		catch(Exception e){	
		}			
	}
	
}
