package com.dmkartik.phrasesearch

object ArrayIterator {
  /**
   * Generic Array iterator that takes an Array, and a method as parameters.
   * Recursively process over the array, passing the items in the array to the method
   * @param array Array to iterate over
   * @param method Method that gets called on each item.  Must take the item's type as a parameter
   * @tparam A The type of items in the array.
   * @return Returns a boolean, true => operation exited early, false => operation processed all items
   */
  def iterate[A](array: Array[A], method: (A) => Boolean): Boolean = {
    if(array.isEmpty) return false
    if(method(array.head)) return true
    iterate(array.drop(1), method)
  }
}