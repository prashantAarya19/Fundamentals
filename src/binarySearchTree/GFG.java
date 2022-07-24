package binarySearchTree;// Java implementation of above approach
import java.util.*;

class GFG{

// Structure of a BST Node
static class Node
{
	int data;
	Node left;
	Node right;
};

static Node newNode(int num)
{
	Node temp = new Node();
	temp.data = num;
	temp.left = temp.right = null;
	return temp;
}

// A utility function to print
// Inorder traversal of a Binary Tree
static void inorder(Node root)
{
	if (root != null)
	{
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}

// The function to print data
// of two BSTs in sorted order
static void merge(Node root1, Node root2)
{
	
	// Base cases
	if (root1 == null && root2 == null)
		return;

	// If the first tree is exhausted
	// simply print the inorder
	// traversal of the second tree
	if (root1 == null)
	{
		inorder(root2);
		return;
	}

	// If second tree is exhausted
	// simply print the inoreder
	// traversal of the first tree
	if (root2 == null)
	{
		inorder(root1);
		return;
	}

	// A temporary pointer currently
	// pointing to root of first tree
	Node temp1 = root1;

	// previous pointer to store the
	// parent of temporary pointer
	Node prev1 = null;

	// Traverse through the first tree
	// until you reach the leftmost element,
	// which is the first element of the tree
	// in the inorder traversal.
	// This is the least element of the tree
	while (temp1.left != null)
	{
		prev1 = temp1;
		temp1 = temp1.left;
	}

	// Another temporary pointer currently
	// pointing to root of second tree
	Node temp2 = root2;

	// Previous pointer to store the
	// parent of second temporary pointer
	Node prev2 = null;

	// Traverse through the second tree
	// until you reach the leftmost element,
	// which is the first element of
	// the tree in inorder traversal.
	// This is the least element of the tree.
	while (temp2.left != null)
	{
		prev2 = temp2;
		temp2 = temp2.left;
	}

	// Compare the least current least
	// elements of both the tree
	if (temp1.data <= temp2.data)
	{
		
		// If first tree's element is
		// smaller print it
		System.out.print(temp1.data + " ");

		// If the node has no parent, that
		// means this node is the root
		if (prev1 == null)
		{
			
			// Simply make the right
			// child of the root as new root
			merge(root1.right, root2);
		}

		// If node has a parent
		else
		{
			
			// As this node is the leftmost node,
			// it is certain that it will not have
			// a let child so we simply assign this
			// node's right pointer, which can be
			// either null or not, to its parent's left
			// pointer. This statement is
			// just doing the task of deleting the node
			prev1.left = temp1.right;

			// recursively call the merge
			// function with updated tree
			merge(root1, root2);
		}
	}
	else
	{
		System.out.print(temp2.data + " ");

		// If the node has no parent, that
		// means this node is the root
		if (prev2 == null)
		{
			
			// Simply make the right child
			// of root as new root
			merge(root1, root2.right);
		}

		// If node has a parent
		else
		{
			prev2.left = temp2.right;

			// Recursively call the merge
			// function with updated tree
			merge(root1, root2);
		}
	}
}

// Driver Code
public static void main(String args[])
{
	Node root1 = null, root2 = null;
	
	root1 = newNode(3);
	root1.left = newNode(1);
	root1.right = newNode(5);
	
	root2 = newNode(4);
	root2.left = newNode(2);
	root2.right = newNode(6);

	// Print sorted nodes of both trees
	merge(root1, root2);
}
}

// This code is contributed by ipg2016107
