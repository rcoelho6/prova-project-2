
package prova.project2.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.9
 * Tue Jun 27 14:16:18 BRT 2017
 * Generated source version: 3.1.9
 */

@XmlRootElement(name = "addClientResponse", namespace = "http://service.project2.prova/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addClientResponse", namespace = "http://service.project2.prova/")

public class AddClientResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}

