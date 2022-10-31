import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class datosCliente {

	String numero="",nombre="",direccion_envio="",poblacion="",codigo_postal="",provincia="";
	
	ArrayList<String> arrayCliente = new ArrayList<String>();
	
	public datosCliente() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("factura.xml"));
		document.getDocumentElement().normalize();
		
		NodeList factura = document.getElementsByTagName("datos_cliente");
		
		for(int i=0; i<factura.getLength();i++) {
			Node fac = factura.item(i);
			if(fac.getNodeType() == Node.ELEMENT_NODE) {

				Element elemento = (Element) fac;
				
				numero="Numero de Cliente: " + getNodo("numero",elemento);
				nombre="Nombre: " + getNodo("nombre",elemento);
				direccion_envio="Direccion de Envio: " + getNodo("direccion_envio",elemento);
				poblacion="Poblacion: " + getNodo("poblacion",elemento);
				codigo_postal="Codigo Postal: " + getNodo("codigo_postal",elemento);
				provincia="Provincia: " + getNodo("provincia",elemento);
				
				arrayCliente.add(numero);
				arrayCliente.add(nombre);
				arrayCliente.add(direccion_envio);
				arrayCliente.add(poblacion);
				arrayCliente.add(codigo_postal);
				arrayCliente.add(provincia);
			
				arrayCliente.add("\n------------\n");
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
