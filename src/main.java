
public class main {

	public static void main(String[] args) {
		
		datosFactura dfactura = new datosFactura();
		
		System.out.print(dfactura.arrayDatos.toString().replace("[", "").replace(", ", "\n").replace("]", ""));
		
		
		datosEmpresariales dempresariales= new datosEmpresariales();
		
		System.out.print(dempresariales.arrayEmpresariales.toString().replace("[", "").replace(", ", "\n").replace("]", ""));
		
		
		datosCliente dcliente = new datosCliente();
		
		System.out.print(dcliente.arrayCliente.toString().replace("[", "").replace(", ", "\n").replace("]", ""));
		
		
		datosFacturaCompra compra = new datosFacturaCompra();
		
		System.out.print(compra.arrayCompra.toString().replace("[", "").replace(", ", "\n").replace("]", ""));

	}

}
