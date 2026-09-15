package com.sj.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Depth First Search on a graph (adjacency list) using an explicit stack
//instead of recursion, so it avoids call-stack overflow on deep/large graphs.

//For example, given:
//A -> B, C
//B -> D
//C -> D
//D -> (none)
//dfs("A") visits A, C, D, B (order depends on adjacency list ordering,
//since each neighbour is pushed onto the stack and processed LIFO).

public class IterativeDFS {

	public static void main(String[] args) {
		Map<String, List<String>> graph = Map.of(
				"A", List.of("B", "C"),
				"B", List.of("D"),
				"C", List.of("D"),
				"D", List.of()
		);

		System.out.println(dfs(graph, "A"));
	}

	public static Set<String> dfs(Map<String, List<String>> graph, String start) {
		Set<String> visited = new LinkedHashSet<>();
		Deque<String> stack = new ArrayDeque<>();

		stack.push(start);

		while (!stack.isEmpty()) {
			String node = stack.pop();

			if (visited.contains(node)) {
				continue;
			}

			visited.add(node);

			for (String neighbour : graph.getOrDefault(node, List.of())) {
				if (!visited.contains(neighbour)) {
					stack.push(neighbour);
				}
			}
		}

		return visited;
	}
}
