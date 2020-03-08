// Flatten Nested List Iterator 扁平化嵌套列表迭代器

@MEDIUM
public class LC341 {}

public class NestedIterator implements Iterator<Integer> {

  private Stack<NestedInteger> stack;

  NestedIterator(List<NestedInteger> nestedList) {
    this.stack = new Stack<>();
    pushNestedListToStack(nestedList);
  }

  @Override
  public Integer next() {
    if (!hasNext()) return null;
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty() && !stack.peek().isInteger()) {
      pushNestedListToStack(stack.pop().getList());
    }
    return !stack.isEmpty();
  }

  private void pushNestedListToStack(List<NestedInteger> nestedList) {
    Stack<NestedInteger> container = new Stack<>();

    for (NestedInteger ni : nestedList) {
      container.push(ni);
    }

    while (!container.isEmpty()) {
      this.stack.push(container.pop());
    }
  }
}
