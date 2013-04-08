import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author antonio081014
 * 
 */
public class WordNet {

	private Noun[] listOfNounSynsets;

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		ArrayList<Noun> list = new ArrayList<Noun>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(synsets));
			String[] sets = in.readLine().split(",");
			Noun noun = new Noun(sets[0], sets[1], sets[2]);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	// the set of nouns (no duplicates), returned as an Iterable
	public Iterable<String> nouns() {
	}

	// is the word a WordNet noun?
	public boolean isNoun(String word) {
	}

	// distance between nounA and nounB (defined below)
	public int distance(String nounA, String nounB) {
	}

	// a synset (second field of synsets.txt) that is the common ancestor of
	// nounA and nounB
	// in a shortest ancestral path (defined below)
	public String sap(String nounA, String nounB) {
	}
}

class Noun {
	private int ID;
	private String[] Synsets;
	private String Gloss;
	private ArrayList<Noun> Hypernyms;

	public Noun(String id, String set, String def) {
		this.ID = Integer.parseInt(id);
		this.Synsets = set.split("\\s");
		this.Gloss = def;
		this.Hypernyms = new ArrayList<Noun>();
	}

	public int getID() {
		return ID;
	}

	public String[] getSynsets() {
		return Synsets;
	}

	public String getGloss() {
		return Gloss;
	}

	public void addHypernyms(Noun noun) {
		this.Hypernyms.add(noun);
	}

	public void delete(Noun noun) {
		for (int i = 0; i < Hypernyms.size(); i++)
			if (noun.equals(Hypernyms.get(i))) {
				this.Hypernyms.remove(i);
				return;
			}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Noun)) {
			return false;
		}
		Noun other = (Noun) obj;
		if (ID != other.ID) {
			return false;
		}
		return true;
	}

	public int hasNoun(Noun noun) {
		for (int i = 0; i < this.Hypernyms.size(); i++)
			if (this.Hypernyms.get(i).equals(noun))
				return i;
		return -1;
	}
}
