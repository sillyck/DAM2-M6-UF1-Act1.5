import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class datosFacturaCompra {

	String ref="",descripcion="",cantidad="",precio="",iva="",importe="";
	
	ArrayList<String> arrayCompra = new ArrayList<String>();
	
	public datosFacturaCompra() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("factura.xml"));
		document.getDocumentElement().normalize();
		
		NodeList factura = document.getElementsByTagName("compra");
		
		for(int i=0; i<factura.getLength();i++) {
			Node fac = factura.item(i);
			if(fac.getNodeType() == Node.ELEMENT_NODE) {

				Element elemento = (Element) fac;
				
				ref="Ref: " + getNodo("ref",elemento);
				descripcion="Descripcion: " + getNodo("descripcion",elemento);
				cantidad="Cantidad: " + getNodo("cantidad",elemento);
				precio="precio: " + getNodo("precio",elemento);
				iva="IVA: " + getNodo("iva",elemento);
				importe="Importe: " + getNodo("importe",elemento);
				
				arrayCompra.add(ref);
				arrayCompra.add(descripcion);
				arrayCompra.add(cantidad);
				arrayCompra.add(precio);
				arrayCompra.add(iva);
				arrayCompra.add(importe);
			
				arrayCompra.add("\n------------\n");
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
