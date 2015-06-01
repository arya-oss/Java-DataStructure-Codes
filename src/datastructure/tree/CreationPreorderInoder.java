package datastructure.tree;

/**
 * @see www.rajmani1995.blogspot.com
 * @author Rajmani Arya
 */
public class CreationPreorderInoder {
    private int i=0;
    class bnode{
        char data;
        bnode left, right;
        public bnode() {
            this.left=this.right=null;
        }
        public bnode(char data) {
            this.data = data;
            this.left=this.right=null;
        }   
    }
    void inorder(bnode T){
	if(T == null) return;
        inorder(T.left);
	System.out.print(" "+T.data);
	inorder(T.right);
    }
    int height(bnode root){
	if(root == null) return 0;
	return 1+Math.max(height(root.left), height(root.right));
    }
    void levelorder(bnode T, int lev){
	if(T == null) return;
	if(lev == 0)
            System.out.print(" "+T.data);
	else{
            levelorder(T.left, lev-1);
            levelorder(T.right, lev-1);
	}
    }
    /**
     * 
     * @param str In-order String
     * @param st  starting index
     * @param end ending index
     * @param ch  character to be searched
     * @return index of character ch
     */
    int getIndex(String str, int st,int end, char ch){
	for (int i = st; i <= end; ++i)
            if(str.charAt(i) == ch)
		return i;
	return 0;
    }
    /**
     * 
     * @param in In-Order String
     * @param pre PreOrder String
     * @param start Starting index = 0
     * @param end ending index = string length
     * @return root of the tree
     */
    bnode create(String in, String pre, int start, int end){
	bnode t = null;
        if(end < start)
            return t;
        t = new bnode(pre.charAt(i));
	int mid = getIndex(in, start, end, pre.charAt(i++));
	t.left = create(in, pre, start, mid-1);
	t.right = create(in, pre, mid+1, end);
	return t;
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        CreationPreorderInoder c = new CreationPreorderInoder();
        String in="1234567";
        String pre="4213657";
        bnode root=null;
        root = c.create(in, pre, 0, pre.length()-1);
        c.inorder(root);
    }
}