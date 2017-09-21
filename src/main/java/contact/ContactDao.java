package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDao implements IContactDao {
  List<Contact> contacts;

  public ContactDao() {
    this.contacts = new ArrayList<>();
  }

  /**
   * Ajoute un contact à la liste.
   * 
   * @param c
   *          : le contact à ajouter
   */
  @Override
  public void creerContact(Contact c) {
    this.contacts.add(c);
  }

  /**
   * Récupere un contact dans la liste.
   * 
   * @param nom
   *          : Le nom du contact
   */
  @Override
  public Contact recupererContact(String nom) {
    for (Contact contact : contacts) {
      if (contact.getNom().equals(nom)) {
        return contact;
      }
    }
    return null;
  }

  @Override
  public boolean isContactExiste(String nom) {
    return recupererContact(nom) != null;

  }

  /**
   * Supprime le contact de la liste.
   * 
   * @param nom
   *          : Le nom du contact dans la liste.
   */
  @Override
  public void supprimerContact(String nom) throws ContactExistException {
    Contact c = recupererContact(nom);
    if (c != null) {
      this.contacts.remove(c);
    } else {
      throw new ContactExistException("Echec : Contact non présent dans la liste");
    }
  }
}
