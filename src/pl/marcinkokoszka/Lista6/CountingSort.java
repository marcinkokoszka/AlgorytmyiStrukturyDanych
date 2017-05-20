package pl.marcinkokoszka.Lista6;

import pl.marcinkokoszka.Lista4.ArrayList;
import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;
import pl.marcinkokoszka.Lista5.ListSorter;

public class CountingSort implements ListSorter {

	private int assignments = 0;
	private int compares = 0;

	private final Comparator _comparator;

	public CountingSort(Comparator comparator){
		_comparator = comparator;
	}

	public List sort(List list)
	{
		List aux = new ArrayList(list.size());

		int min = (int) list.get(0);
		int max = (int) list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if ((int) list.get(i) < min) {
				min = (int) list.get(i);
                compares++;
			} else if ((int) list.get(i) > max) {
				max = (int) list.get(i);
                compares++;
			}
		}

		int[] counts = new int[max - min + 1];

		for (int i = 0;  i < list.size(); i++) {
			counts[(int) list.get(i) - min]++;
		}

		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i-1];
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			aux.set(counts[(int) list.get(i) - min]--, list.get(i));
			assignments++;
		}

		return aux;
	}

	@Override
	public int getAssignments() {
		return assignments;
	}

	@Override
	public int getCompares() {
		return compares;
	}

	@Override
	public void setAssignments(int assignments) {
		this.assignments = assignments;
	}

	@Override
	public void setCompares(int compares) {
		this.compares = compares;
	}
}