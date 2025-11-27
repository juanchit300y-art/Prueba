package Presentacion;

import Controllers.MunicipioController;
import Modelos.Municipio;
import Modelos.Hotel;
import Modelos.ActividadTuristica;
import Modelos.Trayecto;
import java.util.List;
import java.util.Scanner;

public class SubMenuMunicipio {

    private Scanner scanner;
    private MunicipioController controller;
    private SubMenuActividadTuristica submenuActividadTuristica;
    private SubMenuHotel submenuHotel;
    private SubMenuTrayecto submenuTrayecto;
    public SubMenuMunicipio(Scanner scanner) {
        this.controller = new MunicipioController();
        this.scanner = scanner;
        this.submenuActividadTuristica= new SubMenuActividadTuristica(scanner);
        this.submenuHotel= new SubMenuHotel(scanner);
        this.submenuTrayecto= new SubMenuTrayecto(scanner);
    }
    public void mostrarMenu() {
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("============= SUBMENU MUNICIPIO ====================");
            System.out.println("1. Crear Municipio");
            System.out.println("2. Actualizar Municipio");
            System.out.println("3. Eliminar Municipio");
            System.out.println("4. Ver Municipio por ID");
            System.out.println("5. Ver todos los Municipios");

            System.out.println("------ Opciones extras ------");
            System.out.println("6. Ver Hoteles asociados a un Municipio");
            System.out.println("7. Asignar Hotel a un Municipio");
            System.out.println("8. Ver Actividades Turísticas de un Municipio");
            System.out.println("9. Asignar Actividad Turística a un Municipio");
            System.out.println("10. Ver Trayectos donde el Municipio es Inicio");
            System.out.println("11. Asignar Trayecto como Inicio de un Municipio");
            System.out.println("12. Ver Trayectos donde el Municipio es Destino");
            System.out.println("13. Asignar Trayecto como Destino de un Municipio");
            System.out.println("14. Gestionar Actividades Turisticas");
            System.out.println("15. Gestionar Hoteles");
            System.out.println("16. Gestionar Trayectos");

            System.out.println("======= Presione 0 para Salir =======");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    actualizar();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    verPorId();
                    break;
                case 5:
                    verTodos();
                    break;
                case 6:
                    verHoteles();
                    break;
                case 7:
                    asignarHotel();
                    break;
                case 8:
                    verActividades();
                    break;
                case 9:
                    asignarActividad();
                    break;
                case 10:
                    verTrayectosInicio();
                    break;
                case 11:
                    asignarTrayectoInicio();
                    break;
                case 12:
                    verTrayectosDestino();
                    break;
                case 13:
                    asignarTrayectoDestino();
                    break;
                case 14:
                    submenuActividadTuristica.verSubMenuActividadTuristica();
                    break;
                case 15:
                    submenuHotel.mostrarMenu();
                    break;
                case 16:
                    submenuTrayecto.verSubMenuTrayecto();
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void crear() {
        System.out.println("=== Crear Municipio ===");

        System.out.print("Ingrese el nombre del municipio: ");
        String nombre = scanner.nextLine();

        boolean resultado = controller.añadirMunicipio(nombre);

        if (resultado) {
            System.out.println("Municipio creado correctamente.");
        } else {
            System.out.println("No se pudo crear el municipio. Verifique los datos.");
        }
    }

    private void actualizar() {
        System.out.println("=== Actualizar Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre (deje vacío para no cambiar): ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) nombre = null;

        boolean resultado = controller.actualizarMunicipio(id, nombre);

        if (resultado) {
            System.out.println("Municipio actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar. Verifique los datos.");
        }
    }

    private void eliminar() {
        System.out.println("=== Eliminar Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.eliminarObjeto(id);

        if (resultado) {
            System.out.println("Municipio eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar. Tiene relaciones asociadas.");
        }
    }

    private void verPorId() {
        System.out.println("=== Ver Municipio por ID ===");

        System.out.print("Ingrese el ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Municipio municipio = controller.getGeneralById(id);

        if (municipio != null) {
            System.out.println(municipio);
        } else {
            System.out.println("No se encontró un municipio con ese ID.");
        }
    }

    private void verTodos() {
        System.out.println("=== Lista de Municipios ===");

        List<Municipio> lista = controller.getAllGeneral();

        if (lista.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (Municipio m : lista) {
                System.out.println(m);
            }
        }
    }

    private void verHoteles() {
        System.out.println("=== Ver Hoteles de un Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Hotel> hoteles = controller.getHotelesDeMunicipio(id);

        if (hoteles.isEmpty()) {
            System.out.println("No hay hoteles asociados a este municipio.");
        } else {
            for (Hotel h : hoteles) {
                System.out.println(h);
            }
        }
    }

    private void asignarHotel() {
        System.out.println("=== Asignar Hotel a un Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer municipioId = scanner.nextInt();

        System.out.print("Ingrese el ID del Hotel: ");
        Integer hotelId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignHotelToMunicipio(municipioId, hotelId);

        if (resultado) {
            System.out.println("Hotel asignado correctamente.");
        } else {
            System.out.println("No se pudo asignar el hotel. Verifique los IDs.");
        }
    }

    private void verActividades() {
        System.out.println("=== Ver Actividades Turísticas de un Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<ActividadTuristica> actividades = controller.getActividadesTuristicasDeMunicipio(id);

        if (actividades.isEmpty()) {
            System.out.println("No hay actividades turísticas en este municipio.");
        } else {
            for (ActividadTuristica a : actividades) {
                System.out.println(a);
            }
        }
    }

    private void asignarActividad() {
        System.out.println("=== Asignar Actividad Turística a un Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer municipioId = scanner.nextInt();

        System.out.print("Ingrese el ID de la Actividad Turística: ");
        Integer actividadId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignActividadTuristicaToMunicipio(municipioId, actividadId);

        if (resultado) {
            System.out.println("Actividad asignada correctamente.");
        } else {
            System.out.println("No se pudo asignar la actividad. Verifique los IDs.");
        }
    }

    private void verTrayectosInicio() {
        System.out.println("=== Ver Trayectos donde el Municipio es Inicio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Trayecto> trayectos = controller.getTrayectosInicioDeMunicipio(id);

        if (trayectos.isEmpty()) {
            System.out.println("No hay trayectos con este municipio como inicio.");
        } else {
            for (Trayecto t : trayectos) {
                System.out.println(t);
            }
        }
    }

    private void asignarTrayectoInicio() {
        System.out.println("=== Asignar Trayecto como Inicio del Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer municipioId = scanner.nextInt();

        System.out.print("Ingrese el ID del Trayecto: ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignTrayectoMunicipioInicioToMunicipio(municipioId, trayectoId);

        if (resultado) {
            System.out.println("Trayecto asignado correctamente.");
        } else {
            System.out.println("No se pudo asignar. Verifique los IDs.");
        }
    }

    private void verTrayectosDestino() {
        System.out.println("=== Ver Trayectos donde el Municipio es Destino ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        List<Trayecto> trayectos = controller.getTrayectosDestinoDeMunicipio(id);

        if (trayectos.isEmpty()) {
            System.out.println("No hay trayectos con este municipio como destino.");
        } else {
            for (Trayecto t : trayectos) {
                System.out.println(t);
            }
        }
    }

    private void asignarTrayectoDestino() {
        System.out.println("=== Asignar Trayecto como Destino del Municipio ===");

        System.out.print("Ingrese el ID del Municipio: ");
        Integer municipioId = scanner.nextInt();

        System.out.print("Ingrese el ID del Trayecto: ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = controller.assignTrayectoMunicipioDestinoToMunicipio(municipioId, trayectoId);

        if (resultado) {
            System.out.println("Trayecto asignado correctamente.");
        } else {
            System.out.println("No se pudo asignar. Verifique los IDs.");
        }
    }
}
