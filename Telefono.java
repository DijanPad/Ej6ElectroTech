public class Telefono implements DispositivoElectronico{

    private boolean on;
    private String modelo;
    
    
    public Telefono(boolean on, String modelo) {
        this.on = on;
        this.modelo = modelo;
    }
    
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
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
        return modelo;
    }

}

