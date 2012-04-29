import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 */

/**
 * @author Jari
 *
 */
public class Morse implements IMorse {
	
	private static java.util.Map<String, String> morsekoodit = new java.util.HashMap<String, String>();
	private static java.util.Map<String, String> aakkoset = new java.util.HashMap<String, String>();
	Morse(){
		morsekoodit.put("A",".-");
		morsekoodit.put("B","-...");
		morsekoodit.put("C","-.-.");
		morsekoodit.put("D","-..");
		morsekoodit.put("E",".");
		morsekoodit.put("F","..-.");
		morsekoodit.put("G","--.");
		morsekoodit.put("H","....");
		morsekoodit.put("I","..");
		morsekoodit.put("J",".---");
		morsekoodit.put("K","-.-");
		morsekoodit.put("L",".-..");
		morsekoodit.put("M","--");
		morsekoodit.put("N","-.");
		morsekoodit.put("O","---");
		morsekoodit.put("P",".--.");
		morsekoodit.put("Q","--.-");
		morsekoodit.put("R",".-.-");
		morsekoodit.put("S","...");
		morsekoodit.put("T","-");
		morsekoodit.put("U","..-");
		morsekoodit.put("V","...-");
		morsekoodit.put("W",".--");
		morsekoodit.put("X","-..-");
		morsekoodit.put("Y","-.--");
		morsekoodit.put("Z","--..");
		morsekoodit.put("Å",".--.-");
		morsekoodit.put("Ä",".-.-");
		morsekoodit.put("Ö","---.");
		morsekoodit.put("Ü","..--");

		morsekoodit.put("0","-----");
		morsekoodit.put("1",".----");
		morsekoodit.put("2","..---");
		morsekoodit.put("3","...--");
		morsekoodit.put("4","....-");
		morsekoodit.put("5",".....");
		morsekoodit.put("6","-....");
		morsekoodit.put("7","--...");
		morsekoodit.put("8","---..");
		morsekoodit.put("9","----.");

		morsekoodit.put("?","..--..");
		morsekoodit.put("/","-..-.");
		morsekoodit.put("=","-...-");
		morsekoodit.put(":","---...");
		morsekoodit.put(",","--..--");
		morsekoodit.put(".",".-.-.-");

		morsekoodit.put(" "," ");
		
		// loop through map
		Set<Entry<String, String>> entries = morsekoodit.entrySet();
		for (Iterator<Entry<String, String>> iterator = entries.iterator();	iterator.hasNext();) { 
			java.util.Map.Entry entry = (java.util.Map.Entry) iterator.next();
			//System.out.println(entry.getKey() + " = " + entry.getValue());
			aakkoset.put(entry.getValue().toString(), entry.getKey().toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Morse morse=new Morse();
		System.out.println("Hello Morse");
		
		String input="";
		if (args.length==2) {
			String op=args[0];
			input=args[1];
			if (op.equalsIgnoreCase("-f")){
				System.out.println( morse.toMorse(input) );
			} else if (op.equalsIgnoreCase("-t")) {
				System.out.println( morse.toText(input) );
			} else {
				morse.printSyntax();
			}
		} else {
			morse.printSyntax();
		}

	}

	@Override
	public String toMorse(String text) {
		// TODO Auto-generated method stub
		int strLength=text.length();
		String koodi="";
		for(int i=0; i<strLength; i++){
			String c=text.substring(i, i+1).toUpperCase();
			if (morsekoodit.containsKey(c)){
				koodi=koodi+morsekoodit.get(c);
				if (i<strLength-1) {
					koodi=koodi+" ";
				}
			}
		}
		return koodi;
	}

	@Override
	public String toText(String morsecode) {
		// TODO Auto-generated method stub
		String teksti="";
		String[] merkit = morsecode.split(" ");
		for (int i=0; i<merkit.length;i++) {
			String c=merkit[i];
			if (aakkoset.containsKey(c)){
				teksti=teksti+aakkoset.get(c);
			}
		}
		return teksti;
	}
	
	private void printSyntax(){
		System.out.println("Syntax:");
		System.out.println("\tMorsekoodi tekstistä:\tMorse -f <teksti>");
		System.out.println("\tMorsekoodi tekstiksi:\tMorse -t <morsekoodi>");
	}
	

}
