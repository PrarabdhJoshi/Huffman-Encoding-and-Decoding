


public class Main {
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//makefourway();
		
	}*/
	public static Fourwayoptimizedheap makefourway(String FILENAME){
		Readfile.readfile(FILENAME);
		Fourwayoptimizedheap fourway = new Fourwayoptimizedheap(Readfile.frequency_chart.size());
		for(String val: Readfile.frequency_chart.keySet()){
			fourway.insert(Readfile.frequency_chart.get(val));
		}
		//fourway.printHeap();
		return fourway;
	}
	/*
	public static Binaryheap makebinaryheap(String FILENAME){
		Readfile.readfile(FILENAME);
		Binaryheap binaryheap = new Binaryheap(Readfile.frequency_chart.size());
		for(String val: Readfile.frequency_chart.keySet()){
			binaryheap.insert(Readfile.frequency_chart.get(val));
		}
		
		return binaryheap;
	}*/
	/*
	public static Pairingheap makepairingheap(){
		//Readfile.readfile();
		PairingHeap pr = new PairingHeap(Readfile.frequency_chart.size());
		for(String val: Readfile.frequency_chart.keySet()){
			pr.insert(Readfile.frequency_chart.get(val));
		}
		//pr.printHeap();
		return null;
	}*/
	
	

}
