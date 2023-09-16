package ejercicioJPA;

import ejercicioJPA.entidades.*;
import ejercicioJPA.enumeraciones.Estado;
import ejercicioJPA.enumeraciones.FormaPago;
import ejercicioJPA.enumeraciones.Tipo;
import ejercicioJPA.enumeraciones.TipoEnvio;
import ejercicioJPA.repositorios.ClienteRepository;
import ejercicioJPA.repositorios.FacturaRepository;
import ejercicioJPA.repositorios.PedidoRepository;
import ejercicioJPA.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class EjercicioUnoApplication {

	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;


	public static void main(String[] args) {
		SpringApplication.run(EjercicioUnoApplication.class, args);
		System.out.println("Estoy funcionando :)");
	}

	@Bean
	CommandLineRunner init (ClienteRepository clienteRepository) {
		return args -> {
			System.out.println("---------ESTOY FUNCIONANDO---------");

			//Crear rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Skinner & the Superintendent")
					.build();

			//Crear productos
			Producto producto1 = Producto.builder()
					.tipo(Tipo.MANUFACTURADO)
					.tiempoEstimadoCocina(600)
					.denominacion("Asado arruinado")
					.precioVenta(0)
					.precioCompra(7300)
					.stockActual(1)
					.stockMinimo(1)
					.unidadMedida("unidad1")
					.receta("Dejar la carne demasiado tiempo en el horno hasta que se queme. ADVERTENCIA: si no se apaga el horno se puede generar una Aurora Boreal en la cocina. ")
					.build();

			Producto producto2 = Producto.builder()
					.tipo(Tipo.MANUFACTURADO)
					.tiempoEstimadoCocina(20)
					.denominacion("Almejas al vapor")
					.precioVenta(29200)
					.precioCompra(14600)
					.stockActual(0)
					.stockMinimo(0)
					.unidadMedida("unidad2")
					.receta("Solo son una invencion para justificar el humo que sale del horno. Nunca hay stock.")
					.build();

			Producto producto3 = Producto.builder()
					.tipo(Tipo.MANUFACTURADO)
					.tiempoEstimadoCocina(0)
					.denominacion("Hamburguejas al vapor")
					.precioVenta(730) // U$D 1
					.precioCompra(365)
					.stockActual(4)
					.stockMinimo(4)
					.unidadMedida("unidad3")
					.receta("(Cuando nadie este viendo) Salir de la cocina por la venta y comprar hamburguesas Krusty, emplatar y servir como Hambuerguejas al vapor. Una vieja receta familiar.")
					.build();

			//Agregar productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			rubro1.agregarProducto(producto3);

			//Guardar rubro
			rubroRepository.save(rubro1);

			//Crear cliente
			Cliente cliente1 = Cliente.builder()
					.nombre("Seymour")
					.apellido("Skinner")
					.telefono("111-111")
					.email("directorskinner@email.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Gary")
					.apellido("Chalmers")
					.telefono("222-222")
					.email("superintendentechalmers@email.com")
					.build();

			//Crear domicilio
			Domicilio domicilio1 = Domicilio.builder()
					.calle("calle actual")
					.numero("111")
					.localidad("Springfield")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("otra calle")
					.numero("222")
					.localidad("Capital City")
					.build();

			//Agregar domicilio al cliente1
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);

			//Crear detalle pedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(7300)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(0)
					.subtotal(0)
					.build();

			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(2920)
					.build();

			//Formato de fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fechaString = "2023-01-01"; //cambiar fecha
			Date fecha = formatoFecha.parse(fechaString);

			//Crear pedido
			Pedido pedido1 = Pedido.builder()
					.estado(Estado.PREPARACION)
					.fecha(fecha)
					.tipoEnvio(TipoEnvio.RETIRA)
					.total(7300)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado(Estado.ENTREGADO)
					.fecha(fecha)
					.tipoEnvio(TipoEnvio.RETIRA)
					.total(2920)
					.build();

			//Crear factura
			Factura factura1 = Factura.builder()
					.numero(0001)
					.fecha(fecha)
					.descuento(10)
					.formaPago(FormaPago.ETC)
					.total(7300)
					.build();

			Factura factura2 = Factura.builder()
					.numero(0002)
					.fecha(fecha)
					.descuento(0)
					.formaPago(FormaPago.EFECTIVO)
					.total(2920)
					.build(); 

			//Agregar detalle al pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);

			//Agregar pedido al cliente
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);

			//Relacionar detalle con producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto3);

			//Relacionar factura con pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			//Guardar cliente
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			//RECUPERAR OBJETOS desde la Base de Datos

			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse((null));
			if (rubroRecuperado != null) {
				System.out.println("Rubro Recuperado: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProducto();
			}

			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);

			if (clienteRecuperado != null) {
				System.out.println("Cliente Recuperado:");
				System.out.println("ID cliente: " + clienteRecuperado.getId());
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono " + clienteRecuperado.getTelefono());
				System.out.println("-------------DATOS de Domicilios y Pedidos-------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();
			}
		};
	}
}
