package com.itson.utils;

/**
 *
 * @author chaly
 */
public class FormatoPaginas {
    private int elementosPerPag;
    private int numPag;

    public FormatoPaginas() {
        this.elementosPerPag = 2;
        this.numPag = 0;
    }

    public FormatoPaginas(int elementosPerPag, int numPag) {
        this.elementosPerPag = elementosPerPag;
        this.numPag = numPag;
    }

    public int getElementosPerPag() {
        return elementosPerPag;
    }

    public void setElementosPerPag(int elementosPerPag) {
        this.elementosPerPag = elementosPerPag;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
    
    
    public void avanzar(){
        this.numPag++;
        
    }
    public void retroceder(){
        if(this.numPag>0){
            this.numPag--;
        }
    }
}


