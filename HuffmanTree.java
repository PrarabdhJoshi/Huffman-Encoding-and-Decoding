


import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanTree{
	
	static Node root=null;
	
	HashMap<String, Node> freq = new HashMap<String, Node>();
	
	public static HashMap<String, String> path_values = new HashMap<String, String>();
	
	public static void make_huffman_tree(String FILENAME){
		//-------------HUFFMAN TREE-------------------------
		HuffmanTree huffmantree = new HuffmanTree();
		
		//----------4 WAY OBJECT-----------------------
		Fourwayoptimizedheap fourway = Main.makefourway(FILENAME);
		
		//------------------BINARY TREE OBJECT----------------
		//Binaryheap binaryheap = Main.makebinaryheap(FILENAME);
		
		//---------------Pairing Heap object-----------
		//Pairingheap pairingheap = new Pairingheap();
		
		
		long start_time = System.currentTimeMillis();
		for(int i=0;i<10;i++){
			while(!fourway.isEmpty() ){
				//fourway.printHeap();
				
				//System.out.println("\n"+fourway.findMin().getFrequency());
				
				Node min1 = fourway.findMin();
				fourway.deleteMin();
				//fourway.printHeap();
				if(fourway.isEmpty()){
				
				break;
				}
				//System.out.print("\t"+fourway.findMin().getFrequency()+"\n");
				Node min2 = fourway.findMin();
				fourway.deleteMin();
				//System.out.println("\n ----------------Now Insertion--------------");
				//fourway.printHeap();
				Node new_node = huffmantree.insert_huffman(min1, min2);
				//encodings.put(new_node.getValue(), new_node);
				fourway.insert(new_node);
				//System.out.println(huffmantree.toString());
				
			}
		}
		//System.out.println("4 way time: " + (System.currentTimeMillis()-start_time));
		
		
		/*HuffmanTree huffmantree1 = new HuffmanTree();
		start_time = System.currentTimeMillis();
		for(int i=0;i<10;i++){
		while(!binaryheap.isEmpty() ){
			//binaryheap.printHeap();
			
			
			
			Node min1 = binaryheap.findMin();
			binaryheap.deleteMin();
			
			if(binaryheap.isEmpty()){
			
			break;
			}
		
			Node min2 = binaryheap.findMin();
			binaryheap.deleteMin();
			
			Node new_node = huffmantree1.insert_huffman(min1, min2);
			binaryheap.insert(new_node);
			
		}
	}
		
		//System.out.println("Bianry time: " + (System.currentTimeMillis()-start_time)/10);
		
		*/
		
		/*
		 * 
  			time1 = System.currentTimeMillis();
  			int i = 10;
  			while(i > 0){
  				HuffmanTree huffmanTree2 = new HuffmanTree();
   
   
				while(PairingHeap.root != null){
					Node minNode1 = pairingHeap.deleteMin();
					if(PairingHeap.root == null){
					break;
				}
				Node minNode2 = pairingHeap.deleteMin();
				Node node = huffmanTree2.insert(minNode1, minNode2);
				pairingHeap.insert(node);
			}
    	}
    			
    			System.out.println("Pairing Heap time is " + (System.currentTimeMillis()-time1)/10);
		 */
		
		huffmantree.huffmantraversal();
		//huffmantree1.huffmantraversal();
		//System.out.println("4 way time: " + (System.currentTimeMillis()-start_time));
		//get_bianry_codes(FILENAME);
		//generate_code_table();
		
		//make_decoder_tree();
		//generate_the_decode_file();
		//System.out.println(decoder_root.getRightchild().getValue());
		
		
	}
	
	public void huffmantraversal(){
		
		ArrayList<Node> huffman_nodes = new ArrayList<Node>();
		huffman_nodes.add(root);
		
		while(!huffman_nodes.isEmpty()){
			Node cur_node = huffman_nodes.remove(0);
			if(cur_node.getEncode_value()==null){
				cur_node.setEncode_value("");
			}
			if(cur_node.getleftchild()!=null){
				cur_node.getleftchild().setEncode_value(new StringBuffer().append(cur_node.getEncode_value()).append("0").toString());
			}
			if(cur_node.getrightchild()!=null){
				cur_node.getrightchild().setEncode_value(new StringBuffer().append(cur_node.getEncode_value()).append("1").toString());
			}
			if(cur_node.getValue()!=null){
				path_values.put(cur_node.getValue(), cur_node.getEncode_value());
			}
			else{
				if(cur_node.getleftchild()!=null){
					huffman_nodes.add(cur_node.getleftchild());
			}
				if(cur_node.getrightchild()!=null){
					huffman_nodes.add(cur_node.getrightchild());
				}
				
			}
			
		}
	}
	
	public Node insert_huffman(Node min1, Node min2){
		Node internal = new Node();
		internal.setleftchild(min1);
		internal.setrightchild(min2);
		internal.setFrequency(min1.getFrequency() + min2.getFrequency());
		root = internal;
		return internal;
		
	}
	
	public String toString(){
		
		return this.root.toString() + "" + this.root.getleftchild().toString() + " "+ this.root.getrightchild().toString();
	}
	
}