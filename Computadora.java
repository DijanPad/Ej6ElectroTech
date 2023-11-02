public class Computadora implements DispositivoElectronico{
    
    private boolean on;
    private String marca;

    
    public Computadora(boolean on, String marca) {
        this.on = on;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void encender(){
        this.on = true;
    }
    public void apagar() {
        this.on = false;
    }
    public boolean isOn(){
        return this.on;
    }
    public String toString(){
        return marca;
    }

}
