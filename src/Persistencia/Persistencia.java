package Persistencia;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileInputStream;


public class Persistencia {

	private XStream xStream = new XStream(new DomDriver("UTF-8"));
	
	public void salvarSalao(Object sla, String nomeArquivo) throws Exception {
		
		File arquivo = new File(nomeArquivo); 
		arquivo.createNewFile();
		PrintWriter pW = new PrintWriter(arquivo);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		xml += xStream.toXML(sla);
		pW.print(xml);
		pW.close();
	}
	
	public Object recuperarSalao(String nomeArquivo)throws Exception{
		
		File arquivo = new File(nomeArquivo);
		if (arquivo.exists()){
			FileInputStream fIS = new FileInputStream(arquivo);
			return (Object) xStream.fromXML(fIS);

		}
		else {
			throw new Exception();
		}
	}
}