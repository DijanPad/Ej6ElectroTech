import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        ArrayList<DispositivoElectronico> dips = new ArrayList<DispositivoElectronico>();

        boolean run = true;
        int inputOption = 0;

        String database = "techs.csv";

        String menu = "Tech Disps"+"\n"+
        "1. Mostar todos los dispositivos"+"\n"+
        "2. Dispositivos encendidos"+"\n"+
        "3. Dispositivos apagados\n"+
        "4. Salir";
        Scanner scanner = new Scanner(System.in);

        //cargar datos de un CSV
        
            try (BufferedReader br = new BufferedReader(new FileReader(database))) {
                String encabezado = br.readLine();
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split(",");
                    
                    // Extraer los valores del CSV
                    String type = valores[0];
                    boolean on = Boolean.parseBoolean(valores[1]);
                    String modelomarca = valores[2];
                    
                    
    
                    if (type.equals("T")){
                    dips.add(new Telefono(on,modelomarca));
                    }
                    if (type.equals("C")){
                    dips.add(new Computadora(on,modelomarca));
                }
                } }catch (IOException e) {
                    e.printStackTrace();
                }

            while(run == true){
                System.out.println(menu);
                
                System.out.println("Ingresa una opcion del menu: ");
                inputOption = scanner.nextInt();
    
                System.out.println("\n ");
    
                if(inputOption == 1){
                    System.out.println("Todos los jugadores inscritos: \n");
                    for(int i = 0; i<dips.size();i++){
                        if (dips.get(i) instanceof Telefono){
                        System.out.println(((Telefono) dips.get(i)).toString());
                    }if (dips.get(i) instanceof Computadora) {
                        System.out.println(((Computadora) dips.get(i)).toString());
                    }
                    }
                }if(inputOption == 2){
                    System.out.println("Todos los dispositivos encendidos: \n");
                    for(int i = 0; i<dips.size();i++){
                        if (dips.get(i).isOn() == true){
                            if (dips.get(i) instanceof Telefono){
                                System.out.println(((Telefono) dips.get(i)).toString());
                            }if (dips.get(i) instanceof Computadora) {
                                System.out.println(((Computadora) dips.get(i)).toString());
                    }
                    }
                    }
                }if(inputOption == 3){
                    System.out.println("Todos los dispositivos apagados: \n");
                    for(int i = 0; i<dips.size();i++){
                        if (dips.get(i).isOn() == false){
                            if (dips.get(i) instanceof Telefono){
                                System.out.println(((Telefono) dips.get(i)).toString());
                            }if (dips.get(i) instanceof Computadora) {
                                System.out.println(((Computadora) dips.get(i)).toString());
                    }
                    }
                    }
                }
                if(inputOption == 4){
                    run = false;
                }
    

                try (FileWriter writer = new FileWriter(database)) {
            
                writer.write("on,modelomarca,\n");
                
                for (int i = 0; i <dips.size(); i++) {
                
                if(dips.get(i) instanceof Telefono){
                    writer.write("T" + ","+
                    dips.get(i).isOn() + "," +
                    ((Telefono) dips.get(i)).getModelo() + "," +
                    "\n" );
                }
                if(dips.get(i) instanceof Computadora){
                    writer.write("C" + ","+
                    dips.get(i).isOn() + "," +
                    ((Computadora) dips.get(i)).getMarca() + "," +
                   "\n" );
                }
            } 
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ocurrio un error al guardar en " + database +"\n");
            }
            }

    }}