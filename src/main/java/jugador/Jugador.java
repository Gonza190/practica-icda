package jugador;

//Se ha creado un paquete para esta única clase debido a 
//que al tratar de importar esta clase desde src/main/java
//donde están las demás clases .java, el JSP no compila

public class Jugador {

    private String nombre;
    private int votos;

    public Jugador(String nombre, int votos) {
        this.nombre = nombre;
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

}
