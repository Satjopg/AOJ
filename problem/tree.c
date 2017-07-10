#include <stdio.h>
#include <stdlib.h>
#include "tree.h"

/**
 * @brief        二分木の新しいノードを作成する
 * @param        value ノードが保持する値
 * @return       *tree_node_t 新しいノード
 */
tree_node_t *alloc_node(int value) {

  tree_node_t *new_tree_node = NULL;
  new_tree_node = (tree_node_t *)malloc(sizeof(tree_node_t));

  if(new_tree_node == NULL){
    printf("メモリの確保に失敗しました\n");
    return NULL;
  }

  new_tree_node->value = value;
  new_tree_node->right = NULL;
  new_tree_node->left = NULL;

  return new_tree_node;
}
