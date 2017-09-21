import java.util.ArrayList;
import java.util.List;

public class ContactDao implements IContactDao{
    List <Contact> contacts;

    ContactDao(){
        this.contacts= new ArrayList<Contact>();
    }


    public void creerContact(Contact c) throws ContactExistException{
        boolean contactFind = isContactExiste(c.getNom());
        if(contactFind==false) {
            this.contacts.add(c);
        }
        else{
            throw new ContactExistException("Echec : Contact non présent dans la liste");
        }
    }


    public Contact recupererContact(String nom){
        Contact contactFind = null;
        for (int i = 0;i<contacts.size();i++){
            contactFind = contacts.get(i);
        }
        return contactFind;
    }


    public boolean isContactExiste(String nom){
        boolean contactFind = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getNom() == nom) {
                contactFind = true;
            }
        }
        return contactFind;

    }

    public void supprimerContact(String nom) throws ContactExistException{
        boolean contactFind = isContactExiste(nom);
        if(contactFind==true) {
            Contact c = recupererContact(nom);
            this.contacts.remove(c);
        }
        else{
            throw new ContactExistException("Echec : Contact non présent dans la liste");
        }
    }
}
