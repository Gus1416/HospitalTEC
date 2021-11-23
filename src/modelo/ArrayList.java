package modelo;


/**
 * Clase genérica para el uso de ArrayList.
 * 
 * @author Sebastián
 * @version 02/11/2021
 * @param <E>  parámetro de la clase genérica (colección de elementos)
 */
public class ArrayList<E>  {
  //Atributos de la clase
  private Object[] array;
  public static final int DEFAULT_SIZE = 20;
  private int size = 0;

  /**
   * Constructor de la clase.
   */
  public ArrayList() {
    this(DEFAULT_SIZE);
  }

  /**
   * Constructor de la clase con parámetros.
   * 
   * @param size el tamaño de la lista
   */
  public ArrayList(int size) {
    array = new Object[size];
  }

  /**
   * Agrega un elemento a la lista.
   * 
   * @param element Elemento que se agrega a la lista. 
   */
  public void add(E element) {
    ensureCapacity();
    array[size++] = element;
  }

  /**
   * Elimina un elemento de la lista.
   * 
   * @param index Índice donde se agrega el elemento.
   * @return el elemento eliminado
   */
  public E remove(int index) {
    if (index >= size || index < 0){
      throw new RuntimeException("Invalid index");
    }
    E element = (E) array[index];
    array[index] = null;
    --size;
    compress();
    return element;
  }

  /**
   * Obtiene un elemento de la lista en la posición indicada.
   * 
   * @param index Índice del elemento a obtener.
   * @return el elemento obtenido
   */
  public E get(int index) {
    if (index > size){
      throw new RuntimeException("Invalid index");
    }
    E element = (E) array[index];
    return element;
  }

  /**
   * Retorna el tamaño de la lista.
   * 
   * @return un entero con la cantidad de elementos de la lista
   */
  public int size() {
    return this.size;
  }

  /**
   * Valida la extensión de la lista.
   */
  private void ensureCapacity() {
    if (size < array.length){
      return;
    }
    resize();
  }

  /**
   * Cambia el tamaño de la lista.
   */
  private void resize() {
    Object[] temp = new Object[array.length * 2];
    copy(array, temp);
    array = temp;
  }

  /**
   * Copía un objeto de la lista.
   * 
   * @param src   Objeto a copiar.
   * @param dest  Objeto copiado.
   */
  private void copy(Object[] src, Object[] dest) {
    if (dest.length < src.length){
      throw new RuntimeException(src + " cannot be copied into " + dest);
    }
    for (int i = 0; i < src.length; i++){
      dest[i] = src[i];
    }
  }

  /**
   * Comprime la lista.
   */
  private void compress() {
    int skipCount = 0;
    for (int i = 0; i < size && i < array.length; i++){
      if (array[i] == null) {
        ++skipCount;
      }
      array[i] = array[i + skipCount];
    }
  }
}