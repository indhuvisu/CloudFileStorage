import javax.swing.JOptionPane;


public class TireTest {
	public static void main(String args[])
	{
		Trie trie = new Trie();
		String ch;
		do{
			String fileName = JOptionPane.showInputDialog("Enter the filename that u want to insert");
			trie.insert(fileName);
			ch = JOptionPane.showInputDialog("Do you want insert another file?(yes\no)");
		}while(ch.compareTo("yes") == 0);
		trie.displayTrie();
		String fName = JOptionPane.showInputDialog("Enter the filename that u want to search");
		trie.search(fName);
	}

}