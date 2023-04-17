package com.itson.utils;

/**
 *
 * @author 
 */
public class FormatoPaginas {
    private int elementosPerPag;
    private int numPag;

    /**
     * Constructor que inicializa el número de elementos por página a 2
     */
    public FormatoPaginas() {
        this.elementosPerPag = 2;
        this.numPag = 0;
    }

    /**
     * Constructor que inicializa sus atributos al valor de sus parámetros
     * @param elementosPerPag Elementos por página que se requieren
     * @param numPag Número de página
     */
    public FormatoPaginas(int elementosPerPag, int numPag) {
        this.elementosPerPag = elementosPerPag;
        this.numPag = numPag;
    }

    /**
     * Método que regresa el número de elementos por página
     * @return Número de elementos por página
     */
    public int getElementosPerPag() {
        return elementosPerPag;
    }

    /**
     * Método que setea el número de elementos por página
     * @param elementosPerPag Número de elementos por página
     */
    public void setElementosPerPag(int elementosPerPag) {
        this.elementosPerPag = elementosPerPag;
    }

    /**
     * Método que regresa el número de página
     * @return Número de página
     */
    public int getNumPag() {
        return numPag;
    }

    /**
     * Método que setea el número de página
     * @param numPag Número de página
     */
    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
    
    /**
     * Método que avanza de página
     */
    public void avanzar(){
        this.numPag++;
    }
    
    /**
     * Método que retrocede de página
     */
    public void retroceder(){
        if(this.numPag>0){
            this.numPag--;
        }
    }
}


