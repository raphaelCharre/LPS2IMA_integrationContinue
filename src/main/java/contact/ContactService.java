package contact;

public class ContactService {

  IContactDao dao;

  public ContactService() {
    dao = new ContactDao();
  }

  /*
   * Creer un contact.
   * 
   * @param nom : nom du contact.
   * 
   * @param tel : tel du contact.
   */
  public void creerContact(String nom, String tel) throws Exception {
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

  public void creerContact(String nom) throws Exception {
    creerContact(nom, null);
  }

  void supprimerContact(String nom) throws Exception {
    dao.supprimerContact(nom);
  }
}
