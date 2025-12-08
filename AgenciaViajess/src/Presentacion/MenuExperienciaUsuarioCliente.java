package Presentacion;

import Controllers.*;
import Modelos.*;
import java.util.List;
import java.util.Scanner;

public class MenuExperienciaUsuarioCliente {

    private final ViajeController viajeController;
    private final FacturaController facturaController;
    private final EntretenimientoController entretenimientoController;
    private final ItinerarioTransporteController itinerarioController;
    private final PlanController planController;
    private final ActividadTuristicaController actividadController;
    private final CuotaController cuotaController;
    private final TrayectoController trayectoController;
    private final ReservaController reservaController;
    
    private Scanner scanner;

    public MenuExperienciaUsuarioCliente(Scanner scanner) {
        this.viajeController = new ViajeController();
        this.facturaController = new FacturaController();
        this.entretenimientoController = new EntretenimientoController();
        this.itinerarioController = new ItinerarioTransporteController();
        this.planController = new PlanController();
        this.actividadController = new ActividadTuristicaController();
        this.cuotaController = new CuotaController();
        this.trayectoController = new TrayectoController();
        this.reservaController = new ReservaController();
        this.scanner = scanner;
    }

    public void mostrarMenuCliente(Integer clienteId) {

        int opcion;

        do {
            System.out.println("\n========= MENÚ CLIENTE =========");
            System.out.println("Cliente ID: " + clienteId);
            System.out.println("--- Gestión de Viajes ---");
            System.out.println("1. Ver mis viajes");
            System.out.println("2. Crear un nuevo viaje");
            System.out.println("3. Eliminar un viaje");
            System.out.println("4. Ver detalles de un viaje");
            System.out.println("5. Ver factura de un viaje");
            System.out.println("\n--- Gestión de Componentes ---");
            System.out.println("6. Gestionar entretenimientos de mis viajes");
            System.out.println("7. Gestionar itinerarios de transporte");
            System.out.println("8. Gestionar cuotas de pago");
            System.out.println("\n--- Consultas ---");
            System.out.println("9. Ver planes disponibles");
            System.out.println("10. Ver actividades turísticas disponibles");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {

                case 1:
                    mostrarViajesCliente(clienteId);
                    break;

                case 2:
                    crearNuevoViaje(clienteId);
                    break;

                case 3:
                    eliminarViajeCliente(clienteId);
                    break;

                case 4:
                    verDetallesViaje(clienteId);
                    break;

                case 5:
                    verFacturaViaje(clienteId);
                    break;

                case 6:
                    gestionarEntretenimientos(clienteId);
                    break;

                case 7:
                    gestionarItinerarios(clienteId);
                    break;

                case 8:
                    gestionarCuotas(clienteId);
                    break;

                case 9:
                    verPlanesDisponibles();
                    break;

                case 10:
                    verActividadesDisponibles();
                    break;

                case 0:
                    System.out.println("Regresando...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while(opcion != 0);

    }

    // ============================================================
    // MÉTODOS DE GESTIÓN DE VIAJES
    // ============================================================

    private void mostrarViajesCliente(Integer clienteId) {
        List<Factura> facturas = facturaController.getFacturasByCliente(clienteId);

        if (facturas.isEmpty()) {
            System.out.println("Este cliente no tiene viajes.");
            return;
        }

        System.out.println("\n--- LISTA DE VIAJES ---");
        for (Factura f : facturas) {
            Viaje v = viajeController.getGeneralById(f.getViajeId());
            System.out.println("ID Viaje: " + v.getId() + " | Factura: " + f.getId() + " | Costo: $" + f.getCosto());
        }
    }

    private void crearNuevoViaje(Integer clienteId) {

        // Crear el viaje vacío
        viajeController.añadirViaje();

        // Obtenemos el ID del nuevo viaje
        List<Viaje> viajes = viajeController.getAllGeneral();
        Integer nuevoViajeId = viajes.get(viajes.size() - 1).getId();

        // Creamos su factura asociada
        System.out.print("Costo inicial del viaje: ");
        int costo = scanner.nextInt();
        scanner.nextLine();

        facturaController.añadirFactura(costo, nuevoViajeId, clienteId);

        System.out.println("✔ Viaje creado con éxito. ID: " + nuevoViajeId);
    }

    private void eliminarViajeCliente(Integer clienteId) {

        mostrarViajesCliente(clienteId);

        System.out.print("ID del viaje que desea eliminar: ");
        int viajeId = scanner.nextInt();
        scanner.nextLine();

        // Verificar que ese viaje pertenece al cliente
        if (!verificarPertenencia(clienteId, viajeId)) {
            System.out.println("❌ Ese viaje no pertenece al cliente.");
            return;
        }

        boolean eliminado = viajeController.eliminarObjeto(viajeId);

        if (!eliminado) {
            System.out.println("❌ No se puede eliminar el viaje: tiene dependencias activas.");
        } else {
            System.out.println("✔ Viaje eliminado con éxito.");
        }
    }

    private void verDetallesViaje(Integer clienteId) {

        mostrarViajesCliente(clienteId);

        System.out.print("Ingrese el ID del viaje: ");
        int viajeId = scanner.nextInt();
        scanner.nextLine();

        // Validar pertenencia
        if (!verificarPertenencia(clienteId, viajeId)) {
            System.out.println("❌ Ese viaje no pertenece al cliente.");
            return;
        }

        System.out.println("\n===== Detalles completos del viaje =====");
        System.out.println(viajeController.getGeneralById(viajeId));

        System.out.println("\n--- Entretenimientos ---");
        List<Entretenimiento> entretenimientos = viajeController.getEntretenimientosDeViaje(viajeId);
        if (entretenimientos.isEmpty()) {
            System.out.println("Sin entretenimientos registrados.");
        } else {
            entretenimientos.forEach(System.out::println);
        }

        System.out.println("\n--- Itinerarios de Transporte ---");
        List<ItinerarioTransporte> itinerarios = viajeController.getItinerariosTransporteDeViaje(viajeId);
        if (itinerarios.isEmpty()) {
            System.out.println("Sin itinerarios registrados.");
        } else {
            itinerarios.forEach(System.out::println);
        }

        System.out.println("\n--- Cuotas de Pago ---");
        List<Cuota> cuotas = viajeController.getCuotasDeViaje(viajeId);
        if (cuotas.isEmpty()) {
            System.out.println("Sin cuotas registradas.");
        } else {
            cuotas.forEach(System.out::println);
        }
    }

    private void verFacturaViaje(Integer clienteId) {

        mostrarViajesCliente(clienteId);

        System.out.print("Ingrese el ID del viaje: ");
        int viajeId = scanner.nextInt();
        scanner.nextLine();

        List<Factura> facturas = facturaController.getFacturasByCliente(clienteId);

        Factura factura = facturas.stream()
                .filter(f -> f.getViajeId().equals(viajeId))
                .findFirst()
                .orElse(null);

        if (factura == null) {
            System.out.println("❌ No existe factura asignada a ese viaje para este cliente.");
            return;
        }

        System.out.println("\n=== FACTURA ===");
        System.out.println("ID: " + factura.getId());
        System.out.println("Costo: $" + factura.getCosto());
        System.out.println("Cliente: " + factura.getClienteId());
        System.out.println("Viaje: " + factura.getViajeId());
    }

    // ============================================================
    // GESTIÓN DE ENTRETENIMIENTOS
    // ============================================================

    private void gestionarEntretenimientos(Integer clienteId) {
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE ENTRETENIMIENTOS ===");
            System.out.println("1. Ver entretenimientos de un viaje");
            System.out.println("2. Agregar entretenimiento a un viaje");
            System.out.println("3. Eliminar entretenimiento");
            System.out.println("4. Ver detalles de un entretenimiento");
            System.out.println("5. Ver plan asociado a un entretenimiento");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verEntretenimientosDeViaje(clienteId);
                    break;
                case 2:
                    agregarEntretenimiento(clienteId);
                    break;
                case 3:
                    eliminarEntretenimiento(clienteId);
                    break;
                case 4:
                    verDetalleEntretenimiento(clienteId);
                    break;
                case 5:
                    verPlanDeEntretenimiento(clienteId);
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void verEntretenimientosDeViaje(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<Entretenimiento> entretenimientos = entretenimientoController.getEntrenimientosByViaje(viajeId);

        if (entretenimientos.isEmpty()) {
            System.out.println("Este viaje no tiene entretenimientos.");
        } else {
            System.out.println("\n--- ENTRETENIMIENTOS DEL VIAJE ---");
            for (Entretenimiento e : entretenimientos) {
                System.out.println(e);
            }
        }
    }

    private void agregarEntretenimiento(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        System.out.println("\n--- PLANES DISPONIBLES ---");
        List<Plan> planes = planController.getAllGeneral();
        if (planes.isEmpty()) {
            System.out.println("No hay planes disponibles.");
            return;
        }
        planes.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Plan: ");
        Integer planId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = entretenimientoController.añadirEntretenimiento(viajeId, planId);

        if (resultado) {
            System.out.println("✔ Entretenimiento agregado correctamente.");
        } else {
            System.out.println("❌ Error: Verifique los IDs ingresados.");
        }
    }

    private void eliminarEntretenimiento(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<Entretenimiento> entretenimientos = entretenimientoController.getEntrenimientosByViaje(viajeId);
        if (entretenimientos.isEmpty()) {
            System.out.println("Este viaje no tiene entretenimientos.");
            return;
        }

        System.out.println("\n--- ENTRETENIMIENTOS DEL VIAJE ---");
        entretenimientos.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Entretenimiento a eliminar: ");
        Integer entId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = entretenimientoController.eliminarObjeto(entId);

        if (resultado) {
            System.out.println("✔ Entretenimiento eliminado correctamente.");
        } else {
            System.out.println("❌ No se pudo eliminar el entretenimiento.");
        }
    }

    private void verDetalleEntretenimiento(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<Entretenimiento> entretenimientos = entretenimientoController.getEntrenimientosByViaje(viajeId);
        if (entretenimientos.isEmpty()) {
            System.out.println("Este viaje no tiene entretenimientos.");
            return;
        }

        System.out.println("\n--- ENTRETENIMIENTOS DEL VIAJE ---");
        entretenimientos.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Entretenimiento: ");
        Integer entId = scanner.nextInt();
        scanner.nextLine();

        Entretenimiento ent = entretenimientoController.getGeneralById(entId);
        if (ent != null) {
            System.out.println("\n=== DETALLES DEL ENTRETENIMIENTO ===");
            System.out.println(ent);
        } else {
            System.out.println("❌ No se encontró el entretenimiento.");
        }
    }

    private void verPlanDeEntretenimiento(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<Entretenimiento> entretenimientos = entretenimientoController.getEntrenimientosByViaje(viajeId);
        if (entretenimientos.isEmpty()) {
            System.out.println("Este viaje no tiene entretenimientos.");
            return;
        }

        System.out.println("\n--- ENTRETENIMIENTOS DEL VIAJE ---");
        entretenimientos.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Entretenimiento: ");
        Integer entId = scanner.nextInt();
        scanner.nextLine();

        Plan plan = entretenimientoController.getPlanDeEntretenimiento(entId);

        if (plan != null) {
            System.out.println("\n=== PLAN ASOCIADO ===");
            System.out.println(plan);
            
            // Mostrar elementos del plan
            System.out.println("\n--- Elementos del Plan ---");
            List<ElementoPlan> elementos = planController.getElementosPlanDePlan(plan.getId());
            if (elementos.isEmpty()) {
                System.out.println("Sin elementos registrados.");
            } else {
                elementos.forEach(System.out::println);
            }
        } else {
            System.out.println("❌ No se encontró el plan asociado.");
        }
    }

    // ============================================================
    // GESTIÓN DE ITINERARIOS DE TRANSPORTE
    // ============================================================

    private void gestionarItinerarios(Integer clienteId) {
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE ITINERARIOS DE TRANSPORTE ===");
            System.out.println("1. Ver itinerarios de un viaje");
            System.out.println("2. Agregar itinerario a un viaje");
            System.out.println("3. Actualizar itinerario");
            System.out.println("4. Eliminar itinerario");
            System.out.println("5. Ver detalles de un itinerario");
            System.out.println("6. Ver reservas de un itinerario");
            System.out.println("7. Agregar reserva a un itinerario");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verItinerariosDeViaje(clienteId);
                    break;
                case 2:
                    agregarItinerario(clienteId);
                    break;
                case 3:
                    actualizarItinerario(clienteId);
                    break;
                case 4:
                    eliminarItinerario(clienteId);
                    break;
                case 5:
                    verDetalleItinerario(clienteId);
                    break;
                case 6:
                    verReservasItinerario(clienteId);
                    break;
                case 7:
                    agregarReservaItinerario(clienteId);
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void verItinerariosDeViaje(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<ItinerarioTransporte> itinerarios = itinerarioController.getItinerariosTransporteByViaje(viajeId);

        if (itinerarios.isEmpty()) {
            System.out.println("Este viaje no tiene itinerarios de transporte.");
        } else {
            System.out.println("\n--- ITINERARIOS DEL VIAJE ---");
            for (ItinerarioTransporte it : itinerarios) {
                System.out.println(it);
            }
        }
    }

    private void agregarItinerario(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        System.out.println("\n--- TRAYECTOS DISPONIBLES ---");
        List<Trayecto> trayectos = trayectoController.getAllGeneral();
        if (trayectos.isEmpty()) {
            System.out.println("No hay trayectos disponibles.");
            return;
        }
        trayectos.forEach(System.out::println);

        System.out.print("\nIngrese el orden del itinerario: ");
        Integer orden = scanner.nextInt();

        System.out.print("Ingrese el ID del Trayecto: ");
        Integer trayectoId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = itinerarioController.añadirItinerarioTransporte(orden, trayectoId, viajeId);

        if (resultado) {
            System.out.println("✔ Itinerario agregado correctamente.");
        } else {
            System.out.println("❌ Error: Verifique los datos ingresados.");
        }
    }

    private void actualizarItinerario(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<ItinerarioTransporte> itinerarios = itinerarioController.getItinerariosTransporteByViaje(viajeId);
        if (itinerarios.isEmpty()) {
            System.out.println("Este viaje no tiene itinerarios.");
            return;
        }

        System.out.println("\n--- ITINERARIOS DEL VIAJE ---");
        itinerarios.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Itinerario a actualizar: ");
        Integer itId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo orden (0 para no cambiar): ");
        Integer orden = scanner.nextInt();
        if (orden == 0) orden = null;

        System.out.print("Nuevo ID de Trayecto (0 para no cambiar): ");
        Integer trayectoId = scanner.nextInt();
        if (trayectoId == 0) trayectoId = null;
        scanner.nextLine();

        boolean resultado = itinerarioController.actualizarItinerarioTransporte(itId, orden, trayectoId, null);

        if (resultado) {
            System.out.println("✔ Itinerario actualizado correctamente.");
        } else {
            System.out.println("❌ No se pudo actualizar el itinerario.");
        }
    }

    private void eliminarItinerario(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<ItinerarioTransporte> itinerarios = itinerarioController.getItinerariosTransporteByViaje(viajeId);
        if (itinerarios.isEmpty()) {
            System.out.println("Este viaje no tiene itinerarios.");
            return;
        }

        System.out.println("\n--- ITINERARIOS DEL VIAJE ---");
        itinerarios.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Itinerario a eliminar: ");
        Integer itId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = itinerarioController.eliminarObjeto(itId);

        if (resultado) {
            System.out.println("✔ Itinerario eliminado correctamente.");
        } else {
            System.out.println("❌ No se pudo eliminar. Puede tener reservas asociadas.");
        }
    }

    private void verDetalleItinerario(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<ItinerarioTransporte> itinerarios = itinerarioController.getItinerariosTransporteByViaje(viajeId);
        if (itinerarios.isEmpty()) {
            System.out.println("Este viaje no tiene itinerarios.");
            return;
        }

        System.out.println("\n--- ITINERARIOS DEL VIAJE ---");
        itinerarios.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Itinerario: ");
        Integer itId = scanner.nextInt();
        scanner.nextLine();

        ItinerarioTransporte it = itinerarioController.getGeneralById(itId);
        if (it != null) {
            System.out.println("\n=== DETALLES DEL ITINERARIO ===");
            System.out.println(it);

            Trayecto trayecto = itinerarioController.getTrayectoDeItinerarioTransporte(itId);
            if (trayecto != null) {
                System.out.println("\n--- Trayecto ---");
                System.out.println(trayecto);
            }
        } else {
            System.out.println("❌ No se encontró el itinerario.");
        }
    }

    private void verReservasItinerario(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<ItinerarioTransporte> itinerarios = itinerarioController.getItinerariosTransporteByViaje(viajeId);
        if (itinerarios.isEmpty()) {
            System.out.println("Este viaje no tiene itinerarios.");
            return;
        }

        System.out.println("\n--- ITINERARIOS DEL VIAJE ---");
        itinerarios.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Itinerario: ");
        Integer itId = scanner.nextInt();
        scanner.nextLine();

        List<Reserva> reservas = itinerarioController.getReservasDeItinerarioTransporte(itId);

        if (reservas.isEmpty()) {
            System.out.println("Este itinerario no tiene reservas.");
        } else {
            System.out.println("\n--- RESERVAS DEL ITINERARIO ---");
            reservas.forEach(System.out::println);
        }
    }

    private void agregarReservaItinerario(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<ItinerarioTransporte> itinerarios = itinerarioController.getItinerariosTransporteByViaje(viajeId);
        if (itinerarios.isEmpty()) {
            System.out.println("Este viaje no tiene itinerarios.");
            return;
        }

        System.out.println("\n--- ITINERARIOS DEL VIAJE ---");
        itinerarios.forEach(System.out::println);

        System.out.print("\nIngrese el ID del Itinerario: ");
        Integer itId = scanner.nextInt();

        System.out.print("Ingrese el número de personas: ");
        Integer numPersonas = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ingrese el Id de la habitacion: ");
        Integer idHabitacion = scanner.nextInt();
        scanner.nextLine();

        // Crear primero la reserva
        boolean reservaCreada = reservaController.añadirReserva(numPersonas, idHabitacion,itId  );
        if (!reservaCreada) {
            System.out.println("❌ No se pudo crear la reserva.");
            return;
        }

        // Obtener el ID de la reserva recién creada
        List<Reserva> reservas = reservaController.getAllGeneral();
        Integer reservaId = reservas.get(reservas.size() - 1).getId();

        // Asignar reserva al itinerario
        boolean resultado = itinerarioController.assignReservaToItinerarioTransporte(itId, reservaId);

        if (resultado) {
            System.out.println("✔ Reserva creada y asignada correctamente. ID: " + reservaId);
        } else {
            System.out.println("❌ No se pudo asignar la reserva al itinerario.");
        }
    }

    // ============================================================
    // GESTIÓN DE CUOTAS
    // ============================================================

    private void gestionarCuotas(Integer clienteId) {
        int opcion;

        do {
            System.out.println("\n=== GESTIÓN DE CUOTAS DE PAGO ===");
            System.out.println("1. Ver cuotas de un viaje");
            System.out.println("2. Registrar pago de cuota");
            System.out.println("3. Actualizar cuota");
            System.out.println("4. Eliminar cuota");
            System.out.println("5. Ver resumen de pagos");
            System.out.println("0. Volver");
            System.out.print("Seleccione opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verCuotasDeViaje(clienteId);
                    break;
                case 2:
                    registrarCuota(clienteId);
                    break;
                case 3:
                    actualizarCuota(clienteId);
                    break;
                case 4:
                    eliminarCuota(clienteId);
                    break;
                case 5:
                    verResumenPagos(clienteId);
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void verCuotasDeViaje(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<Cuota> cuotas = cuotaController.getCuotasByViaje(viajeId);

        if (cuotas.isEmpty()) {
            System.out.println("Este viaje no tiene cuotas registradas.");
        } else {
            System.out.println("\n--- CUOTAS DEL VIAJE ---");
            int totalPagado = 0;
            for (Cuota c : cuotas) {
                System.out.println(c);
                totalPagado += c.getMonto();
            }
            System.out.println("\nTotal pagado: $" + totalPagado);
        }
    }

    private void registrarCuota(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        System.out.print("Monto de la cuota: $");
        Integer monto = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = cuotaController.añadirCuota(monto, viajeId);

        if (resultado) {
            System.out.println("✔ Cuota registrada correctamente.");
        } else {
            System.out.println("❌ No se pudo registrar la cuota.");
        }
    }

    private void actualizarCuota(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<Cuota> cuotas = cuotaController.getCuotasByViaje(viajeId);
        if (cuotas.isEmpty()) {
            System.out.println("Este viaje no tiene cuotas.");
            return;
        }

        System.out.println("\n--- CUOTAS DEL VIAJE ---");
        cuotas.forEach(System.out::println);

        System.out.print("\nIngrese el ID de la Cuota a actualizar: ");
        Integer cuotaId = scanner.nextInt();

        System.out.print("Nuevo monto (0 para no cambiar): ");
        Integer monto = scanner.nextInt();
        if (monto == 0) monto = null;
        scanner.nextLine();

        boolean resultado = cuotaController.actualizarCuota(cuotaId, monto, null);

        if (resultado) {
            System.out.println("✔ Cuota actualizada correctamente.");
        } else {
            System.out.println("❌ No se pudo actualizar la cuota.");
        }
    }

    private void eliminarCuota(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        List<Cuota> cuotas = cuotaController.getCuotasByViaje(viajeId);
        if (cuotas.isEmpty()) {
            System.out.println("Este viaje no tiene cuotas.");
            return;
        }

        System.out.println("\n--- CUOTAS DEL VIAJE ---");
        cuotas.forEach(System.out::println);

        System.out.print("\nIngrese el ID de la Cuota a eliminar: ");
        Integer cuotaId = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = cuotaController.eliminarObjeto(cuotaId);

        if (resultado) {
            System.out.println("✔ Cuota eliminada correctamente.");
        } else {
            System.out.println("❌ No se pudo eliminar la cuota.");
        }
    }

    private void verResumenPagos(Integer clienteId) {
        Integer viajeId = seleccionarViaje(clienteId);
        if (viajeId == null) return;

        // Obtener factura del viaje
        List<Factura> facturas = facturaController.getFacturasByCliente(clienteId);
        Factura factura = facturas.stream()
                .filter(f -> f.getViajeId().equals(viajeId))
                .findFirst()
                .orElse(null);

        if (factura == null) {
            System.out.println("❌ No se encontró factura para este viaje.");
            return;
        }

        // Obtener cuotas del viaje
        List<Cuota> cuotas = cuotaController.getCuotasByViaje(viajeId);

        int costoTotal = factura.getCosto();
        int totalPagado = 0;

        for (Cuota c : cuotas) {
            totalPagado += c.getMonto();
        }

        int saldo = costoTotal - totalPagado;

        System.out.println("\n=== RESUMEN DE PAGOS ===");
        System.out.println("Costo total del viaje: $" + costoTotal);
        System.out.println("Total pagado: $" + totalPagado);
        System.out.println("Saldo pendiente: $" + saldo);
        System.out.println("\nNúmero de cuotas: " + cuotas.size());

        if (saldo > 0) {
            System.out.println("\n⚠ Tiene pagos pendientes.");
        } else if (saldo == 0) {
            System.out.println("\n✔ Viaje totalmente pagado.");
        } else {
            System.out.println("\n⚠ Tiene un sobrepago de: $" + Math.abs(saldo));
        }
    }

    // ============================================================
    // MÉTODOS DE CONSULTA
    // ============================================================

    private void verPlanesDisponibles() {
        System.out.println("\n=== PLANES DISPONIBLES ===");

        List<Plan> planes = planController.getAllGeneral();

        if (planes.isEmpty()) {
            System.out.println("No hay planes disponibles en este momento.");
            return;
        }

        for (Plan p : planes) {
            System.out.println("\n" + p);
            
            // Mostrar elementos de cada plan
            List<ElementoPlan> elementos = planController.getElementosPlanDePlan(p.getId());
            if (!elementos.isEmpty()) {
                System.out.println("  Elementos incluidos:");
                for (ElementoPlan ep : elementos) {
                    System.out.println("    - " + ep);
                }
            }
        }
    }

    private void verActividadesDisponibles() {
        System.out.println("\n=== ACTIVIDADES TURÍSTICAS DISPONIBLES ===");

        List<ActividadTuristica> actividades = actividadController.getAllGeneral();

        if (actividades.isEmpty()) {
            System.out.println("No hay actividades turísticas disponibles.");
            return;
        }

        actividades.forEach(System.out::println);
    }

    // ============================================================
    // MÉTODOS AUXILIARES
    // ============================================================

    private boolean verificarPertenencia(Integer clienteId, Integer viajeId) {
        List<Factura> facturas = facturaController.getFacturasByCliente(clienteId);
        return facturas.stream().anyMatch(f -> f.getViajeId().equals(viajeId));
    }

    private Integer seleccionarViaje(Integer clienteId) {
        mostrarViajesCliente(clienteId);

        if (facturaController.getFacturasByCliente(clienteId).isEmpty()) {
            return null;
        }

        System.out.print("\nIngrese el ID del viaje: ");
        Integer viajeId = scanner.nextInt();
        scanner.nextLine();

        if (!verificarPertenencia(clienteId, viajeId)) {
            System.out.println("❌ Ese viaje no pertenece al cliente.");
            return null;
        }

        return viajeId;
    }

}