#include <stdio.h>
#include "tree.h"

// グローバル変数
tree_node_t *start;

// 関数のプロトタイプ宣言
tree_node_t *create_tree(const int *input_arr, const int arr_count);
void create_recursion_tree(tree_node_t *now_node, const int new_node_value);
int search(int num);
int delete(int num);
void show_tree(tree_node_t *start);

/**
 * @brief        二分木を作成する起点関数
 * @param[in]    input_arr    二分木を構成する値の配列
 * @param[in]    arr_count    input_arrの配列の長さ
 * @return       *tree_node_t 新しいノード
 */
tree_node_t *create_tree(const int *input_arr, const int arr_count) {
  int node_count = 0;
  tree_node_t *start;
  int index;
  for(index = 0;index < arr_count; index++) {
    int new_node_value = input_arr[index];
    if(node_count == 0) {
      tree_node_t *start_tree_node = alloc_node(new_node_value);
      start = start_tree_node;
    } else {
      create_recursion_tree(start, new_node_value);
    }
    node_count++;
  }
  return start;
}

/**
 * @brief        二分木を再帰で作成する
 * @param        tree_node_t  現在のノード
 * @param[in]    int          新しいノードの値
 * @return       *tree_node_t 新しいノード
 */
void create_recursion_tree(tree_node_t *now_node, const int new_node_value) {
  if (now_node->value > new_node_value) {
    if(now_node->left == NULL){
      tree_node_t *new_tree_node = alloc_node(new_node_value);
      now_node->left = new_tree_node;
    } else {
      create_recursion_tree(now_node->left, new_node_value);
    }
  } else {
    if(now_node->right == NULL) {
      tree_node_t *new_tree_node = alloc_node(new_node_value);
      now_node->right = new_tree_node;
    } else {
      create_recursion_tree(now_node->right, new_node_value);
    }
  }
}

/**
 * @brief        与えられた値が木に存在するか探す
 * @param        num   探す値
 * @return       depth 値があった木の深さ(なければ-1を返す)
 */
int search(int num) {
  tree_node_t *now_node = start;
  int depth = 1;
  while(now_node != NULL) {
    if(now_node->value == num) {
      return depth;
    } else {
      depth++;
      if(now_node->value > num) {
        now_node = now_node->left;
      } else {
        now_node = now_node->right;
      }
    }
  }
  printf("入力値はありませんでした。\n");
  return -1;
}

/**
 * @brief        与えられた値のノードを消す
 * @param        num   消すノードの値
 * @return       depth 値があった木の深さ(値がなければ-1を返す)
 */
int delete(int num) {
  tree_node_t *now_node = start;
  tree_node_t *prev_node;
  int depth = 1;

  while(now_node != NULL) {
    if(now_node->value == num) {
      tree_node_t *delete_node = now_node;
      tree_node_t *replace_node = now_node;
      tree_node_t *replace_prev_node;

      while(replace_node->right != NULL) {
        replace_prev_node = replace_node;
        replace_node = replace_node->right;
      }

      if (replace_prev_node == NULL) {
        replace_node = delete_node->left;
      } else {
        replace_prev_node->right = NULL;
      }

      if(prev_node->value > delete_node->value) {
        prev_node->left = replace_node;
      } else {
        prev_node->right = replace_node;
      }

      return depth;
      
    } else {
      depth++;
      prev_node = now_node;
      if(now_node->value > num) {
        now_node = now_node->left;
      } else {
        now_node = now_node->right;
      }
    }
  }
  printf("入力値はありませんでした。\n");
  return -1;
}

/**
 * @brief        二分木の中身を昇順に表示する関数
 * @param        *start 二分木の起点
 */
void show_tree(tree_node_t *start) {
  if(start->left != NULL) {
    show_tree(start->left);
  }
  printf("%d\n", start->value);
  if(start->right != NULL) {
      show_tree(start->right);
  }
}

int main(void) {
  int input_arr[13] = {15, 8, 24, 6, 10, 19, 30, 3, 13, 16, 21, 1, 5};
  int arr_count = sizeof(input_arr) / sizeof(input_arr[0]);
  start = create_tree(input_arr, arr_count);
  show_tree(start);
  printf("depth = %d\n", search(15));
  return 0;
}
