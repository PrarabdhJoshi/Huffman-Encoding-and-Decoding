
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Readfile {
	
	//private static final String FILENAME = "sample_input_large.txt";
	static HashMap<String,Node> frequency_chart= new HashMap<String,Node>();
	public static void readfile(String FILENAME){
	
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME));)
		{
			String line;
			while((line=br.readLine())!=null && !line.isEmpty()){
				
				//int val = Integer.parseInt(line);
				if(frequency_chart.containsKey(line)){
					Node node = frequency_chart.get(line);
					node.setFrequency(node.getFrequency()+1);
					frequency_chart.put(line, node);
				}
				else{
					Node node = new Node(line,1);
					frequency_chart.put(line, node);
				}
				
				
			}
			

		}
		
			 catch (IOException e) {

			  e.printStackTrace();

		}
		
	}
	

}

