package list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E>, Cloneable {

  class Node<E> {
    E data;
    Node<E> next;  // 다음 노드 객체를 가리키는 래퍼런스 변수

    Node(E data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  private Node<E> search(int index) {
    if(index < 0 || index >= size)
      throw new IndexOutOfBoundsException(); // 범위 밖(잘못된 위치)일 경우 예외 던지기

    Node<E> x = head;	// head가 기리키는 노드부터 시작

    for (int i = 0; i < index; i++) {
      x = x.next;	// x 노드의 다음 노드를 x에 저장한다
    }

    return x;
  }

  public void addFirst(E data) {
    Node<E> newNode = new Node<>(data);
    newNode.next = head;
    head = newNode;
    size++;

    if (head.next == null) {
      tail = head;
    }
  }

  @Override
  public boolean add(E data) {
    addLast(data);
    return true;
  }

  public void addLast(E data) {
    if (size == 0) {	// 처음 넣는 노드일 경우 addFisrt로 추가
      addFirst(data);
      return;
    }

    Node<E> newNode = new Node<>(data);
    tail.next = newNode;
    tail = newNode;
    size++;
  }

  @Override
  public void add(int index, E data) {
    if(index < 0 || index >= size)
      throw new IndexOutOfBoundsException(); // 범위 밖(잘못된 위치)일 경우 예외 던지기

    // 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출
    if (index == 0) {
      addFirst(data);
      return;
    }
    // 추가하려는 index가 마지막 위치일 경우 addLast 호출
    if (index == size) {
      addLast(data);
      return;
    }
    // 추가하려는 위치의 이전 노드
    Node<E> prev_Node = search(index - 1);

    // 추가하려는 위치의 노드
    Node<E> next_Node = prev_Node.next;

    // 추가하려는 노드
    Node<E> newNode = new Node<>(data);

    /**
     * 이전 노드가 가리키는 노드를 끊은 뒤
     * 새 노드로 변경해준다.
     * 또한 새 노드가 가리키는 노드는 next_Node로
     * 설정해준다.
     */
    prev_Node.next = newNode;
    newNode.next = next_Node;
    size++;
  }

  public E remove() {

    Node<E> headNode = head;

    if (headNode == null)
      throw new NoSuchElementException();

    E element = headNode.data;
    Node<E> nextNode = head.next;

    head.data = null;
    head.next = null;
    head = nextNode;
    size--;

    if(size == 0) {
      tail = null;
    }
    return element;
  }

  @Override
  public E remove(int index) {

    if (index == 0) {
      return remove();
    }

    if (index >= size || size < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> prevNode = search(index - 1);
    Node<E> removedNode = prevNode.next;
    Node<E> nextNode = removedNode.next;

    E element = removedNode.data;
    prevNode.next = nextNode;

    if(prevNode.next == null) {
      tail = prevNode;
    }
    removedNode.next = null;
    removedNode.data = null;
    size--;

    return element;
  }

  @Override
  public boolean remove(Object data) {

    Node<E> prevNode = head;
    boolean hasValue = false;
    Node<E> x = head;	// removedNode 

    for (; x != null; x = x.next) {
      if (data.equals(x.data)) {
        hasValue = true;
        break;
      }
      prevNode = x;
    }

    if(x == null) {
      return false;
    }

    if (x.equals(head)) {
      remove();
      return true;
    }

    else {
      prevNode.next = x.next;

      if(prevNode.next == null) {
        tail = prevNode;
      }
      x.data = null;
      x.next = null;
      size--;
      return true;
    }
  }

  @Override
  public E get(int index) {
    return search(index).data;
  }

  @Override
  public void set(int index, E value) {
    Node<E> replaceNode = search(index);
    replaceNode.data = value;
  }

  @Override
  public boolean contains(Object value) {
    return indexOf(value) >= 0;
  }

  @Override
  public int indexOf(Object value) {
    int index = 0;

    for (Node<E> x = head; x != null; x = x.next) {
      if (value.equals(x.data)) {
        return index;
      }
      index++;
    }
    // 찾고자 하는 요소를 찾지 못했을 경우 -1 반환
    return -1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void clear() {
    for (Node<E> x = head; x != null;) {
      Node<E> nextNode = x.next;
      x.data = null;
      x.next = null;
      x = nextNode;
    }
    head = tail = null;
    size = 0;
  }

  public Object clone() throws CloneNotSupportedException {

    SinglyLinkedList<? super E> clone = (SinglyLinkedList<? super E>) super.clone();

    clone.head = null;
    clone.tail = null;
    clone.size = 0;

    for (Node<E> x = head; x != null; x = x.next) {
      clone.addLast(x.data);
    }

    return clone;
  }

  public Object[] toArray() {
    Object[] array = new Object[size];
    int idx = 0;
    for (Node<E> x = head; x != null; x = x.next) {
      array[idx++] = (E) x.data;
    }
    return array;
  }

  @SuppressWarnings("unchecked")
  public <T> T[] toArray(T[] a) {
    if (a.length < size) {
      a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
    }
    int i = 0;
    Object[] result = a;
    for (Node<E> x = head; x != null; x = x.next) {
      result[i++] = x.data;
    }
    return a;
  }

  public void sort() {
    sort(null);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void sort(Comparator<? super E> c) {
    Object[] a = this.toArray();
    Arrays.sort(a, (Comparator) c);

    int i = 0;
    for (Node<E> x = head; x != null; x = x.next, i++) {
      x.data = (E) a[i];
    }
  }
}
