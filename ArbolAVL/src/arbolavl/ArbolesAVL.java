/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

/**
 *
 * @author FIET-PIS
 */
class ArbolesAVL {
    public static void main(String[ ] args)
    {
    ArbolAVL arbolitoAVL = new ArbolAVL();   
    arbolitoAVL.insertar(10);
    arbolitoAVL.insertar(5);
    arbolitoAVL.insertar(13);
    arbolitoAVL.insertar(1);
    arbolitoAVL.insertar(6);
    arbolitoAVL.insertar(17);
    arbolitoAVL.insertar(18);
    
  arbolitoAVL.postOrden(arbolitoAVL.ObtenerRaiz());
  arbolitoAVL.MostrarPorNiveles();
    
//nodoArbolAVL varNodo= arbolitoAVL.buscar(18, arbolitoAVL.ObtenerRaiz());
//System.out.println(varNodo.nivel);


   
    }
    
}
