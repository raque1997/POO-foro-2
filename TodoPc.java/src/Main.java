import javax.swing.*; // Librería para crear interfaces gráficas (JOptionPane)
import java.util.ArrayList; // Librería para usar listas dinámicas

// Clase base que representa un equipo electrónico
class Equipo {
    String fabricante; // Atributo que presenta la caracteristica Marca del fabricante
    String modelo; // Atributo que presenta la caracteristica Modelo del equipo
    String microprocesador; //Atributo que presenta la caracteristica Procesador del equipo
    String memoria; //Atributo que presenta la caracteristica Cantidad de memoria

    // Constructor de la clase Equipo
    public Equipo(String fabricante, String modelo, String microprocesador, String memoria) {
        this.fabricante = fabricante; // this. es un Metodo para manipular los datos en la clase
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
    }

    // Metodo para mostrar la información básica del equipo
    public void mostrarInformacion() {
        String info = "Fabricante: " + fabricante + "\n" +
                "Modelo: " + modelo + "\n" +
                "Microprocesador: " + microprocesador + "\n" +
                "Memoria: " + memoria;
        JOptionPane.showMessageDialog(null, info); // Muestra la información en un cuadro de diálogo
    }
}

// Clase Desktop que hereda de Equipo
class Desktop extends Equipo {
    String tarjetaGrafica;
    String tamanoTorre;
    String capacidadDiscoDuro;

    // Constructor de la clase Desktop
    public Desktop(String fabricante, String modelo, String microprocesador, String memoria,
                   String tarjetaGrafica, String tamanoTorre, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria); // Llama al constructor de la superclase
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorre = tamanoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    //@Override tiene la funcion de Sobrescribir el metodo mostrarInformacion para incluir detalles de Desktop
    @Override
    public void mostrarInformacion() {
        String info = "Tipo: Desktop\n" +
                "Fabricante: " + fabricante + "\n" +
                "Modelo: " + modelo + "\n" +
                "Microprocesador: " + microprocesador + "\n" +
                "Memoria: " + memoria + "\n" +
                "Tarjeta Gráfica: " + tarjetaGrafica + "\n" +
                "Tamaño Torre: " + tamanoTorre + "\n" +
                "Capacidad Disco Duro: " + capacidadDiscoDuro ;
        JOptionPane.showMessageDialog(null, info); // Muestra la información de la Laptop
    }
}

// extends crea la Clase Laptop que hereda de Equipo
class Laptop extends Equipo {
    String tamanoPantalla; // Atributo
    String capacidadDiscoDuro;

    // Constructor de la clase Laptop
    public Laptop(String fabricante, String modelo, String microprocesador, String memoria,
                  String tamanoPantalla, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    // con @Override Sobrescribe el metodo mostrarInformacion para incluir detalles de la Laptop
    @Override
    public void mostrarInformacion() {
        String info = "Tipo: Laptop\n" +
                "Fabricante: " + fabricante + "\n" +
                "Modelo: " + modelo + "\n" +
                "Microprocesador: " + microprocesador + "\n" +
                "Memoria: " + memoria + "\n" +
                "Tamaño Pantalla: " + tamanoPantalla + "\n" +
                "Capacidad Disco Duro: " + capacidadDiscoDuro;
        JOptionPane.showMessageDialog(null, info); // Muestra la información de la Tablet
    }
}

// Clase Tablet que hereda de Equipo
class Tablet extends Equipo {
    String tamanoPantalla;
    String tipoPantalla;
    String capacidadMemoriaNAND;
    String sistemaOperativo;

    // Constructor de la clase Tablet
    public Tablet(String fabricante, String modelo, String microprocesador, String tamanoPantalla,
                  String tipoPantalla, String capacidadMemoriaNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador, "No Aplica");
        this.tamanoPantalla = tamanoPantalla; //metodo
        this.tipoPantalla = tipoPantalla;
        this.capacidadMemoriaNAND = capacidadMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Sobrescribe el metodo mostrarInformacion para incluir detalles de la tablet
    @Override
    public void mostrarInformacion() {
        String info = "Tipo: Tablet\n" +
                "Fabricante: " + fabricante + "\n" +
                "Modelo: " + modelo + "\n" +
                "Microprocesador: " + microprocesador + "\n" +
                "Tamaño Pantalla: " + tamanoPantalla + "\n" +
                "Tipo Pantalla: " + tipoPantalla + "\n" +
                "Capacidad Memoria NAND: " + capacidadMemoriaNAND + "\n" +
                "Sistema Operativo: " + sistemaOperativo;
        JOptionPane.showMessageDialog(null, info);  // Muestra la información de la Tablet
    }
}

// Clase principal que maneja el registro y visualización de equipos
public class Main {
    public static void main(String[] args) {
        ArrayList<Equipo> equipos = new ArrayList<>(); // Lista que almacena equipos
        String[] opciones = {"Registrar equipo", "Ver equipos", "Salir"}; // Opciones del menú principal
        String[] tiposEquipos = {"Desktops", "Laptops", "Tablets"}; // tipos de equipos a regrisar

        while (true) {
            // Mostrar menú de opciones
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            if (opcion == JOptionPane.CLOSED_OPTION || opcion == 2) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta pronto!");
                System.exit(0); // Cierra el programa si el usuario selecciona "Salir"
            }

            int tipoEquipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de equipo", "Tipo de Equipo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposEquipos, tiposEquipos[0]);
            if (tipoEquipo == JOptionPane.CLOSED_OPTION) System.exit(0);

