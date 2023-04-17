package com.itson.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alexa Soto(236348) y Rosalía Perez (233505)
 */
@Entity
public class Placa extends Tramite implements Serializable {

    /**
     * Identificador de placas
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Serie de carácteres que son asignados a una placa
     */
    @Column(name = "num_alfanumerico", nullable = false)
    private String num_alfanumerico;

    /**
     * Fecha en la que se realizó el trámite
     */
    @Column(name = "fecha_recepcion", nullable = true)
    private Date fecha_recepcion;

    /**
     * Define si la placa está vigente o vencida
     */
    @Column(name = "estado", nullable = false)
    private boolean estado;

    /**
     * Vehículo al que se le asignará una placa
     */
    @ManyToOne
    @JoinColumn(name = "num_serie", referencedColumnName = "num_serie") // Llave foránea
    private Vehiculo vehiculo;

    /**
     * Constructor por defecto
     */
    public Placa() {
    }

    /**
     * Constructor que asigna parámetros a una placa
     *
     * @param id Identificador de placas
     * @param num_alfanumerico Serie de carácteres que son asignados a una placa
     * @param fecha_recepcion Fecha en la que se realizó el trámite
     * @param estado Define si la placa está vigente o vencida
     * @param vehiculo Vehículo al que se le asignará una placa
     * @param idTramite Identificador del trámite
     * @param fechaEmision Fecha en la que se realizó el trámite
     * @param costo Costo del trámite
     * @param persona Persona que solicitó el trámite
     */
    public Placa(Long id, String num_alfanumerico, Date fecha_recepcion, boolean estado, Vehiculo vehiculo, Long idTramite, Date fechaEmision, float costo, Persona persona) {
        super(idTramite, fechaEmision, costo, persona);
        this.id = id;
        this.num_alfanumerico = num_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor que asigna parámetros a una placa
     *
     * @param num_alfanumerico Serie de carácteres que son asignados a una placa
     * @param fecha_recepcion Fecha en la que se realizó el trámite
     * @param estado Define si la placa está vigente o vencida
     * @param vehiculo Vehículo al que se le asignará una placa
     * @param fechaEmision Fecha en la que se realizó el trámite
     * @param costo Costo del trámite
     * @param persona Persona que solicitó el trámite
     */
    public Placa(String num_alfanumerico, Date fecha_recepcion, boolean estado, Vehiculo vehiculo, Date fechaEmision, float costo, Persona persona) {
        super(fechaEmision, costo, persona);
        this.num_alfanumerico = num_alfanumerico;
        this.fecha_recepcion = fecha_recepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor que asigna parámetros a una placa
     *
     * @param num_alfanumerico Serie de carácteres que son asignados a una placa
     * @param estado Define si la placa está vigente o vencida
     * @param vehiculo Vehículo al que se le asignará una placa
     * @param fechaEmision Fecha en la que se realizó el trámite
     * @param costo Costo del trámite
     * @param persona Persona que solicitó el trámite
     */
    public Placa(String num_alfanumerico, boolean estado, Vehiculo vehiculo, Date fechaEmision, float costo, Persona persona) {
        super(fechaEmision, costo, persona);
        this.num_alfanumerico = num_alfanumerico;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    /**
     * Regresa una serie de carácteres que son asignados a una placa
     *
     * @return Serie de carácteres que son asignados a una placa
     */
    public String getNum_alfanumerico() {
        return num_alfanumerico;
    }

    /**
     * Asigna una serie de carácteres que son asignados a una placa
     *
     * @param num_alfanumerico Serie de carácteres que son asignados a una placa
     */
    public void setNum_alfanumerico(String num_alfanumerico) {
        this.num_alfanumerico = num_alfanumerico;
    }

    /**
     * Regresa la fecha en la que se registró la placa
     *
     * @return Fecha en la que se registró la placa
     */
    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    /**
     * Asigna la fecha en la que se registró la placa
     *
     * @param fecha_recepcion Fecha en la que se registró la placa
     */
    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    /**
     * Regresa el vehículo al que se le asignó la placa
     *
     * @return Vehículo al que se le asignó la placa
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Le asigna una placa a un vehículo
     *
     * @param vehiculo Vehículo al que se le asignó la placa
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Regresa el identificador de una placa
     *
     * @return Identificador de una placa
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador de una placa
     *
     * @param id Identificador de una placa
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Regresa si la placa está vigente o vencida.
     *
     * @return Estado de la placa
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Asigna el estado de la placa
     *
     * @param estado Estado de la placa
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método que calcula el hashcode de la identificación de una placa
     *
     * @return Hashcode del identificador
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara una placa con otro objeto
     *
     * @param obj Objeto a comparar
     * @return Regresa falso si la comparación con otro objeto no es igual,
     * sino, regresará verdadero en caso de ser igual
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Placa other = (Placa) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Cadena de texto con los parámetros de la placa
     *
     * @return Cadena de texto con los parámetros de la placa
     */
    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", num_alfanumerico=" + num_alfanumerico + ", fecha_recepcion=" + fecha_recepcion + ", estado=" + estado + ", vehiculo=" + vehiculo + '}';
    }

}
