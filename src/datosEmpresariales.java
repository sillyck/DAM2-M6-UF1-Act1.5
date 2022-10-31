import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class datosEmpresariales {

	String nombre_empresa="",calle="",ciudad="",codigo_postal="",cif="",telefono="",fax="";
	
	ArrayList<String> arrayEmpresariales = new ArrayList<String>();
	
	public datosEmpresariales() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("factura.xml"));
		document.getDocumentElement().normalize();
		
		NodeList factura = document.getElementsByTagName("datos_empresariales");
		
		for(int i=0; i<factura.getLength();i++) {
			Node fac = factura.item(i);
			if(fac.getNodeType() == Node.ELEMENT_NODE) {

				Element elemento = (Element) fac;
				
				nombre_empresa="Nombre de la empresa: " + getNodo("nombre_empresa",elemento);
				calle="Calle: " + getNodo("calle",elemento);
				ciudad="Ciudad: " + getNodo("ciudad",elemento);
				codigo_postal="Codigo Postal: " + getNodo("codigo_postal",elemento);
				cif="CIF: " + getNodo("cif",elemento);
				telefono="Telefono: " + getNodo("telefono",elemento);
				fax="Fax: " + getNodo("fax",elemento);
				
				arrayEmpresariales.add(nombre_empresa);
				arrayEmpresariales.add(calle);
				arrayEmpresariales.add(ciudad);
				arrayEmpresariales.add(codigo_postal);
				arrayEmpresariales.add(cif);
				arrayEmpresariales.add(telefono);
				arrayEmpresariales.add(fax);
			
				arrayEmpresariales.add("\n------------\n");
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