            if (opcion == 0) {
                // Registrar equipo
                String fabricante = JOptionPane.showInputDialog("Ingrese el fabricante:");
                if (fabricante == null || fabricante.isEmpty()) continue;

                String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
                if (modelo == null || modelo.isEmpty()) continue;

                String microprocesador = JOptionPane.showInputDialog("Ingrese el microprocesador:");
                if (microprocesador == null || microprocesador.isEmpty()) continue;

                String memoria = null;
                if (tipoEquipo != 2) { // No solicitar memoria para tablets
                    memoria = JOptionPane.showInputDialog("Ingrese la memoria:");
                    if (memoria == null || memoria.isEmpty()) continue;
                }

                if (tipoEquipo == 0) {
                    // Registrar Desktop
                    String tarjetaGrafica = JOptionPane.showInputDialog("Ingrese la tarjeta gráfica:");
                    if (tarjetaGrafica == null || tarjetaGrafica.isEmpty()) continue;

                    String tamanoTorre = JOptionPane.showInputDialog("Ingrese el tamaño de la torre:");
                    if (tamanoTorre == null || tamanoTorre.isEmpty()) continue;

                    String capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                    if (capacidadDiscoDuro == null || capacidadDiscoDuro.isEmpty()) continue;

                    equipos.add(new Desktop(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamanoTorre, capacidadDiscoDuro));

                } else if (tipoEquipo == 1) {
                    // Registrar Laptop
                    String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                    if (tamanoPantalla == null || tamanoPantalla.isEmpty()) continue;

                    String capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                    if (capacidadDiscoDuro == null || capacidadDiscoDuro.isEmpty()) continue;

                    equipos.add(new Laptop(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDiscoDuro));

                } else if (tipoEquipo == 2) {
                    // Registrar Tablet
                    String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño diagonal de la pantalla:");
                    if (tamanoPantalla == null || tamanoPantalla.isEmpty()) continue;

                    String tipoPantalla = JOptionPane.showInputDialog("Ingrese el tipo de pantalla (Capacitiva/Resistiva):");
                    if (tipoPantalla == null || tipoPantalla.isEmpty()) continue;

                    String capacidadMemoriaNAND = JOptionPane.showInputDialog("Ingrese la capacidad de memoria NAND:");
                    if (capacidadMemoriaNAND == null || capacidadMemoriaNAND.isEmpty()) continue;

                    String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                    if (sistemaOperativo == null || sistemaOperativo.isEmpty()) continue;

                    equipos.add(new Tablet(fabricante, modelo, microprocesador, tamanoPantalla, tipoPantalla, capacidadMemoriaNAND, sistemaOperativo));
                }

            } else if (opcion == 1) {
                // Ver equipos
                ArrayList<Equipo> equiposFiltrados = new ArrayList<>();
                if (tipoEquipo == 0) {
                    for (Equipo equipo : equipos) {
                        if (equipo instanceof Desktop) {
                            equiposFiltrados.add(equipo);
                        }
                    }
                } else if (tipoEquipo == 1) {
                    for (Equipo equipo : equipos) {
                        if (equipo instanceof Laptop) {
                            equiposFiltrados.add(equipo);
                        }
                    }
                } else if (tipoEquipo == 2) {
                    for (Equipo equipo : equipos) {
                        if (equipo instanceof Tablet) {
                            equiposFiltrados.add(equipo);
                        }
                    }
                }

                if (equiposFiltrados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay equipos registrados para este tipo.");
                } else {
                    for (Equipo equipo : equiposFiltrados) {
                        equipo.mostrarInformacion();
                    }
                }
            }
        }
    }
}
