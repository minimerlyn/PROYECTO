/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package piezas;
import Settings.Ajustes;

/**
 *
 * @author reyga
 */
public class Monton {
    
    private Pieza[] monton;
    private int nPiezasMonton;
    
    public Monton(){
        int nPiezasTotales=0;
        for (int i = 0; i < Ajustes.MAX_NUMERO_PIEZA+1; i++) {
            nPiezasTotales+=i+1;
        }//se han obtenido el numero de piezas totales.
        monton=new Pieza[nPiezasTotales];
        nPiezasMonton=monton.length;
        int k=0;
        for (int i = 0; i < Ajustes.MAX_NUMERO_PIEZA+1; i++) {
            for (int j = i; j < Ajustes.MAX_NUMERO_PIEZA+1; j++) {
                monton[k]= new Pieza(i,j);
                k++;
            }
        }//Se han creado todas las piezas y asignado a una posicion del array monton.
        
    }
    public Pieza getUnaPieza(int n){
        return monton[n];
    }
    
    public void eliminarPiezaMonton(Pieza p){
        int n=0;
        while(n<getNPiezasMonton() && p!=monton[n])
            n++;
        if(n==getNPiezasMonton())
            System.err.println("hubo un error, no se encontro la pieza");
        else{
            for (int i = n+1; i < monton.length; i++) {
                monton[i-1]=monton[i];
            }
        } 
        nPiezasMonton--;
    }
    
    public int getNPiezasMonton(){
        return nPiezasMonton;
    }
    
    public int getNPiezasTotales(){
        return monton.length;
    }
    
    @Override
    public String toString(){
        StringBuilder toret= new StringBuilder();
        int j=0,k=Ajustes.MAX_NUMERO_PIEZA+1;
        for (int i = 0; i < monton.length; i++) {
            if(j==k){
                toret.append("\n");
                k-=1;
                j=0;
            }
            toret.append(monton[i].toString());
            toret.append(" ");
            j++;
        }
        return toret.toString();
    }
}
