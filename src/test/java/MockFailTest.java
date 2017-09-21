import org.easymock.*;
import org.junit.Test;
import org.testng.Assert;

public class MockFailTest extends MockTest {
    @TestSubject
    private ContactService service = new ContactService();
    @Mock
    private IContactDao dao;

    @Test
    public void testCreerContactCasValide() throws Exception{
        //Phase d'enregistrement des comportements
        String nom = "ContactOK";
        EasyMock.expect(dao.isContactExiste(nom)).andReturn(false);

        Capture<Contact> capture = EasyMock.newCapture();
        dao.creerContact(EasyMock.capture(capture));
        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.creerContact(nom);

        //Vérification
        verifyAll();
        Assert.assertEquals(nom, capture.getValue().getNom());
    }
    
    @Test(expected=ContactExistException.class)
    public void testCreerContactCasInvalide1() throws Exception{
        //Phase d'enregistrement des comportements
        String nom = "ContactOK";
        EasyMock.expect(dao.isContactExiste(nom)).andReturn(true);

        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.creerContact(nom);

        //Vérification
        verifyAll();
    }

    /* @Test
    public void testSupprimerContactCasValide() throws Exception{
        //Phase d'enregistrement des comportements
        String nom = "ContactOK";
        EasyMock.expect(dao.isContactExiste(nom)).andReturn(true);
        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.supprimerContact(nom);

        //Vérification
        verifyAll();
    }*/

}
