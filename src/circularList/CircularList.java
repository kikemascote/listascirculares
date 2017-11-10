package circularList;

import node.Node;

public class CircularList<T> {
	private Node<T> sentinel	= null;
	private Node<T> actual	= null;
	
	public CircularList() {
		sentinel	 = new Node<T>();
		actual	 = new Node<T>();
		sentinel.setIndex(-1);
		actual.setIndex(-1);
	}
	public CircularList(T value) {
		this();
		sentinel.setNext(new Node<T>(value));
		actual = sentinel.getNext();
		sentinel.getNext().setNext(actual);
	}
	public Node<T> Search(T value){
		return(!isEmpty())?Search(value, sentinel.getNext()):null;
		// else 
		//	return null;
		//return Search(value, sentinel.getNext());
	}
	public Node<T> Search(T value, Node<T> list){	
		if (list.getNext().getValue().equals(value)) {
			return list.getNext();
		}
		if (list.getNext().equals(sentinel.getNext())) {
			return null;
		}
		
		return Search(value, list.getNext());
	}
	
	public boolean isEmpty() {
		return (sentinel.getNext()==null)?true:false;
	}
	
	public Node<T> getLast(){
		Node<T> tmp = sentinel.getNext();
		if(!isEmpty()) {
			while(!sentinel.getNext().equals(tmp.getNext())) 
				tmp = tmp.getNext();
				return tmp;
		}// end if
		return null;
	}
	//Version de Alets
	public void AddFirst(T value) {
		Node<T> nuevo = new Node<T>(value), last = getLast();
		if(last == null) {
			sentinel.setNext(nuevo);
			nuevo.setNext(sentinel.getNext());
		}else {
			nuevo.setNext(sentinel.getNext());
			sentinel.setNext(nuevo);
			last.setNext(nuevo);
		}
	}
	//Version en clase
	public void addFirst(T value) {
		Node<T> nuevo = new Node<T>(value);
		Node<T> last = getLast();
		if(isEmpty()) {
			sentinel.setNext(nuevo);
			nuevo.setNext(nuevo);
		}else {
			nuevo.setNext(sentinel.getNext());
			sentinel.setNext(nuevo);
			last.setNext(nuevo);
		}
		
	}
	public void addBefore() {
		
	}
	public void addEnd() {
		
	}
	public void addAfter() {
		
	}
	
	public void print() {
		Node<T> tmp = sentinel.getNext();
		/*if(tmp!=null) 
			System.out.println(tmp.getValue());
			while(tmp.getNext()!=sentinel.getNext()) {
				System.out.println(tmp.getNext().getValue());
				tmp=tmp.getNext();
		}*/
		if(!isEmpty())
			while(!tmp.getNext().equals(sentinel.getNext())) {
				System.out.println(tmp.getValue());
				tmp=tmp.getNext();
			}
		System.out.println(tmp.getValue());
	}
	public void reIndex() {
		
	}
	public Node<T> searchBefore(T value, Node<T> list){	
		if (list.getNext().getValue().equals(value)) {
			return list;
		}
		if (list.getNext().equals(sentinel.getNext())) {
			return null;
		}
		
		return searchBefore(value, list.getNext());
	}
	
	public boolean remove(T value) {
		if(!isEmpty()) {
			Node<T> found = Search(value);
			if(found!= null) {
				Node<T> tmp =searchBefore(value,sentinel.getNext());
				if(tmp.equals(tmp.getNext())) 
					sentinel.setNext(null);
				else if(sentinel.getNext().equals(found)) {
					sentinel.setNext(found.getNext());
					tmp.setNext(found.getNext());
				}else {
					tmp.setNext(found.getNext());
				}
			}
				/*
				if(tmp.equals(tmp.getNext())){
					sentinel.setNext(null);
						
					}else{
						if (found.equals(sentinel.getNext())){
							sentinel.setNext(found.getNext());
						}
					tmp.setNext(found.getNext());
					}
			*/
		}
		return false;
			
	}
}

	
	/*
Método Eliminar por valor
public void eliminar(Integer d){
       if(inicio!=null){
         NodoCircular aux=inicio;
         NodoCircular ant=null;
         while((aux.getSiguiente()!=inicio)&&(aux.getDato()!=d)){
                   ant=aux;
                   aux=aux.getSiguiente();
                  
         }
        
         if(aux==inicio){
                   System.out.println("No existe el elemento"); 
                   return;
         }
         if(ant==null){
             inicio=inicio.getSiguiente();
             aux=null;
             aux=inicio;

             while(aux.getSiguiente()!=inicio){
             ant=aux;
                     aux=aux.getSiguiente();

             }

                   ant.setSiguiente(inicio);
                  

         }else{

                   ant.setSiguiente(aux.getSiguiente());
                   aux=null;
        
         }
       }else{System.out.println("Lista Vacia");}
}*/
