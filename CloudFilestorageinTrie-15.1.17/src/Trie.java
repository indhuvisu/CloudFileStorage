import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

	class TrieNode 
	{
	    char content; 
	    boolean isEnd; 
	    int count;  
	    LinkedList<TrieNode> childList; 
	 
	    /* Constructor */
	    public TrieNode(char c)
	    {
	        childList = new LinkedList<TrieNode>();
	        isEnd = false;
	        content = c;
	        count = 0;
	    }  
	    public TrieNode subNode(char c)
	    {	        if (childList != null)
	            for (TrieNode eachChild : childList)
	                if (eachChild.content == c)
	                    return eachChild;
	        return null;
	    }
	    void display()
	    {
	    	if(childList !=null)
	    	{
	    		for(TrieNode eachChild : childList)
	    		{
	    			System.out.print(eachChild.content + " ");
	    			eachChild.display();
	    		}
	    		System.out.println("");
	    	}
	    }
}

class Trie {
	private TrieNode root;	 
	String path = "/home/hduser/testfortrie/";
		     /* Constructor */
		    public Trie()
		    {
		        root = new TrieNode(' '); 
		    }
		     /* Function to insert word */
		    public void insert(String word)
		    {
		        if (search(word) == true) 
		        {
		        	System.out.println("File already Exists...Enter valid one");
		            return; 
		        }
		        TrieNode current = root; 
		        for (char ch : word.toCharArray() )
		        {
		            TrieNode child = current.subNode(ch);
		            if (child != null)
		            {
		                current = child;
		                path = path + ch + "/";
		                System.out.println(path);
		            }
		            else 
		            {
		                 current.childList.add(new TrieNode(ch));
		                 new File(path + ch).mkdir();
		                 path = path + ch + "/";
		                 System.out.println(path);
		                 current = current.subNode(ch);
		            }
		            current.count++;
		        }
		        File file = new File(path + word);
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				path = "/home/hduser/testfortrie/";
		        current.isEnd = true;
		    }
		    /* Function to search for word */
		   public boolean search(String word)
		   {
		   	    TrieNode current = root;  
		    	        for (char ch : word.toCharArray() )
		    	        {
		    	        	if (current.subNode(ch) == null)
		    	        		return false;
		    	        	else
		    	        		current = current.subNode(ch);
		    	        }      
		    	      if (current.isEnd == true) 
		    	       return true;
		    return false;
		   }
		    	    /* Function to remove a word */
		   public void remove(String word)
		   {
		    	if (search(word) == false)
		    	{
		    	    System.out.println(word +" does not exist in trie\n");
		    	    return;
		        }             
		    	TrieNode current = root;
		    	 for (char ch : word.toCharArray()) 
		    	 { 
		    	   TrieNode child = current.subNode(ch);
		    	   if (child.count == 1) 
		    	   {
		    		   	  current.childList.remove(child);
		    	    	  return;
		    	   } 
		    	   else 
		    	   {
		    	    child.count--;
		    	    current = child;
		    	   }
		    	  }
		    	   current.isEnd = false;
		    }
		 void displayTrie()
		 {
		   	 root.display();
		 }
		
		void helloWorld()
		{
			System.out.println();
		}
}
