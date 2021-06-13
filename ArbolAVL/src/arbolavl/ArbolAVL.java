/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

/**
 *
 * @author refaz
 */
public class ArbolAVL {
    private nodoArbolAVL raiz;
      
    public ArbolAVL(){
        raiz = null;
    }

    /**
     *
     * @return
     */
    public nodoArbolAVL obtenerRaiz(){
    return raiz;
} 
    
    //BUSCAR UN NODO
    public nodoArbolAVL buscar(int d, nodoArbolAVL r){
        if(raiz == null){
            return null;
        }else if(r.dato == d){
            return r;
        }else if(r.dato < d){
            return buscar(d,r.hijoDerecho);
        }else{
            return buscar(d,r.hijoIzquierdo);
        }
    }
    //OBTENER EL FACTOR DE EQUILIBRIO
    public int obtenerFE(nodoArbolAVL x){
        if(x== null){
            return -1;
        }else{
            return x.fe;
        }
    }
    
    // Rotación simple izquierda
	public nodoArbolAVL rotacionIzquierda(nodoArbolAVL c) {
		nodoArbolAVL auxiliar = c.hijoIzquierdo;
		c.hijoIzquierdo = auxiliar.hijoDerecho;
		auxiliar.hijoDerecho = c;
		c.fe = Math.max(obtenerFE(c.hijoIzquierdo), 
                        obtenerFE(c.hijoDerecho)) + 1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), 
                        obtenerFE(auxiliar.hijoDerecho)) + 1;
		return auxiliar;
	}

	// Rotación simple Derecha
	public nodoArbolAVL rotacionDerecha(nodoArbolAVL c) {
		nodoArbolAVL auxiliar = c.hijoDerecho;
		c.hijoDerecho = auxiliar.hijoIzquierdo;
		auxiliar.hijoDerecho = c;
		c.fe = Math.max(obtenerFE(c.hijoIzquierdo), 
                        obtenerFE(c.hijoDerecho)) + 1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), 
                        obtenerFE(auxiliar.hijoDerecho)) + 1;
		return auxiliar;
	}

	// Rotacion Doble a la izquierda
	public nodoArbolAVL rotacionDobleIzquierda(nodoArbolAVL c) {
		nodoArbolAVL temporal;
		c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
		temporal = rotacionIzquierda(c);
		return temporal;
	}

	// Rotacion Doble a la izquierda
	public nodoArbolAVL rotacionDobleDerecha(nodoArbolAVL c) {
		nodoArbolAVL temporal;
		c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
		temporal = rotacionDerecha(c);
		return temporal;
	}
    
    
     //METODO PARA INSERTAR AVL
     public nodoArbolAVL insertarAVL(nodoArbolAVL nuevo,nodoArbolAVL subAr){
         nodoArbolAVL nuevoPadre = subAr;
         if(nuevo.dato < subAr.dato){
             if(subAr.hijoIzquierdo == null){
                 subAr.hijoIzquierdo = nuevo;
             }else{
                 subAr.hijoIzquierdo = 
                         insertarAVL(nuevo,subAr.hijoIzquierdo);
                 if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2)){
                     if(nuevo.dato < subAr.hijoIzquierdo.dato){
                         nuevoPadre = rotacionIzquierda(subAr);
                     }else{
                         nuevoPadre = rotacionDobleIzquierda(subAr);
                     }
                 }
             }
         }else if(nuevo.dato > subAr.dato){
             if(subAr.hijoDerecho == null){
                 subAr.hijoDerecho = nuevo;
                 
             }else{
                 subAr.hijoDerecho = insertarAVL(nuevo,subAr.hijoDerecho);
                 if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==-2)){
                     if(nuevo.dato > subAr.hijoDerecho.dato){
                         nuevoPadre = rotacionDerecha (subAr);
                     }else{
                         nuevoPadre = rotacionDobleDerecha(subAr);
                     }
                 }
             }
         }else{
             System.out.println("NODO DUPLICADO");
         }
         //ACTUALIZANDO EL FE
         if((subAr.hijoIzquierdo == null)&&(subAr.hijoDerecho !=null)){
             subAr.fe = subAr.hijoDerecho.fe + 1;
         }else if((subAr.hijoDerecho == null)&&(subAr.hijoIzquierdo != null)){
             subAr.fe = subAr.hijoIzquierdo.fe +1 ;
         }else{
             subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo),
                     obtenerFE(subAr.hijoDerecho))+1;
         }
               nuevo.SetNivel(nuevo.nivel+1);
         return nuevoPadre;
     }
     //METODO PARA INSERTAR
     public void insertar(int d){
         nodoArbolAVL nuevo = new nodoArbolAVL(d);
         if(raiz == null){
             raiz = nuevo;
         }else{
             raiz = insertarAVL(nuevo, raiz);
         }
     }
     //RECORRIDOS 
     //meteodo para recorrer el arbol INORDEN
    public void inOrden(nodoArbolAVL r){
        if(r != null){
            inOrden(r.hijoIzquierdo);
            System.out.print (r.dato + " , ");
            inOrden(r.hijoDerecho);
            
        }     
    }
    
     //meteodo para recorrer el arbol PREORDEN
     public void preOrden(nodoArbolAVL r){

        if(r != null){
            System.out.print(r.dato + " , ");
            
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
            
        }    
    }
 int[] vector= new int[7];
     //meteodo para recorrer el arbol POSTORDEN
    public void postOrden(nodoArbolAVL r){
        if(r != null){
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            //System.out.print(r.dato + " , ");
            for (int i = 1; i<=7;i++) {
            if(r.nivel==i)
            {
                //vector[i]=r.dato;
             System.out.println(r.dato + " NIVEL: "+i);
            }
        }
            
        }    
     
    }
    
     

    public nodoArbolAVL ObtenerRaiz()
    {
        return this.raiz;
    }
    public void MostrarPorNiveles()
    {
      
 
    }

           
}
