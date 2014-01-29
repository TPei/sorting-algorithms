package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class Heapsort extends CountingSorter implements Sorter {
	private int[] array;
	private int length;

	/**
	 * sort an array
	 * @param array array to be sorted
	 */
	public void sort(int[] array) {
		this.array = array;
		length = array.length;
		heapsort();
	}

	private void heapsort() {
		buildheap();
		while (length > 1) {
			length--;
			exchange(0, length);
			downheap(0);
		}
	}

	/**
	 * create a heap from array
	 */
	private void buildheap() {
		for (int node = length / 2 - 1; node >= 0; node--)
			downheap(node);
	}

	/**
	 * downheap
	 * @param node considered top node for now
	 */
	private void downheap(int node) {
		int childNode = 2 * node + 1; // first child of "node"
		while (childNode < length) {
			if (childNode + 1 < length) // is there a second child?
				if (array[c(childNode + 1)] > array[c(childNode)])
					childNode++;
			// childnode is child of node with max value

			if (array[c(node)] >= array[c(childNode)])
				return; // node got heap property
			// else
			exchange(node, childNode); // swap node and child
			node = childNode; // go on with node = childnode
			childNode = 2 * node + 1;
		}
	}

	/**
	 * switch two elements in heap
	 * 
	 * @param i element one to be switched
	 * @param j element two to be switched
	 */
	private void exchange(int i, int j) {
		int temp = array[c(i)];
		array[c(i)] = array[c(j)];
		array[c(j)] = temp;
	}

}