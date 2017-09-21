public interface IContactDao {
  public void creerContact(Contact c) throws ContactExistException;
  
  public Contact recupererContact(String nom);
  
  public boolean isContactExiste(String nom);
  
  public void supprimerContact(String nom) throws ContactExistException;

}
