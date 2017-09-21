public class ContactService {

    IContactDao dao;

    ContactService (){
        dao = new ContactDao();
    }


    void creerContact(String nom, String tel) throws Exception{
        Contact c = null;
        char[] nomTab = nom.toCharArray();
        if(nomTab.length >= 3 && nomTab.length <= 40) {
            if(dao.isContactExiste(nom)==false) {
                c = new Contact(nom, tel);
            }
            else{
                throw new ContactExistException("Erreur : contact existant");
            }
        }
        else{
            throw new IllegalArgumentException("Erreur : nom incorrect");
        }
        dao.creerContact(c);
    }
    void creerContact(String nom) throws Exception{
        Contact c = null;
        char[] nomTab = nom.toCharArray();
        if(nomTab.length >= 3 && nomTab.length <= 40) {
            if(dao.isContactExiste(nom)==false) {
                c = new Contact(nom);
            }
            else{
                throw new ContactExistException("Erreur : contact existant");
            }
        }
        else{
            throw new IllegalArgumentException("Erreur : nom incorrect");
        }
        dao.creerContact(c);
    }
}
