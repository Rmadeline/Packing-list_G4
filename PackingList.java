
public class PackingList {
    //Aruibutos
    private String idPackingList;
    private String descripcion;
    private String clienteConsignatario;
    private String vendedor;
    private String fechaEmision;
    private String estado;
    private String puertoEmbarque;
    private String paisDestino;
    
public String getIdPackingList() {
        return idPackingList;
    }

    public void setIdPackingList(String idPackingList) {
        this.idPackingList = idPackingList;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClienteConsignatario() {
        return clienteConsignatario;
    }

    public void setClienteConsignatario(String clienteConsignatario) {
        this.clienteConsignatario = clienteConsignatario;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPuertoEmbarque() {
        return puertoEmbarque;
    }

    public void setPuertoEmbarque(String puertoEmbarque) {
        this.puertoEmbarque = puertoEmbarque;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }
}
