package appclient.service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import appclient.model.Title;

/**
 * @author Edivaldo Nogueira Class responsible for transforming the response to
 *         the request xml format.
 */
public class Transformer {

	public static String layoutRequestXML(String reference) throws NoSuchFieldException {

		Title title = new Title();

		title.setReference(reference);

		XStream xstream = new XStream(new DomDriver());

		xstream.alias("Title", appclient.model.Title.class);

		String xml = xstream.toXML(title);

		return xml;
	}

}
