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
public class nodoArbolAVL {
       public int dato, fe, nivel;
        nodoArbolAVL hijoDerecho, hijoIzquierdo;
        
        public nodoArbolAVL(int d) 
                {
                    this.dato = d;
                    this.fe = 0;
                    this.hijoIzquierdo = null;
                    this.hijoDerecho = null;
                    this.nivel=1;
                }
        public void SetNivel(int parValor)
        {
            this.nivel= parValor;
        }
               
    }
