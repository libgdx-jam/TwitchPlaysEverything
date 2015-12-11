package test.model;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "persons")
public class PersonListWrapper {

    private List<KeyBind> persons;

    @XmlElement(name = "person")
    public List<KeyBind> getPersons() {
        return persons;
    }

    public void setPersons(List<KeyBind> persons) {
        this.persons = persons;
    }
}