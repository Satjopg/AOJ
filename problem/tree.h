#ifndef _TREE_H_
#define _TREE_H_

// 二分木のノード
struct tree_node {
  int value;
  struct tree_node *right;
  struct tree_node *left;
};

typedef struct tree_node tree_node_t;

// treeに関する関数宣言
tree_node_t *alloc_node(int value);

#endif
