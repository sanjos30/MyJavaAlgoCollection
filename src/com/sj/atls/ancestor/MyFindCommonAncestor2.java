package com.sj.atls.ancestor;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
 
/**
 * Finds the common ancestor for 2 commits in a Git commit graph.
 *
 * See http://codereview.stackexchange.com/questions/51547/missing-level-of-technical-depth-common-ancestor
 *
 * @author Greg Bowering
 */
public class MyFindCommonAncestor2 {
 
  public static String findCommmonAncestor(String[] commitHashes,
      String[][] parentHashes, String commitHash1, String commitHash2) {
 
    if (commitHash1.equals(commitHash2)) {
      // efficiently handle edge case, the 2 commits are the same:
      return commitHash1;
    }
 
    /*
     * Flag whether array scan has encountered commits of interest. If there is
     * a long commit history and the commits in question are quite old, we want
     * to skip quickly to the interesting part of the data. Depends on input
     * commitHashes array being sorted in reverse chronological.
     */
    boolean haveSeenCommit1 = false;
    boolean haveSeenCommit2 = false;
 
    /*
     * Commit ancestors can be considered as an upside-down tree rooted at
     * the commit. In a single scan of the input data we perform two breadth-first
     * searches, one starting from each of commitHash1 and commitHash2.
     * The following 2 ancestors sets keep tabs on the current state of the
     * 2 searches.
     * When either commit is found by the other commit's ancestor search,
     * or if the commit at the current input scan cursor appears in both searches, we
     * have found the lowest common ancestor.
     */
    Set<String> commit1Ancestors = Collections.emptySet();
    Set<String> commit2Ancestors = Collections.emptySet();
 
    /*
     * Single scan through input data. Complexity O(n).
     */
    for (int i = 0; i < commitHashes.length; i++) {
      String commitHash = commitHashes[i];
      String[] parents = parentHashes[i];
      List<String> parentsList = parents == null ? null : Arrays
          .asList(parents);
      if (!haveSeenCommit1 && commitHash1.equals(commitHash)) {
        // Encountered commit1
        if (parents != null) {
          commit1Ancestors = new HashSet<>(parentsList);
        }
        haveSeenCommit1 = true;
      }
      if (!haveSeenCommit2 && commitHash2.equals(commitHash)) {
        // Encountered commit2
        if (parents != null) {
          commit2Ancestors = new HashSet<>(parentsList);
        }
        haveSeenCommit2 = true;
      }
      if (!haveSeenCommit1 && !haveSeenCommit2) {
        // haven't encountered any commits of interest yet
        continue;
      }
      if (commit1Ancestors.contains(commitHash2)) {
        // commit2 is an ancestor of commit1:
        return commitHash2;
      }
      if (commit2Ancestors.contains(commitHash1)) {
        // commit1 is an ancestor of commit2:
        return commitHash1;
      }
      if (commit1Ancestors.contains(commitHash)
          && commit2Ancestors.contains(commitHash)) {
        // found lowest common ancestor:
        return commitHash;
      }
      if (parents != null) {
        // replace ancestors with parents and continue:
        if (commit1Ancestors.remove(commitHash)) {
          commit1Ancestors.addAll(parentsList);
        }
        if (commit2Ancestors.remove(commitHash)) {
          commit2Ancestors.addAll(parentsList);
        }
      }
    }
    // scanned through all input without finding common ancestor.
    return null;
  }
 
  public static void main(String[] args) {
 
    String[] commits = { "G", "F", "E", "D", "C", "B", "A" };
    String[][] parents = { { "F", "D" }, { "E" }, { "B" }, { "C" }, { "B" },
        { "A" }, null };
 
    String commit1 = "G";
    String commit2 = "B";
 
    System.out.println("Common Ancestor is "
        + MyFindCommonAncestor.findCommmonAncestor(commits, parents, commit1,
            commit2));
  }
 
}