package modelo;

public class cocheObj {

    String Matricula;
    String Marca;
    String Modelo;
    Double Precio;
    String Descripcion;
    String Estado;
    String Imagen;

    public cocheObj() {
        this.Matricula = "a";
        this.Marca = "b";
        this.Modelo = "c";
        this.Precio = 0.0;
        this.Descripcion = "a";
        this.Estado = "b";
        this.Imagen = "c";
    }

    public cocheObj(String Matricula, String Marca, String Modelo, String Descripcion, Double Precio, String Estado, String Imagen) {
        this.Matricula = Matricula;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Precio = Precio;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Imagen = Imagen;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }
    
}
