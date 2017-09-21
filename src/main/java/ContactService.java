public class ContactService {

  IContactDao dao;

  ContactService() {
    dao = new ContactDao();
  }


  void creerContact(String nom, String tel) throws Exception {
    if (nom != null && nom.length() >= 3 && nom.length() <= 40) {
      if (!dao.isContactExiste(nom)) {
        dao.creerContact(new Contact(nom, tel));
      } else {
        throw new ContactExistException("Erreur : contact existant");
      }
    } else {
      throw new IllegalArgumentException("Erreur : nom incorrect");
    }
  }

  void creerContact(String nom) throws Exception {
    creerContact(nom, null);
  }
}
