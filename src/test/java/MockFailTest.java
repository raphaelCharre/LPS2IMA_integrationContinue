import org.easymock.*;
import org.junit.Test;

public class MockFailTest extends MockTest {
    @TestSubject
    private ContactService service = new ContactService();
    @Mock
    private IContactDao dao;

    @Test
    public void testCreerContactCasValide() throws Exception{
        //Phase d'enregistrement des comportements
        String nom = "ContactOK";
        String tel = "9874959343";
        EasyMock.expect(dao.isContactExiste(nom)).andReturn(true);

        Capture<String> capture = EasyMock.newCapture();
        service.creerContact(EasyMock.capture(capture));
        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.creerContact(nom,tel);

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
