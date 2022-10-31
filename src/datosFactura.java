import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class datosFactura {

	String numero_factura="",fecha="",numero_pedido="",forma_pago="",base_imponible="",iva="",cuota_iva="",total_factura="";
	
	ArrayList<String> arrayDatos = new ArrayList<String>();
	
	public datosFactura() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("factura.xml"));
		document.getDocumentElement().normalize();
		
		NodeList factura = document.getElementsByTagName("datos_factura");
		
		for(int i=0; i<factura.getLength();i++) {
			Node fac = factura.item(i);
			if(fac.getNodeType() == Node.ELEMENT_NODE) {

				Element elemento = (Element) fac;
				
				numero_factura="Numero de la Factura: " + getNodo("numero_factura",elemento);
				fecha="Fecha: " + getNodo("fecha",elemento);
				numero_pedido="Numero de Pedido: " + getNodo("numero_pedido",elemento);
				forma_pago="Forma de Pago: " + getNodo("forma_de_pago",elemento);
				base_imponible="Base Imponible: " + getNodo("base_imponible",elemento);
				iva="IVA: " + getNodo("iva",elemento);
				cuota_iva="Cuota_iva: " + getNodo("cuota_iva",elemento);
				total_factura="Total de la Factura: " + getNodo("total_factura",elemento);
				
				arrayDatos.add(numero_factura);
				arrayDatos.add(fecha);
				arrayDatos.add(numero_pedido);
				arrayDatos.add(forma_pago);
				arrayDatos.add(base_imponible);
				arrayDatos.add(iva);
				arrayDatos.add(cuota_iva);
				arrayDatos.add(total_factura);
			
				arrayDatos.add("\n------------\n");
			}
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static String getNodo(String etiqueta, Element elem) {
		NodeList node = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = (Node) node.item(0);
		return valornodo.getNodeValue();
	}
}
