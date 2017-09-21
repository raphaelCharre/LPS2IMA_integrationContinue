package contacttest;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.testng.Assert;

import contact.Contact;
import contact.ContactExistException;
import contact.ContactService;
import contact.IContactDao;

public class MockFailTest extends MockTest {
  @TestSubject
  private ContactService service = new ContactService();
  @Mock
  private IContactDao dao;

  @Test
  public void testCreerContactCasValide() throws Exception {
    // Phase d'enregistrement des comportements
    String nom = "ContactOK";
    EasyMock.expect(dao.isContactExiste(nom)).andReturn(false);

    Capture<Contact> capture = EasyMock.newCapture();
    dao.creerContact(EasyMock.capture(capture));
    // Fin de l'enregistrement
    replayAll();

    // Appel de la méthode
    service.creerContact(nom);

    // Vérification
    verifyAll();
    Assert.assertEquals(nom, capture.getValue().getNom());
  }

  @Test(expected = ContactExistException.class)
  public void testCreerContactCasInvalide1() throws Exception {
    // Phase d'enregistrement des comportements
    String nom = "ContactOK";
    EasyMock.expect(dao.isContactExiste(nom)).andReturn(true);

    // Fin de l'enregistrement
    replayAll();

    // Appel de la méthode
    service.creerContact(nom);

    // Vérification
    verifyAll();
  }

  /*
   * @Test public void testSupprimerContactCasValide() throws Exception { // Phase
   * d'enregistrement des comportements String nom = "ContactOK";
   * EasyMock.expect(dao.supprimerContact(nom)).andVoid();
   * 
   * replayAll();
   * 
   * service.supprimerContact(nom);
   * 
   * verifyAll(); }
   */

}
