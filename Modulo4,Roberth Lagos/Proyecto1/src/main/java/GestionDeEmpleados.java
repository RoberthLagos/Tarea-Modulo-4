import java.util.ArrayList;
import java.util.Scanner;

public class GestionDeEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        int opcion;
        do {
            System.out.println("\n_______________________________");
            System.out.println("\nSistema de Gestion de Empleados:");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Mostrar Empleados");
            System.out.println("3. Salir");
            System.out.print("Selecciona una Opcion: ");
            System.out.println("\n_______________________________");
            opcion = scanner.nextInt();
            scanner.nextLine();  
            
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el Nombre del Empleado: ");
                    String Nombre = scanner.nextLine();
                    System.out.print("Ingrese la Edad del Empleado: ");
                    int Edad = scanner.nextInt();
                    System.out.print("Ingrese el Salario del Empleado: ");
                    double Salario = scanner.nextDouble();

                    Empleado empleado = new Empleado(Nombre, Edad, Salario);
                    gestor.agregarEmpleado(empleado);
                    break;

                case 2:
                    gestor.mostrarEmpleados();
                    break;

                case 3:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpcion Invalida. Intente De Nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}

class Empleado {
    private String Nombre;
    private int Edad;
    private double Salario;

    public Empleado(String Nombre, int Edad, double Salario) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Salario = Salario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public void imprimirInformacion() {
        System.out.println("\nListado De Empleados:");
        System.out.println("Nombre: " + Nombre + ", Edad: " + Edad + ", Salario: " + Salario);
    }
}

class GestorEmpleados {
    private ArrayList<Empleado> listaEmpleados;

    public GestorEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
        System.out.println("\nEmpleado Agregado.");
    }

    public void mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("\nNo Hay Empleados Para Mostrar.");
        } else {
            for (Empleado empleado : listaEmpleados) {
                empleado.imprimirInformacion();
            }
        }
    }
}
