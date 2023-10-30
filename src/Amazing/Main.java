package Amazing;

public class Main {

	public static void main(String[] args) {

	   	EmpresaAmazing empresa = new EmpresaAmazing("30-456789-2");
	   
		// empresa.registrarAutomovil("AB444ZZ", 10000, 3500, 5);
		empresa.registrarUtilitario("AA222FF", 18000, 10000, 10000);
		// empresa.registrarAutomovil("AA666XX", 8000, 2500, 4);
		// empresa.registrarCamion("AE555YY", 40000, 200000, 50);
		empresa.registrarUtilitario("AG111ZZ", 21000, 6000, 9000);
		// empresa.registrarCamion("AA111BB", 55000, 300000, 35);

		  
/* 1 */	   int p1 = empresa.registrarPedido("Angel Gutierrez",  "San Martin 321", 28324132);
/* 2 */	   int p2 = empresa.registrarPedido("Marta Benitez",  "Pasco 1020", 19456398);
/* 3 */	   int p3 = empresa.registrarPedido("Daniel Constanzo",  "J.Verdi 876", 35678901);
/* 4 */	   int p4 = empresa.registrarPedido("Beatriz Espinoza",  "L.Alberdi 549", 20345678);
/* 5 */	   int p5 = empresa.registrarPedido("Angel Gutierrez",  "Madariaga 321", 28324132);
/* 6 */	   int p6 = empresa.registrarPedido("Beatriz Espinoza", "L.Alberdi 549", 20345678);
		   
/* 0 */	   int paq1= empresa.agregarPaquete(p1, 1235, 2890, 1000);
/* 1 */	   int paq2= empresa.agregarPaquete(p4, 1290, 5500, 1100);
/* 3 */	   int paq3= empresa.agregarPaquete(p1, 5400, 13400, 3, 400); // Especial
/* 3 */	   int paq4= empresa.agregarPaquete(p6, 800, 2890, 1000);
/* 3 */	   int paq5= empresa.agregarPaquete(p3, 1800, 3500, 1000);
/* 4 */	   int paq6= empresa.agregarPaquete(p1, 3800, 13400, 3, 400); // Especial
/* 4 */	   int paq7= empresa.agregarPaquete(p6, 17000, 28900, 1000);
/* 5 */	   int paq8= empresa.agregarPaquete(p1, 35000, 134000, 3, 400); // Especial
/* 6 */	   int paq9= empresa.agregarPaquete(p4, 120000, 56000, 2, 1100); // Especial
/* 6 */	   int paq10= empresa.agregarPaquete(p6, 1500, 3890, 1000);
		   
		   empresa.cerrarPedido(p1);
		   empresa.cerrarPedido(p3);
		   
		   System.out.println("Listados con la carga de transportes: ");
		  
		   System.out.println(empresa.cargarTransporte("AA222FF"));

/* 1 */	   int p10 = empresa.registrarPedido("Angel Gutierrez",  "San Martin 321", 28324132);
/* 3 */	   int p30 = empresa.registrarPedido("Daniel Constanzo",  "J.Verdi 876", 35678901);


/* 0 */	   int paq11 = empresa.agregarPaquete(p10, 1235, 2890, 1000);
/* 3 */	   int paq12= empresa.agregarPaquete(p10, 5400, 13400, 3, 400); // Especial
/* 3 */	   int paq15= empresa.agregarPaquete(p30, 1800, 3500, 1000);
/* 4 */	   int paq13= empresa.agregarPaquete(p10, 3800, 13400, 3, 400); // Especial
/* 5 */	   int paq14= empresa.agregarPaquete(p10, 35000, 134000, 3, 400); // Especial

		   empresa.cerrarPedido(p10);
		   empresa.cerrarPedido(p30);
           
		   System.out.println(empresa.cargarTransporte("AG111ZZ"));
		   
		//    empresa.cerrarPedido(p6);
		//    empresa.quitarPaquete(paq10);
		   
		//    System.out.println(empresa.cargarTransporte("AE555YY"));
		   System.out.println();
		   
		//    System.out.println("Costo del transporte: " + 
        //            empresa.costoEntrega("AE555YY"));
		//    System.out.println();
		   
		   System.out.println("Facturacion total de pedidos: " + 
		           empresa.facturacionTotalPedidosCerrados());
		   System.out.println();
		   
		   System.out.println("Listados con paquetes sin entregar: ");
		//    System.out.println(empresa.pedidosNoEntregados());
		   System.out.println();
		   
		   System.out.println("Hay transportes iguales: " + empresa.hayTransportesIdenticos());
		   
		   System.out.println(empresa.toString());   
	}
	
}
