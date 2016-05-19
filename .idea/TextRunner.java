
class Word {
	protected String word;
	
	public Word(String word) {
		this.word = word;
	}
	
	public Word() {
		
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Word word1 = (Word) o;

		return word != null ? word.equals(word1.word) : word1.word == null;

	}

	@Override
	public String toString() {
		return "Word{" +
				"word='" + word + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		return word != null ? word.hashCode() : 0;
	}


}

class Sentence extends Word {
	protected String sentence;
	
	public Sentence(String word, String sentence) {
		super(word);
		this.sentence = sentence + word;
	}
	
	public Sentence(String sentence) {
		this.sentence = sentence;
	}
	
	public Sentence() {

	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getSentence() {
		return sentence;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Sentence sentence1 = (Sentence) o;

		return sentence != null ? sentence.equals(sentence1.sentence) : sentence1.sentence == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (sentence != null ? sentence.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Sentence{" +
				"sentence='" + sentence + '\'' +
				'}';
	}
}

class Text extends Sentence {
	private String text;
	private String header;
	
	public Text(Word word,Sentence sentence) {
		text = sentence.sentence+word.word;
	}
	
	public void addText(String text) {
		this.text += text;
	}
	
	public void print() {
		if (header == null) {
			System.out.println(text);
		} else {
			System.out.println(header);
			System.out.println(text);
		}
	}
	
	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Text text1 = (Text) o;

		if (text != null ? !text.equals(text1.text) : text1.text != null) return false;
		return header != null ? header.equals(text1.header) : text1.header == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (text != null ? text.hashCode() : 0);
		result = 31 * result + (header != null ? header.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Text{" +
				"text='" + text + '\'' +
				", header='" + header + '\'' +
				'}';
	}
}

public class TextRunner {
	public static void main(String[] args) {
		Sentence sentence = new Sentence("London is the ");
		Word word= new Word("capital ");
		Text text = new Text(word,sentence);
		text.print();
		text.addText("of Great Britain");
		text.print();
		text.setHeader("Header!");
		text.print();
		
	}
}
